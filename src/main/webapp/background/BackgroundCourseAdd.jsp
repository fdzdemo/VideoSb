<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<!--<base href="http://localhost:8080/Voids/">--><base href=".">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>智游教育</title>
<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">

<style type="text/css">
.col-md-1 {
	padding-top: 20px;
}

.a1 {
	color: gray;
}

b {
	float: right;
}
</style>
</head>

<body>


	<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
		<div class="container">			
				<h2>添加课程</h2>		
		</div>
	</div>

	<div class="container" style="margin-top: 20px;">

		<form id="infoForm" class="form-horizontal" action="addCourse.do" method="post" >
			
			<div class="form-group">
			    <label for="subjectId" class="col-sm-2 control-label">所属学科</label>
			    <div class="col-sm-10">

					<select name="subject_id" id="subject_id" class="form-control">
						<option value="0" selected="selected">请选择所属学科</option>							
							<option value="1">Web前端</option>
							<option value="2">Java</option>
							<option value="3">Android</option>
							<option value="4">IOS</option>
							<option value="5">大数据</option>
							<option value="6">UI</option>
							<option value="7">VR</option>	
							<option value="8">U3D</option>	
							<option value="9">人工智能</option>	
							<option value="10">Python</option>	
							<option value="11">PHP</option>													
					</select>

			    </div>
			  </div>					
			
			<div class="form-group">
				<label for="subject_title" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input class="form-control" name="course_title" id="course_title" placeholder="课程标题" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="courseDesc" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="course_desc" name="course_desc" rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">保存</button>
				</div>
			</div>
		</form>
	</div>

<!--[if lt IE 9]>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="./bootstrap/js/jquery-1.js"></script>
<script src="./bootstrap/js/bootstrap.js"></script>
<script src="./bootstrap/js/confirm.js"></script>
<script src="./bootstrap/js/jquery.js"></script>
<script src="./bootstrap/js/message_cn.js"></script>






<div id="modal-background" class=""></div>
<div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1">
<div class="modal-dialog modal-undefined"><div class="modal-content">
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