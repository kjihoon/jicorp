<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
                Problems look mighty small from 150 miles up
              </h3>
            </a>
            <p class="post-meta">Posted by
              <a href="#">${content.USER_ID }</a>
              <!-- on September 24, 2018 -->${content.LOAD_DATE }</p>
          </div>
          <hr>
          </c:forEach>
          

          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-primary float-right" href="${pageContext.request.contextPath}/load/contents">Post&rarr;</a>
          </div>
        </div>
      </div>
    </div>

    <hr>