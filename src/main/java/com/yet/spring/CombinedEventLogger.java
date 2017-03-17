package com.yet.spring;

import java.util.Map;

public class CombinedEventLogger implements EventLogger{

	Map<EventType,EventLogger> loggers;
	
	public CombinedEventLogger(Map<EventType,EventLogger> loggers) {		
		this.loggers = loggers;
	}

	@Override
	public void logEvent(Event event) {
		for (Map.Entry<EventType,EventLogger> pair : loggers.entrySet()) {
			pair.getValue().logEvent(event);
		}
	}

}
