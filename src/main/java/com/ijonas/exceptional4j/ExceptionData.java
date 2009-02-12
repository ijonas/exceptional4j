package com.ijonas.exceptional4j;

public class ExceptionData {
	// required data
	private String language;
	private String exception_class;
	private String exception_message;
	private List<String> exception_backtrace;
	
	// optional data
	private String occured_at;
	private String framework;
	private String controller_name;
	private String action_name;
	private String application_root;
	private String url;
	private Map<String, String> parameters;
	private Map<String, String> session;
	private Map<String, String> environment;
	
}