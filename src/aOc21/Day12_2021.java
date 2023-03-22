package aOc21;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.SwingWorker;

import program.Main;
import program.Read;
import program.Show;
import program.Tool;

public class Day12_2021 {
	static LinkedList<ArrayList<String>> path=new LinkedList<ArrayList<String>>();

	public static long calculate1(String s) {
		path.clear();
		var input=Read.copList(s);
		var inn=new ArrayList<String[]>();
		var temp=new LinkedList<ArrayList<String>>();
		var finn=new LinkedList<ArrayList<String>>();
		var firstPath=new ArrayList<String>();	// first path
		firstPath.add("start");	// add start to first path
		path.add(firstPath);	// add first path to paths


// add inverse direction
		for (String[] a:input){
			inn.add(a);
			String[] tt= {a[1],a[0]};
			inn.add(tt);
		}
		
		input.clear();
		for (String[] a:inn){
			if (a[1].equals("start")||a[0].equals("end")){
				continue;
			}
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
	
	public static long calc2(String s) {
		path.clear();
		var input=Read.copList(s);
		var inn=new ArrayList<String[]>();
		var temp=new LinkedList<ArrayList<String>>();
		var finn=new LinkedList<ArrayList<String>>();
		var firstPath=new ArrayList<String>();	// first path
		firstPath.add("TRUE");
		firstPath.add("start");	// add start to first path
		path.add(firstPath);	// add first path to paths

// add inverse directions
		for (String[] a:input){
			inn.add(a);
			String[] tt= {a[1],a[0]};
			inn.add(tt);
		}
		
		input.clear();
		for (String[] a:inn){
			if (a[1].equals("start")||a[0].equals("end")){
				continue;
			}
			input.add(a);
		}

	// add a step to every path (and separate the ended or wrong ones)
		while (path.size()>0){
//			System.out.println("Path sixe "+path.size());
//			System.out.println("fin sixe "+finn.size());
			for (ArrayList<String> a:path){
				for (String[] b:input){
					if (b[0].equals(a.get(a.size()-1))){
						var c=new ArrayList<String>();
						for (String ne:a){
							c.add(ne);
						}
						if (doppioBis(b[1], c)==false){
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
				aggiungi(d);
			}
			temp.clear();
		}
		
		Tool.bell();
		return (long) finn.size();
	}
	
// add next step and signal double
	public static void aggiungi(ArrayList<String> c){
		boolean tr=true;
		for (ArrayList<String> s : path) {
			if (s==c) {
				tr=false;
				break;
			}
		}
		if (tr) {
			path.add(c);
		}
	}
	
	public static boolean doppio(String x,ArrayList<String> c){
		boolean dop=false;
		if (x.charAt(0)>='a'&&x.charAt(0)<='z') {
			for (String h : c) {
				if (h.equals(x)){
					dop=true;
				}
			}
		}
		return dop;
	}
	
	public static boolean doppioBis(String x,ArrayList<String> c){
		boolean cop=false;
		for (int i=0;i<c.size();i++) {
			ArrayList<String> tt=new ArrayList<String>();
			tt.addAll(c);
			tt.remove(i);
			cop=doppio(c.get(i),tt);
			if (cop) {
				break;
			}
		}
		boolean ne=doppio(x,c);
		return ne&&cop;
	}
	
	public static long calculate2(String s) {
		Show ss=new Show("Please waith, this should take an average of 2/3 minutes...");
		ss.setVisible(true);
		
		SwingWorker<Long, Void> worker = new SwingWorker<Long, Void>() { @Override
				    public Long doInBackground() {
						return calc2(s);
			    }
		
			    @Override
			    public void done() {
			    	 try {
			        	 Main.resulT.setText(""+get());
			        	 ss.dispose();
			        	 
			         } catch (Exception ignore) {}
			    }
			};
		worker.execute();
		return 0;
	}
}