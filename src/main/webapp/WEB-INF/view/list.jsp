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
<title>列表展示页面</title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="/resource/css/index.css">
<!-- 引入js -->
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">

function goPage(page) {
		location="list?page="+page+"&name="+$("[name='name']").val()
} 
//文章详情
function PlanDetail(id) {
	$.post(
	"planByid",
	{id:id},
	function (p) {
		$("#myModal").empty();
		$("#myModal").append("项目名称:&nbsp;&nbsp;<b>"+p.name+"</b><br>"+"投资金额:&nbsp;&nbsp;"+p.amount+"<br>"+"分管领导:&nbsp;&nbsp;"+p.manager+"<br>"+"所属部门:&nbsp;&nbsp;"+p.deptName+"<br>"+"项目说明:<br>"+p.content+"<br>");		
	},"json"
	)
}

//回显
function toupdate(id) {
	location="toupdate?id="+id;
}

//全选全不选 反选
function checkall(flag) {
	$(".checkone").prop("checked",flag)
}
function checkfan() {
	$(".checkone").each(function() {
		$(this).prop("checked",!this.checked)
	})
}

function delall() {
	var ids=$(".checkone:checked").map(function() {
		return this.value
	}).get().join()
	if(ids!=null&&ids.length>0){
		if(confirm("确认删除吗")){
			location="delall?ids="+ids
		}
	}else{
		alert("您还没有选中")
	}
}
		
	
		

</script>
</head>
<body>

<div class="container">
	<form action="list" method="post">
		项目名称：<input type="text" name="name" value="${p.name }">
		<input type="submit" value="查询" class="btn btn-success">
	</form>
	<button class="btn btn-warning" onclick="checkfan()">反选</button>
	<button class="btn btn-warning" onclick="delall()">批量删除</button>
	<table class="table table-hover table-striped table-bordered" style="text-align:center">
		<tr>
			<td><input type="checkbox"  onclick="checkall(this.checked)"></td>
			<td>主键</td>
			<td>项目名称</td>
			<td>投资金额</td>
			<td>分管领导</td>
			<td>部门</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${info.list }" var="p">
			<tr>
				<td><input type="checkbox" value="${p.id }" class="checkone" ></td>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.amount}</td>
				<td>${p.manager }</td>
				<td>${p.deptName }</td>
				<td>
				<button type="button" class="btn btn-primary" data-toggle="modal" 
				data-target="#exampleModalLong" onclick="PlanDetail(${p.id})">详情</button>
				<button type="button" class="btn btn-primary" 
				 onclick="toupdate(${p.id})">更新</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<jsp:include page="/WEB-INF/view/pages.jsp"></jsp:include>
			</td>
		</tr>
	</table>


</div>	
<!-- 模态框 -->
<div  class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document" >
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">项目投资详情</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="myModal"></div>
    </div>
  </div>
</div>
</body>
</html>