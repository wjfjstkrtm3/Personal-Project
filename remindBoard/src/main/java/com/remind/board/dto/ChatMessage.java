package com.remind.board.dto;


public class ChatMessage {

	private String chatRoomId;
	private String writer;
	private String message;
	private String sessionId;
	private String fileName;
	private String fileSize;
	private MessageType type;
	
	public String getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return "ChatMessage [chatRoomId=" + chatRoomId + ", writer=" + writer + ", message=" + message + ", sessionId="
				+ sessionId + ", fileName=" + fileName + ", fileSize=" + fileSize + ", type=" + type + "]";
	}
	
	
}
