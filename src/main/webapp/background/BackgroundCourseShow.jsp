<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>智游教育</title>
		
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">

<script src="./bootstrap/js/jquery-1.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<script src="./bootstrap/js/confirm.js"></script>
<script src="./bootstrap/js/jquery.js"></script>
<script src="./bootstrap/js/message_cn.js"></script>

		<style type="text/css">
		th {
			text-align: center;
		}
		</style>
	</head>

	<body>
   
    <div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	          <h2>课程管理</h2>
	  </div>
	</div>
	
	<form action="deleteAll.do">
	<div class="container">
	    <button onclick="showAddPage()" type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      添加
		</button>
		<input name="ids" id="ids" type="hidden">
		<button onclick="deleteAll()" type="submit" id="btn" class="btn btn-info dropdown-toggle">
		      批量删除
		</button>
	</div>
	
	<div class="container" style="margin-top: 20px;">
		
		<table class="table table-bordered table-hover" style="text-align: center;table-layout:fixed;">
      <thead>
        <tr class="active">
          <th><input type="checkbox" id="all" ></th>
          <th>序号</th>
          <th style="width:16%">标题</th>
          <th style="width:60%">简介</th>
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
        </tbody>
      </table>
    
	</div>
	  </form>
	  
	 
	总共${count}条数据，当前第${page}页
	<c:if test="${count%5==0 }">
		<c:set var="page" value="${count/5}"></c:set>
	</c:if>
		<c:if test="${count%5!=0 }">
		<c:set var="page" value="${count/5+1}"></c:set>
	</c:if>
	<c:forEach var="i" begin="1" end="${page}">
	<a href="showCourseH.do?page=${i }">第${i }页</a>   
	</c:forEach>
	  
		
	<script type="text/javascript">
		function showAddPage(){
			location.href="http://localhost:8080/SSMProject/addCourse.jsp";
		}
		function delCourseById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("/SSMProject/delCourse.do",param,function(data){
							if(data=='success'){
								Confirm.show('温馨提示：', '删除成功');
								window.location.reload();
	//							$(Obj).parent().parent().remove();
							}else{
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
		
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

		
		
	</script>
  

<div id="modal-background" class=""></div>
<div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1">
<div class="modal-dialog modal-undefined">
<div class="modal-content">
<div class="modal-header">
<button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button">
<span aria-hidden="true">×</span>
</button>
<h4 id="modal-title" class="modal-title">Modal Title</h4>
</div>
<div id="modal-body" class="modal-body"> Modal Message </div>
<div id="modal-footer" class="modal-footer"></div>
</div></div></div>
<div id="modal-background" class=""></div>
</body>
</html>