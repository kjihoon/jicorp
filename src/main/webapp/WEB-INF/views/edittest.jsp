
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/tail/tail_css/tail.writer.css">
	<script src="${pageContext.request.contextPath}/resources/tail/tail_js/marked.js"></script>
	<script src="${pageContext.request.contextPath}/resources/tail/tail_js/tail.writer.min.js"></script>
	
</head>
<body>
<textarea class="my-tail-editor">


</textarea>

<button id="mdtestbt">buttion</button>

<div class=".tail-writer-object tail-writer-preview">
<div id="mdtest">
</div>
</div>


 <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
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
	$("#mdtestbt").click(function(){
		var a= $("div .tail-writer-preview").html();
		
		$("#mdtest").html(a);
		//alert(a);
	})
	

</script>

</html>