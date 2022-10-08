package com.teampj.shop.order;

import java.util.ArrayList;

import com.teampj.shop.TotalDTO;

public interface OrderService {

	ArrayList<TotalDTO> orderlist(String id, int stnrd);

	TotalDTO orderdetail(String string, String ocode);

	void ordercancel(String ocode, String string);

}