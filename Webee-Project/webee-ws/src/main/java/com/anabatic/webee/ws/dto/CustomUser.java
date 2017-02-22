/**
 * 
 */
package com.anabatic.webee.ws.dto;

/**
 * @author muchamad.girinata
 *
 */
public class CustomUser {
	private String username ="";
	private String nickname="";
	private String language = "";
	private String nik;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	
}
