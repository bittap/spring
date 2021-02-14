package chap2.di.dept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeptLogic {
	public DeptDao deptDao = null;
	public List<Map<String, Object>> getDeptList() {
		System.out.println("DeptLogic getDeptList호출 성공");
		List<Map<String, Object>> deptList = new ArrayList<Map<String,Object>>();
		deptList = deptDao.getDeptList();
		return deptList;
	}
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

}
