package memberDAO;

import java.util.List;

import memberDTO.MemberDTO;



public interface MemberDAO {
	
	//회원목록
	public List<MemberDTO> list0(MemberDTO dto);
	public int count0(MemberDTO dto);
	public int memberCount0();
	
	//상품 구매회원목록
	public List<MemberDTO> list(MemberDTO dto);
	public int count(MemberDTO dto);
	public int memberCount();
	
	//모든 이메일 주소 검색
	public List<MemberDTO> email_list();

}
