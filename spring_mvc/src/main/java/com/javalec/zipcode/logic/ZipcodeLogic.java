package com.javalec.zipcode.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.javalec.vo.BoardVO;
import com.javalec.zipcode.dao.ZipcodeDAO;
import com.javalec.zipcode.vo.ZipCodeVO;


public class ZipcodeLogic {
	
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private ZipcodeDAO dao = null;
	
	public ZipcodeLogic() {
		dao = new ZipcodeDAO();
		System.out.println("ZipcodeLogic생성");
	}
	
	public List<ZipCodeVO> select(BoardVO boardVO) {
		logger.info("select 함수호출");
		
		return dao.select(boardVO);
	}
	
	public BoardVO setPaingBoardVO(BoardVO boardVO) {
		return dao.setPaingBoardVO(boardVO);
	}

	public void delete(int num) {
		dao.delete(num);
	}

	public ZipCodeVO detail(int num) {
		return dao.detail(num);
	}

//	public void update(ZipCodeVO zipCodeVO) {
//		dao.update(zipCodeVO);
//	}
//
//	public void insert(ZipCodeVO zipCodeVO) {
//		dao.insert(zipCodeVO);
//	}

	

}
