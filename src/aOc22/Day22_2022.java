package aOc22;
import java.util.ArrayList;
import java.util.HashMap;
import program.Read;

public class Day22_2022 {
	static int[] cor= {0,0,0,1};
	static int[][] tabella;
	static HashMap<Integer,int[][]> cubo=new HashMap<Integer,int[][]>();
	
	public static long calculate1(String s) {
		int fin=0;
		int lung=0;
		ArrayList<String[]> list= Read.tiles(s);
		String command=list.get(1)[0];
		String[] tab=list.get(0);
		lung=tab[8].length();
		tabella=new int[tab.length][];	// TABELLA PIASTRELLE
		for (int i=0;i<tab.length;i++) {
			String a=tab[i];
			String[] cut=a.split("");
			int[] tp=new int[lung];
			for (int h=0;h<cut.length;h++) {
				String t=cut[h];
				int x=0;
				switch (t) {
				case ".":
					x=1;
					break;
				case "#":
					x=9;
					break;
				}
				tp[h]=x;
			}
			tabella[i]=tp;
		}
		
		ArrayList<String> comandi=new ArrayList<String>();	// LISTA COMANDI
		String[] com=command.split("");
		int d=0;
		while (d<com.length) {
			String temp=com[d];
			boolean isInt1=false;
			boolean isInt2=false;
			try {
				int x=Integer.parseInt(temp);
				isInt1=true;
			}
			catch (Exception e) {}
			String te;
			try {
				te=com[d+1];
			}
			catch (Exception er) {comandi.add(temp); break;}
			
			try {
				int y=Integer.parseInt(te);
				isInt2=true;
			}
			catch (Exception e) {}
			if (isInt1&&isInt2) {
				d++;
				temp=temp+te;
			}
			comandi.add(temp);
			d++;
		}
		
		d=0;
		while (d<comandi.size()) {
			int move=Integer.parseInt(comandi.get(d));
			muovi(move);
			d++;
			try {
				gira(comandi.get(d));
				d++;
			}
			catch (Exception e) {break;}
		}
		fin=(1000*(1+cor[0]))+(4*(1+cor[1]))+cor[2];
		
		return (long) fin;
	}
	private static void muovi(int move) {
		boolean tr=true;
		for (int i=0;i<move;i++) {
			if (tr) {
				int y=cor[0];
				int x=cor[1];
				switch(cor[2]) {
				case 0:	// destra
					movD();
					tabella[y][x]=5;
					break;
				case 1:	// giu
					movG();
					tabella[y][x]=5;
					break;
				case 2:	// sinistra
					movS();
					tabella[y][x]=5;
					break;
				case 3:	// su
					movU();
					tabella[y][x]=5;
					break;
				}
			}
		}
	}
	private static void movU() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			y=tabella.length-1;
		}
		if (tabella[y][x]==1||tabella[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (tabella[y][x]==9) {
			cor[0]=y;
			movG();
			return ;
		}
		else {
			cor[0]=y;
			movU();
		}
	}
	private static void movG() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=tabella.length) {
			y=0;
		}
		if (tabella[y][x]==1||tabella[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (tabella[y][x]==9) {
			cor[0]=y;
			movU();
			return;
		}
		else {
			cor[0]=y;
			movG();
		}
	}
	private static void movS() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			x=tabella[1].length-1;
		}
		if (tabella[y][x]==1||tabella[y][x]==5) {
			cor[1]= x;
		}
		else if (tabella[y][x]==9) {
			cor[1]= x;
			movD();
			return;
		}
		else {
			cor[1]=x;
			movS();
		}
	}
	private static void movD() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=tabella[1].length) {
			x=0;
		}
		if (tabella[y][x]==1||tabella[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (tabella[y][x]==9) {
			cor[1]= x;
			movS();
			return;
		}
		else {
			cor[1]=x;
			movD();
		}
	}
	private static void gira(String d) {
		if (d.equals("R")) {
			cor[2]=cor[2]+1;
		}
		else {
			cor[2]=cor[2]-1;
		}
		if (cor[2]==4) {
			cor[2]=0;
		}
		else if (cor[2]==-1) {
			cor[2]=3;
		}
	}
	
	public static long calculate2(String s) {
		int fin=0;
		ArrayList<String[]> list= Read.tiles(s);
		String command=list.get(1)[0];
		String[] tab=list.get(0);
		
		// Make TAVOLA TOT
		tabella=new int[tab.length][];
		for (int i=0;i<tab.length;i++) {
			String a=tab[i];
			String[] cut=a.split("");
			int[] tp=new int[cut.length];
			for (int h=0;h<cut.length;h++) {
				String t=cut[h];
				int x=0;
				switch (t) {
				case ".":
					x=1;
					break;
				case "#":
					x=9;
					break;
				}
				tp[h]=x;
			}
			tabella[i]=tp;
		}
		
		// Make SINGLE FACES
		int[][] faccia1=new int[50][];
		for (int i=0;i<50;i++) {
			int[] riga=new int[50];
			for (int h=0;h<50;h++) {
				riga[h]=tabella[i][h+50];
			}
			faccia1[i]=riga;
		}
		cubo.put(1,faccia1);
		int[][] faccia2=new int[50][];
		for (int i=0;i<50;i++) {
			int[] riga=new int[50];
			for (int h=0;h<50;h++) {
				riga[h]=tabella[i][h+100];
			}
			faccia2[i]=riga;
		}
		cubo.put(2,faccia2);
		int[][] faccia3=new int[50][];
		for (int i=0;i<50;i++) {
			int[] riga=new int[50];
			for (int h=0;h<50;h++) {
				riga[h]=tabella[i+50][h+50];
			}
			faccia3[i]=riga;
		}
		cubo.put(3,faccia3);
		int[][] faccia4=new int[50][];
		for (int i=0;i<50;i++) {
			int[] riga=new int[50];
			for (int h=0;h<50;h++) {
				riga[h]=tabella[i+100][h];
			}
			faccia4[i]=riga;
		}
		cubo.put(4,faccia4);
		int[][] faccia5=new int[50][];
		for (int i=0;i<50;i++) {
			int[] riga=new int[50];
			for (int h=0;h<50;h++) {
				riga[h]=tabella[i+100][h+50];
			}
			faccia5[i]=riga;
		}
		cubo.put(5,faccia5);
		int[][] faccia6=new int[50][];
		for (int i=0;i<50;i++) {
			int[] riga=new int[50];
			for (int h=0;h<50;h++) {
				riga[h]=tabella[i+150][h];
			}
			faccia6[i]=riga;
		}
		cubo.put(6,faccia6);

		// Make commands
		ArrayList<String> comandi=new ArrayList<String>();
		String[] com=command.split("");
		int d=0;
		while (d<com.length) {
			String temp=com[d];
			boolean isInt1=false;
			boolean isInt2=false;
			try {
				int x=Integer.parseInt(temp);
				isInt1=true;
			}
			catch (Exception e) {}
			String te;
			try {
				te=com[d+1];
			}
			catch (Exception er) {comandi.add(temp); break;}
			
			try {
				int y=Integer.parseInt(te);
				isInt2=true;
			}
			catch (Exception e) {}
			if (isInt1&&isInt2) {
				d++;
				temp=temp+te;
			}
			comandi.add(temp);
			d++;
		}
		
		// CALCULATE
		d=0;
		while (d<comandi.size()) {
			int move=Integer.parseInt(comandi.get(d));
			muovi2(move);
			d++;
			try {
				gira(comandi.get(d));
				d++;
			}
			catch (Exception e) {break;}
		}
		fin=calcFin();
		return (long) fin;
	}
	
	private static int calcFin() {
		int fin=0;
		int x=0;
		int y=0;
		int dir=cor[2];
		switch (cor[3]) {
		case 1:
			y=cor[0]+1;
			x=cor[1]+1+50;
			break;
		case 2:
			y=cor[0]+1;
			x=cor[1]+1+100;
			break;
		case 3:
			y=cor[0]+1+50;
			x=cor[1]+1+50;
			break;
		case 4:
			y=cor[0]+1+100;
			x=cor[1]+1;
			break;
		case 5:
			y=cor[0]+1+100;
			x=cor[1]+1+50;
			break;
		case 6:
			y=cor[0]+1+150;
			x=cor[1]+1;
			break;
		}
		fin=(1000*(y))+(4*(x))+dir;
		return fin;
	}

	private static void muovi2(int move) {
		for (int i=0;i<move;i++) {
			int tab=cor[3];
				switch (tab) {
				case 1:
					switch(cor[2]) {
						case 0:	// destra
							movD1();
							break;
						case 1:	// giu
							movG1();
							break;
						case 2:	// sinistra
							movS1();
							break;
						case 3:	// su
							movU1();
							break;
						}
					break;
				case 2:
					switch(cor[2]) {
					case 0:	// destra
						movD2();
						break;
					case 1:	// giu
						movG2();
						break;
					case 2:	// sinistra
						movS2();
						break;
					case 3:	// su
						movU2();
						break;
					}
					break;
				case 3:
					switch(cor[2]) {
					case 0:	// destra
						movD3();
						break;
					case 1:	// giu
						movG3();
						break;
					case 2:	// sinistra
						movS3();
						break;
					case 3:	// su
						movU3();
						break;
					}
					break;
				case 4:
					switch(cor[2]) {
					case 0:	// destra
						movD4();
						break;
					case 1:	// giu
						movG4();
						break;
					case 2:	// sinistra
						movS4();
						break;
					case 3:	// su
						movU4();
						break;
					}
					break;
				case 5:
					switch(cor[2]) {
					case 0:	// destra
						movD5();
						break;
					case 1:	// giu
						movG5();
						break;
					case 2:	// sinistra
						movS5();
						break;
					case 3:	// su
						movU5();
						break;
					}
					break;
				case 6:
					switch(cor[2]) {
					case 0:	// destra
						movD6();
						break;
					case 1:	// giu
						movG6();
						break;
					case 2:	// sinistra
						movS6();
						break;
					case 3:	// su
						movU6();
						break;
					}
					break;
			}
		}
	}

	//********* Move from 1
	private static void movU1() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			y=cor[1];
			x=0;
			if (cubo.get(6)[y][x]!=9) {
				cor[1]=x;
				cor[0]=y;
				cor[2]=0;
				cor[3]=6;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(1)[y][x]==1||cubo.get(1)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(1)[y][x]==9) {
			return ;
		}
	}
	private static void movG1() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=cubo.get(1).length) {
			x=cor[1];
			y=0;
			if (cubo.get(3)[y][x]!=9) {
				cor[0]=y;
				cor[3]=3;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(1)[y][x]==1||cubo.get(1)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(1)[y][x]==9) {
			return;
		}
	}
	private static void movS1() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			y=49-y;
			x=0;
			if (cubo.get(4)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=0;
				cor[3]=4;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(1)[y][x]==1||cubo.get(1)[y][x]==5) {
			cor[1]= x;
		}
		else if (cubo.get(1)[y][x]==9) {
			return;
		}
	}
	private static void movD1() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=cubo.get(1)[1].length) {
			x=0;
			if (cubo.get(2)[y][x]!=9) {
				cor[1]=x;
				cor[3]=2;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(1)[y][x]==1||cubo.get(1)[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (cubo.get(1)[y][x]==9) {
			return;
		}
	}
	
	//********* Move from 2
	private static void movU2() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			y=49;
			if (cubo.get(6)[y][x]!=9) {
				cor[0]=y;
				cor[3]=6;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(2)[y][x]==1||cubo.get(2)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(2)[y][x]==9) {
			return ;
		}
	}
	private static void movG2() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=cubo.get(2).length) {
			y=cor[1];
			x=49;
			if (cubo.get(3)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=2;
				cor[3]=3;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(2)[y][x]==1||cubo.get(2)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(2)[y][x]==9) {
			return;
		}
	}
	private static void movS2() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			x=49;
			if (cubo.get(1)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=1;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(2)[y][x]==1||cubo.get(2)[y][x]==5) {
			cor[1]= x;
		}
		else if (cubo.get(2)[y][x]==9) {
			return;
		}
	}
	private static void movD2() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=cubo.get(2)[1].length) {
			y=49-cor[0];
			x=49;
			if (cubo.get(5)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=2;
				cor[3]=5;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(2)[y][x]==1||cubo.get(2)[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (cubo.get(2)[y][x]==9) {
			return;
		}
	}
	
	//********* Move from 3
	private static void movU3() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			y=49;
			if (cubo.get(1)[y][x]!=9) {
				cor[0]=y;
				cor[3]=1;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(3)[y][x]==1||cubo.get(3)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(3)[y][x]==9) {
			return ;
		}
	}
	private static void movG3() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=cubo.get(3).length) {
			y=0;
			if (cubo.get(5)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=5;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(3)[y][x]==1||cubo.get(3)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(3)[y][x]==9) {
			return;
		}
	}
	private static void movS3() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			x=cor[0];
			y=0;
			if (cubo.get(4)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=1;
				cor[3]=4;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(3)[y][x]==1||cubo.get(3)[y][x]==5) {
			cor[1]= x;
		}
		else if (cubo.get(3)[y][x]==9) {
			return;
		}
	}
	private static void movD3() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=cubo.get(3)[1].length) {
			y=49;
			x=cor[0];
			if (cubo.get(2)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=3;
				cor[3]=2;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(3)[y][x]==1||cubo.get(3)[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (cubo.get(3)[y][x]==9) {
			return;
		}
	}
	
	//********* Move from 4
	private static void movU4() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			x=0;
			y=cor[1];
			if (cubo.get(3)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=0;
				cor[3]=3;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(4)[y][x]==1||cubo.get(4)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(4)[y][x]==9) {
			return ;
		}
	}
	private static void movG4() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=cubo.get(4).length) {
			y=0;
			if (cubo.get(6)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=6;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(4)[y][x]==1||cubo.get(4)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(4)[y][x]==9) {
			return;
		}
	}
	private static void movS4() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			x=0;
			y=49-cor[0];
			if (cubo.get(1)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=0;
				cor[3]=1;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(4)[y][x]==1||cubo.get(4)[y][x]==5) {
			cor[1]= x;
		}
		else if (cubo.get(4)[y][x]==9) {
			return;
		}
	}
	private static void movD4() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=cubo.get(4)[1].length) {
			x=0;
			if (cubo.get(5)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=5;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(4)[y][x]==1||cubo.get(4)[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (cubo.get(4)[y][x]==9) {
			return;
		}
	}
	
	//********* Move from 5
	private static void movU5() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			y=49;
			if (cubo.get(3)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=3;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(5)[y][x]==1||cubo.get(5)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(5)[y][x]==9) {
			return ;
		}
	}
	private static void movG5() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=cubo.get(5).length) {
			y=cor[1];
			x=49;
			if (cubo.get(6)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=2;
				cor[3]=6;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(5)[y][x]==1||cubo.get(5)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(5)[y][x]==9) {
			return;
		}
	}
	private static void movS5() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			x=49;
			if (cubo.get(4)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=4;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(5)[y][x]==1||cubo.get(5)[y][x]==5) {
			cor[1]= x;
		}
		else if (cubo.get(5)[y][x]==9) {
			return;
		}
	}
	private static void movD5() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=cubo.get(5)[1].length) {
			x=49;
			y=49-cor[0];
			if (cubo.get(2)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=2;
				cor[3]=2;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(5)[y][x]==1||cubo.get(5)[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (cubo.get(5)[y][x]==9) {
			return;
		}
	}

	//********* Move from 6
	private static void movU6() {
		int x=cor[1];
		int y=cor[0]-1;
		if (y<0) {
			y=49;
			if (cubo.get(4)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=4;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(6)[y][x]==1||cubo.get(6)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(6)[y][x]==9) {
			return ;
		}
	}
	private static void movG6() {
		int x=cor[1];
		int y=cor[0]+1;
		if (y>=cubo.get(6).length) {
			y=0;
			if (cubo.get(2)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[3]=2;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(6)[y][x]==1||cubo.get(6)[y][x]==5) {
			cor[0]=y;
			return;
		}
		else if (cubo.get(6)[y][x]==9) {
			return;
		}
	}
	private static void movS6() {
		int x=cor[1]-1;
		int y=cor[0];
		if (x<0) {
			x=cor[0];
			y=0;
			if (cubo.get(1)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=1;
				cor[3]=1;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(6)[y][x]==1||cubo.get(6)[y][x]==5) {
			cor[1]= x;
		}
		else if (cubo.get(6)[y][x]==9) {
			return;
		}
	}
	private static void movD6() {
		int x=cor[1]+1;
		int y=cor[0];
		if (x>=cubo.get(6)[1].length) {
			x=cor[0];
			y=49;
			if (cubo.get(5)[y][x]!=9) {
				cor[0]=y;
				cor[1]=x;
				cor[2]=3;
				cor[3]=5;
				return;
			}
			else {
				return;
			}
		}
		if (cubo.get(6)[y][x]==1||cubo.get(6)[y][x]==5) {
			cor[1]= x;
			return;
		}
		else if (cubo.get(6)[y][x]==9) {
			return;
		}
	}
}