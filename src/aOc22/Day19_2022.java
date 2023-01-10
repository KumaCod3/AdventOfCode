package aOc22;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import program.Read;

public class Day19_2022 {
	// and Corri19
	static ArrayList<Integer> finee=new ArrayList<Integer>();
	static ArrayList<Integer> finale=new ArrayList<Integer>();
	
	public static long calculate1(String s) {
		finee.clear();
		finale.clear();
		int fin=0;
		ArrayList<int[]> list= Read.goed(s);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ArrayList<Future<?>> futures = new ArrayList<>();

		for (int i=0;i<list.size();i++) {
		  Future<?> f = executor.submit(new Corri19(list.get(i), i,24));
		  futures.add(f);
		}

		for (Future<?> f : futures) {
			try {
				f.get();
			}
			catch (Exception ee) {}
		}
		
		for (int a:finee) {
			fin=fin+a;
		}
		
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		finee.clear();
		finale.clear();
		int fin=1;
		ArrayList<int[]> list= Read.goed(s);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ArrayList<Future<?>> futures = new ArrayList<>();

		int x=list.size();
		if (list.size()>=3) {
			x=3;
		}
		for (int i=0;i<x;i++) {
		  Future<?> f = executor.submit(new Corri19(list.get(i), i,32));
		  futures.add(f);
		}

		for (Future<?> f : futures) {
			try {
				f.get();
			}
			catch (Exception ee) {}
		}
		for (int a:finale) {
			fin=fin*a;
		}
		
		return (long) fin;
	}
}