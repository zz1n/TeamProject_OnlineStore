package com.teampj.shop.sellerOrder;

import java.util.ArrayList;

public interface SellerOrderService {

	// �뜝�룞�삕�뼶�뜝�룞�삕�뜝占�
	public ArrayList<SellerOrderDTO> orderview(String scode, String serchname, String serchname1, String orderday1,
			String orderday2);

	// �뜝�룞�삕�뜝�룞�삕�뜝�떕占� �뜝�룞�삕�뜝�룞�삕
	public int oshipUpdate(String scode, String string, String string2, String string3, String String4);

	// �솚�뜝�룞�삕�뜝�룞�삕�쉶
	public ArrayList<SellerOrderDTO> refundview(String scode, String serchcolumn, String serchname, String ostate,
			String orderday1, String orderday2);

	// �솚遺덉젙蹂� �쑀�� 遺��떞
	public int refundsaveuser(String scode, String string, String string2, String string3, int parseInt, int parseInt2,
			int i);

	// �솚遺덉젙蹂� �뙋留ㅼ옄 遺��떞
	public int refundsaveseller(String scode, String string, String string2, String string3, int parseInt,
			int parseInt2, int i);

}
