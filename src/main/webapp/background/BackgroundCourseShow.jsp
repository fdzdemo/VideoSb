<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>智游教育</title>

<link href="/VideoSb/static/z/bootstrap/css/bootstrap.css" rel="stylesheet">

<script src="/VideoSb/static/js/jquery-1.js"></script>
<script src="/VideoSb/static/js/bootstrap.js"></script>
<script src="/VideoSb/static/js/confirm.js"></script>
<script src="/VideoSb/static/js/jquery.js"></script>
<script src="/VideoSb/static/js/message_cn.js"></script>

<style type="text/css">
th {
	text-align: center;
}
</style>
</head>

<body>
	<nav class="navbar-inverse">
		<div class="container">

			<div class="navbar-header">
				<a class="navbar-brand">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li><a href="http://localhost:8080/VideoSb/videoShow.do">视频管理</a></li>
					<li class="active"> <a href="http://localhost:8080/VideoSb/speakerShow.do">主讲人管理</a></li>
					<li ><a href="http://localhost:8080/VideoSb/showCourseH.do">课程管理</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<span>${admin.accounts}</span> <i
						class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a
						href="loginOut.do" class="navbar-link">退出</a>
				</p>
			</div>
			<!-- /.navbar-collapse -->


		</div>
		<!-- /.container-fluid -->
	</nav>






	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>课程管理</h2>
		</div>
	</div>

	<form action="courseDeleteAll.do">
		<div class="container">
			<button onclick="showAddPage()" type="button"
				class="btn btn-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">添加</button>
			<input id="ids" name="ids" type="hidden">
			<button onclick="deleteAll()" type="submit" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all"></th>
						<th>序号</th>
						<th style="width: 16%">标题</th>
						<th style="width: 60%">简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>

					 <c:forEach items="${list }" var="i">
        <tr>
          <td><input type="checkbox" name="select" value="${i.id }" ></td>
          <td>${i.id }</td>
          <td>${i.course_title }</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${i.course_desc }</td>
		  <td><a href="updateCourse.do?id=${i.id }">✎</a></td>
          <td><a href="javascript:void(0);" id="deletedID" onclick="delCourseById('#deletedID','${i.id}','${i.course_title}')" >X</a></td>
          </tr>
        </c:forEach>
					
					<tr>
						<td colspan="2"><font>总共${count}条,当前第${page}页</font> <c:if
								test="${count%5==0}">
								<c:set var="page" value="${count/5}">
								</c:set>
							</c:if> <c:if test="${count%5!=0}">
								<c:set var="page" value="${count/5+1}">
								</c:set>
							</c:if> <c:forEach var="i" begin="1" end="${page}">
								<a href="showCourseH.do?page=${i}">第${i}页</a>
							</c:forEach>
					</tr>
				</tbody>
			</table>

		</div>
	</form>


	<script type="text/javascript">
		$(function() {
			$("#all").click(function() {
				$("input[name='select']").attr("checked", this.checked);
			})

		})
		function deleteAll() {
			var selected = [];
			$.each($("input[name='select']"), function() {
				if (this.checked) {
					selected.push($(this).val());
				}
			})
			var ids = JSON.stringify(selected);
			$("#ids").val(ids);
		}
		function showAddPage() {
//			location.href = "http://localhost:8080/VideoSb/background/BackgroundCourseAdd.jsp";
			location.href = "addCourseShow.do";
		}
		function delCourseById(Obj, id, title) {

			Confirm.show('温馨提示：', '确定要删除' + title + '么？', {
				'Delete' : {
					'primary' : true,
					'callback' : function() {
						var param = {
							"id" : id
						};
						$.post("delCourse.do", param, function(
								data) {
							if (data == 'success') {
								Confirm.show('温馨提示：', '删除成功');
								window.location.reload();
								//$(Obj).parent().parent().remove();
							} else {
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
	</script>


	<div id="modal-background" class=""></div>
	<div id="confirm-modal" class="modal fade role=" dialog"=""
		tabindex="-1">
		<div class="modal-dialog modal-undefined">
			<div class="modal-content">
				<div class="modal-header">
					<button id="modal-upper-close" class="close modal-close"
						aria-label="Close" type="button">
						<span aria-hidden="true">×</span>
					</button>
					<h4 id="modal-title" class="modal-title">Modal Title</h4>
				</div>
				<div id="modal-body" class="modal-body">Modal Message</div>
				<div id="modal-footer" class="modal-footer"></div>
			</div>
		</div>
	</div>
	<div id="modal-background" class=""></div>
</body>
</html>