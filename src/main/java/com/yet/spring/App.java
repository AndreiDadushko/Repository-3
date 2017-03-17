package com.yet.spring;


import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
Client client;
EventLogger eventLogger;
Map<EventType,EventLogger> loggers;


public App(Client client, EventLogger eventLogger,Map<EventType,EventLogger> loggers) {
	this.client = client;
	this.eventLogger = eventLogger;
	this.loggers=loggers;
}

public static void main(String[] args){
	ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	App app=(App)ctx.getBean("app");
	Event a1=((Event)ctx.getBean("event"));
	a1.setMsg("ABRACADABRA");
	app.logEvent(a1,EventType.INFO);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Event a2=((Event)ctx.getBean("event"));
	a2.setMsg("SHUBRABUBRA");
	app.logEvent(a2,null);
	System.out.println(app.client.getGreeting());
	ctx.close();
	
}

private void logEvent(Event event, EventType type){
	EventLogger logger=loggers.get(type);
	if(logger==null){
		logger=eventLogger;
	}
	logger.logEvent(event);
}
}
