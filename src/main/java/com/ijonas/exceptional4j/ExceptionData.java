package com.ijonas.exceptional4j;

import com.google.gson.*;
import java.util.*;

public class ExceptionData {
	
	public ExceptionData() {
		language = "java";
		exception_backtrace = new ArrayList<String>();
		parameters = new HashMap<String, String>();
		session = new HashMap<String, String>();
		
		environment = new HashMap<String, String>();
		environment.putAll(System.getenv());
		
		occured_at = new Date();		
	}
	
	public ExceptionData(Throwable t) {
		this();
		exception_class = t.getClass().getName();
		exception_message = t.getMessage();			
		for (StackTraceElement ste : t.getStackTrace()) {
			exception_backtrace.add(ste.toString());
		}		
	}
	
	// required data
	private String language;
	private String exception_class;
	private String exception_message;
	private List<String> exception_backtrace;
	
	// optional data
	private Date occured_at;
	private String framework;
	private String controller_name;
	private String action_name;
	private String application_root;
	private String url;
	private Map<String, String> parameters;
	private Map<String, String> session;
	private Map<String, String> environment;
	
	public Map<String, String> getParameters() { return parameters; }
	public Map<String, String> getSession() { return session; }
	public Map<String, String> getEnvironment() { return environment; }
	
	public String getLanguage() { return language; }
	public void setLanguage(String val) { language = val; }

	public String getException_class() { return exception_class; }
	public void setException_class(String val) { exception_class = val; }

	public String getException_message() { return exception_message; }
	public void setException_message(String val) { exception_message = val; }

	public List<String> getException_backtrace() { return exception_backtrace; }
	public void setException_backtrace(List<String> val) { exception_backtrace = val; }
	
	public Date getOccured_at() { return occured_at; }
	public void setOccured_at(Date val) { occured_at = val; }
	
	public String getFramework() { return framework; }
	public void setFramework(String val) { framework = val; }
		
	public String getController_name() { return controller_name; }
	public void setController_name(String val) { controller_name = val; }

	public String getAction_name() { return action_name; }
	public void setAction_name(String val) { action_name = val; }

	public String getApplication_root() { return application_root; }
	public void setApplication_root(String val) { application_root = val; }

	public String getUrl() { return url; }
	public void setUrl(String val) { url = val; }
	
	public String serialiseToJson() {
		Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd HH:mm:ss z").create();
		return gson.toJson(this);			
	}
}