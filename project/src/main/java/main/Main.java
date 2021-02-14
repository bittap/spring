package main;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mainDTO.MainDTO;
import service.Service;

@Controller
public class Main {
	private Service service;
	int today_price;
	int today_order_count;
	int before_price;
	int before_order_count;
	
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public ModelAndView doGet() {
		
		ModelAndView mav = new ModelAndView();

		//날짜 구하기
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		String day_of_the_week = "";
		switch (calendar.get(Calendar.DAY_OF_WEEK)){
			case 1 : day_of_the_week = "일요일"; break;
			case 2 : day_of_the_week = "월요일"; break;
			case 3 : day_of_the_week = "화요일"; break;
			case 4 : day_of_the_week = "수요일"; break;
			case 5 : day_of_the_week = "목요일"; break;
			case 6 : day_of_the_week = "금요일"; break;
			case 7 : day_of_the_week = "토요일"; break;
			
		}
		if(service.today_priceProcess() != 0){
			today_price = service.today_priceProcess();
		
		}else{
			today_price = 0;
		}
		
		if(service.today_priceProcess() != 0){
			today_order_count = service.today_order_countProcess();
			}else{
				today_order_count  = 0;
			}
		
	
		
		
		
		mav.addObject("month", month);
		mav.addObject("day", day);
		mav.addObject("day_of_the_week", day_of_the_week);
		
		// 오늘날짜 주문 갯수와 실제매출현황
		mav.addObject("today_price", today_price);
		mav.addObject("today_order_count", today_order_count);
		
		//저번달
		if(service.before_priceProcess() != 0){
			before_price  = service.before_priceProcess();
		
		}else{
			before_price = 0;
		}
		if(service.before_order_countProcess() != 0){
			before_order_count = service.before_order_countProcess();
			}else{
				before_order_count  = 0;
			}
		
		
		// 저번달 주문 갯수와 실제매출현황
		mav.addObject("before_price", before_price);
		mav.addObject("before_order_count", before_order_count);

		// 월간 주문현황
		List<MainDTO> list = service.month_order_listProcess();
		mav.addObject("order_list", list);
		
		// 월간 회원현황
		List<MainDTO> list1 = service.month_member_listProcess();
		mav.addObject("member_list", list1);
		
		

		
		
		
		
		mav.setViewName("main/main");
		return mav;
	}//end doGet()

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	
}
