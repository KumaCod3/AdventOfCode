package aOc22;

import java.util.ArrayList;
import java.util.Scanner;

public class Read {
	ArrayList<String> input=new ArrayList<String>();
	Scanner sc=new Scanner(System.in);
	ArrayList<String[]> fin=new ArrayList<String[]>();
	
	public Read(String cut) {
		leggi();
		traduci(cut);
	}
	
	public void leggi() {
		String line=sc.nextLine();
		while (!line.equals("stop")){
			input.add(line);
		}
	}
	public void traduci(String cut) {
		for (String lin:input){
			String[] og=lin.split(cut);
			fin.add(og);
			
		}
	}
	public ArrayList<String[]> get() {
		return fin;
	}
}
