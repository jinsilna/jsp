package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {
	UserDao userdao = new UserDao();
		public List<UserVo> selectUserAll(){
			return userdao.selectUserAll();
		}

		public UserVo selectUser(String userid){
			return userdao.selectUser(userid);
		}
		
		public UserVo selectUserByVo(UserVo userVo){
			return userdao.selectUserByVo(userVo);
			
		}

		@Override
		public PageVo slectUserPageList(PageVo pageVo) {
			return userdao.slectUserPageList(pageVo);
		}
}
