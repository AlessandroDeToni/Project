package it.myproject.models;

public class Stats {
	
	private int count;
	private double sum;
	private double avg;
	private double max;
	private double min;
	private double dev_std;
	
	public Stats(int count, double sum, double avg, double max, double min, double dev_std) {
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.dev_std = dev_std;
	}
	
	public int getCount() {
		return count;
	}
	
	public double getSum() {
		return sum;
	}
	
	public double getAvg() {
		return avg;
	}
	
	public double getMax() {
		return max;
	}
	
	public double getMin() {
		return min;
	}
	
	public double getDev_std() {
		return dev_std;
	}

}
