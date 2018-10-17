package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public class BoardService implements BoardServiceInf {
	BoardDaoInf boardao = new BoardDao();

	@Override
	public List<BoardVo> BoardCnt() {
		return boardao.BoardCnt();
	}

	/**
	 * Method : selectBoard 작성자 : pc07 변경이력 :
	 * 
	 * @param prod_id
	 * @return Method 설명 : 게시판 아이디 가져오기
	 */
	@Override
	public BoardVo selectBoard(String prod_id) {
		return boardao.selectBoard(prod_id);
	}

	@Override
	public  Map<String, Object> selectBoardPageList(PageVo pageVo){
		List<BoardVo> boardList = boardao.selectBoardPageList(pageVo);
		int totalBoardCnt = boardao.getBoardCnt();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boardList", boardList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalBoardCnt/pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int getBoardCnt() {
		return boardao.getBoardCnt();
	}

	
	
	
	/**
	 * Method : selectUserPageList
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 조회 
	 */
	

}
