package com.eoe.sel02.day05;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		try {
			InetAddress ip=InetAddress.getByName("127.0.0.1");
			String name =ip.getCanonicalHostName();
			boolean reachable=ip.isReachable(2000);
			System.out.println(name+"\t是否可达"+reachable);
			InetAddress.getByAddress(new byte[]{10,0,0,11});
			System.out.println(ip.getHostAddress());
			System.out.println("是否可达:"+ip.isReachable(2100));
			System.out.println(Arrays.toString(ip.getAddress()));
			System.out.println(ip.getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
