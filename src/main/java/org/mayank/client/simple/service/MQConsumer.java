package org.mayank.client.simple.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MQConsumer {

	@JmsListener(destination = "greet")
	public void consumeMessage(String message) {
		System.out.println(message);
	}

//	@JmsListener(destination = "greet3")
//	public void consumeMessage2(String message) {
//
//		System.out.println(message);
//	}

}
