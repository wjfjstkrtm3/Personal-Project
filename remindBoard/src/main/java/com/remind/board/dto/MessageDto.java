package com.remind.board.dto;

public class MessageDto {

	private int no;
	private String sender;
	private String receiver;
	private String content;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Message [no=" + no + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content + "]";
	}
	
}
