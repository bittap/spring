package service;

import java.util.List;

import mainDAO.MainDAO;
import mainDTO.MainDTO;
import memberDAO.MemberDAO;
import memberDAO.MemberDaoImp;
import memberDTO.MemberDTO;

public class ServiceImp implements Service {
	private MemberDAO dao;
	private MainDAO mainDAO;
	
	public ServiceImp() {
		// TODO Auto-generated constructor stub
	}


	
	public MemberDAO getDao() {
		return dao;
	}



	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	


	public MainDAO getMainDAO() {
		return mainDAO;
	}



	public void setMainDAO(MainDAO mainDAO) {
		this.mainDAO = mainDAO;
	}



	@Override
	public List<MemberDTO> listProcess0(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.list0(dto);
	}
	
	@Override
	public int countProcess0(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.count0(dto);
	}
	
	@Override
	public int memberCountProcess0() {
		// TODO Auto-generated method stub
		return dao.memberCount0();
	}
	

	
	//상품 구매회원목록
	@Override
	public List<MemberDTO> listProcess(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.list(dto);
	}
	
	@Override
	public int countProcess(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.count(dto);
	}
	
	@Override
	public int memberCountProcess() {
		// TODO Auto-generated method stub
		return dao.memberCount();
	}
	
	@Override
	public List<MemberDTO> email_listProcess() {
		// TODO Auto-generated method stub
		return dao.email_list();
	}
	
	//main
	
	@Override
	public int today_priceProcess() {
		// TODO Auto-generated method stub
		return mainDAO.today_price();
	}
	
	@Override
	public int today_order_countProcess() {
		// TODO Auto-generated method stub
		return mainDAO.today_order_count();
	}
	
	@Override
	public int before_order_countProcess() {
		// TODO Auto-generated method stub
		return mainDAO.before_order_count();
	}
	
	@Override
	public int before_priceProcess() {
		// TODO Auto-generated method stub
		return mainDAO.before_price();
	}
	
	@Override
	public List<MainDTO> month_order_listProcess() {
		// TODO Auto-generated method stub
		return mainDAO.month_order_list();
	}
	
	@Override
	public List<MainDTO> month_member_listProcess() {
		// TODO Auto-generated method stub
		return mainDAO.month_member_list();
	}
	
	
	


	


	
	
	
}
