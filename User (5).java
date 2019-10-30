package com.neuedu.entity;

/**
* @ClassName: User
* @Description: 创建User类
* @author cps
* @date 2019年9月10日 下午6:15:00
*
*/
public class User {
	private Integer userId;
	private String userPsw;
	private String userName;
	private String userQuestion;
	private String userAnswer;
	
	public User() {
		
	}
	
    
	public User(Integer userId, String userPsw, String userName, String userQuestion, String userAnswer) {
		super();
		this.userId = userId;
		this.userPsw = userPsw;
		this.userName = userName;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
	}
	


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserPsw() {
		return userPsw;
	}


	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserQuestion() {
		return userQuestion;
	}


	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}


	public String getUserAnswer() {
		return userAnswer;
	}


	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPsw=" + userPsw + ", userName=" + userName + ", userQuestion="
				+ userQuestion + ", userAnswer=" + userAnswer + "]";
	}

}
