package memberDaoController;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import memberDAO.MemberDaoImp;
import memberDTO.MemberDTO;
import service.Service;

@Controller
public class MemberDaoController1 {
	private Service service;
	private int size;

	@RequestMapping("/member_buyList1.do")
	public ModelAndView doGet(String member_signDate1,String member_signDate2, String order_date1, String order_date2, String member_purchaseAmount1,String member_purchaseAmount2
			,String select, String select_result, String psize,String psort, String pageNumber, String chk) throws ParseException {

		ModelAndView mav = new ModelAndView();
		MemberDaoImp dao = new MemberDaoImp();
		
		//카운트수를 세기위한 dto
		MemberDTO dto = new MemberDTO();
		
		if(!member_signDate1.equals("")){
			dto.setMember_signDate1(member_signDate1);
			//System.out.println("member_signDate1 = "+dto.getMember_signDate1());

			
		}
		if(!member_signDate2.equals("")){
			dto.setMember_signDate2(member_signDate2);
			//System.out.println("member_signDate2 = "+dto.getMember_signDate2());
			
		}
		if(!order_date1.equals("")){
			dto.setOrder_date1(order_date1);
			//System.out.println("order_date1 = "+dto.getOrder_Date1());
			
		}
		if(!order_date2.equals("")){
			dto.setOrder_date2(order_date2);
			//System.out.println("order_date2 = "+dto.getOrder_Date2());
			
		}
		if(!member_purchaseAmount1.equals("")){
			dto.setMember_purchaseAmount1(Integer.parseInt(member_purchaseAmount1));
			//System.out.println("member_purchaseAmount1 = "+dto.getMember_purchaseAmount1());
			
		}
		if(!member_purchaseAmount2.equals("")){
			dto.setMember_purchaseAmount2(Integer.parseInt(member_purchaseAmount2));
			//System.out.println("member_purchaseAmount2 = "+dto.getMember_purchaseAmount2());
			
		}
		if(select.equals("0")){
			if(select_result.equals(""))
				dto.setAll("0");	
				//System.out.println("All = "+dto.getAll());
		}
		if(select.equals("1")){
			dto.setMember_id(select_result);
			//System.out.println("All = "+dto.getMember_id());
		}
		if(select.equals("2")){
			dto.setMember_name(select_result);
			//System.out.println("Member_name = "+dto.getMember_name());
		}
		if(select.equals("3")){
			dto.setMember_homeNumber(select_result);
			//System.out.println("Member_homeNumber = "+dto.getMember_homeNumber());
		}
		if(select.equals("4")){
			dto.setMember_telNumber(select_result);
			//System.out.println("Member_telNumber = "+dto.getMember_telNumber());
		}
		if(select.equals("5")){
			dto.setMember_email(select_result);
			//System.out.println("Member_email = "+dto.getMember_email());
		}


		int su = service.countProcess(dto);
		
		if(Integer.parseInt(psize) == 5){
			size = 5;

		}else if(Integer.parseInt(psize) == 10){
			size = 10;

		}else if(Integer.parseInt(psize) == 15){
			size = 15;

		}

		//실제 값을 구하기 위한  dto1
		MemberDTO dto1 = new MemberDTO(Integer.parseInt(pageNumber),su, size);
		
		if(!member_signDate1.equals("")){
			dto1.setMember_signDate1(member_signDate1);
			//System.out.println("member_signDate1 = "+dto.getMember_signDate1());
			
		}
		if(!member_signDate2.equals("")){
			dto1.setMember_signDate2(member_signDate2);
			//System.out.println("member_signDate2 = "+dto.getMember_signDate2());
			
		}
		if(!order_date1.equals("")){
			dto1.setOrder_date1(order_date1);
			//System.out.println("order_date1 = "+dto.getOrder_Date1());
			
		}
		if(!order_date2.equals("")){
			dto1.setOrder_date2(order_date2);
			//System.out.println("order_date2 = "+dto.getOrder_Date2());
			
		}
		if(!member_purchaseAmount1.equals("")){
			dto1.setMember_purchaseAmount1(Integer.parseInt(member_purchaseAmount1));
			//System.out.println("member_purchaseAmount1 = "+dto.getMember_purchaseAmount1());
			
		}
		if(!member_purchaseAmount2.equals("")){
			dto1.setMember_purchaseAmount2(Integer.parseInt(member_purchaseAmount2));
			//System.out.println("member_purchaseAmount2 = "+dto.getMember_purchaseAmount2());
			
		}
		if(select.equals("0")){
			if(select_result.equals(""))
				dto1.setAll("0");	
				dto1.setSelect("0");
				//System.out.println("All = "+dto.getAll());
		}
		if(select.equals("1")){
			dto1.setMember_id(select_result);
			dto1.setSelect("1");
			//System.out.println("All = "+dto.getMember_id());
		}
		if(select.equals("2")){
			dto1.setMember_name(select_result);
			dto1.setSelect("2");
			//System.out.println("Member_name = "+dto.getMember_name());
		}
		if(select.equals("3")){
			dto1.setMember_homeNumber(select_result);
			dto1.setSelect("3");
			//System.out.println("Member_homeNumber = "+dto.getMember_homeNumber());
		}
		if(select.equals("4")){
			dto1.setMember_telNumber(select_result);
			dto1.setSelect("4");
			//System.out.println("Member_telNumber = "+dto.getMember_telNumber());
		}
		if(select.equals("5")){
			dto1.setMember_email(select_result);
			dto1.setSelect("5");
			//System.out.println("Member_email = "+dto.getMember_email());
		}
		
		if(psort.equals("member_signDate")){
			dto1.setSort(psort);
			//System.out.println("signdate = "+dto1.getSort());
		}else if(psort.equals("member_purchaseAmount")){
			dto1.setSort(psort);
			//System.out.println("purchaseAmount = "+dto1.getSort());
		}else{
			dto1.setSort(psort);
			//System.out.println("member_nAME = "+dto1.getSort());
		}
		if(!select_result.equals("")){
			dto1.setSelect_result(select_result);
		}
		
		dto1.setSize(size);
		
		

		List<MemberDTO> aList = service.listProcess(dto1);
		
		
		mav.addObject("dto", aList);
		mav.addObject("su", su);
		mav.addObject("page",dto1);
		mav.addObject("exist",1);
		mav.setViewName("member/memberBuyList");
		
		
		
		
	

		return mav;
	}
		
	
	
	
		
		
		
		

	

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
}
