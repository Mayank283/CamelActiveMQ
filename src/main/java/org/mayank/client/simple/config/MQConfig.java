package org.mayank.client.simple.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
@EnableJms
public class MQConfig {

	/** ActiveMq connection factory with default configuration */
	@Autowired
	ConnectionFactory activeMQConnectionFactory;

	/** Serialize message content to json using TextMessage */
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	/** JmsTemplate required for message producers */
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(activeMQConnectionFactory);
		template.setMessageConverter(jacksonJmsMessageConverter());
		template.setPubSubDomain(true);
		return template;
	}

	/** Required for JmsListener Configuration */
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {

		DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
		containerFactory.setConnectionFactory(activeMQConnectionFactory);
		containerFactory.setConcurrency("1-1");
		containerFactory.setPubSubDomain(true);
		return containerFactory;
	}
}