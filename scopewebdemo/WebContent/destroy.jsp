<%@ page  pageEncoding="GBK"  import="java.util.Enumeration"
	contentType="text/html; charset=GBK"%>

<%
		if(request.getParameter("destroy") != null)	{
			session.invalidate();					
		}
%>
		
<html>
<meta http-equiv="Content-Type" content="text/html;charset=gbk" />
<head>
<title>����request��session���÷�Χ��ʹ��</title>
</head>
<body>
<a href="index.jsp">�ص���ҳ</a>
</body>
</html>
