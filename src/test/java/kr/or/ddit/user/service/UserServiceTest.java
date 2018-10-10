package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	private UserServiceInf userService;
	
	/* junit 실행주기 
	
	    @BeforeClass이 적용된 메소드 실행 (최초 1회) - 반드시 static 메소드로 선언 
	    @Before 어노테이션이 적용된 메소드 실행 (테스트 메소드 실행전 실행)
	    @Test
	    @After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행 후 실행) - 반드시 static 메소드로 선언 
	    @AfterClass 어노테이션이 적용된 메소드 실행(최초 1회)
	    
	    beforeClass
	    before --> selectUserAll --> after
	    before --> selectUser(String) --> after
	    before --> selectUser(UserVo) --> after
	    afterClass 
	    
	*/
	
	@BeforeClass
	// beforeClass는 static 
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	@Before
	public void before(){
		System.out.println("before");
		userService = new UserService();
	}
	@After
	public void after(){
		System.out.println("after");
	}
	
	
	@Test
	public void selectUserAll(){
		/***Given***/ 
		/* UserDao 객체를 생성 */
		

		/***When***/
		List<UserVo> list = userService.selectUserAll();
		System.out.println("list : " + list.size());
		System.out.println("list : " + list);
		
		/***Then***/
		           // 예상값 , 결과값 
		assertEquals(5, list.size());
	}
	
	@Test
	public void selectUserTest(){
		/***Given***/ 
		/* UserDao 객체를 생성 */

		/***When***/
		UserVo userVo = userService.selectUser("brown");
		
		System.out.println("brown : " + userVo.toString());
		/***Then***/
		           // 예상값 , 결과값 
	
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	@Test
	public void selectUserByVoTest(){
		
		/***Given***/ 
		/* UserDao 객체를 생성 */
		
		/***When***/
		UserVo userVo = userService.selectUser("brown");
		
		System.out.println("brown : " + userVo.toString());
		/***Then***/
	
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		// 예상값 , 결과값 
		assertEquals("brown", userVo.getUserId());
	}
	@Test
	public void slectUserPageListTest(){
		UserDao userDao = new UserDao();
		List<UserVo> userVo = userDao.selectUserAll();
		
		assertEquals(105, userVo.size());
		
	}

}
