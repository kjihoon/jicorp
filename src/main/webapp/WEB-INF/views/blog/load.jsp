<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.tail-writer-object{
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

</style>
  <!-- Post Content -->
    <article>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
         
			<div id="priview_md" class=".tail-writer-object tail-writer-preview">
			
			
			</div>
			</div>
          </div>
        </div>
    </article>
    <hr>





<div class="container">
<div class="row">
<div class="col-lg-8 col-md-10 mx-auto">
       <textarea class="my-tail-editor" id="content_md"></textarea>
        <form  method="post" id="load_content" action="${pageContext.request.contextPath}/create/contents" >
				<input type="hidden" name="TITLE">
				<input type="hidden" name="TITLE_SUB">
				<input type="hidden" name="USER_ID">
				<input type="hidden" name="CONTENT">
				<input type="hidden" name="CONTENT_MD">
				<input type="hidden" name="THUMBNAIL" value="default">
		</form>
		<jsp:include page="imgload.jsp"></jsp:include>		 

		
		
        <button class="btn btn-dark" id="priview_md_bt">미리보기</button>
        <button class="btn btn-dark" id="load_content_bt">작성</button>
</div>
</div>
</div>


<hr>
 	<!-- Custom scripts for this template -->
	<script>
	var option = {
		    width:            "100%",
		    height:           ["200px", "500px"],
		    classes:          "",
		    resize:           true,
		    indentTab:        false,
		    indentSize:       4,
		    toolbar:          [
		        "headers", "|", "bold", "italic", "strikethrough", "|", "quote", "code",
		        "codeblock", "indent", "outdent", "|", "link", "image", "table", "hr", "|",
		        "list:unordered", "list:ordered", "|", "preview"
		    ],
		    tooltip:          "top",
		    statusbar:        true
		};
		document.addEventListener("DOMContentLoaded", function(){
		    var options = option
		    // Just use an CSS Selector...
		    tail.writer(".my-tail-editor", options);
		
		});
		var TITLE;
		var TITLE_SUB;
		var USER_ID;
		var CONTENT;
		var CONTENT_MD;
		// convert to md from priview text
		
		$(document).ready(function(){
			$("#load_content_bt").hide();
		})
		$("#priview_md_bt").click(function(){
				var html_prview= $("body > div > div > div > div > div.tail-writer-preview").html();
				$("#priview_md").html(html_prview);
				TITLE = $("#priview_md h1").first().text();
				TITLE_SUB = $("#priview_md h3").first().text();
				
				
				USER_ID ="jihoon";
				CONTENT = html_prview;
				CONTENT_MD=$("#content_md").val();
				
				$("#load_content input[name=TITLE]").val(TITLE);
				$("#load_content input[name=TITLE_SUB]").val(TITLE_SUB);
				$("#load_content input[name=USER_ID]").val(USER_ID);
				$("#load_content input[name=CONTENT]").val(CONTENT);
				$("#load_content input[name=CONTENT_MD]").val(CONTENT_MD);	
				$("#load_content_bt").show();
			});
			$("#load_content_bt").click(function(){
				if (TITLE==""||TITLE_SUB==""||USER_ID==""||CONTENT==""||CONTENT==""){
					alert("표기법을 지켜주세요")
				}else{
					$("#load_content").submit();
				}
				
			});
		
		
		
		
	</script>