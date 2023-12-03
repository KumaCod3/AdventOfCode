package aOc23;
import java.util.ArrayList;
import program.Read;

public class Day3_2023 {
	static ArrayList<int[]> simboli=new ArrayList<int[]>();

	public static long calculate1(String s) {
		ArrayList<String> lista = (ArrayList<String>) Read.striList(s);
		Long fin=0l;
		// raccolgo coordinate di tutte le posizioni valide validi
		for (int riga=0;riga<lista.size();riga++) {
			String rig=lista.get(riga);
			for (int colonna=0; colonna<rig.length();colonna++) {
				if (rig.charAt(colonna)!='.'&&!Character.isDigit(rig.charAt(colonna))) {
					int[] coor1= {riga-1,colonna-1};
					simboli.add(coor1);
					int[] coor2= {riga-1,colonna};
					simboli.add(coor2);
					int[] coor3= {riga-1,colonna+1};
					simboli.add(coor3);
					int[] coor4= {riga,colonna-1};
					simboli.add(coor4);
					int[] coor5= {riga,colonna+1};
					simboli.add(coor5);
					int[] coor6= {riga+1,colonna-1};
					simboli.add(coor6);
					int[] coor7= {riga+1,colonna};
					simboli.add(coor7);
					int[] coor8= {riga+1,colonna+1};
					simboli.add(coor8);
				}
			}
		}
		
		// cerco tutti i numeri
		for (int riga=0;riga<lista.size();riga++) {
			String rig=lista.get(riga);
			int i=0;
			while (i<rig.length()) {
				if (rig.charAt(i)=='.') {
					i++;
//					System.out.print(".");
					continue;
				}
				else if (Character.isDigit(rig.charAt(i))) {
					boolean valido=false;
					String tp=""+rig.charAt(i);
					valido=check(riga,i);
					i++;
					if (Character.isDigit(rig.charAt(i))) {
						tp=tp+rig.charAt(i);
						valido=(check(riga,i)||valido);
						i++;
						if (Character.isDigit(rig.charAt(i))) {
							tp=tp+rig.charAt(i);
							valido=(check(riga,i)||valido);
							i++;
							int ff=Integer.parseInt(tp);
//							System.out.print(ff);
							if (valido) {
								fin=fin+ff;
							}
							continue;
						}
						else {
							i++;
							int ff=Integer.parseInt(tp);
//							System.out.print(ff);
							if (valido) {
								fin=fin+ff;
							}
							continue;
						}
					}
					else {
						i++;
						int ff=Integer.parseInt(tp);
//						System.out.print(ff);
						if (valido) {
							fin=fin+ff;
						}
						continue;
					}
				}
				else {
					i++;
//					System.out.print(rig.charAt(i));
					continue;
				}
				
			}
		}
		return fin;
	}
	
	static private boolean check(int riga, int colonna) {
		for (int[] ar:simboli){
			if (ar[0]==riga&&ar[1]==colonna) {
				return true;
			}
		}
		return false;
	}

	public static long calculate2(String s) {
		ArrayList<String> lista = (ArrayList<String>) Read.striList(s);
		long fin=0l;
		
		// raccolgo coordinate di tutti *
		ArrayList<int[]> asterischi=new ArrayList<int[]>();
		for (int riga=0;riga<lista.size();riga++) {
			String rig=lista.get(riga);
			for (int colonna=0; colonna<rig.length();colonna++) {
				if (rig.charAt(colonna)=='*') {
					int[] ast= {riga,colonna};
					asterischi.add(ast);
				}	
			}
		}
		// trovo tutti numeri e loro coordinate
		ArrayList<int[]> numeri=new ArrayList<int[]>();
		for (int riga=0;riga<lista.size();riga++) {
			String rig=lista.get(riga);
			int i=0;
			while (i<rig.length()) {
				if (rig.charAt(i)=='.') {
					i++;
//					System.out.print(".");
					continue;
				}
				else if (Character.isDigit(rig.charAt(i))) {
					int[] nu={-1,-1,-1,-1,-1,-1,-1};
					nu[1]=riga;
					nu[2]=i;
					String tp=""+rig.charAt(i);
					i++;
					if (Character.isDigit(rig.charAt(i))) {
						tp=tp+rig.charAt(i);
						nu[3]=riga;
						nu[4]=i;
						i++;
						if (Character.isDigit(rig.charAt(i))) {
							tp=tp+rig.charAt(i);
							nu[5]=riga;
							nu[6]=i;
							i++;
							int ff=Integer.parseInt(tp);
							nu[0]=ff;
							numeri.add(nu);
//							System.out.print(ff);
							continue;
						}
						else {
							i++;
							int ff=Integer.parseInt(tp);
							nu[0]=ff;
							numeri.add(nu);
//							System.out.print(ff);
							continue;
						}
					}
					else {
						i++;
						int ff=Integer.parseInt(tp);
						nu[0]=ff;
						numeri.add(nu);
//						System.out.print(ff);
						continue;
					}
				}
				else {
					i++;
//					System.out.print(rig.charAt(i));
					continue;
				}
			}
		}
		
		// faccio controlo incrociato
		for (int[] corAs : asterischi) {
			ArrayList<Integer> num=new ArrayList<Integer>();
			for (int[] n : numeri) {
				if ((n[1]>=corAs[0]-1 && n[1]<=corAs[0]+1) && (n[2]>=corAs[1]-1 && n[2]<=corAs[1]+1)) {
					num.add(n[0]);
				}
				else if ((n[3]>=corAs[0]-1 && n[3]<=corAs[0]+1) && (n[4]>=corAs[1]-1 && n[4]<=corAs[1]+1)) {
					num.add(n[0]);
				}
				else if ((n[5]>=corAs[0]-1 && n[5]<=corAs[0]+1) && (n[6]>=corAs[1]-1 && n[6]<=corAs[1]+1)) {
					num.add(n[0]);
				}
			}
			if (num.size()==2) {
				int ff=1;
				for (int n:num) {
					ff=ff*n;
				}
				fin=fin+ff;
			}
		}
		return fin;
	}
}
