package com.producter.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class PlayerNotFoundException extends RuntimeException implements GraphQLError {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7421648462824143294L;
	private final Map<String, Object> extensions = new HashMap<>();

    public PlayerNotFoundException(String message, Long id) {
        super(message);
        extensions.put("invalidPlayerId", id);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}