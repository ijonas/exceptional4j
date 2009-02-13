package com.ijonas.exceptional4j;

import static org.junit.Assert.*;
import org.junit.*;
import com.ijonas.exceptional4j.ExceptionData;
import com.google.gson.*;


public class ExceptionDataTest {
	ExceptionData xd;
	
	public ExceptionDataTest() {}
	
	@Before
	public void setup() {
		xd = new ExceptionData();
		
		try {
			throw new Exception("Something really bad has occured.");
		} catch (Exception e) {
			xd.setException_class(e.getClass().getName());
			xd.setException_message(e.getMessage());			
			for (StackTraceElement ste : e.getStackTrace()) {
				xd.getException_backtrace().add(ste.toString());
			}
		}
 		
	}
	
	@Test
	public void testBasicGettersAndSetters() throws Exception {
		
	}
	
	@Test
	public void testJSonSerialization() throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(xd);		
		System.out.print(jsonOutput);
	}
	
}