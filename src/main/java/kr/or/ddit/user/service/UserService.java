package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public class UserService implements UserServiceInf {
	    UserDao userdao = new UserDao();
		
		@Override
		public List<UserVo> selectUserAll(){
			return userdao.selectUserAll();
		}
		@Override
		public UserVo selectUser(String userid){
			return userdao.selectUser(userid);
		}
		@Override
		public UserVo selectUserByVo(UserVo userVo){
			return userdao.selectUserByVo(userVo);
			
		}
		
		/**
		 * Method : selectUserPageList
		 * 작성자 : pc07
		 * 변경이력 :
		 * @param pageVo
		 * @return
		 * Method 설명 : 사용자 페이징 조회 
		 */
		@Override
		public Map<String, Object>  selectUserPageList(PageVo pageVo) {
			
			// 페이지에 해당하는 유저 리스트 (1~10건사이)
			List<UserVo> userList  = userdao.selectUserPageList(pageVo);
			
			// 페이지 네비게이션을 위한 전체 유저 리스트 조회 
			int totalUserCnt = userdao.getUserCnt();
			
			// 결과를 담는 map 
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("userList", userList);
			resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt/pageVo.getPageSize()));
			
			
			return resultMap;
		}
		@Override
		public int insertUser(UserVo userVo) {
			// TODO Auto-generated method stub
			return userdao.insertUser(userVo);
		}
		@Override
		public int getUserCnt() {
			// TODO Auto-generated method stub
			return userdao.getUserCnt();
		}
		@Override
		public int deleteUser(String userId) {
			// TODO Auto-generated method stub
			return userdao.deleteUser(userId);
		}
	
		@Override
		public int updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userdao.updateUser(userVo);
		}
}














