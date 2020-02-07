<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@  taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"   %>
<%@  taglib prefix="f" uri="http://www.springframework.org/tags/form" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/resource/css/index.css">
<!-- 引入js -->
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		$.post(
			"deptSelects",
			function(depts) {
				for ( var i in depts) {
					$("#dept").append("<option value='"+depts[i].id+"'>"+depts[i].name+"</option>")
				}
				$("#dept").val('${p.dept_id}')
			},"json"
		)
		
		$("#con").text('${p.content}')
	})
</script>
</head>
<body>
<form action="update" method="post">
	<input type="hidden" name="id" value="${p.id }">
  <div class="form-group">
    <label for="name"><font color="blue">项目名称</font></label>
    <input type="text" class="form-control" id="name" name="name" value="${p.name }" >
  </div>
  <div class="form-group">
    <label for="dept"><font color="blue">所属部门</font></label>
    <select class="form-control" id="dept" name="dept_id">    
    </select>
  </div>
  <div class="form-group">
    <label for="amo"><font color="blue">投资金额</font></label>
    <input type="text" class="form-control" id="amo" name="amount" value="${p.amount }">
  </div>
  <div class="form-group">
    <label for=man"><font color="blue">分管领导</font></label>
    <input type="text" class="form-control" id="man" name="manager" value="${p.manager }">
  </div>
  <div class="form-group">
    <label for="con"><font color="blue">项目说明</font></label>
    <textarea class="form-control" id="con" rows="3" name="content"></textarea>
  </div>
  <input type="submit" value="发布" class="btn btn-primary">
</form>
	

</body>
</html>