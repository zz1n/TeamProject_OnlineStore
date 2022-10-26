package com.teampj.shop.check;

import java.util.ArrayList;

public interface CheckService {

	ArrayList<CheckDTO> usercheck(String string, int i);

	void checkdel(String string, String string2);

	int gotocheck(String userid, String pcode, int i);

	
	


	
}