package org.mayank.client.simple.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

	@Bean
	public RouteBuilder routeBuilder() {
		return new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("activemq:topic:greet").unmarshal().xmljson().to("activemq:queue:greet1");
			}
		};

	}

	// @Bean
	// public RouteBuilder routeBuilderProcessor() {
	// return new RouteBuilder() {
	//
	// @Override
	// public void configure() throws Exception {
	// from("activemq:queue:greet").process(new Processor() {
	// @Override
	// public void process(Exchange exchange) throws Exception {
	// exchange.getIn().setBody(exchange.getIn().getBody(String.class) + "Mayank2");
	// }
	// }).to("activemq:queue:greet3");
	// }
	// };
	//
	// }
}