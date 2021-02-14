package memberDAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import memberDTO.MemberDTO;

public class MemberDaoImp implements MemberDAO {
	SqlSessionTemplate sessionTemplate;

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
	
	public MemberDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<MemberDTO> list0(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("member.memberList_search", dto);
	}
	
	@Override
	public int count0(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("member.memberList_count",dto);
	}
	
	@Override
	public int memberCount0() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("member.memberAll_count");
	}
	
	@Override
	public List<MemberDTO> list(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("member.memberBuyList_search", dto);
	}
	
	@Override
	public int count(MemberDTO dto) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("member.memberBuyList_count",dto);
	}
	
	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("member.memberBuyListAll_count");
	}
	
	@Override
	public List<MemberDTO> email_list() {
		// TODO Auto-generated method stub
		return  sessionTemplate.selectList("member.email_list");
	}
	


}
