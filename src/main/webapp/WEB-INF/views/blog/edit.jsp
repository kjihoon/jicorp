<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

  <!-- Post Content -->
    <article>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
         
			<div id="priview_md" class=".tail-writer-object tail-writer-preview" name="md">
			
			
			</div>
			</div>
          </div>
        </div>
    </article>
    <hr>





<div class="container">
<div class="row">
<div class="col-lg-8 col-md-10 mx-auto">
       <textarea class="my-tail-editor" id="content_md">${content.CONTENT_MD }</textarea>
        <form method="post" id="edit_content" action="${pageContext.request.contextPath}/update/contents">
				<input type="hidden" name="TITLE">
				<input type="hidden" name="TITLE_SUB">
				<input type="hidden" name="CONTENT">
				<input type="hidden" name="CONTENT_MD">
				<input type="hidden" name="CONTENTS_IDX">
		</form>
		
        <button class="btn btn-dark" id="priview_md_bt">미리보기</button>
        <button class="btn btn-dark" id="edit_content_bt">수정</button>
        <button class="btn btn-dark" id="delete_content_bt">삭제</button>
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
			$("#edit_content_bt").hide();
		})
		$("#priview_md_bt").click(function(){
				var html_prview= $("body > div > div > div > div > div.tail-writer-preview").html();
				$("#priview_md").html(html_prview);
				TITLE = $("#priview_md h1").first().text();
				TITLE_SUB = $("#priview_md h3").first().text();
				CONTENT = html_prview;
				CONTENT_MD=$("#content_md").val();
				CONTENTS_IDX="${content.CONTENTS_IDX}";
				
				$("#edit_content input[name=TITLE]").val(TITLE);
				$("#edit_content input[name=TITLE_SUB]").val(TITLE_SUB);
				$("#edit_content input[name=CONTENT]").val(CONTENT);
				$("#edit_content input[name=CONTENT_MD]").val(CONTENT_MD);
				$("#edit_content input[name=CONTENTS_IDX]").val(CONTENTS_IDX);	
				$("#edit_content_bt").show();
			});
			$("#edit_content_bt").click(function(){
				if (TITLE==""||TITLE_SUB==""||USER_ID==""||CONTENT==""||CONTENT_MD==""){
					alert("표기법을 지켜주세요")
				}else{
					$("#edit_content").submit();
				}
				
			});
		
		
		
		
	</script>