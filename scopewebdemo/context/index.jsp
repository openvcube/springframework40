<%@ page  pageEncoding="GBK"  import="java.util.Enumeration"
	contentType="text/html; charset=GBK"%>

<jsp:useBean id="sessionProcess" scope="session" class="test.SessionProcess" />

<html>
<meta http-equiv="Content-Type" content="text/html;charset=gbk" />
<head>
<title>����request��session���÷�Χ��ʹ��</title>
</head>
<body>
<center>
<fieldset style="background:#fedcba"><legend>�����Ự����</legend>
<form method="post" name="form1" action="index.jsp">
<table border="0" cellspacing="1" cellpadding="1" width="200">
	<tr>
		<td nowrap><b>�����session��������</b></td>
		<td><input type="text" name="name" /></td>
	</tr>
	<tr>
	<td><b>session����ֵ��</b></td>
		<td><input type="text" name="value" /></td>
	</tr>
	<tr>
		<td colspan="2" align=center>
			<input type="submit" value="����" name="add" />
		</td>
	</tr>
</table>
</center>
</form>
</fieldset>

<fieldset style="background:#fedcba"><legend>��ӡ�Ự����</legend>
<center>
<table border="0" cellspacing="10"
	cellpadding="0">
	<tr>
		<td valign="top">
		<%
				if (request.getParameter("add") != null) {					
					String nameItem = request.getParameter("name");					
					if (nameItem != null && nameItem.trim().length() > 0)
						session.setAttribute(nameItem, request.getParameter("value"));
				}
		%>
		<center>
			<table border=1 cellspacing="1" cellpadding=5 width=300 bgcolor=#dddddd>
				<tr>
					<td><center><b>��</b></center></td>
					<td><center><b>ֵ</b></center></td>
				</tr>
				<%
					Enumeration sessionNams = session.getAttributeNames();
					while (sessionNams.hasMoreElements()) {
						String name = (String) sessionNams.nextElement();
				%>
				<tr>
					<td><%= name %></td>
					<td><%= "" + session.getAttribute(name) %></td>
				</tr>
				<%
				}
				%>
			</table>
		</center>
		</td>
	</tr>
</table>
<table>
<tr>
<td>
<form method="post" name="form2" action="destroy.jsp">
<table border="0" cellspacing="1" cellpadding="1" width="200">
	<tr>
		<td align=center>
			<input type="submit" value="ʧЧ��ǰsession" name="destroy" />
		</td>
	</tr>
</table>
</center>
</form>

</td>
</tr>
</table>
</center>
</fieldset>
</body>
</html>

<%
	sessionProcess.processSessionContent(session);
%>
