package com.teampj.shop.profit;

import java.util.ArrayList;
import java.util.List;

public interface ProfitService {
	
	//철민
	public List<ProfitDTO> getIncome(String scode, String begindate, String enddate);

	public List<ProfitDTO> profitOut();

	public ArrayList<ProfitDTO> testin(String scode, String begindate, String enddate);

	public ArrayList<ProfitDTO> testout();

}