package com.cs157a1.payMe.Entity;

public class UserHasTransactions {
	private String sentUserName;
	private String receivedUserName;
	private String type;
	
	public UserHasTransactions() {}
	
	public UserHasTransactions(String sentUserName, String receivedUserName, String type) {
		super();
		this.sentUserName = sentUserName;
		this.receivedUserName = receivedUserName;
		this.type = type;
	}

	public String getSentUserName() {
		return sentUserName;
	}

	public void setSentUserName(String sentUserName) {
		this.sentUserName = sentUserName;
	}

	public String getReceivedUserName() {
		return receivedUserName;
	}

	public void setReceivedUserName(String receivedUserName) {
		this.receivedUserName = receivedUserName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
