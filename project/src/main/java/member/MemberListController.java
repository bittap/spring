package member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberListController {

	@RequestMapping("/member_list.do")
	public String doGet() {		
		return "member/memberList";
	}//end doGet()
}
