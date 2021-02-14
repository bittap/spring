package service;

import java.util.List;

import mainDTO.MainDTO;
import memberDTO.MemberDTO;

public interface Service {
	
	//회원목록
	public List<MemberDTO> listProcess0(MemberDTO dto);
	public int countProcess0(MemberDTO dto);
	public int memberCountProcess0();
	
	
	//상품 구매회원목록
	public List<MemberDTO> listProcess(MemberDTO dto);
	public int countProcess(MemberDTO dto);
	public int memberCountProcess();
	
	//모든 이메일 주소 검색
	public List<MemberDTO> email_listProcess();
	
	//main
	public int today_priceProcess();
	public int today_order_countProcess();
	
	//저번달 검색
	public int before_priceProcess();
	public int before_order_countProcess();
	
	//주문현황 검색
	public List<MainDTO> month_order_listProcess();
	
	//월간 회원현황 검색
	public List<MainDTO> month_member_listProcess();
}
