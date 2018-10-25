<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" required="false" type="java.lang.Integer"%>
<%@ attribute name="color" required ="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- length 속성이 없을경우 length 기본값 20으로 표현 
	logging.jsp 에서 length 값을 줬던걸 빼줘야한다.
--%>

length : ${length} <br>

<font color="${color }">
	<c:forEach begin="1" end="${length==null?20:length}">=</c:forEach>
		logging
	<c:forEach begin="1" end="${length==null?20:length}">=</c:forEach>
</font>