<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <c:forEach items="${contents }" var="content">           
          <div class="post-preview">
            <a href="${pageContext.request.contextPath}/select/content?CONTENTS_IDX=${content.CONTENTS_IDX}">
              <h2 class="post-title">
                ${content.TITLE }
              </h2>
              <h3 class="post-subtitle" style="font-family: 'Nanum Pen Script', cursive;">
				${content.TITLE_SUB }
              </h3>
            </a>
            <p class="post-meta">Posted by
              <a href="#">${content.USER_ID }</a>
              <!-- on September 24, 2018 --><span class="load_date">${content.LOAD_DATE }</span></p>
          </div>
          <hr>
          </c:forEach>
          

          <!-- Pager -->
          <div class="clearfix">
            <a name="mastercheck" class="btn btn-primary float-right" href="${pageContext.request.contextPath}/load/contents">POST</a>
          </div>
        </div>
      </div>
    </div>
    <hr>
   