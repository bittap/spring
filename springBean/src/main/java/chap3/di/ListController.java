package chap3.di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ListController extends AbstractController {
	//servlet-context.xml에 등록해둔 인사말을 java코드에서 사용하기 위해
	//선언함.
	List<String> insaBean = null;
	public void setInsaBean(List<String> insaBean) {
		this.insaBean = insaBean;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		//ModelAndView에 insaBean객체의 주소번지를 저장하면
		//request.setAttribute()한 것고ㅑㅏ 동일한 효과를 볼수 있음
		mav.addObject("insaBean", insaBean);
		mav.setViewName("di/insaList");
		return mav;
	}

}
