<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			
			conn = DriverManager.getConnection(url, user, pass);
			
			// 3. Statement객체 또는 PreparedStatement객체 생성 
			//		==> 질의를 수행하고 결과를 받아오는 객체
			//  	==> 이 객체의 생성은 Connection객체를 이용한다.
			stmt = conn.createStatement();
			
			// 4. Statement객체를 이용하여 질의를 수행하고
			// 		결과를 받아서 ResultSet객체에 담는다.
			//      (단, ResultSet객체는 Select문일 때만 사용한다.)
			
			int num = (int)(Math.random()*19)+1;
			
			String sql = "select * from jspstudent where no =" +num;  // 실행할 SQL명령
			
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lotto.jsp</title>
</head>
<body>
	<h2>★203호★</h2>
	<canvas id="myCanvas" width="500" height="500" 
		style="border: 1px solid #000000" > </canvas>
	<img src = "/profile/신기.gif">
	<script type="text/javascript">

			var canvas = document.getElementById("myCanvas");
			var ctx = canvas.getContext("2d");
			
		/* 	ctx.fillStyle = "#f9d5bd";
			ctx.fillRect(0,0,200,100); */ 
			
			
			ctx.beginPath();
			//원의 중심 X 좌표, 원의 중심 Y 좌표, 반지름) 
			ctx.arc(100,100,100,0,2*Math.PI);
			ctx.stroke();
			
			ctx.font = "60px Arial";
			
			 
			
		<%	if(rs.next()){%>
				ctx.fillText("<%=rs.getString("name")%>",10,115);
			<%}%>
				
			</script>
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