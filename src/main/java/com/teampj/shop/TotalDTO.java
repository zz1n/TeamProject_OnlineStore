package com.teampj.shop;

import com.teampj.shop.board.BoardDTO;
import com.teampj.shop.check.CheckDTO;
import com.teampj.shop.list.ListDTO;
import com.teampj.shop.order.OrderDTO;
import com.teampj.shop.profit.ProfitDTO;
import com.teampj.shop.seller.SellerDTO;
import com.teampj.shop.user.UserDTO;

public class TotalDTO {

	BoardDTO bto;
	CheckDTO cto;
	ListDTO lto;
	OrderDTO oto;
	ProfitDTO pto;
	SellerDTO sto;
	UserDTO uto;
	
	public BoardDTO getBto() {
		return bto;
	}
	public void setBto(BoardDTO bto) {
		this.bto = bto;
	}
	public CheckDTO getCto() {
		return cto;
	}
	public void setCto(CheckDTO cto) {
		this.cto = cto;
	}
	public ListDTO getLto() {
		return lto;
	}
	public void setLto(ListDTO lto) {
		this.lto = lto;
	}
	public OrderDTO getOto() {
		return oto;
	}
	public void setOto(OrderDTO oto) {
		this.oto = oto;
	}
	public ProfitDTO getPto() {
		return pto;
	}
	public void setPto(ProfitDTO pto) {
		this.pto = pto;
	}
	public SellerDTO getSto() {
		return sto;
	}
	public void setSto(SellerDTO sto) {
		this.sto = sto;
	}
	public UserDTO getUto() {
		return uto;
	}
	public void setUto(UserDTO uto) {
		this.uto = uto;
	}
	

}
