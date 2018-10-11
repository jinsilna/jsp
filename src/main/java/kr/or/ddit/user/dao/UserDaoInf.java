package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoInf {
	List<UserVo> selectUserAll();
	
	UserVo selectUser(String userid);
	
	UserVo selectUserByVo(UserVo userVo);
	
	List<UserVo> selectUserPageList(PageVo pageVo);
	
	/**
	 * Method : getUserCnt
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 건수 조회 
	 */
	int getUserCnt();
}