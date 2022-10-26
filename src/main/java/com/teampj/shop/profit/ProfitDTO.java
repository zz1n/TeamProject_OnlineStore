package com.teampj.shop.profit;

public class ProfitDTO {

	String odate,pcode;
	int totcost,refundcost,ocount,oprofit;
	public ProfitDTO() {
		super();}
	public ProfitDTO(String odate, String pcode, int totcost, int refundcost, int ocount, int oprofit) {
		super();
		this.odate = odate;
		this.pcode = pcode;
		this.totcost = totcost;
		this.refundcost = refundcost;
		this.ocount = ocount;
		this.oprofit = oprofit;
	}
	public String getodate() {
		return odate;
	}
	public void setodate(String odate) {
		this.odate = odate;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public int getTotcost() {
		return totcost;
	}
	public void setTotcost(int totcost) {
		this.totcost = totcost;
	}
	public int getRefundcost() {
		return refundcost;
	}
	public void setRefundcost(int refundcost) {
		this.refundcost = refundcost;
	}
	public int getOcount() {
		return ocount;
	}
	public void setOcount(int ocount) {
		this.ocount = ocount;
	}
	public int getOprofit() {
		return oprofit;
	}
	public void setOprofit(int oprofit) {
		this.oprofit = oprofit;
	}
	
	

}