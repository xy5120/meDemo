package com.xy5120.test;

public class ThreadText {

	static int tip=50;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ticket ticket1=new Ticket();
		Ticket ticket2=new Ticket();
		Thread t1=new Thread(ticket1);
		Thread t2=new Thread(ticket2);
		t1.setName("1线程");
		t2.setName("2线程");
		t1.start();
		t2.start();
	}
	/*public static void run(){
		while(tip>0){
			
			tip--;
			System.out.println(Thread.currentThread()+",余票："+tip);
			if(){
				tip--;
				System.out.println(Thread.currentThread()+",余票："+tip);
			}else{
				System.out.println(Thread.currentThread()+"线程，票已卖完");
				return;
			}
		}
		System.out.println(Thread.currentThread()+"线程，票已卖完");
		return;
		
	}*/
	

}
