package com.yet.spring;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("app")
public class App {
	
	
@Inject
Client client;

@Inject
@Resource(name="consoleEventLogger")
EventLogger eventLogger;
//Map<EventType,EventLogger> loggers;


/*public App(Client client, EventLogger eventLogger,Map<EventType,EventLogger> loggers) {
	this.client = client;
	this.eventLogger = eventLogger;
	this.loggers=loggers;
}*/

public App(Client client, EventLogger eventLogger) {
	this.client = client;
	this.eventLogger = eventLogger;
}

public App() {
	
}

public static void main(String[] args){
	ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
	App app=(App)ctx.getBean("app");
	Event a1=((Event)ctx.getBean("event"));
	
	app.logEvent(a1);
	/*try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Event a2=((Event)ctx.getBean("event"));
	a2.setMsg("SHUBRABUBRA");
	app.logEvent(a2,null);
	System.out.println(app.client.getGreeting());*/
	ctx.close();
	
}

/*private void logEvent(Event event, EventType type){
	EventLogger logger=loggers.get(type);
	if(logger==null){
		logger=eventLogger;
	}
	logger.logEvent(event);
}*/

private void logEvent(Event event){
	eventLogger.logEvent(event);
}
}
