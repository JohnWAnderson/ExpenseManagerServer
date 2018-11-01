package com.jwa.api.payload.response;


/**
 * 
 * @author John Anderson
 * 
 * returns the basic user information for front end, also to make calls with user name
 */
public class UserBasicResponseObject {
    private String username;
    private String name;

    public UserBasicResponseObject( String username, String name) {
        this.username = username;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
