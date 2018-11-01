package com.jwa.api.payload.response;

/**
 * 
 * @author John Anderson
 *
 * Response payload that gives the user their jwt token with token type
 */
public class JwtResponseObject {
	private String accessToken;
    private String tokenType = "Bearer ";

    public JwtResponseObject(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
