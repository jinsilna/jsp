package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {

	List<UserVo> selectUserAll();
	
    UserVo selectUser(String userid);
	
	UserVo selectUserByVo(UserVo userVo);
	
	
	/**
	 * Method : selectUserPageList
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 조회 
	 */
	Map<String, Object> selectUserPageList(PageVo pageVo);

}
