package com.linkedin.collections;

import java.util.*;

public class Application {

	public static void main(String[] args) {

		Guest john = new Guest("John", "Doe", false);
		Guest bob = new Guest("Bob", "Doe", false);
		Guest sonia = new Guest("Sonia", "Doe", true); //loyalty program
		Guest siri = new Guest("Siri", "Doe", true); //loyalty program

		// Queue is first in, first out, FIFO

		//difference between poll and peek is poll removes the element from the queue, peek does not.

		Queue<Guest> checkinQueue0 = new ArrayDeque<>();
		checkinQueue0.offer(john);
		checkinQueue0.offer(bob);
		print(checkinQueue0);

		Guest guest0 = checkinQueue0.poll();
		print(checkinQueue0);
		Guest guest1 = checkinQueue0.peek();
		print(checkinQueue0);
		System.out.println(guest0);

		Comparator<Guest> programComp
				= Comparator.comparing(Guest::isLoyaltyProgramMember).reversed();

		Queue<Guest> checkinQueue = new PriorityQueue<>(programComp);
		checkinQueue.add(john);
		checkinQueue.add(bob);
		checkinQueue.add(sonia);
		checkinQueue.add(siri);
		print(checkinQueue);

		Guest guest = checkinQueue.remove();
		print(checkinQueue);
		System.out.println(guest);

		Guest guest2 = checkinQueue.element();
		print(checkinQueue);
		System.out.println(guest1);


		//implementing Stack using ArrayDeque
		Deque<String> messageStack = new ArrayDeque<>();
		messageStack.push("Message 1");
		messageStack.push("Message 2");
		messageStack.push("Message 3");
		messageStack.push("Message 4");
		print(messageStack);

		System.out.println(messageStack.pop());
		messageStack.push("Message 4");
		System.out.println(messageStack.pop());
		System.out.println(messageStack.peek());

		print(messageStack);

	}

	public static void print(Deque<String> queue) {

		System.out.format("%n--Queue Contents--%n");

		int x = 0;
		for(String message : m) {
			System.out.format("%x: %s %s %n", x++, m.toString(), x == 1 ? "(Head)":"");
		}
		
		System.out.println("");
		
	}

	public static void print(Queue<Guest> queue) {

		System.out.format("%n--Queue Contents--%n");

		int x = 0;
		for(Guest guest : queue) {
			System.out.format("%x: %s %s %n", x++, guest.toString(), x == 1 ? "(Head)":"");
		}

		System.out.println("");

	}
