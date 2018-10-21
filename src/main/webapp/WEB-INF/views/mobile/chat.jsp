<!------ Include the above in your HEAD tag ---------->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1 ,user-scalable=0" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mobile-chat.css">
      <!-- Web socket CDN -->
      <script src="http://cdn.sockjs.org/sockjs-0.3.4.js"></script>
      <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
   </head>
   
   
   
   
   <body>
   
   <div id="kwakaoDiv">
      <div class="menu">
         <div class="back"> <i class="fa fa-chevron-left"></i>
         <img src="https://i.imgur.com/DY6gND0.png" draggable="false"/>
         </div>
         <div class="name" id="clientName">Client</div>
         <div class="last">Kwakao Talk</div>
      </div>
      
      
      <ol class="chat">
         
         
        
      </ol>
      <input id="message" class="textarea" type="text" placeholder="글 쓰기"/>
      <div id="sendBtn" class="emojis"></div>
      
      </div>
   </body>
   <script>
   
	  
	   
   
   		//웹소켓을 지정한 url로 연결한다.
		let sock = new SockJS("<c:url value="/kwakaotalk"/>");
		sock.onmessage = onMessage;
		sock.onclose = onClose;
		sock.onopen = helloMessage;
		var client;
		
        $(document).ready(function() {
        		setClientName();
               $("#sendBtn").click(function() {
                       sendMessage();
                       $('#message').val('')
               });
               $("#message").keydown(function(key) {
                       if (key.keyCode == 13) {// 엔터
                              sendMessage();
                              $('#message').val('')
                       }
               });
        });
        
		function setClientName(){
			 client = prompt("이름 입력해 주세요!");
	           while(client==""){
	        	   alert("하라는대로 좀해 ..")
	        	   client = prompt("이름입력해!!");
	           }
	         $("#clientName").text(client);
	     
		}
		
        function helloMessage(){
        	var msg = new MsgObj(client,client+"님이 접속하였습니다");
        	sock.send(JSON.stringify(msg));
        	$("body").scrollTop($(document).height());
        }
        
        // 메시지 전송
        function sendMessage() {
        	var msg = new MsgObj($("#clientName").text(),$("#message").val());
        	sock.send(JSON.stringify(msg));
        	$("body").scrollTop($(document).height());
        	
        }
        // 서버로부터 메시지를 받았을 때
        function onMessage(msg) {
               var data = msg.data;
               data = JSON.parse(data);
               var appendMsg;
               if (data.client==$("#clientName").text()){
            	   appendMsg = mkSelfMsg(data.msg);
               }else{
            	   appendMsg = mkOtherMsg(data.msg,data.client);
               }
               $(".chat").append(appendMsg);
               $("body").scrollTop($(document).height());
        }
        // 서버와 연결을 끊었을 때
        function onClose(evt) {
        	var msg = new MsgObj(client,client+"님이 나갔습니다.");
        	//sock.send(JSON.stringify(msg));
            //$(".chat").append("연결 끊김");
        }
        
        $(window).bind("beforeunload", function (e){
        	return "창을 닫으실래요?";
        });
        function mkOtherMsg(msg,clientName){
        	var othermsg = "<li class='other'>"+
            "<div class='avatar'><img src='https://i.imgur.com/HYcn9xO.png' draggable='false'/></div>"+
            "<div class='msg'>"+clientName+
              " <p>"+
               	msg+
               "</p>"+
              " <time>"+getTime()+"</time>"+
            "</div>"+
         "</li>";
         	return othermsg;
        }
   		function mkSelfMsg(msg){
   			var selfmsg = "<li class='self'>"+
   	        "<div class='avatar'><img src='https://i.imgur.com/DY6gND0.png' draggable='false'/></div>"+
   	        "<div class='msg'>"+
   	          " <p>"+
   	       		msg+
   	           "</p>"+
   	          " <time>"+getTime()+"</time>"+
   	        "</div>"+
   	     "</li>";
   	     return selfmsg
   		}
   		function getTime(){
   			var time = new Date();
   			return time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
   		}
   		var MsgObj = function(client,msg) {
   		  this.client = client;
   		  this.msg = msg;
   		};
   		

        
     
   
   </script>
</html>