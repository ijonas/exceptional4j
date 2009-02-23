package com.ijonas.exceptional4j;

import static org.junit.Assert.*;
import org.junit.*;
import com.ijonas.exceptional4j.ExceptionData;
import com.ijonas.exceptional4j.Exceptional;

import org.apache.commons.httpclient.*;
import static org.mockito.Mockito.*;

public class ExceptionalTest {

	HttpClient mHttpClient;
	
	@Before
	public void setup() {
		mHttpClient = mock(HttpClient.class);
	}
	
		
	@Test
	public void testSimpleConstructor() throws Exception {
		Exceptional exceptional = new Exceptional()
		assertNotNull(exceptional);
	}
	
	@Test
	public void testUnencryptedTranfer() throws Exception {
		
	}
	
	@Test
	public void testEncryptedTranfer() throws Exception {
		
	}
	
	@Test
	public void testUnencryptedTranfer() throws Exception {
		
	}

}