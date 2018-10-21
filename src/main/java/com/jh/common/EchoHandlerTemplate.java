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
	  
	  // Ŭ���̾�Ʈ�� ���� ���Ŀ� ����Ǵ� �޼���
	  @Override
	  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    sessionList.add(session);
	    logger.info("{"+session.getId()+"} �����");
	  }
	 
	  // Ŭ���̾�Ʈ�� ������ �޽����� �������� �� ����Ǵ� �޼���
	  @Override
	  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
	    logger.info("{"+session.getId()+"}�� ���� {"+message.getPayload()+"} ����");
	    for (WebSocketSession sess : sessionList) {
	      sess.sendMessage(new TextMessage(session.getId() + " : " + message.getPayload()));
	    }
	  }
	 
	  // Ŭ���̾�Ʈ�� ������ ������ �� ����Ǵ� �޼ҵ�
	  @Override
	  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	    sessionList.remove(session);
	    logger.info("{"+ session.getId()+"} ���� ����");
	  }
	}
