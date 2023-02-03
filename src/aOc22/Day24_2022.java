package aOc22;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import program.Read;

public class Day24_2022 {
	static int[] ini= {0,1};
	static ArrayList<int[]> posiz=new ArrayList<int[]>();
	static ArrayList<int[]> temPos=new ArrayList<int[]>();
	static ArrayList<int[]>list;
	static HashMap<Integer,ArrayList<int[]>> storms;
	static int larg=0;
	static int alt=0;
	static int[] fini= new int[2];
	
	public static long calculate1(String s) {
		list=Read.snow(s);
		alt=list.size();
		larg=list.get(0).length;
		fini[0]=alt-1;
		fini[1]=larg-2;
		posiz.add(ini);
		storms=new HashMap<Integer,ArrayList<int[]>>();
		ArrayList<int[]>es=new ArrayList<int[]>();
		ArrayList<int[]>su=new ArrayList<int[]>();
		ArrayList<int[]>we=new ArrayList<int[]>();
		ArrayList<int[]>no=new ArrayList<int[]>();
		storms.put(1,es);
		storms.put(2,su);
		storms.put(3,we);
		storms.put(4,no);
		for (int i=0;i<list.size();i++) {
			for (int h=0;h<list.get(0).length;h++) {
				int[] cor= {i,h};
				int val=list.get(i)[h];
				if (val>0&&val<5) {
					storms.get(val).add(cor);
				}
			}
		}
		
		int giro=0;
		while (true) {
			giro++;
			moveS();
			rePain();
			moveM();
			cleanUp();
			if(check()) {
				break;
			}
		}
		
		return (long) giro;
	}
	
	static void cleanUp() {
		temPos.add(posiz.get(0));
		for (int[] cor:posiz) {
			boolean tr=true;
			for (int[] corN:temPos) {
				if (cor[0]==corN[0]&&cor[1]==corN[1]) {
					tr=false;
					break;
				}
			}
			if (tr) {
				temPos.add(cor);
			}
		}
		posiz.clear();
		for (int[] cor:temPos) {
			posiz.add(cor);
		}
		temPos.clear();
	}
	
	static boolean check() {
		for (int[] cor:posiz) {
			if (cor[0]==fini[0]&&cor[1]==fini[1]) {
				return true;
			}
		}
		return false;
	}
	
	static void moveS() {
		for (int[] tem:storms.get(1)) {
			tem[0]=tem[0];	
			tem[1]=tem[1]+1;
			if (tem[1]==larg-1) {
				tem[1]=1;
			}
		}
		for (int[] tem:storms.get(2)) {
			tem[0]=tem[0]+1;	
			tem[1]=tem[1];
			if (tem[0]==alt-1) {
				tem[0]=1;
			}
		}
		for (int[] tem:storms.get(3)) {
			tem[0]=tem[0];	
			tem[1]=tem[1]-1;
			if (tem[1]==0) {
				tem[1]=larg-2;;
			}
		}
		for (int[] tem:storms.get(4)) {
			tem[0]=tem[0]-1;	
			tem[1]=tem[1];
			if (tem[0]==0) {
				tem[0]=alt-2;
			}
		}
	}
	
	static void moveM() {
		for (int[] posIn:posiz) {
			int[] temp= {posIn[0],posIn[1]};
			temp[0]=posIn[0]+1;
			temp[1]=posIn[1];
			try {
				if (list.get(temp[0])[temp[1]]==0) {
					int[] nuo= {temp[0],temp[1]};
					temPos.add(nuo);
				}
			}
			catch (Exception e) { // no -1
			}
			temp[0]=posIn[0];
			temp[1]=posIn[1]+1;
			try {
				if (list.get(temp[0])[temp[1]]==0) {
					int[] nuo= {temp[0],temp[1]};
					temPos.add(nuo);
				}
			}
			catch (Exception e) { // no -1
			}
			temp[0]=posIn[0];
			temp[1]=posIn[1]-1;
			try {
				if (list.get(temp[0])[temp[1]]==0) {
					int[] nuo= {temp[0],temp[1]};
					temPos.add(nuo);
				}
			}
			catch (Exception e) { // no -1
			}
			temp[0]=posIn[0]-1;
			temp[1]=posIn[1];
			try {
				if (list.get(temp[0])[temp[1]]==0) {
					int[] nuo= {temp[0],temp[1]};
					temPos.add(nuo);
				}
			}
			catch (Exception e) { // no -1
			}
			int[] nuo= {posIn[0],posIn[1]};
			if (list.get(nuo[0])[nuo[1]]==0) {
				temPos.add(nuo);
			}
		}
		posiz.clear();
		for (int[] cor:temPos) {
			posiz.add(cor);
		}
		temPos.clear();
	}
	
	static void rePain() {
		for (int i=0;i<list.size();i++) {
			for (int h=0;h<list.get(i).length;h++) {
				if (list.get(i)[h]!=9) {
					list.get(i)[h]=0;
				}
			}
		}
		for (Map.Entry<Integer,ArrayList<int[]>> entry:storms.entrySet()) {
			for (int[] cor:entry.getValue()) {
				list.get(cor[0])[cor[1]]=entry.getKey();
			}
		}
	}
	
	public static long calculate2(String s) {
		list=Read.snow(s);
		alt=list.size();
		larg=list.get(0).length;
		posiz.add(ini);
		fini[0]=alt-1;
		fini[1]=larg-2;
		storms=new HashMap<Integer,ArrayList<int[]>>();
		ArrayList<int[]>es=new ArrayList<int[]>();
		ArrayList<int[]>su=new ArrayList<int[]>();
		ArrayList<int[]>we=new ArrayList<int[]>();
		ArrayList<int[]>no=new ArrayList<int[]>();
		storms.put(1,es);
		storms.put(2,su);
		storms.put(3,we);
		storms.put(4,no);
		for (int i=0;i<list.size();i++) {
			for (int h=0;h<list.get(0).length;h++) {
				int[] cor= {i,h};
				int val=list.get(i)[h];
				if (val>0&&val<5) {
					storms.get(val).add(cor);
				}
			}
		}
		
		int giro=0;
		while (true) {
			giro++;
			moveS();
			rePain();
			moveM();
			cleanUp();
			if(check()) {
				break;
			}
		}
		posiz.clear();
		posiz.add(fini);
		while (true) {
			giro++;
			moveS();
			rePain();
			moveM();
			cleanUp();
			if(checkBis()) {
				break;
			}
		}
		posiz.clear();
		posiz.add(ini);
		while (true) {
			giro++;
			moveS();
			rePain();
			moveM();
			cleanUp();
			if(check()) {
				break;
			}
		}
		posiz.clear();
		posiz.add(ini);
		return (long) giro;
	}
	
	static boolean checkBis() {
		for (int[] cor:posiz) {
			if (cor[0]==ini[0]&&cor[1]==ini[1]) {
				ini[0]=cor[0];
				ini[1]=cor[1];
				return true;
			}
		}
		return false;
	}
}
