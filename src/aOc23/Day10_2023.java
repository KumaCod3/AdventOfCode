package aOc23;
import java.util.ArrayList;

import program.Read;

public class Day10_2023 {
	private static ArrayList<int[]> copie = new ArrayList<int[]>();
	
	public static long calculate1(String s) {
		Long fin=0l;
		char[][] lista = Read.pips(s);
		char c='-';
		int[] cor1= {0,0};
		int[] cor2= {0,0};
		for (int x=0;x<lista[0].length;x++) {
			for (int y=0;y<lista.length;y++) {
				if (lista[y][x]=='S') {
					cor1[0]=y;
					cor1[1]=x+1;
					cor2[0]=y;
					cor2[1]=x;
					break;
				}
			}
		}
		while (c!='S') {
			int[] cor3= {0,0};
			switch(c) {
				case '-':
					cor3[1]=cor2[1]+(cor2[1]-cor1[1]);
					cor3[0]=cor2[0];
					break;
				case '|':
					cor3[0]=cor2[0]+(cor2[0]-cor1[0]);
					cor3[1]=cor2[1];
					break;
				case 'L':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]-1;
						cor3[1]=cor2[1];
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]+1;
					}
					break;
				case 'J':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]-1;
						cor3[1]=cor2[1];
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]-1;
					}
					break;
				case '7':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]+1;
						cor3[1]=cor2[1];
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]-1;
					}
					break;
				case 'F':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]+1;
						cor3[1]=cor2[1];
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]+1;
					}
					break;
			}
			cor1[0]=cor2[0];
			cor1[1]=cor2[1];
			cor2[0]=cor3[0];
			cor2[1]=cor3[1];
			fin++;
			c=lista[cor3[0]][cor3[1]];
		}

		return fin/2;
	}	
	
	public static long calculate2(String s) {
		Long fin=0l;
		char[][] lista = Read.pips(s);
		char c='-';
		int[] cor1= {0,0};
		int[] cor2= {0,0};
		ArrayList<int[]> olio= new ArrayList<int[]>();
		ArrayList<int[]> temp= new ArrayList<int[]>();

		ArrayList<char[]> prova=new ArrayList<char[]>();
		char[] nun=new char[(lista[0].length*2)+4];
		prova.add(nun);
		int indx=1;
		for (char[] cr:lista) {
			indx=1;
			char[] nu=new char[(cr.length*2)+4];
			char[] nunu=new char[(cr.length*2)+4];
			for (char ch:cr) {
				nu[indx]=ch;
				indx=indx+2;
			}
			prova.add(nu);
			prova.add(nunu);
		}
		char[][] lis=new char[prova.size()][];
		for (int i=0;i<prova.size();i++) {
			lis[i]=prova.get(i);
		}
		
		
		
		for (int x=0;x<lis[0].length;x++) {
			for (int y=0;y<lis.length;y++) {
				if (lis[y][x]=='S') {
					cor1[0]=y;
					cor1[1]=x+1;
					cor2[0]=y;
					cor2[1]=x;
					break;
				}
			}
		}
		char[][] ll=new char[lis.length][];
		for (int i=0;i<lis.length;i++) {
			char[] x=new char[lis[0].length];
			ll[i]=x;
		}
		boolean cont=true;
		while (cont) {
			int[] cor3= {0,0};
			boolean verticale=false;
			switch(c) {
				case '-':
					cor3[1]=cor2[1]+(cor2[1]-cor1[1]);
					cor3[0]=cor2[0];
					break;
				case '|':
					cor3[0]=cor2[0]+(cor2[0]-cor1[0]);
					cor3[1]=cor2[1];
					verticale=true;
					break;
				case 'L':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]-1;
						cor3[1]=cor2[1];
						verticale=true;
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]+1;
					}
					break;
				case 'J':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]-1;
						cor3[1]=cor2[1];
						verticale=true;
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]-1;
					}
					break;
				case '7':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]+1;
						cor3[1]=cor2[1];
						verticale=true;
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]-1;
					}
					break;
				case 'F':
					if (cor2[0]==cor1[0]) {
						cor3[0]=cor2[0]+1;
						cor3[1]=cor2[1];
						verticale=true;
					}
					else if (cor2[1]==cor1[1]) {
						cor3[0]=cor2[0];
						cor3[1]=cor2[1]+1;
					}
					break;
				case 'S':
					cont=false;
			}

			ll[cor1[0]][cor1[1]]='0';
			cor1[0]=cor2[0];
			cor1[1]=cor2[1];
			cor2[0]=cor3[0];
			cor2[1]=cor3[1];
			c=lis[cor3[0]][cor3[1]];
			if (c!='|'&&c!='-'&&c!='F'&&c!='L'&&c!='7'&&c!='J'&&c!='I'&&c!='S') {
				if (verticale) {
					c='|';
					lis[cor3[0]][cor3[1]]=c;
				}
				else {
					c='-';
					lis[cor3[0]][cor3[1]]=c;
				}
			}
		}
		
		int xMas=ll.length;
		int yMas=ll[0].length;
		int[] iniz= {0,0};
		int[] iniz2= {0,yMas-1};
		int[] iniz3= {xMas-1,0};
		int[] iniz4= {xMas-1,yMas-1};
		ll[0][0]='-';
		olio.add(iniz);
		olio.add(iniz2);
		olio.add(iniz3);
		olio.add(iniz4);
		
		while (olio.size()>0) {
			for (int[] cor:olio) {
				int[] uno= {cor[0]+1,cor[1]};
				int[] due= {cor[0]-1,cor[1]};
				int[] tre= {cor[0],cor[1]+1};
				int[] quat= {cor[0],cor[1]-1};
				if (controlla(uno)) 
				temp.add(uno);
				if (controlla(due)) 
				temp.add(due);
				if (controlla(tre)) 
				temp.add(tre);
				if (controlla(quat))
				temp.add(quat);
			}
			olio.clear();
			for (int[] cor:temp) {
				if (cor[0]>=0&&cor[1]>=0&&cor[0]<xMas&&cor[1]<yMas) {
					if (ll[cor[0]][cor[1]]!='0') {
						ll[cor[0]][cor[1]]='-';
							olio.add(cor);
					}
				}
			}
			temp.clear();
		}
		
		// conto 
		for (int i=1;i<ll.length;i=i+2) {
			char[] ch=ll[i];
			for (int j=1;j<ch.length;j=j+2) {
				char cc=ch[j];
				if (cc!='-'&&cc!='0') {
					fin=fin+1;
				}
			}
		}
		
		return fin;
	}
	
	private static boolean controlla(int[] cor) {
		for (int[] cop:copie) {
			if (cop[0]==cor[0]&&cop[1]==cor[1]) {
				return false;
			}
		}
		copie.add(cor);
		return true;
	}
}