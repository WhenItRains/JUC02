package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ListMain {

	public static void main(String[] args) {

		/*
		 * List<String> list = new ArrayList<>(); list = Arrays.asList("a","b","c");
		 * list.forEach(System.out::print);
		 */

		/*
		 * for (int i = 1; i <= 30; i++) { new Thread(() -> {
		 * list.add(UUID.randomUUID().toString().substring(0, 4));
		 * System.out.println(list); }, String.valueOf(i)).start();
		 * 
		 * }
		 */

		/*List<String> list = new CopyOnWriteArrayList<String>();

		for (int i = 1; i <= 30; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}*/
		mapss();
	}
	
	public static void setss() {
		Set<String> s = new CopyOnWriteArraySet<String>();
		for (int i = 1; i <= 30; i++) {
			new Thread(() -> {
				s.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(s);
			}, String.valueOf(i)).start();
		}
	}
	
	public static void mapss() {
		Map<String,String> s = new ConcurrentHashMap<String,String>();
		for (int i = 1; i <= 30; i++) {
			new Thread(() -> {
				s.put(UUID.randomUUID().toString().substring(0, 4),UUID.randomUUID().toString().substring(0, 4));
				System.out.println(s);
			}, String.valueOf(i)).start();
		}
	}

}
