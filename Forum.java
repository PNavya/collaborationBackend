package com.niit.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Forum")
@Component
public class Forum {
	
	@Id
	private String Forum_name;
	private String Topic_name;
	private String creation_date;
	private String userId;
	private String post;
	private String postid;
	private String comments;
	private String replies;
	public String getForum_name() {
		return Forum_name;
	}
	public void setForum_name(String forum_name) {
		Forum_name = forum_name;
	}
	public String getTopic_name() {
		return Topic_name;
	}
	public void setTopic_name(String topic_name) {
		Topic_name = topic_name;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}
	


}
