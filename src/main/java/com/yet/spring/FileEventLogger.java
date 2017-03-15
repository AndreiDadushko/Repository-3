package com.yet.spring;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;




public class FileEventLogger implements EventLogger{
String filename;

public FileEventLogger(String filename) {
	this.filename = filename;
}

@Override
public void logEvent(Event event) {
	
		try {
			FileWriter re=new FileWriter(new File(filename));
			re.append(event.getMsg());
			re.flush();
			re.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
}
public void init() throws IOException{
	File f=new File(filename);
	System.out.println("OPA");
	try{
	System.out.println(f.canWrite());
	System.out.println("NA");
	}catch(Exception e){System.out.println("efvwvwvvwfvwefv");}
}


}
