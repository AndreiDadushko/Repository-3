package com.yet.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("client")
public class Client {
	@Value("1")
String id;
	@Value("Hey! HEY! HEEEEEEY!")
String greeting;
	@Value("VALERA")
String fullName;

public Client() {
		super();
	}

public Client(String id, String fullName) {	
	this.id = id;
	this.fullName = fullName;
}

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getGreeting() {
	return greeting;
}

public void setGreeting(String greeting) {
	this.greeting = greeting;
}


}
