package org.mayank.client.simple.controller;

import org.mayank.client.simple.model.MessageModel;
import org.mayank.client.simple.service.MQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mayankagarwal
 *
 */
@RestController
public class TestController {

	@Autowired
	MQProducer mqProducer;

	@RequestMapping(value = "/produce", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MessageModel produceMessage() {

		return mqProducer.sendMessage();
	}

}
