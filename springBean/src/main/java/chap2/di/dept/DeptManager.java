package chap2.di.dept;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptManager extends JFrame implements ActionListener{
	JButton jbtn_sel = new JButton("조회");
	DeptController deptController = null;
	public void initDisplay() {
		//이벤트 처리 클래스와 이벤트소스()연결하기
		jbtn_sel.addActionListener(this);
		//JFrame 북쪽에 붙여주세요.
		this.add("North",jbtn_sel);
		//창의 가로 세로 크기 지정
		this.setSize(500, 400);
		//화면에 출력하기
		this.setVisible(true);
	}
	public static void main(String[] args) {
		DeptManager dm = new DeptManager();
		dm.initDisplay();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 누르면 눌렀다는 것을 JVM이 감지하고
		//이벤트에 대한 처리를 해야하 함.
		//이벤트를 감지한 주소번지를 담기
		Object obj = e.getSource();
		//너 조회번튼 누른거야?
		if(jbtn_sel==obj) {
			System.out.println("조회 버튼호출 성공");
			ApplicationContext context = 
					new ClassPathXmlApplicationContext("chap2\\di\\dept\\deptBean.xml");
			deptController =(DeptController)context.getBean("deptController");
			deptController.getDeptList();
		}
		
	}

}
