package com.javalec.zipcode.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.util.Constant;
import com.javalec.vo.BoardVO;
import com.javalec.zipcode.vo.ZipCodeVO;


public class ZipcodeDAO {

	private Logger logger = Logger.getLogger(this.getClass().toString());
	private JdbcTemplate jdbcTemplate = null;
	
	public ZipcodeDAO() {
		jdbcTemplate = Constant.template;
	}

	public List<ZipCodeVO> select(BoardVO boardVO) {
		logger.info("select 함수호출");

		String sql = "select * from ZIPCODE_T where 1=1 ";
		
		if("uid_no".equals(boardVO.getSearchKind()) && boardVO.getSearchString() != null) 
		{
			sql += "and " + boardVO.getSearchKind() +" = '"+ boardVO.getSearchString()+"'";
		}
		if(!"".equals(boardVO.getSearchKind()) && boardVO.getSearchString() != null) 
		{
			sql += "and " + boardVO.getSearchKind() +" like '%"+ boardVO.getSearchString()+"%'";
		}
		
		sql += " order by uid_no desc offset "+boardVO.getITEMNUM()*(boardVO.getPage()-1) +" rows fetch next "+boardVO.getITEMNUM() +" rows only";
		logger.info(sql);
		
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<ZipCodeVO>(ZipCodeVO.class));
	}
	
//	private String getQuery(String mapperId, Object object) {
//		String sql = conn().getConfiguration().getMappedStatement(mapperId).getBoundSql(object).getSql();
//		
//		return sql;
//	}
	
	private int getAllPageNumber(BoardVO boardVO) {

		String sql = "select ceil(count(*)/"+boardVO.getPage()+")  from zipcode_t where 1=1 ";
		
		if("uid_no".equals(boardVO.getSearchKind()) && boardVO.getSearchString() != null) 
		{
			sql += "and " + boardVO.getSearchKind() +" = '"+ boardVO.getSearchString()+"'";
		}
		if(!"".equals(boardVO.getSearchKind()) && boardVO.getSearchString() != null) 
		{
			sql += "and " + boardVO.getSearchKind() +" like '%"+ boardVO.getSearchString()+"%'";
		}
		
		return jdbcTemplate.queryForObject(sql, java.lang.Integer.class);
	}
	
	public BoardVO setPaingBoardVO(BoardVO boardVO) {
		int allPage = getAllPageNumber(boardVO);
		
		boardVO.setPrevBtnPage(getPrevBtnPage(boardVO));
		boardVO.setNextBtnPage(getNextBtnPage(boardVO,allPage));
		boardVO.setPageS(pageS(boardVO,allPage));
		
		return boardVO;
	}

	private int getPrevBtnPage(BoardVO boardVO) {
		int prevResult = 0;
		
		int mok = (int) Math.ceil((double)boardVO.getPage()/boardVO.getPAGENUM());
		
		if(mok == 1) prevResult = 0;
		else prevResult = (mok-2)*boardVO.getPAGENUM()+1;

		return prevResult;
	}

	private int getNextBtnPage(BoardVO boardVO,int allPage) {
		int nextResult = 0;
		
		int mok = (int) Math.ceil((double)boardVO.getPage()/boardVO.getPAGENUM());
		
		nextResult = (mok)*boardVO.getPAGENUM()+1;
		if(nextResult > allPage) nextResult = 0;
		
		return nextResult;
	}

	private List<Integer> pageS(BoardVO boardVO,int allPage) {

		List<Integer> list = new ArrayList<Integer>();
		
		int mok = (int) Math.ceil((double)boardVO.getPage()/boardVO.getPAGENUM());
		
		int start = ((mok-1)*boardVO.getPAGENUM())+1;
		for (int i = start; i <= start+boardVO.getPAGENUM()-1; i++) {
			if(i > allPage) break;
			list.add(i);
		}
		return list;
	}
	
//	public static void main(String[] args) {
//		ZipcodeDAO zipcodeDAO =new ZipcodeDAO(new BoardVO());
//		/*
//		BoardVO vo = zipcodeDAO.getPaingBoardVO();
//		System.out.println("이전 페이지 = " + vo.getPrevBtnPage());
//		System.out.println("다음 페이지 = " + vo.getNextBtnPage());
//		for (int iterable_element : vo.getPageS()) {
//			System.out.println("페이지s"+iterable_element);
//		}
//		*/
//		zipcodeDAO.detail(52);
//	}
//
	public void delete(final int num) {
		String sql = "delete from ZIPCODE_T where uid_no = ?";
		//String sql = "delete from ZIPCODE_T where uid_no = "+num;
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, num);
			}
		});
		logger.info("delete쿼리 실행완료");
	}

	public ZipCodeVO detail(int num) {
		String sql = "select * from ZIPCODE_T where uid_no = "+num;
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<ZipCodeVO>(ZipCodeVO.class));
	}

//	public void update(ZipCodeVO zipCodeVO) {
//		SqlSession sqlSession = conn();
//		sqlSession.update("zipcode.mybatis.zipcode.update",zipCodeVO);
//		sqlSession.commit();
//		sqlSession.close();
//	}
//	
//	public void insert(ZipCodeVO zipCodeVO) {
//		SqlSession sqlSession = conn();
//		sqlSession.update("zipcode.mybatis.zipcode.insert",zipCodeVO);
//		sqlSession.commit();
//		sqlSession.close();
//	}

}
