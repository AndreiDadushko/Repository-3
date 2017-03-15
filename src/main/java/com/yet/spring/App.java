package com.yet.spring;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
Client client;
EventLogger eventLogger;

public App(Client client, EventLogger eventLogger) {
	this.client = client;
	this.eventLogger = eventLogger;
}

public static void main(String[] args){
	ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	App app=(App)ctx.getBean("app");
	Event a1=((Event)ctx.getBean("event"));
	a1.setMsg("ABRACADABRA");
	app.logEvent(a1);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Event a2=((Event)ctx.getBean("event"));
	a2.setMsg("SHUBRABUBRA");
	app.logEvent(a2);
	ctx.close();
}

private void logEvent(Event event){
	event.setMsg(event.getMsg().replaceAll(client.getId(), client.getFullName()));
	eventLogger.logEvent(event);
}
}
