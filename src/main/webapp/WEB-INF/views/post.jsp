<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/tail/tail_css/tail.writer.css">
	<script src="${pageContext.request.contextPath}/resources/tail/tail_js/marked.js"></script>
	<script src="${pageContext.request.contextPath}/resources/tail/tail_js/tail.writer.min.js"></script>
	
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/clean-blog.min.css" rel="stylesheet">
<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
 
.container{
     font-family: 'Nanum Pen Script', cursive;
}
</style>
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index.html">Start Bootstrap</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.html">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="post.html">Sample Post</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('img/post-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-heading">
              <h1>Man must explore, and this is exploration at its greatest</h1>
              <h2 class="subheading">Problems look mighty small from 150 miles up</h2>
              <span class="meta">Posted by
                <a href="#">Start Bootstrap</a>
                on August 24, 2018</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Post Content -->
    <article>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
          
          <textarea class="my-tail-editor">
</textarea>

<button id="mdtestbt">buttion</button>

<div id="mdtestdiv" class=".tail-writer-object tail-writer-preview">
<div id="mdtest">
</div>
</div>
          
          
          
           
            <p>Placeholder text by
              <a href="http://spaceipsum.com/">Space Ipsum</a>. Photographs by
              <a href="https://www.flickr.com/photos/nasacommons/">NASA on The Commons</a>.</p>
          </div>
        </div>
      </div>
    </article>

    <hr>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
          </div>
        </div>
      </div>
    </footer>
	
	
	
    <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>
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
		
		// convert to md from priview text
		$("#mdtestbt").click(function(){
			var a= $("body > article > div > div > div > div.tail-writer-object.tail-writer-preview > div.tail-writer-preview").html();
			//alert(a);
			$("#mdtest").html(a);
			
		})
	</script>
  </body>

</html>
