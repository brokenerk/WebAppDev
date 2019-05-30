<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:s="/struts-tags" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Credit Cards</title>
</head>
<body>
	<div class="row">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Number</th>
					<th>Owner</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="creditCards" var="creditCard">
					<tr>
						<td>${creditCard.id}</td>
						<td>${creditCard.number}</td>
						<td>${creditCard.owner}</td>
						<!-- Metodo PUT -->
						<td><a href="#">Edit</a></td>
						<!-- Metodo DELETE -->
						<td><a href="#">Remove</a></td>
						</tr>
				</s:iterator>
			</tbody>
		</table>
		<!-- Metodo POST -->
		<a href="#">Add new</a>
	</div>
</body>
</html>
</jsp:root>