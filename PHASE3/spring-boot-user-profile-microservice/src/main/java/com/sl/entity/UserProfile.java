package com.sl.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userprofile")
public class UserProfile {

	@Id
	private String id;

	private String name;

	private String subscriberType;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

}
