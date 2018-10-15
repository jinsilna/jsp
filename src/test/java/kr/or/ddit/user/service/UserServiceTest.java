package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	private UserServiceInf userService;
private final String NATRUE = "natrue";
	
	@Before
	public void setup(){
		userService = new UserService();
		userService.deleteUser(NATRUE);
	}
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
		// DB에서 값 바꿔서 105가 나와야한다.
		//assertEquals(5, list.size());
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

		PageVo pagevo = new PageVo();

		pagevo.setPage(1);
		pagevo.setPageSize(10);

		Map<String, Object> resultMap = userService.selectUserPageList(pagevo);

		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		
		int pageCnt = (Integer)resultMap.get("pageCnt");
		
		//	assertEquals(1, pagevo.getPage());
		assertEquals(10, userList.size());
		assertEquals(11, pageCnt);
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
		int totalUserCnt = userService.getUserCnt();
		
		/***Then***/
		//assertEquals(105, totalUserCnt);
	}
	
	

	@Test
	public void insertUserTest(){
		
		/***Given***/
		//userVo 준비
		UserVo userVo = new UserVo();
		
		userVo.setUserId("natrue");
		userVo.setPass  ("jinsilna");
		userVo.setName  ("너진실");
		userVo.setAdd1  ("addr1");
		userVo.setAdd2 ("addr2");
		userVo.setZip   ("zip");
		GregorianCalendar gc = new GregorianCalendar(2018,7,8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		userVo.setEmail ("email");
		userVo.setTel   ("tel");
		      

		/***When***/
		// userDao.insertUser()
		int cnt = userService.insertUser(userVo);
		
		/***Then***/
		// 입력 건수 비교
		
		assertEquals(1, cnt);
		
		// 필요 X 
		//userDao.deleteUser("userId");
		}
		
}
