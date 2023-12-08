package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import aOc22.Day12_2022;

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
	
	public static ArrayList<String[]> copList(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			a=a.replace("-"," ");
			String[] riga=a.split(" ");
			lista.add(riga);
		}
		return lista;
	}
	public static ArrayList<String[]> copListN(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			String[] riga=a.split(" ");
			lista.add(riga);
		}
		return lista;
	}
	
	public static ArrayList<char[]> copListCh(String s){
		ArrayList<char[]> lista= new ArrayList<char[]>();
		String[] cut=s.split("\\n");
		for (String g:cut) {
			char[] riga= new char[g.length()];
			for (int i=0;i<g.length();i++) {
				char a=g.charAt(i);
				riga[i]=a;
			}
			lista.add(riga);
		}
		return lista;
	}
	
	public static ArrayList<int[]> simp(String s){
		ArrayList<int[]> lista= new ArrayList<int[]>();
		String[] cut=s.split("\\n\\n");
		for (String a:cut) {
			String[] riga=a.split("\\n");
			int[] line=new int[riga.length];
			for (int i=0;i<riga.length;i++) {
				line[i]=Integer.parseInt(riga[i]);				
			}
			lista.add(line);
		}
		return lista;
	}

	public static ArrayList<Integer> intList(String s){
		ArrayList<Integer> lista= new ArrayList<Integer>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			int n=Integer.parseInt(a);
			lista.add(n);
		}
		return lista;
	}
	
	public static LinkedList<int[]> intCopList(String s){
			LinkedList<int[]> lista = new LinkedList<int[]>();
			String[] cut=s.split("\\n");
			for (String line:cut) {
				int[] coor = new int[4];
				line = line.replaceAll(",", " ");
				line = line.replaceAll(" -> ", " ");
				String[] y = line.split(" ");
				for (int d = 0; d < y.length; d++) {
					coor[d] = Integer.parseInt(y[d]);
				}
				lista.add(coor);
			}
			return lista;
		}
		
	public static List<String> striList(String s){
		ArrayList<String> lista= new ArrayList<String>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			lista.add(a);
		}
		return lista;
	}

	public static ArrayList<int[]> intArList(String s){
		ArrayList<int[]> lis= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			String[] riga=a.split("");
			int[] in=new int[riga.length];
			for (int i=0;i<riga.length;i++) {
				in[i]=Integer.parseInt(riga[i]);
			}
			lis.add(in);
		}
		return lis;
	}
	
	public static int[][] arOfAr(String s){
		String[] cut=s.split("\\n");
		int[][] lis=new int[cut.length][];
		for (int i=0;i<cut.length;i++) {
			String[] riga=cut[i].split("");
			int[] in=new int[riga.length];
			for (int h=0;h<riga.length;h++) {
				in[h]=Integer.parseInt(riga[h]);
			}
			lis[i]=(in);
		}
		return lis;
	}

	public static List<Integer> intVirList(String s){
		List<Integer> lista= new LinkedList<Integer>();
		String[] cut=s.split(",");
		for (String a:cut) {
			int n=Integer.parseInt(a);
			lista.add(n);
		}
		return lista;
	}

	public static ArrayList<String[]> coorList(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			a=a.replace("-"," ");
			String[] riga=a.split(" ");
			lista.add(riga);
		}
		return lista;
	}
	
	public static LinkedList<int[]> comandi(String s,int n){
		LinkedList<int[]> lista= new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		int max=n;
		int min=0-n;
		
		for (String line:cut) {
			line = line.replaceAll(",", " ");
			line = line.replaceAll("\\.\\.", " ");
			line = line.replaceAll("=", " ");
			line = line.replaceAll(" x ", " ");
			line = line.replaceAll(" y ", " ");
			line = line.replaceAll(" z ", " ");
			String[] y = line.split(" ");
			boolean range=true;
	
			int[] riga = new int[y.length];
			for (int i = 0; i < y.length; i++) {
				if (y[i].equals("on")) {
					riga[i] = 1;
				} else if (y[i].equals("off")) {
					riga[i] = 0;
				} else {
					riga[i] = Integer.valueOf(y[i]);
					if (Integer.valueOf(y[i])<min||Integer.valueOf(y[i])>max) {
						range=false;
					}
				}
			}
			if (range) {
				lista.add(riga);
			}
		}
		return lista;
	}
	
	public static LinkedList<long[]> comandi(String s){
		LinkedList<long[]> lista= new LinkedList<long[]>();
		String[] cut=s.split("\\n");
		
		for (String line:cut) {
			line = line.replaceAll(",", " ");
			line = line.replaceAll("\\.\\.", " ");
			line = line.replaceAll("=", " ");
			line = line.replaceAll(" x ", " ");
			line = line.replaceAll(" y ", " ");
			line = line.replaceAll(" z ", " ");
			String[] y = line.split(" ");
	
			long[] riga = new long[y.length];
			for (int i = 0; i < y.length; i++) {
				if (y[i].equals("on")) {
					riga[i] = 1;
				} else if (y[i].equals("off")) {
					riga[i] = 0;
				} else {
					riga[i] = Long.valueOf(y[i]);
				}
			}
			lista.add(riga);
		}
		return lista;
	}

	public static LinkedList<int[]> coor(String s){
		LinkedList<int[]> lista= new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		for (String cor:cut) {
			int[] ins=new int[2];
			String[] sing=cor.split(",");
			ins[0]=Integer.parseInt(sing[0]);
			ins[1]=Integer.parseInt(sing[1]);
			lista.add(ins);
		}
		
		return lista;
	}
			
			
	public static ArrayList<int[]> simb(String s) {
		ArrayList<int[]> tavola=new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String a:cut){
			String[] y=a.split("");
			int[] x=new int[y.length];
			for (int d=0;d<y.length;d++){
				if (y[d].equals(".")){
					x[d]=0;}
				else if (y[d].equals(">")){
					x[d]=1;}
				else if (y[d].equals("v")){
					x[d]=2;}
				}
			tavola.add(x);
			}
		return tavola;
	}
	public static ArrayList<String[]> pieg(String s){
		ArrayList<String[]> pieghe = new ArrayList<String[]>();
		
		String[] ele=s.split("\\n");
		for (String inn:ele) {
			String[] intera = inn.split(" ");
			String[] pieg = intera[2].split("=");
			pieghe.add(pieg);
		}
		
		return pieghe;
	}
	
	public static HashMap<String, String> rule(String s){
		HashMap<String, String> rules = new HashMap<String, String>();
		String[] cut=s.split("\\n");
		for (String line:cut) {
			if (line.equals("")) {
				continue;
			}
	
			line = line.replaceAll("\\-\\>", "");
			String[] y = line.split("  ");
			rules.put(y[0], y[1]);
		}
		return rules;
	}
	
	public static LinkedList<int[]> inp(String s){
		LinkedList<int[]> input = new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		for (String line:cut) {
			
			if (line.equals("")) {
				continue;
			}
		
			String[] y = line.split("");
			int[] lin = new int[y.length];
			for (int d = 0; d < y.length; d++) {
				if (y[d].equals("#")) {
					lin[d] = 1;
				}
			}
		input.add(lin);
		}
		return input;
	}
	
	public static LinkedList<int[]> coorDop(String s){
		LinkedList<int[]> lista= new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		for (String cor:cut) {
			cor = cor.replaceAll("\\-", ",");
			String[] riga=cor.split(",");
			int[] ins=new int[riga.length];
			for (int i=0;i<riga.length;i++) {
				ins[i]=Integer.parseInt(riga[i]);
			}
			lista.add(ins);
		}
		
		return lista;
	}
	public static LinkedList<int[]> coorDopD(String s){
		LinkedList<int[]> lista= new LinkedList<int[]>();
		String[] cut=s.split("\\n");
		for (String cor:cut) {
			cor = cor.replaceAll("\\-,,", "");
			String[] riga=cor.split(" ");
			int[] ins=new int[3];
			int i=0;
			for (String a:riga) {
				try {
					ins[i]=Integer.parseInt(a);
					i++;
				}
				catch (Exception e){}
			}
			lista.add(ins);
		}
		
		return lista;
	}
	public static ArrayList<String[]> copListD(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			String[] riga=a.split("");
			lista.add(riga);
		}
		return lista;
	}
	
	public static int[][] copAlt(String s){
		String[] cut=s.split("\\n");
		int[][] lista=new int[cut.length][];
		int aa='a';
		int ind=0;
		for (String a:cut) {
			String[] riga=a.split("");
			int[] rin=new int[riga.length];
			for (int i=0;i<riga.length;i++) {
				int tem=riga[i].charAt(0);
				rin[i]=tem-aa+1;
				if (rin[i]==-13) {
					rin[i]=1;
					Day12_2022.corI[0]= ind;
					Day12_2022.corI[1]= i;
				}
				else if (rin[i]==-27) {
					rin[i]='z'-'a'+1;
					Day12_2022.corF[0]= ind;
					Day12_2022.corF[1]= i;
				}
			}
			lista[ind]=rin;
			ind++;
		}
		return lista;
	}
	
	public static HashMap<Integer,LinkedList<String>>  schem(String s){
		HashMap<Integer,LinkedList<String>> car=new HashMap<Integer,LinkedList<String>>();
		HashMap<Integer,LinkedList<String>> temp=new HashMap<Integer,LinkedList<String>>();
		
		String[] righe=s.split("\\n");
		ArrayList<String[]> arr=new ArrayList<String[]>();
		for (String r:righe) {
			String[] line=r.split("");
			arr.add(line);
		}
		arr.remove(arr.size()-1);
		for(String[] r:arr) {
			for (int i=0;i<r.length;i++) {
				String b=r[i];
				Character a=b.charAt(0);
				if (Character.isUpperCase(a)) {
					try {
						temp.get(i).add(b);
					}
					catch (Exception e) {
						temp.put(i, new LinkedList<String>());
						temp.get(i).add(b);
					}
				}
			}
		}
		int[] index=new int[temp.size()];
		int ind=0;
		for (int u:temp.keySet()) {
			index[ind]=u;
			System.out.println(ind+" to "+u);
			ind++;
		}
		Arrays.sort(index);
		for (Map.Entry<Integer,LinkedList<String>> entry:temp.entrySet()) {
			int in=-1;
			for (int i=0;i<index.length;i++) {
				if (index[i]==entry.getKey())
					in=i+1;
			}
			car.put(in, entry.getValue());
		}
		return car;
	}
	
	public static ArrayList<String> singl(String s){
		ArrayList<String> lista= new ArrayList<String>();
		String[] cut=s.split("");
		for (String a:cut) {
			lista.add(a);
		}
		return lista;
	}
	public static ArrayList<String[]> copListS(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			a=a.replaceAll("\\$ ","command");
			a=a.replaceAll("/","0");
			String[] riga=a.split(" ");
			lista.add(riga);
		}
		return lista;
	}
	
	public static ArrayList<String[]> monk(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n\\n");
		for (String a:cut) {
			
			String[] riga=a.split("\\n");
			lista.add(riga);
		}
		
		return lista;
	}
	
	public static ArrayList<String> pro(String s){
		ArrayList<String> lista= new ArrayList<String>();
		s=s.replace("\\n\\n", "\\n");
		String[] cut=s.split("\\n");
		for (String a:cut) {
			
			
			lista.add(a);
		}
		
		return lista;
	}
	
	public static ArrayList<int[]> bacon(String s){
		ArrayList<int[]> lista= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			a=a.replace(",","");
			a=a.replace("="," ");
			a=a.replace(":","");
			String[] riga=a.split(" ");
			int[] fin=new int[5];
			fin[0]=Integer.parseInt(riga[3]);
			fin[1]=Integer.parseInt(riga[5]);
			fin[2]=Integer.parseInt(riga[11]);
			fin[3]=Integer.parseInt(riga[13]);
			fin[4]=Math.abs(fin[2]-fin[0])+Math.abs(fin[3]-fin[1]);
			lista.add(fin);
		}
		return lista;
	}

	public static ArrayList<int[][]> sand(String s){
		String[] cut=s.split("\\n");
		ArrayList<int[][]> lis=new ArrayList<int[][]>();
		for (int i=0;i<cut.length;i++) {
			String[] riga=cut[i].split(" -> ");
			int[][] in=new int[riga.length][];
			
			for (int h=0;h<riga.length;h++) {
				String[] coor=riga[h].split(",");
				int[] cop= {Integer.parseInt(coor[0]),Integer.parseInt(coor[1])};
				in[h]=cop;
			}
			lis.add(in);
		}
		return lis;
	}
	
	public static ArrayList<String[]> elep(String s){
		String[] cut=s.split("\\n");
		ArrayList<String[]> lis=new ArrayList<String[]>();
		for (String c:cut) {
			c=c.replace(";","");
			c=c.replace(",","");
			c=c.replace("="," ");
			c=c.replace(":","");
			String[] riga=c.split(" ");
			lis.add(riga);
		}
		return lis;
	}
	
	public static ArrayList<String[]> desrt(String s){
		String[] cut=s.split("\\n");
		ArrayList<String[]> lis=new ArrayList<String[]>();
		for (String c:cut) {
			c=c.replace("=","");
			c=c.replace("(","");
			c=c.replace(")","");
			c=c.replace(",","");
			c=c.replace("  "," ");
			String[] riga=c.split(" ");
			lis.add(riga);
		}
		return lis;
	}
	
	public static ArrayList<Integer> tetris(String s){
		ArrayList<Integer> lista= new ArrayList<Integer>();
		String[] cut=s.split("");
		for (String a:cut) {
			if (a.equals("<")) {
				lista.add(-1);
			}
			else if (a.equals(">")) {
				lista.add(+1);
			}
		}
		return lista;
	}
	
	public static ArrayList<String[]> tiles(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n\\n");
		String[] tab=cut[0].split("\\n");
		lista.add(tab);
		String[] com=new String[1];
		com[0]=cut[1];
		lista.add(com);
		return lista;
	}
	public static int[][] field(String s){
		String[] cut=s.split("\\n");
		int[][] lista=new int[cut.length][];
		for (int h=0;h<cut.length;h++) {
			cut[h]=cut[h].replace(".","0");
			cut[h]=cut[h].replace("#","9");
			String[] riga=cut[h].split("");
			int[] ri=new int[riga.length];
			for (int i=0;i<riga.length;i++){
				int p=Integer.parseInt(riga[i]);
				ri[i]=p;
			}
			lista[h]=ri;
		}
		return lista;
	}

	public static ArrayList<int[]> snow(String s){
		ArrayList<int[]> lista= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String riga:cut) {
			riga=riga.replace(".","0");
			riga=riga.replace("#","9");
			riga=riga.replace(">","1");
			riga=riga.replace("v","2");
			riga=riga.replace("<","3");
			riga=riga.replace("^","4");
			String[] ri=riga.split("");
			int[] ga=new int[ri.length];
			for (int i=0;i<ri.length;i++){
				int p=Integer.parseInt(ri[i]);
				ga[i]=p;
			}
			lista.add(ga);
		}
		return lista;
	}


	public static ArrayList<int[]> snafu(String s){
		ArrayList<int[]> lista= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String r:cut) {
			String[] ri=r.split("");
			int[] ga=new int[ri.length];
			for (int i=0;i<ri.length;i++) {
				ri[i]=ri[i].replace("-","-1");
				ri[i]=ri[i].replace("=","-2");
				int p=Integer.parseInt(ri[i]);
				ga[ri.length-1-i]=p;
			}
			lista.add(ga);
		}
		return lista;
	}

	public static ArrayList<int[]> goed(String s) {
		ArrayList<int[]> lista= new ArrayList<int[]>();
		String[] cut=s.split("\\n");
		for (String r:cut) {
			String[] ri=r.split(" ");
			String[] line= {ri[6],ri[12],ri[18],ri[21],ri[27],ri[30]};
			int[] ga=new int[6];
			for (int i=0;i<6;i++) {
				ga[i]=Integer.parseInt(line[i]);
			}
			lista.add(ga);
		}
		return lista;
	}
	public static ArrayList<String[]> copList23(String s){
		ArrayList<String[]> lista= new ArrayList<String[]>();
		String[] cut=s.split("\\n");
		for (String a:cut) {
			String[] rr=a.split(":");
			String[] riga=rr[1].split("\\|");
			lista.add(riga);
		}
		return lista;
	}
}

