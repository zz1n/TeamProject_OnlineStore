package com.teampj.shop.sellerOrder;

import java.util.ArrayList;

public interface SellerOrderService {

	//배송관리
		public ArrayList<SellerOrderDTO> orderview(String scode, String serchname, String serchname1, String orderday1,
				String orderday2);
	//송장번호 저장
		public int oshipUpdate(String scode, String string, String string2, String string3);
	//환불조회
		public ArrayList<SellerOrderDTO> refundview(String scode, String serchcolumn, String serchname, String ostate,
				String orderday1, String orderday2);
	//환불내역 저장
		public int refundsave(String scode, String string, String string2, String string3, int i, String string5,
				int j);
		
		
}
