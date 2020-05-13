package com.emart.buyer.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * status code
	 */
	private int statusCode;

	/**
	 * error messages
	 */
	private ArrayList<String> messages = new ArrayList<>();

	/**
	 * result data
	 */
	private Object data;
	
	/**
	 * result data count
	 */
    private Integer count;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int i) {
		this.statusCode = i;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
