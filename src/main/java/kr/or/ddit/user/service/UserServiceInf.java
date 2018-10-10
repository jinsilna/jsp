package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {

	List<UserVo> selectUserAll();
	
    UserVo selectUser(String userid);
	
	UserVo selectUserByVo(UserVo userVo);
	
	PageVo slectUserPageList(PageVo pageVo);
}
