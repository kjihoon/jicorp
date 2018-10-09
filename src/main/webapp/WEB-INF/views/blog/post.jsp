<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

    <!-- Post Content -->
    <jsp:include page="arrow.jsp"></jsp:include>
    
    <article>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
          <div class=".tail-writer-object tail-writer-preview" name="md">
			${content.CONTENT }
		  </div>
            <!-- <p>Placeholder text by
              <a href="http://spaceipsum.com/">Space Ipsum</a>. Photographs by
              <a href="https://www.flickr.com/photos/nasacommons/">NASA on The Commons</a>.</p> -->
          </div>
        </div>
      </div>
      
    </article>
    <hr>
    <div class="container">
    <div class="clearfix">
            <a name="mastercheck" class="btn btn-primary float-right" href="${pageContext.request.contextPath}/edit/contents?CONTENTS_IDX=${content.CONTENTS_IDX }">EDIT</a>
      </div>
    </div>
      
