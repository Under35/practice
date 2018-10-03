package com.shaojie.demo.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int SIZE = 1000;
		int[] data = generateData(SIZE);
		printData(data);
		List<SortMethod> sms = new LinkedList<SortMethod>();
		sms.add(new BubbleSort());
		sms.add(new SelectSort());
		sms.add(new InsertionSort());
		sms.add(new QuickSort());
		
		for(SortMethod sm : sms) {
			System.err.println(sm.getMethodName()+"-----sort: ------");
			//sort
			data = generateData(SIZE);
			long st = System.currentTimeMillis();
			sm.sort(data);
			System.out.println("sort time:"+(System.currentTimeMillis() - st));
			printData(data);
			
			//reverse
			data = generateData(SIZE);
			System.out.println("reverse sort:");
			st = System.currentTimeMillis();
			sm.reverseSort(data);
			System.out.println("end reverse time:"+(System.currentTimeMillis() - st));
			printData(data);
			
			System.err.println("-----end-----");
		}
	}

	public static int[] generateData(int num) {
		Random rand = new Random(47);
		int[] data = new int[num];
		System.out.println();
		for(int k=0;k<num;k++) {
			data[k]=rand.nextInt(num);
		}
		return data;
	}
	public static void printData(int[] data) {
		System.out.println("print data:");
		for(int d : data) {
			System.out.print(d + " ");
		}
		System.out.println("------");
	}
}
