package com.acme.newjob.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@JsonPropertyOrder({"id","userName","token"})
public class TokenUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String userName;
    private String token; 

    
    protected TokenUser() {}
	public TokenUser(String userName, String token) {
		this.userName = userName;
		this.token = token;
	}
	public TokenUser(Long id,String userName, String token) {
		this.userName = userName;
		this.token = token;
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long idLogin) {
		this.id = idLogin;
	}
	@Override
	public String toString() {
		return "LoginResponse [idLogin=" + id + ", userName=" + userName + ", token=" + token + "]";
	}
  
}