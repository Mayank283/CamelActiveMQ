package org.mayank.client.simple.model;

/**
 * @author mayankagarwal
 *
 */

public class MessageModel {

	private String name;

	private int number;

	public MessageModel(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "MessageModel [name=" + name + ", number=" + number + "]";
	}
}
