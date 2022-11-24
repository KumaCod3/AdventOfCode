package aOc21;

import program.Nope;

public class Day24_2021 {
/*	private static int x=0;
	private static int y=0;
	private static int w=0;
	private static int z=0;
	private static int[] camp={9,9,9,9,9,9,9,9,9,9,9,9,9,9};
	private static ArrayList<int[]> error=new ArrayList<int[]>();
*/	
	public static long calculate1(String s) {
/*		ArrayList<String[]> lista=Read.copList(s);
		int fin=0;
		
		String fi="";
		boolean tr=true;
		int giro=0;
		
		while(tr==true) {
			try {
				giro++;
				fi=calculate(lista);
				System.out.println("giro: "+giro+" zeta: "+z);
				if (z==0) {
					tr=false;
				}
				else {
					camp=redux(camp);
				}
			}
			catch(Exception e) {
				camp=redux(camp);
			}
		}
		Tool.bell();
		fin=Integer.parseInt(fi);
		return (long) fin;
	*/
		Nope no=new Nope();
		no.setVisible(true);
		return (long) 0l;
	}

	public static long calculate2(String s) {
//		ArrayList<String[]> lista=Read.copList(s);
		
		Nope no=new Nope();
		no.setVisible(true);
		
		return (long) 0l;
	}
/*	
	public static String calculate(ArrayList<String[]> lista) throws Exception {
		x=0;
		y=0;
		z=0;
		w=0;
		int count=0;
		String fi="";
		System.out.println("Provo: "+Arrays.toString(camp));
		for (String[] oper:lista) {
			if (oper[0].equals("inp")) {
				inp(oper[1], count);
				fi=fi+camp[count];
				count++;
			}
			else if (oper[0].equals("add")) {
				add(oper[1],oper[2]);
			}
			else if (oper[0].equals("mul")) {
				mul(oper[1],oper[2]);
			}
			else if (oper[0].equals("div")) {
				div(oper[1],oper[2]);
			}
			else if (oper[0].equals("mod")) {
				mod(oper[1],oper[2]);
			}
			else if (oper[0].equals("eql")) {
				eql(oper[1],oper[2]);
			}
		}
		return fi;
	}
	
	private static void add(String a, String b) {
		int ri=0;
		try {
			ri=Integer.parseInt(b);
		}
		catch (Exception e) {
			ri=recog(b);
		}
		if (a.equals("x")) {
			x=x+ri;
		}
		else if (a.equals("y")) {
			y=y+ri;
		}
		else if (a.equals("z")) {
			z=z+ri;
		}else if (a.equals("w")) {
			w=w+ri;
		}
		return;
	}
	private static void mul(String a, String b) {
		int ri=0;
		try {
			ri=Integer.parseInt(b);
		}
		catch (Exception e) {
			ri=recog(b);
		}
		if (a.equals("x")) {
			x=x*ri;
		}
		else if (a.equals("y")) {
			y=y*ri;
		}
		else if (a.equals("z")) {
			z=z*ri;
		}else if (a.equals("w")) {
			w=w*ri;
		}
		return;
	}
	private static void div(String a, String b) throws Exception {
		int ri=0;
		try {
			ri=Integer.parseInt(b);
		}
		catch (Exception e) {
			ri=recog(b);
		}
		if (ri==0) {
			throw new Exception();
		}
		if (a.equals("x")) {
			x=x/ri;
		}
		else if (a.equals("y")) {
			y=y/ri;
		}
		else if (a.equals("z")) {
			z=z/ri;
		}else if (a.equals("w")) {
			w=w/ri;
		}
		return;
	}
	private static void mod(String a, String b) throws Exception {
		int ri=0;
		try {
			ri=Integer.parseInt(b);
		}
		catch (Exception e) {
			ri=recog(b);
		}
		if (ri<=0) {
			throw new Exception();
		}
		if (a.equals("x")) {
			if (x>=0) {
				x=x%ri;
			}
			else {
				throw new Exception();
			}
		}
		else if (a.equals("y")) {
			if (y>=0) {
				y=y%ri;
			}
			else {
				throw new Exception();
			}
		}
		else if (a.equals("z")) {
			if (z>=0) {
				z=z%ri;
			}
			else {
				throw new Exception();
			}
		}else if (a.equals("w")) {
			if (w>=0) {
				w=w%ri;
			}
			else {
				throw new Exception();
			}
		}
		return;
	}
	private static void eql(String a, String b) {
		int ri=0;
		try {
			ri=Integer.parseInt(b);
		}
		catch (Exception e) {
			ri=recog(b);
		}
		if (a.equals("x")) {
			x=confronta(x,ri);
		}
		else if (a.equals("y")) {
			y=confronta(x,ri);
		}
		else if (a.equals("z")) {
			z=confronta(x,ri);
		}else if (a.equals("w")) {
			w=confronta(x,ri);
		}
		return;
	}
	private static void inp(String a, int count) {
		int ri=camp[count];
			w=ri;
	}
	private static int recog(String a) {
		int ri=0;
		if (a.equals("x")) {
			ri=x;
		}
		else if (a.equals("y")) {
			ri=y;
		}
		else if (a.equals("z")) {
			ri=z;
		}else if (a.equals("w")) {
			ri=w;
		}
		return ri;
	}
	private static int confronta(int a,int b){
		if (a==b) {
			return 1;
		}
		else {
			return 0;
		}
	}
	private static int[] redux(int[] camp) {
		int ind=13;
		boolean tr=true;
		while (tr==true) {
			for (int i=0; i<14;i++) {
				if (camp[ind-i]>1) {
					camp[ind-i]=camp[ind-i]-1;
					break;
				}
				else {
					camp[ind-i]=9;
				}
			}
			tr=false;
			for (int[] err:error) {
				if(camp[err[0]]==err[1]) {
					tr=true;
				}
			}
		}
		return camp;
	}
*/
}
