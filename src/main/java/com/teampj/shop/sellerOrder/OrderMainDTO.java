package com.teampj.shop.sellerOrder;

public class OrderMainDTO {
	int daycost,monthcost,dayrefund,monthrefund;
	int checklist,shipstate1,shipstate2;
	int ostate2,ostate3,ostate4;
	public OrderMainDTO() {
		super();
	}
	public OrderMainDTO( int daycost, int monthcost, int dayrefund, int monthrefund, int checklist,
			int shipstate1, int shipstate2, int ostate2, int ostate3, int ostate4) {
		super();
		this.daycost = daycost;
		this.monthcost = monthcost;
		this.dayrefund = dayrefund;
		this.monthrefund = monthrefund;
		this.checklist = checklist;
		this.shipstate1 = shipstate1;
		this.shipstate2 = shipstate2;
		this.ostate2 = ostate2;
		this.ostate3 = ostate3;
		this.ostate4 = ostate4;
	}

	public int getDaycost() {
		return daycost;
	}
	public void setDaycost(int daycost) {
		this.daycost = daycost;
	}
	public int getMonthcost() {
		return monthcost;
	}
	public void setMonthcost(int monthcost) {
		this.monthcost = monthcost;
	}
	public int getDayrefund() {
		return dayrefund;
	}
	public void setDayrefund(int dayrefund) {
		this.dayrefund = dayrefund;
	}
	public int getMonthrefund() {
		return monthrefund;
	}
	public void setMonthrefund(int monthrefund) {
		this.monthrefund = monthrefund;
	}
	public int getChecklist() {
		return checklist;
	}
	public void setChecklist(int checklist) {
		this.checklist = checklist;
	}
	public int getShipstate1() {
		return shipstate1;
	}
	public void setShipstate1(int shipstate1) {
		this.shipstate1 = shipstate1;
	}
	public int getShipstate2() {
		return shipstate2;
	}
	public void setShipstate2(int shipstate2) {
		this.shipstate2 = shipstate2;
	}
	public int getOstate2() {
		return ostate2;
	}
	public void setOstate2(int ostate2) {
		this.ostate2 = ostate2;
	}
	public int getOstate3() {
		return ostate3;
	}
	public void setOstate3(int ostate3) {
		this.ostate3 = ostate3;
	}
	public int getOstate4() {
		return ostate4;
	}
	public void setOstate4(int ostate4) {
		this.ostate4 = ostate4;
	}
	
	
	
}
