package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

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
		return session.selectList("user.selectUserAll");
	}

	public UserVo selectUser(String userid){
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();	
		SqlSession session = factory.openSession();
		
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		return session.selectOne("user.selectUser",userid);
	}
	
	public UserVo selectUserByVo(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();	
		SqlSession session = factory.openSession();
		
		return session.selectOne("user.selectUserByVo",userVo);
		
	}

	@Override
	public PageVo slectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		
		return session.selectOne("page.slectUserPageList",pageVo);
	}
	
}
