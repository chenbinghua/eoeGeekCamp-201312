package com.eoe.se1.day03;

import java.util.Scanner;

public class Test02 {
	public static final int INT_NODE = 1;
	public static final int STRING_NODE = 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-int类型的链表");
		System.out.println("2-String类型的链表");
		int select = scanner.nextInt();
		switch (select) {
		case INT_NODE:
			intLink();
			break;
		case STRING_NODE:
			NodeString();
			break;
		}
	}

	private static void NodeString() {
		Node<String> link = new Node<String>();
		Node<String> root = link;
		link.value = "菲菲";
		link.next = new Node<String>();
		link = link.next;
		link.value = "威猛";
		link.next = new Node<String>();
		link = link.next;
		link.value = "张殿菲";
		link = root;
		while (link != null) {
			System.out.println(link.value);
			link = link.next;
		}
	}

	private static void intLink() {
		Node<Integer> link = new Node<Integer>();
		Node<Integer> root = link;
		link.value = 100;
		link.next = new Node<Integer>();
		link = link.next;
		link.value = 200;
		link.next = new Node<Integer>();
		link = link.next;
		link.value = 300;
		link = root;
		while (link != null) {
			System.out.println(link.value);
			link = link.next;
		}
	}
}
