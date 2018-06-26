package com.misc.test;
import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.out.println("Starting Producer/Consumer");
		
		/*Producer.getInstance().start();
		Producer.getInstance().setName("PRODUCER");
		Consumer.getInstance().start();
		Consumer.getInstance().setName("CONSUMER");*/
		
		new Producer().start();
		new Consumer().start();
		
		
		
		
	    Thread.sleep(10000);
		
		
		System.out.println("Final supply chain: " + new SupplyLine().getSupply());
	}
}	

class SupplyLine {
	public final static Object lock = new Object();
	private final static List<String> supply = new ArrayList<String>();
	
	private int minValue;
	private int maxValue;
	public Object getLock() {
		return lock;
	}
	
	public SupplyLine() {
		this.minValue = 0;
		this.maxValue = 5;
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public List<String> getSupply() {
		return supply;
	}
	
	public void removeSupply() {
		supply.remove(supply.size()-1);
	}
	
	public void addSupply(int index) {
		supply.add("Supply number " + index);
	}
	
}


class Producer extends Thread {
	
	
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void produce() throws InterruptedException {
		SupplyLine supply = new SupplyLine();
		
		while(true) {
		synchronized(supply.getLock()) {
				if(supply.getSupply().size() == supply.getMaxValue()) {
					System.out.println("Max supply reached. Producer will wait now");
					try {
						supply.getLock().wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					
					supply.addSupply(supply.getSupply().size());
					System.out.println("Supply added. Total Supply now: " + supply.getSupply().size());
				
					if(supply.getSupply().size() > supply.getMinValue()) {
						System.out.println("Notifying consumer. Supply is avaliable");
						//System.out.println(Consumer.getInstance().getState());
						
						
							supply.getLock().notify();
						
						Thread.sleep(100);
					}
				}		
					
			}
		}
	}
}

class Consumer extends Thread {
	
	public final  static Consumer instance = new Consumer();
	
	public static Consumer getInstance() {
		return instance;
	}
	public void run() {
		try {
			consumer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void consumer() throws InterruptedException {
		SupplyLine supply = new SupplyLine();
	
		while(true) {
		synchronized(supply.getLock()) {

				if(supply.getSupply().size() == supply.getMinValue()) {
					System.out.println("Min supply reached. Consumer will wait now");
					try {
						supply.getLock().wait();	
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				else {
					
					supply.removeSupply();
					System.out.println("Supply consumed. Total Supply now: " + supply.getSupply().size());
					
					if(supply.getSupply().size() < supply.getMaxValue()) {
						System.out.println("Notifying producer. Supply is scarce");
						
						//System.out.println(Producer.getInstance().getState());
						
							supply.getLock().notify();
						
						Thread.sleep(100);
						
					}
				}
			}
		}
	}
}