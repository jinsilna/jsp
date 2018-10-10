package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserDaoTest {
	@Test
	public void selectUserAll(){
		
	
		/***Given***/ 
		/* UserDao 객체를 생성 */
		UserDao userDao = new UserDao();

		/***When***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println("list : " + list.size());
		System.out.println("list : " + list);
		
		/***Then***/
		           // 예상값 , 결과값 
		assertEquals(5, list.size());
	}
	
	@Test
	public void selectUser(){
		/***Given***/ 
		/* UserDao 객체를 생성 */
		UserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = userDao.selectUser("brown");
		
		System.out.println("brown : " + userVo.toString());
		/***Then***/
		           // 예상값 , 결과값 
	
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	@Test
	public void selectUserByVo(){
		
		/***Given***/ 
		/* UserDao 객체를 생성 */
		UserDao userDao = new UserDao();
		
		/***When***/
		UserVo userVo = userDao.selectUser("brown");
		
		System.out.println("brown : " + userVo.toString());
		/***Then***/
	
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		// 예상값 , 결과값 
		assertEquals("brown", userVo.getUserId());
	}
	
	@Test
	public void slectUserPageList(){
		UserDao userDao = new UserDao();
		
		
		
	}
}
