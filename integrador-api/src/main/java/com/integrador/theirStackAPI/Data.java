package com.integrador.theirStackAPI;

import java.io.Serializable;

public class Data implements Serializable
{
	private String job_title,
	url,
	normalized_title;

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNormalized_title() {
		return normalized_title;
	}

	public void setNormalized_title(String normalized_title) {
		this.normalized_title = normalized_title;
	}
}
