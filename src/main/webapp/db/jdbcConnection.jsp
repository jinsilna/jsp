<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jdbcConnection.jsp</title>
</head>
<body>
	<%-- db.properties 에서 가져옴////
db.driver = oracle.jdbc.driver.OracleDriver
db.url = jdbc:oracle:thin:@localhost:1521:xe
db.username = njs  
# db에 pc07이 아니고 njs로 설정해놓음
db.password = java
 --%>
	<%	
		// 작업하기 전에 JDBC드라이버를 Build Path에 추가한다.
		
				// DB작업에 필요한 객체변수 선언
				Connection conn = null;
				try {
					// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// 2. 해당 DB에 접속하기 
					//		==> DriverManager.getConnection()을 이용하고
					//		==> 접속이 성공하면 Connection객체가 생성된다.
					
					String username = "njs";
					String password = "java";
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					
					long startTime = System.currentTimeMillis();
					
					for(int i = 0; i<30; i++){
						conn = DriverManager.getConnection(url, username, password);					
						out.println("schema" + conn.getSchema() + "<br>");
						try { conn.close(); } catch (Exception e2){}
					}
					
					long endTime = System.currentTimeMillis();
					out.println("endTime - startTime : " + (endTime - startTime) + "ms"); 
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally{
					// 6. 사용했던 자원을 반납한다.
					if( conn!=null ) try { conn.close(); } catch (Exception e2){}
				}
					
				
				
	%>
</body>
</html>