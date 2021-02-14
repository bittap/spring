package chap2.di.dept;

import java.util.List;
import java.util.Map;

public class DeptController {
	public DeptLogic deptLogic = null;
	
	public List<Map<String,Object>> getDeptList(){
		System.out.println("DeptController getDeptList호출 성공");
		List<Map<String,Object>> deptList = null;
		deptList = deptLogic.getDeptList();
		
		return deptList;
	}

	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	
}
