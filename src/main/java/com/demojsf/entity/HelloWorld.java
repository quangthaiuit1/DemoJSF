package com.demojsf.entity;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld")
public class HelloWorld {

	private String value = "A Trong";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}