package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public interface BoardDaoInf {
	
	/**
	 * Method : selectBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 전체 가져오기 
	 */
	List<BoardVo> BoardCnt();

	
	BoardVo selectBoard(String prod_id);
	
	
	List<BoardVo> selectBoardPageList(PageVo pageVo);
	
	int getBoardCnt();
	
	
}