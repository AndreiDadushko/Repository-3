package com.yet.spring;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
	int cacheSize;
	List<Event> cache;
	public CacheFileEventLogger(String filename, int cacheSize) {
		super(filename);
		this.cacheSize = cacheSize;
		this.cache = new ArrayList<Event>();;
	}
	@Override
	public void logEvent(Event event) {
		cache.add(event);
		if(cache.size()==cacheSize){
			WriteEventsFromCache();
			cache.clear();
		}		
		
	}
	

	public void WriteEventsFromCache() {
		for (Event event : cache) {
			super.logEvent(event);
		}	
		
	}
	
	public void destroy() {
		
		if(!cache.isEmpty()){
			WriteEventsFromCache();			
		}		
		
	}
}
