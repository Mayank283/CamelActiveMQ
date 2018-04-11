package org.mayank.client.simple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BlehBleh implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("+++++++++++++++++++++BlehBleh++++++++++++++++++++++++++++");
		Thread.sleep(5000);
	}
}
