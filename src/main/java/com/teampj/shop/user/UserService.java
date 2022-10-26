package com.teampj.shop.user;

import java.util.ArrayList;

public interface UserService {

	public void userin(String userid, String userpw , String uname, String uaddress1, String uemail, String umobile, String uzlpcode1 );

	// �븘�씠�뵒以묐났泥댄겕
	public int idCheck(String userid);

	// 濡쒓렇�씤 泥댄겕
	public int loginCheck(String userid, String userpw);

	// 濡쒓렇�씤 �꽦怨� code 諛쒓툒
	public String logincode(String userid);

	public int idCheck();
    //�쉶�썝 �젙蹂� �닔�젙
	public void UserUpdate(String userid, String userpw , String uname, String uaddress1,String uaddress2,String uaddress3, String uemail, String umobile,String uzlpcode1,String uzlpcode2,String uzlpcode3 );
	
	//�쉶�썝 �궘�젣 �떆諛�
	public void delete(String Userid, String userpw);

	//창용
	public String login(String userid, String userpw);
	
	ArrayList<UserDTO> lookup();

}
