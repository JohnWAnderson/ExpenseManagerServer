package com.jwa.api.payload.response;

import java.util.List;

/**
 * 
 * @author John Anderson
 *
 * @param <T> used for ItemReponseObject
 * 
 * Returns the amount of ItemReponses
 */
public class PagedResponseObject<T> {
	private List<T> content;

    public PagedResponseObject() {}

    public PagedResponseObject(List<T> content) {
        this.content = content;
    }

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
    
}
