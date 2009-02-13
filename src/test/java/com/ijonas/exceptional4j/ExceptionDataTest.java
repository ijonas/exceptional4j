package com.ijonas.exceptional4j;

import static org.junit.Assert.*;
import org.junit.*;
import com.ijonas.exceptional4j.ExceptionData;
import java.text.SimpleDateFormat;

public class ExceptionDataTest {
	
	public static String exceptedJsonOutput = "{\"language\":\"java\",\"exception_class\":\"java.lang.Exception\",\"exception_message\":\"Something really bad has occured.\",\"exception_backtrace\":[\"com.ijonas.exceptional4j.Test (line 5)\",\"com.ijonas.exceptional4j.Test (line 3)\"],\"occured_at\":\"20090213 10:41:14 GMT\",\"parameters\":{},\"session\":{},\"environment\":{\"HOME\":\"Timbuktu\",\"PATH\":\"To the promised land\"}}";
		
	@Test
	public void testSimpleConstructor() throws Exception {
		ExceptionData exceptionData = new ExceptionData();
		assertEquals("java", exceptionData.getLanguage());
		assertEquals(0, exceptionData.getException_backtrace().size());
		assertEquals(0, exceptionData.getParameters().size());
		assertEquals(0, exceptionData.getSession().size());
		assertTrue(exceptionData.getEnvironment().size() > 0);
		assertNotNull(exceptionData.getOccured_at());
	}
	
	@Test
	public void testExceptionConstructor() throws Exception {			
		try {
			throw new Exception("Something really bad has occured.");
		} catch (Exception e) {
			ExceptionData exceptionData = new ExceptionData( e );
			assertEquals("java", exceptionData.getLanguage());
			assertEquals(e.getStackTrace().length, exceptionData.getException_backtrace().size());
			assertEquals(0, exceptionData.getParameters().size());
			assertEquals(0, exceptionData.getSession().size());
			assertTrue(exceptionData.getEnvironment().size() > 0);
			assertNotNull(exceptionData.getOccured_at());		
			assertEquals("java.lang.Exception", exceptionData.getException_class());
			assertEquals("Something really bad has occured.", exceptionData.getException_message());
		}
	}
	
	@Test
	public void testJSonSerialization() throws Exception {
		try {
			throw new Exception("Something really bad has occured.");
		} catch (Exception e) {
			ExceptionData exceptionData = new ExceptionData( e );
			exceptionData.getEnvironment().clear();
			exceptionData.getEnvironment().put("PATH", "To the promised land");
			exceptionData.getEnvironment().put("HOME", "Timbuktu");
			exceptionData.getException_backtrace().clear();
			exceptionData.getException_backtrace().add("com.ijonas.exceptional4j.Test (line 5)");
			exceptionData.getException_backtrace().add("com.ijonas.exceptional4j.Test (line 3)");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss z");
			exceptionData.setOccured_at( sdf.parse("20090213 10:41:14 GMT") );
			
			assertEquals(exceptedJsonOutput, exceptionData.serialiseToJson());
		}
	}
	
}