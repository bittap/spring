package member;

import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import memberDTO.MemberDTO;
import service.Service;

@Controller
public class MemberMailingController {
	private Service service;
	
	@RequestMapping(value = "/member_mailing.do", method = RequestMethod.GET)
	public ModelAndView doGet() {
		
		ModelAndView mav = new ModelAndView();
		int count = service.memberCountProcess0();
		mav.setViewName("member/memberMailing");
		mav.addObject("su", count);
		
		
		
		
		
		return mav;
	}//end doGet()
	
	@RequestMapping(value = "/member_mailing.do", method = RequestMethod.POST)
	public ModelAndView doPost(String subject,String group,String email,  String contents ) //throws MessagingException 
	{
		if(group.equals("total")){
			List<MemberDTO> list =service.email_listProcess();
			for(int i=0; i<list.size(); i++){
			  // 메일 관련 정보
	        String host = "smtp.gmail.com";
	        String username = "kinjwo1@gmail.com";
	        String password = "xodud137";
	         
	        // 메일 내용
	        String recipient = list.get(i).getMember_email();
	        String subject1 = subject;
	        String body = contents;
	         
	        //properties 설정
	        Properties props = new Properties();
	        props.put("mail.smtps.auth", "true");
//	        // 메일 세션
//	        Session session = Session.getDefaultInstance(props);
//	        MimeMessage msg = new MimeMessage(session);
//	 
//	        // 메일 관련
//	        msg.setSubject(subject1);
//	        msg.setText(body);
//	        msg.setFrom(new InternetAddress(username));
//	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//	 
//	        // 발송 처리
//	        Transport transport = session.getTransport("smtps");
//	        transport.connect(host, username, password);
//	        transport.sendMessage(msg, msg.getAllRecipients());
//	        transport.close(); 
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("dto", list);
			mav.addObject("chk", 1);
			mav.setViewName("member/memberMailing_success");
			
			
			return mav;
		}else{
			 // 메일 관련 정보
	        String host = "smtp.gmail.com";
	        String username = "kinjwo1@gmail.com";
	        String password = "xodud137";
	         
	        // 메일 내용
	        String recipient = email;
	        String subject1 = subject;
	        String body = contents;
	         
	        //properties 설정
	        Properties props = new Properties();
	        props.put("mail.smtps.auth", "true");
//	        // 메일 세션
//	        Session session = Session.getDefaultInstance(props);
//	        MimeMessage msg = new MimeMessage(session);
//	 
//	        // 메일 관련
//	        msg.setSubject(subject1);
//	        msg.setText(body);
//	        msg.setFrom(new InternetAddress(username));
//	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//	 
//	        // 발송 처리
//	        Transport transport = session.getTransport("smtps");
//	        transport.connect(host, username, password);
//	        transport.sendMessage(msg, msg.getAllRecipients());
//	        transport.close();
	        
			ModelAndView mav = new ModelAndView();
			mav.setViewName("member/memberMailing_success");
			mav.addObject("chk", -1);
			mav.addObject("dto_one", email);
			
			return mav;
		}
		
		
		     
    


	}//end doGet()
	



	
	

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
}
