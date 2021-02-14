package com.javalec.vo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.javalec.zipcode.dao.ZipcodeDAO;
import com.javalec.zipcode.logic.ZipcodeLogic;

public class BoardVO {
	private int prevBtnPage;
	private int nextBtnPage;
	private Map<String, String> searchMap;
	private final int PAGENUM = 5; //pageNum = 왼쪽 오른쪽 안에 있는 page갯수
	private final int ITEMNUM = 10; //itemNum = 1페이지당 글 갯수
	private List<Integer> pageS = null;
	private int page = 1;
	private String searchKind = "";
	private String searchString = "";
	
	public BoardVO() {
		searchMap = new LinkedHashMap<String, String>();
		searchMap.put("", "전체");
		searchMap.put("uid_no", "번호");
		searchMap.put("zipcode", "우편번호");
		searchMap.put("address", "주소");
		
		ZipcodeLogic zipcodeLogic = new ZipcodeLogic();
		zipcodeLogic.setPaingBoardVO(this);
		
	}
	
	public String getString() {
		return "page="+getPage()+"&searchKind="+getSearchKind()+"&searchString="+getSearchString();
	}
	
	public void getInfo() {
		System.out.println("prevBtnPage="+getPrevBtnPage());
		System.out.println("nextBtnPage="+getNextBtnPage());
		Iterator<String> iterator = getSearchMap().keySet().iterator();
		System.out.println("searchMap");
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = getSearchMap().get(key);
			System.out.println("key="+key);
			System.out.println("value="+value);
		}
		System.out.println("PAGENUM="+getPAGENUM());
		System.out.println("ITEMNUM="+getITEMNUM());
		System.out.println("pageS");
//		for (Integer integer : getPageS()) {
//			System.out.println(integer);
//		}
		System.out.println("page="+getPage());
		System.out.println("searchKind="+getSearchKind());
		System.out.println("searchString="+getSearchString());
	}
	
	
	public int getPAGENUM() {
		return PAGENUM;
	}

	public int getITEMNUM() {
		return ITEMNUM;
	}

	public int getPrevBtnPage() {
		return prevBtnPage;
	}

	public void setPrevBtnPage(int prevBtnPage) {
		this.prevBtnPage = prevBtnPage;
	}

	public int getNextBtnPage() {
		return nextBtnPage;
	}

	public void setNextBtnPage(int nextBtnPage) {
		this.nextBtnPage = nextBtnPage;
	}

	public List<Integer> getPageS() {
		return pageS;
	}

	public void setPageS(List<Integer> pageS) {
		this.pageS = pageS;
	}
	
	

	public String getSearchKind() {
		return searchKind;
	}

	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public Map<String, String> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(Map<String, String> searchMap) {
		this.searchMap = searchMap;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	

	
	
	
	
	
}
