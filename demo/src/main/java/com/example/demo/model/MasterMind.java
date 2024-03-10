package com.example.demo.model;

public class MasterMind {

	private String generatedKey;
	private int size;
	private int tries;
	private String message;

	public MasterMind(int size, int tries) {
		this.size = size;
		this.tries = tries;
	}

	public MasterMind() {
	}

	public String getGeneratedKey() {
		return generatedKey;
	}

	public void setGeneratedKey(String generatedKey) {
		this.generatedKey = generatedKey;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
