<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JH FILE SERVER</title>
<style>

a.disabled {
  /* Make the disabled links grayish*/
  color: gray;
  /* And disable the pointer events */
  /* pointer-events: none; */
}
a.file{
	color: red;
}
a[name=dirBtn]{
	font-weight: 700;
}
.badge:hover{
	background-color: red;
}
</style>
</head>
<body>

<div class="container">
<h1>JH FILE SERVER</h1>
<div>
<a href="${pageContext.request.contextPath}"><strong>돌아가기</strong></a>
<a href="${pageContext.request.contextPath}/manager/res"><strong>새로고침</strong></a>
</div>


<div class="row">
 <div class="col-lg-8 col-md-10 mx-auto">
<ul class="dir" name="/res">
	<li><a href="#" name="dirBtn" onclick='test(this);'>/res</a></li>
</ul>
</div>
</div>

</div>


<form  method="post" enctype="multipart/form-data" id="fileform">

<input name="uploadfile" type="file">
<input type="hidden" name="path">
</body>
<script>
$("form").hide();
	function test(thisDom){
			if ($(thisDom).attr("name")!='dirBtn'){
				return;
			}
			var path = $(thisDom).text();
			$(thisDom).addClass("disabled");
			$(thisDom).attr("onclick","upload(this)");
			var element = thisDom;
			$.ajax({
				url:"${pageContext.request.contextPath}/manager/dev?path="+path,
				type:'GET',
				dataType: "json", // after request, data type
				success: function (data) { 
					console.log(data);
					var dir = data.D;
					var file = data.F;
					//file 처리
					for (i=0;i<file.length;i++){
						var tmp = "<a class='file' href='"+path+file[i]+"' >"+path+file[i]+"     </a><span onclick='del(this)' name='"+path+file[i]+"' class='badge badge-primary'>DEL</span><br>";
						$(element).closest("ul").append(tmp);
					}
					
					//dir 처리
					for (i=0;i<dir.length;i++){
						var tmp = "<ul class='dir' name="+path+dir[i]+"><li><a href='#' onclick='test(this);' name='dirBtn'>"+path+dir[i]+"</a></li></ul>";
						$("ul[name='"+path+"']").append(tmp);
							
					}
				},
				error: function (data){
					
				}
			})
	}
	
	function del(dom){
		var check = confirm($(dom).attr("name")+"을 삭제할래?");
		var path = $(dom).attr("name");
		var element = dom;
		if (check){
			$.ajax({
				url:"${pageContext.request.contextPath}/manager/delete?path="+path,
				type:'GET',
				dataType: "json", // after request, data type
				success: function (data) { 
					if (data.flag==true){
					$("a[href='"+path+"']").html("");
					}else{
						alert("삭제 실패")
					}
				},
				error: function(){
					
				}
				
				
			})
		}		
	}
	function upload(dom){
		$("#fileform input[name='path']").val($(dom).text());
		$("#fileform input[name='uploadfile']").trigger('click'); 
		
		$(dom).after("    <span class='badge badge-primary' onclick='uploadform(this);'>UPLOAD</span>")
	}
	function uploadform(dom){
		var form = new FormData(document.getElementById('fileform'));
		var element = dom;
		if ($("#fileform input[name='uploadfile']").val() == ""){alert("파일 선택 필요함"); return;};
		$.ajax({ 
			url: "${pageContext.request.contextPath}/manager/uploadfile", 
			data: form, 
			dataType: 'json', 
			processData: false, 
			contentType: false, 
			type: 'POST', 
			success: function (response) { 
				console.log(response);
				if(response.flag == true){
					$(element).hide();
				}else{
					$(element).text(response.originalFilename);
					$(element).attr("style","background-color: red;");
				}
			}, 
				error: function (jqXHR) {
			} 
		}); 
	}
</script>
</html>