package com.example.testkafka.workers;

public class Work {

	private Double temp;

	public Work() {
	}

	public Work(Double temp) {
		this.temp = temp;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Work{" +
				"temp=" + temp +
				'}';
	}
}
