package com.mongotelusko.joblisting.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobprofile")
public class Post {

	@Id
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Post() {
		}
	public String getProfile() {
		return profile;
	}
	@Override
	public String toString() {
		return "Post [profile=" + profile + ", desc=" + desc + ", exp=" + exp + ", techs=" + Arrays.toString(techs)
				+ "]";
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String[] getTechs() {
		return techs;
	}
	public void setTechs(String[] techs) {
		this.techs = techs;
	}
	private String profile;
    private String desc;
    private int exp;
    private String techs[];
}
