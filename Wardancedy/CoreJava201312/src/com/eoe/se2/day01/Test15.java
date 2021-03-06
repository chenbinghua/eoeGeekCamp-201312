package com.eoe.se2.day01;
/*
 * 【示例-10】线程的异步操作带来的数据不完整性示例。
(1)	银行某账号有1000元存款。
(2)	定义User线程类，该类表示一个用户每次取出400元。
(3)	在main()中创建三个线程对象，并启动这三个线程对象，执行取钱的操作。当存款大于等于400时允许取款，否则不能取款

 */
public class Test15 {
	static int money=1000;
	public static void main(String[] args) {
		User user1=new User("张飞");
		User user2=new User("王菲");
		User user3=new User("刘亦菲");
		user1.start();
		user2.start();
		user3.start();
		
	}
	static class User extends Thread{
		public User(String name) {
			this.setName(name);
		}
		@Override
		public void run() {
			getMoney(this.getName());//取钱
		}
	}
	//对静态方法枷锁，给money静态枷锁
	private static synchronized  void getMoney(String name) {
		if(money>=400){
			System.out.println(name+"取出400元");
			money-=400;
			System.out.println("剩余"+money+"元");
			
		}else{
			System.out.println("存款不足400元");
		}
	}
	
}
