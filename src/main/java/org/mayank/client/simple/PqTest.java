package org.mayank.client.simple;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PqTest {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();

		pq.add("C");
		pq.add("Java");
		pq.add("Python");
		pq.add("C++");

		Iterator<String> itr = pq.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}
}
