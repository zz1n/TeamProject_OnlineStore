package com.teampj.shop.board;

import java.util.ArrayList;

public class PageDTO {

	private int nowpage, startpage, endpage, total, cntperpage, lastpage, start, end;
	private int cntpage = 5;
	
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageDTO(int nowpage, int total, int cntperpage) {
		setNowpage(nowpage);
		setCntperpage(cntperpage);
		setTotal(total);
		calclastpage(getTotal(), getCntperpage());
		calcstartendpage(getNowpage(), cntpage);
		calcstartend(getNowpage(), getCntperpage());
	}

	// db 쿼리에서 사용할 start end값 계산
	private void calcstartend(int nowpage, int cntperpage) {
		setEnd(nowpage * cntperpage);
		setStart(getEnd() - cntperpage + 1);
		
	}

	//시작, 끝 페이지 계산
	private void calcstartendpage(int nowpage, int cntpage) {
		setEndpage(((int)Math.ceil((double)nowpage / (double)cntpage))*cntpage);
		
		if(getLastpage() < getEndpage())
		{
			setEndpage(getLastpage());
		}
		setStartpage(getEndpage() - cntpage + 1);
		if(getStartpage() < 1)
		{
			setStartpage(1);
		}
		
	}

	//제일 마지막 페이지 계산 = 전체 페이지수
	private void calclastpage(int total, int cntperpage) {		
		setLastpage((int) Math.ceil((double)cntperpage / (double)total));
				
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCntperpage() {
		return cntperpage;
	}

	public void setCntperpage(int cntperpage) {
		this.cntperpage = cntperpage;
	}

	public int getLastpage() {
		return lastpage;
	}

	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCntpage() {
		return cntpage;
	}

	public void setCntpage(int cntpage) {
		this.cntpage = cntpage;
	}
	
	
	
}
