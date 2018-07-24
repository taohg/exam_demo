package com.liangx.bean;

public class User {
	private String userName;
	private String userPass;
	private String userAddress;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName +", userPass=" +userPass+", userAddress=" + userAddress;
	}
}
