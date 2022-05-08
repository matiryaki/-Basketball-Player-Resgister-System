package com.producter.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class OverMaximumPlayerCapacityException extends RuntimeException implements GraphQLError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 96740363321912887L;
	private final Map<String, Object> extensions = new HashMap<>();

	 public OverMaximumPlayerCapacityException(String message) {
	        super(message);
	        extensions.put("maximumPlayerCapacity","Capacity must be max 12");
	    }
	
	@Override
	public List<SourceLocation> getLocations() {
		
		return null;
	}

	@Override
	public ErrorType getErrorType() {
		
		return ErrorType.DataFetchingException;
	}

}
