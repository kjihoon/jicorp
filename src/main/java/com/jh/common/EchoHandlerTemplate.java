package com.jh.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandlerTemplate extends TextWebSocketHandler {
	  private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	  Logger logger = Logger.getLogger(this.getClass());
	  
	  // 클라이언트와 연결 이후에 실행되는 메서드
	  @Override
	  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    sessionList.add(session);
	    logger.info("{"+session.getId()+"} 연결됨");
	  }
	 
	  // 클라이언트가 서버로 메시지를 전송했을 때 실행되는 메서드
	  @Override
	  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
	    logger.info("{"+session.getId()+"}로 부터 {"+message.getPayload()+"} 받음");
	    for (WebSocketSession sess : sessionList) {
	      sess.sendMessage(new TextMessage(session.getId() + " : " + message.getPayload()));
	    }
	  }
	 
	  // 클라이언트와 연결을 끊었을 때 실행되는 메소드
	  @Override
	  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	    sessionList.remove(session);
	    logger.info("{"+ session.getId()+"} 연결 끊김");
	  }
	}
