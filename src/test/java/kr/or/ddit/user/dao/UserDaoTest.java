package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

	private UserDaoInf userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
	}
	
	@Test
	public void selectUserAll(){
		
	
		/***Given***/ 
		/* UserDao 객체를 생성 */

		/***When***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println("list : " + list.size());
		System.out.println("list : " + list);
		
		/***Then***/
		           // 예상값 , 결과값 
		//assertEquals(5, list.size());
	}
	
	@Test
	public void selectUser(){
		/***Given***/ 
		/* UserDao 객체를 생성 */

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
		
		PageVo pagevo = new PageVo();
		
		pagevo.setPage(1);
		pagevo.setPageSize(10);
		
		List<UserVo> userList = userDao.selectUserPageList(pagevo);
		
	//	assertEquals(1, pagevo.getPage());
		assertEquals(10, pagevo.getPageSize());
		
		
	}
	/**
	 * Method : getUserCntTest
	 * 작성자 : pc07
	 * 변경이력 :
	 * Method 설명 : 사용자 전체 건수 조회 테스트 
	 */
	@Test
	public void getUserCntTest(){
		
		/***Given***/
		

		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, totalUserCnt);
	}
}
