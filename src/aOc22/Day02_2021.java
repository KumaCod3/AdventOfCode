package aOc22;

import java.util.ArrayList;
import java.util.Scanner;

public class Day02_2021 {
	
	public static long calculate1(String s) {
		ArrayList<String[]> lista=Read.copList(s);
		int fin=0;
		String x = "";
		int val = 0;
		int dep = 0;
		int dis = 0;
		int aim = 0;
		
		for (String[] a:lista) {
			x=a[0];
			val=Integer.parseInt(a[1]);
			if (x.equals("up")) {
				aim = aim - val;
			} else if (x.equals("forward")) {
				dis = dis + val;
				dep = dep + (val * aim);
			} else if (x.equals("down")) {
				aim = aim + val;
			}
		}
		fin= dis * aim;
		return (long) fin;
	}
	public static long calculate2(String s) {
		ArrayList<String[]> lista=Read.copList(s);
		int fin=0;
		String x = "";
		int val = 0;
		int dep = 0;
		int dis = 0;
		int aim = 0;
		
		for (String[] a:lista) {
			x=a[0];
			val=Integer.parseInt(a[1]);
			if (x.equals("up")) {
				aim = aim - val;
			} else if (x.equals("forward")) {
				dis = dis + val;
				dep = dep + (val * aim);
			} else if (x.equals("down")) {
				aim = aim + val;
			}
		}
		fin= dis * dep;
		return (long) fin;
	}
}
