package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	// jspuser 테이블 데이터 전체 조회 
	// Map이 아니고 List로 
	public List<UserVo> selectUserAll(){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();	
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		List<UserVo>  userList = session.selectList("user.selectUserAll");
		session.close();   //위에서 사용한 session객체를 닫아준다.
		return userList;
	}

	public UserVo selectUser(String userid){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();	
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		UserVo uservo = session.selectOne("user.selectUser",userid);
		session.close();
		return uservo;
	}
	
	public UserVo selectUserByVo(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();	
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		UserVo uservo = session.selectOne("user.selectUserByVo",userVo);
		session.close(); 
		return uservo;		
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		List<UserVo> userList = session.selectList("user.selectUserPageList",pageVo);
		session.close();
		return userList;
	}

	/**
	 * Method : getUserCnt
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 건수 조회 
	 */
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		int totalUserCnt= session.selectOne("user.getUserCnt");
		session.close();
		
		return totalUserCnt;
	}

	/**
	 * Method : insertUser
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 등록 
	 */
	@Override
	public int insertUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
	
		int insertUserCnt = session.insert("user.insertUser",userVo);
		
		session.commit(); // 커밋 반드시
		session.close();
	
		return insertUserCnt;
	}

	/**
	 * Method : deleteUser
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제 
	 */
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteUserCnt = session.delete("user.deleteUser",userId);
		
		session.commit(); // 커밋 반드시
		session.close();
	
		return deleteUserCnt;
	}
	

	/**
	 * Method : updateUser
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 수정 
	 */
	@Override
	public int updateUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateUserCnt = session.update("user.updateUser",userVo);
		session.commit();
		session.close();
		
		return updateUserCnt;
	}


	
	

}
