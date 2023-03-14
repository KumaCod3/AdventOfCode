package aOc21;
import java.util.ArrayList;
import java.util.LinkedList;

import program.Read;
import program.Tool;

public class Day12_2021 {
	public static long calculate1(String s) {
		ArrayList<String[]> input=Read.copList(s);
		ArrayList<String[]> inn=new ArrayList<String[]>();
		LinkedList<ArrayList<String>> path=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> temp=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> finn=new LinkedList<ArrayList<String>>();
		ArrayList<String> firstPath=new ArrayList<String>();	// first path
		firstPath.add("start");	// add start to first path
		path.add(firstPath);	// add first path to paths


// add inverse direction
		for (String[] a:input){
			inn.add(a);
			boolean ce=true;
			if (a[0].equals("start")||a[1].equals("end")){
				ce=false;
			}
			if (ce){
				String[] tt= {a[1],a[0]};
				inn.add(tt);
			}
		}
		
		input.clear();
		for (String[] a:inn){
			input.add(a);
		}
		
// add a step to every path (and separate the ended or wrong ones)
		while (path.size()>0){
			for (ArrayList<String> a:path){
				for (String[] b:input){
					if (b[0].equals(a.get(a.size()-1))){
						ArrayList<String> c=new ArrayList<String>();
						for (String ne:a){
							c.add(ne);
						}
						if (doppio(b[1], c)==false){
							c.add(b[1]);
							if (c.get(c.size()-1).equals("end")){
								finn.add(c);
							}
							else {
								temp.add(c);
							}
						}
					}
				}
			}
			path.clear();
			for (ArrayList<String> d:temp){
				path.add(d);
			}
			temp.clear();
		}

		return (long) finn.size();
	}
	
	public static long calculate2(String s) {
		ArrayList<String[]> input=Read.copList(s);
		ArrayList<String[]> inn=new ArrayList<String[]>();
		LinkedList<ArrayList<String>> path=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> temp=new LinkedList<ArrayList<String>>();
		LinkedList<ArrayList<String>> finn=new LinkedList<ArrayList<String>>();
		ArrayList<String> firstPath=new ArrayList<String>();	// first path
		firstPath.add("TRUE");
		firstPath.add("start");	// add start to first path
		path.add(firstPath);	// add first path to paths

// add inverse directions
		for (String[] a:input){
			inn.add(a);
			boolean ce=true;
			if (a[0].equals("start")||a[1].equals("end")){
				ce=false;
			}
			if (ce){
				String[] tt= {a[1],a[0]};
				inn.add(tt);
			}
		}
		
		input.clear();
		for (String[] a:inn){
			input.add(a);
		}

// add a step to every path
		while (path.size()>0){
			for (ArrayList<String> a:path){
				for (String[] b:input){
					if (b[0].equals(a.get(a.size()-1))){
						ArrayList<String> c=new ArrayList<String>();
						for (String ne:a){
							c.add(ne);
						}
						for (String g:aggiungi(b[1], a)){
							c.add(g);
						
							if (c.get(c.size()-1).equals("end")){
								boolean ll=true;
								for (ArrayList<String> q:finn){
									if (q==c){
										ll=false;
									}
								}
								if (ll==true){
									finn.add(c);
								}
							}
							else if (c.get(c.size()-1).equals("zzz")){
							}
							else {
								temp.add(c);
							}
						}
					}
				}
			}
			path.clear();
			for (ArrayList<String> d:temp){
				boolean oo=true;
				for (ArrayList<String> e:path){
					if (e==d){
						oo=false;
					}
				}
				if (check(d)&&oo==true){
					path.add(d);
				}
			}
			temp.clear();
		}
		
		Tool.bell();
		return (long) finn.size();
	}
	
	
	
// check if there is a double already	
	public static boolean check(ArrayList<String> d){
		boolean ck=true;
		for (String a:d){
			if (a.equals("zzz")){
				ck=false;
			}
		}
		return ck;
	}

// add next step and signal double
	public static ArrayList<String> aggiungi(String u,ArrayList<String> c){
	//	char x=u.charAt(0);
		ArrayList<String> a=new ArrayList<String>();
		boolean dop=false;
		boolean ttt=false;
		if (u.charAt(0)>='a'&&u.charAt(0)<='z') {
			for (String h:c) {
				if (h.equals("tt")){
					ttt=true;
				}
				if (h.equals(u)){
					dop=true;
				}
			}
			if (ttt){
				if (dop){
					a.add("zzz");
				}
				else {
					a.add(u);
				}
			}
			else {
				if (dop){
					a.add("tt");
					a.add(u);
				}
				else {
					a.add(u);
				}
			}
		}
		else {
			a.add(u);
		}
		return a;
	}
	
	public static boolean doppio(String x,ArrayList<String> c){
		boolean dop=false;
		if (x.charAt(0)>='a'&&x.charAt(0)<='z') {
			for (String h:c) {
				if (h.charAt(0)=='t'){
				}
			}
			for (String h : c) {
				if (h.equals(x)){
					dop=true;
				}
			}
		}
		return dop;
	}
}