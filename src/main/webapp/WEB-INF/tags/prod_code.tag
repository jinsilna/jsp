<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="code" required="false" type="java.lang.String"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;   // 쿼리문이 select일때만 필요하다.
		
		try {
			// 1. JDBC 드라이버 로딩 ==> Class.forName()을 이용한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 해당 DB에 접속하기 
			//		==> DriverManager.getConnection()을 이용하고
			//		==> 접속이 성공하면 Connection객체가 생성된다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "njs";  // 등록된 사용자 ID
			String pass = "java"; // 등록된 패스워드
			
			conn = DriverManager.getConnection(url,user,pass);
			
			// 3. Statement객체 또는 PㅃreparedStatement객체 생성 
			//		==> 질의를 수행하고 결과를 받아오는 객체
			//  	==> 이 객체의 생성은 Connection객체를 이용한다.
			stmt = conn.createStatement();
			
			// 4. Statement객체를 이용하여 질의를 수행하고
			// 		결과를 받아서 ResultSet객체에 담는다.
			//      (단, ResultSet객체는 Select문일 때만 사용한다.)
			
			String sql = "select prod_id, prod_name from prod where prod_lgu='" + code + "'"; // 실행할 SQL명령
			 
			rs = stmt.executeQuery(sql);  // sql명령이 select일 경우
			// 기타 insert, update, delete명령일 때는 executeUpdate()를
			// 사용한다. 
			
			// 5. ResultSet객체에 저장되어 있는 자료를
			//    반복문과 next()메서드를 이용하여 차례로 읽어와 
			//    처리한다.
			System.out.println("실행 쿼리문 : " + sql);
			System.out.println(" == 쿼리문 실행 결과 == ");
			
			// rs.next() ==> ResultSet객체의 데이터를 가리키는 포인터를
			//			 ==> 다음 레코드로 이동시키고 그 곳에 데이터가
			//			 ==> 있으면 true, 없으면 false를 반환한다.
		%>
		
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
	$(document).ready(function(){
		// select box value set
		$("#lang").val("${lang}");
		
		$("#lang").on("change",function(){
			$("#frm").submit();
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lotto.jsp</title>
</head>
<body>
		<form id = "frm" action="prod_code.jsp">	
			 <select name =lang id ="lang">	
		<%	while(rs.next()){%>
			 	<option value="${lang }"> <%=rs.getString("prod_name") %></option>
		<%}%>
			 </select>
		 </form>
		 
			<%	
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally{
					// 6. 사용했던 자원을 반납한다.
					if( rs!=null ) try { rs.close(); } catch (Exception e2){}
					if( stmt!=null ) try { stmt.close(); } catch (Exception e2){}
					if( conn!=null ) try { conn.close(); } catch (Exception e2){}
				}
				
				
				%>

</body>
</html>