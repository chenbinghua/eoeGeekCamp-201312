package com.eoe.oop.day03.usb;

public class Udisk implements USB {

	@Override
	public void read() {
		System.out.println(USB.UDISK+"��ȡ�������͵�����");
	}

	@Override
	public void write() {
		System.out.println(USB.UDISK+"��������������");
	}
}