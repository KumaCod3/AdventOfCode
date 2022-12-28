package aOc22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import program.Read;

public class Day21_2022 {
	static String find="root";
	static long c=21973580688943l;
	
	public static long calculate1(String s) {
		long fin=calculate(s,-1);
		return fin;
	}
	
	public static long calculate2(String s) {
		long min=1;
		long max=5999999999999l;
		boolean diretto=true;
		long tMax=calculate(s,max);	
		long tMin=calculate(s,min);
		if (tMax<tMin) {
			diretto=false;
		}
		if (diretto) {
			return calculateDir(s,min,max);
		}
		return calculateInv(s,min,max);
	}
	
	public static long calculateInv(String s,long x,long y) {
		long root=c*2;
		long min=x;
		long max=y;
		long prova=0;
		while (true) {
			prova=middle(max,min)-1;
			long tMid=calculate(s,prova); 
			long tMax=calculate(s,max);	
			long tMin=calculate(s,min); 
			if (tMax<root&&tMin>root) {
				if (tMid>root) {
					min=prova;
					return calculateInv(s,min,max);
				}
				else if (tMid<root) {
					max=prova;
					return calculateInv(s,min,max);
				}
				else {
					return prova;
				}
			}
			else if (tMax<root&&tMin<root) {
				max=min;
				min=min/2;
				return calculateInv(s,min,max);
			}
			else if (tMax>root&&tMin>root) {
				min=max;
				max=max+((max-min)/2);
				return calculateInv(s,min,max);
			}
		}
	}
	
	public static long calculateDir(String s,long x,long y) {
		long root=c*2;
		long min=x;
		long max=y;
		long prova=0;
		while (true) {
			prova=middle(max,min)-1;
			long tMid=calculate(s,prova); 
			long tMax=calculate(s,max);	
			long tMin=calculate(s,min); 
			if (tMax>root&&tMin<root) {
				if (tMid<root) {
					min=prova;
					return calculateDir(s,min,max);
				}
				else if (tMid>root) {
					max=prova;
					return calculateDir(s,min,max);
				}
				else {
					return prova;
				}
			}
			else if (tMax>root&&tMin>root) {
				max=min;
				min=min/2;
				return calculateDir(s,min,max);
			}
			else if (tMax<root&&tMin<root) {
				min=max;
				max=max+((max-min)/2);
				return calculateDir(s,min,max);
			}
		}
	}
	
	public static long middle(long x, long y) {
		long fin=0;
		fin=x+((y-x)/2);
		return fin;
	}
	
	public static long calculate(String s, long x) {
		HashMap<String, Long> nums=new HashMap<String, Long>();
		HashMap<String, String[]> oper=new HashMap<String, String[]>();
		ArrayList<String[]> list=Read.elep(s);
		for (String[] mon:list) {
			if (mon.length==2) {
				nums.put(mon[0], Long.parseLong(mon[1]));
			}
			else {
				String[] op= {mon[1],mon[2],mon[3]};
				oper.put(mon[0], op);
			}
		}
		if (x>=0) {
			nums.put("humn", x);
		}
		
		while (true) {
			for (Map.Entry<String, String[]> entry : oper.entrySet()) {
				String[] op=entry.getValue();
				long a=0;
				long b=0;
				try {
					a=nums.get(op[0]);
				}
				catch (Exception e) { continue;}
				try {
					b=nums.get(op[2]);
				}
				catch (Exception e) { continue;}
				long num=0;
				if (op[1].equals("+")) {
					num=a+b;
				}
				else if (op[1].equals("-")) {
					num=a-b;
				}
				else if (op[1].equals("*")) {
					num=a*b;
				}
				else if (op[1].equals("/")) {
					num=a/b;
				}
				nums.put(entry.getKey(), num);
				if (entry.getKey().equals(find)) {
					c=b;
					return num;
				}	
			}	
		}
	}
}