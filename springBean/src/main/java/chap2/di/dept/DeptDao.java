package chap2.di.dept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeptDao {
	public List<Map<String,Object>> getDeptList(){
		System.out.println("DeptDao getDeptList호출 성공");
		List<Map<String, Object>> deptList = new ArrayList<Map<String, Object>>();
		
		return deptList;
	}
}
