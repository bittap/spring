package chap3.di;

public class HelloBeanImpl implements HelloBean {
	String msg3 = null;
	/*
	 * 의존성 주입을 가능하게 하는 두 가지 방법이 있다.
	 * 1)setter객체 주입법 - java코드에서 작성
	 * 2)생성자 객체 주입법 - xml코드에서 작성(MyBatis연동,DB서버와 연결
	 * 
	 * 
	 */
	public void setMsg3(String msg3) {
		this.msg3 = msg3;
	}
	
	@Override
	public String getGreenting(String msg) {
		
		return "Spring!!" + msg3;
	}


}
