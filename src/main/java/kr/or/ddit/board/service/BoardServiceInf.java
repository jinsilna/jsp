package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public interface BoardServiceInf {
	
	
	/**
	 * Method : selectBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 전체 가져오기 
	 */
	List<BoardVo> BoardCnt();
	
	/**
	 * Method : selectBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param prod_id
	 * @return
	 * Method 설명 : 게시판 아이디 가져오기 
	 */
	BoardVo selectBoard(String prod_id);
	
	
	/**
	 * Method : selectBoardPageList
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 페이징처리 
	 */
	Map<String, Object> selectBoardPageList(PageVo pageVo);
	
	int getBoardCnt();
}