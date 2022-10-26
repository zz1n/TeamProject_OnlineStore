package com.teampj.shop.prlist;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/upload/**")
public class ListFileUploadController  {
	
	private static final String CURR_IMAGE_REPO_PATH = "C:\\project0921\\TeamProject_OnlineStore-1\\TeamProject_OnlineStore\\src\\main\\webapp\\image";
	
	@RequestMapping(value="/form")
	public String form() {
		
		return "uploadForm";
	    	    
	  }
	
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)
	  throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap();
		//���ε�� ���ϵ��� ����� ���     ��ϴ� ������ ��ü�� �����Ѵ�
		
		List fileList= fileProcess(multipartRequest);
		map.put("fileList", fileList);		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:form");
		return mav;
	}	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<String> fileList= new ArrayList<String>();
		//÷�ε� ȭ���� �̸��� ���������� �����´�
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()){
			String fileName = fileNames.next();
			//������ ���ε� �ϴ� ȭ�� ���� �������̽�
			MultipartFile mFile = multipartRequest.getFile(fileName);
			//���ε� �Ǵ� ������ �̸�
			String originalFileName=mFile.getOriginalFilename();
			fileList.add(originalFileName);
			File file = new File(CURR_IMAGE_REPO_PATH +"\\"+ fileName);
			mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+ originalFileName)); //�ӽ÷� ����� multipartFile�� ���� ���Ϸ� ����
			}
		return fileList;//ȭ�ϵ��� ��� 
	}
}
