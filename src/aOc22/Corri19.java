package aOc22;

import java.util.ArrayList;

public class Corri19 extends Thread {
	int[] bp;
	int fin;
	int index=0;
	int maxOre;
	int maxObs;
	int maxCla;
	int maxMax;
	int min=24;

	public Corri19(int[] bpp, int i, int x) {
		index=i+1;
		min=x;
		bp=bpp;
		maxMax=0;
		maxOre=bp[0];
		if (bp[1]>maxOre ) {
			maxOre=bp[1];
		}
		if (bp[2]>maxOre ) {
			maxOre=bp[2];
		}
		if (bp[4]>maxOre ) {
			maxOre=bp[4];
		}
		maxObs=bp[5];
		maxCla=bp[3];
	}
	
	public void run() {
		
		int[] iniz= {1,0,0,0,0,0,0,0,0,0,0,0,0,min};
		ArrayList<int[]> percorsi=new ArrayList<int[]>();
		ArrayList<int[]> temp=new ArrayList<int[]>();
		ArrayList<int[]> win=new ArrayList<int[]>();
		percorsi.add(iniz);
		while (percorsi.size()>0) {
			for (int[] perc:percorsi) {
				boolean tr=(perc[4]>=bp[4]&&perc[6]>=bp[5]);
				if (perc[0]<maxOre&&tr==false) {
					int[] nuovo= {perc[0],perc[1],perc[2],perc[3],perc[4],perc[5],perc[6],perc[7],0,0,0,perc[11],perc[12],perc[13]};
					oreBuild(nuovo);
					temp.add(nuovo);
				}
				if (perc[1]<maxCla&&tr==false) {
					int[] nuovo= {perc[0],perc[1],perc[2],perc[3],perc[4],perc[5],perc[6],perc[7],0,0,0,perc[11],perc[12],perc[13]};
					clayBuild(nuovo);
					temp.add(nuovo);
				}
				if (perc[2]<maxObs&&perc[1]>0&&tr==false) {
					int[] nuovo= {perc[0],perc[1],perc[2],perc[3],perc[4],perc[5],perc[6],perc[7],0,0,0,perc[11],perc[12],perc[13]};
					obsBuild(nuovo);
					temp.add(nuovo);
				}
				if (perc[2]>0) {
					int[] nuovo= {perc[0],perc[1],perc[2],perc[3],perc[4],perc[5],perc[6],perc[7],0,0,0,perc[11],perc[12],perc[13]};
					geoBuild(nuovo);
					temp.add(nuovo);
				}
			}
			percorsi.clear();
			for (int[] perc:temp) {
				if (perc[13]<=0) {
					win.add(perc);
				}
				else if (perc[2]>=maxObs&&perc[10]>=maxOre){
					finisci(perc);
					win.add(perc);
				}
				else {
					percorsi.add(perc);
				}
			}
			temp.clear();
		}
		int maxGeo=0;
		for (int[] t:win) {
			if (t[7]>=maxGeo) {
				maxGeo=t[7];
			}
		}
		fin= maxGeo*index;
		Day19_2022.finee.add(fin);
		Day19_2022.finale.add(maxGeo);
	}
	
	void finisci(int[] nuovo) {
		while (nuovo[13]>0) {
			geoBuild(nuovo);
		}
	}
	
	void dig(int[] nuovo) {
		if (nuovo[13]>0) {
			nuovo[4]=nuovo[4]+nuovo[0];
			nuovo[5]=nuovo[5]+nuovo[1];
			nuovo[6]=nuovo[6]+nuovo[2];
			nuovo[7]=nuovo[7]+nuovo[3];
			nuovo[13]=nuovo[13]-1;
			for (int h=0;h<4;h++) {
				nuovo[h]=nuovo[h]+nuovo[8+h];
				nuovo[8+h]=0;
			}
		}
	}
	void geoBuild(int[] perc) {
		if (perc[13]<=0) {
			return;
		}
		if (perc[4]>=bp[4]&&perc[6]>=bp[5]) {
			perc[11]=perc[11]+1;
			perc[4]=perc[4]-bp[4];
			perc[6]=perc[6]-bp[5];
			dig(perc);
		}
		else {
			dig(perc);
			geoBuild(perc);
		}
	}
	void obsBuild(int[] nuovo) {
		if (nuovo[13]<=0) {
			return;
		}
		if (nuovo[4]>=bp[2]&&nuovo[5]>=bp[3]) {
			nuovo[10]=1;
			nuovo[4]=nuovo[4]-bp[2];
			nuovo[5]=nuovo[5]-bp[3];
			dig(nuovo);
		}
		else {
			dig(nuovo);
			obsBuild(nuovo);
		}
	}
	void clayBuild(int[] nuovo) {
		if (nuovo[13]<=0) {
			return;
		}
		if (nuovo[4] >= bp[1]) {
			nuovo[9]=1;
			nuovo[4]=nuovo[4]-bp[1];
			dig(nuovo);
		}
		else {
			dig(nuovo);
			clayBuild(nuovo);
		}
	}
	void oreBuild(int[] nuovo) {
		if (nuovo[13]<=0) {
			return;
		}
		if (nuovo[4] >= bp[0]) {
			nuovo[8]=1;
			nuovo[4]=nuovo[4]-bp[0];
			dig(nuovo);
		}
		else {
			dig(nuovo);
			oreBuild(nuovo);
		}
	}
}
