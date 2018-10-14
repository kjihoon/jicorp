<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<form  method="post" enctype="multipart/form-data" id="fileform">
		<input type="file" name="img" id="input_img">		
	</form>
	<button id="upload_img">IMG 비동기 업로드</button>
	<div id="TMP_THUMBSNAIL">대표이미지:  <span>default</span></div>
	<div id="statusMsg"></div>
	<script>
	
	$(document).ready(function(){
		var thumbnail = "${content.THUMBNAIL}";
		
		if (thumbnail!=null&&thumbnail!=""){
			$("#TMP_THUMBSNAIL span").text("/res/img/"+thumbnail.split("/")[thumbnail.split("/").length-1]);
		}
	})
	
	function addDiv(data,flag){
		console.log("addDiv")
		if (flag == true){
			status = 'primary';
		}else{
			status = 'warning';
		}
		 var alertDiv =  "<div class='col-lg-8 col-md-10 mx-auto'>"+
    	 "<div class='alert alert-"+status+" alert-dismissible fade show' role='alert'>"+ 
    	 data+
		  "</div></div>";
		  
		  return alertDiv;
	}
	
	
	function select_thumbnail(fileName){
		if ($("#edit_content").length>0){
			$("#edit_content input[name=THUMBNAIL]").val("/res/img/"+fileName);
		}else if($("#load_content").length>0){
			$("#load_content input[name=THUMBNAIL]").val("/res/img/"+fileName);
		}
		
		$("#TMP_THUMBSNAIL span").text("/res/img/"+fileName);
		
	}
		
		$('#upload_img').on('click', function () {
			var fileMsg;
			console.log('btn-upload'); 
			var form = new FormData(document.getElementById('fileform')); 
			$.ajax({ 
				url: "${pageContext.request.contextPath}/imgload", 
				data: form, 
				dataType: 'text', 
				processData: false, 
				contentType: false, 
				type: 'POST', 
				success: function (response) { 
					console.log(response);
					if (response == "fail" || response == "이미 존재하는 파일(동일한 이름 포함)"){
						fileMsg = addDiv(response,false);
				        $("#statusMsg").append(fileMsg);
						return;
					}
		        	fileMsg = addDiv(response,true);
		        	$("#statusMsg").append(fileMsg);
		        	
		        	(function(){
		        		$(".alert-primary").click(function(){
		        			alert($(this).text()+"를 썸네일로 하겠냐?")
		        			select_thumbnail($(this).text());
		        			
		        		})	
		        	})();
		        	
					
					
		        	
		        	
				}, 
					error: function (jqXHR) {
					fileMsg = addDiv("",false);
			        $("#statusMsg").append(fileMsg);	
				} 
			}); 
		});
	</script>
