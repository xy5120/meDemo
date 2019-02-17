package com.xy5120.test;

public class Ticket implements Runnable {
	private int tip=50;
	
	
	public void run(){
		while(true){
			synchronized (this) {
				if(tip>0){
					tip--;
					System.out.println(Thread.currentThread().getName()+",余票："+tip);
				}else{
					break;
				}
			}
			
		}
		
		System.out.println(Thread.currentThread().getName()+"线程，票已卖完");
		return;
	}

	
}
