package aOc23;
import java.util.ArrayList;
import java.util.Arrays;
import program.Read;

public class Day6_2023 {
	
	private static int[][] tempi=new int[2][4];
	public static long calculate1(String s) {
		ArrayList<String[]> lista = Read.copListN(s);
		Long fin=1l;
		int dim=lista.get(0).length-1;

		for (int i=0;i<2;i++) {
			String[] ss=lista.get(i);
			int[] temp=new int[dim];
			int indx=0;
			for (String sss:ss) {
				String st=sss.trim();
				try {
					int x=Integer.parseInt(st);
					temp[indx]=x;
					indx++;
				}
				catch(Exception e) {}
			}
			tempi[i]=temp;
		}
		for (int[] t:tempi) {
			System.out.println(Arrays.toString(t));
		}
		for(int i=0;i<dim;i++) {
			int volte=quanteV(i);
			System.out.println(volte);
			fin=fin*volte;
		}
		return fin;
	}
	
	public static long calculate2(String s) {
		try {
			ArrayList<String> lista =(ArrayList<String>) Read.striList(s);
			Long fin=1l;
			long[] gara=new long[2];
	
			for (int i=0;i<2;i++) {
				String ss=lista.get(i);
				String riga="";
				for (int j=0;j<ss.length();j++) {
					char x=ss.charAt(j);
					if (Character.isDigit(x)) {
						riga=riga+x;
					}
				}
				long val=Long.parseLong(riga);
				gara[i]=val;
			}
			System.out.println(gara[0]+" e "+gara[1]);
			
			fin=contaVinti(gara[0], gara[1]);
			return fin;
		} catch (Exception e) {e.printStackTrace();}
		return 88l;
	}

	private static int quanteV(int in) {
		int tempo=tempi[0][in];
		int distanza=tempi[1][in];
		System.out.println("provo "+tempo+" "+distanza);
		int v=0;
		for (int i=0;i<=tempo;i++) {
			int res=tempo-i;
			int dist=i*res;
			if (dist>distanza) {
				System.out.println("ok "+dist);
				v++;
			}
		}
		return v;
	}
	
	private static long contaVinti(long tempo, long distanza) {
		System.out.println(tempo+" "+distanza);
		long min=0;
		for (long i=0;i<=tempo;i++) {
			long res=tempo-i;
			long dist=i*res;
			if (dist>distanza) {
				min=i;
				break;
			}
		}
		long max=0;
		for (long i=tempo-1;i>=0;i--) {
			long res=tempo-i;
			long dist=i*res;
			if (dist>distanza) {
				max=i;
				break;
			}
		}
		System.out.println(min+" "+max);
		return max-min+1;
	}
}
