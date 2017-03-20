package com.yet.spring;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("event")
public class Event {
	@Value("666")
int id;
	@Value("SATANA")
String msg;
	@Inject
	@Resource(name="date")
Date date;
//DateFormat df;

/*public Event(Date date, DateFormat df) {
	this.date = date;
	this.df= df;
	id=new Random().nextInt(50);
}*/
	
public Event(Date date) {
	this.date = date;	
	id=new Random().nextInt(50);
}
public Event() {
	super();
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
@Override
public String toString() {
	return "Event [id=" + id + ", msg=" + msg + ", date=" + date + "]";
}

}
