package aOc22;
import java.util.ArrayList;

public class Day21_2021 {
	static ArrayList<long[]> temp=new ArrayList<long[]>();
	static long ok=0;
	static long ko=0;
	public static long calculate1(String s) {
		int fin=0;
		int p1=0;
		int p2=0;
		int score1=0;
		int score2=0;
		int x=1000;
		int t=0;
		int q=0;
		int ok=0;
		int ko=0;
		ArrayList<Integer> conta=new ArrayList<Integer>();
		ArrayList<Integer> roll=new ArrayList<Integer>();

		String[] righe=s.split("\\n");
		p1 = Integer.parseInt(righe[0].substring(righe[0].length()-1));
		p2 = Integer.parseInt(righe[1].substring(righe[0].length()-1));

		for (int i=1;i<101;i++){
			conta.add(i);
			}

		while (roll.size()<1500){
			if (q<=(conta.size()-3)){
				int num=conta.get(q)+conta.get(q+1)+conta.get(q+2);
				roll.add(num);
				q=q+3;
				}
			else if (q==(conta.size()-2)){
				int num=conta.get(q)+conta.get(q+1)+conta.get(0);
				roll.add(num);
				q=1;
				}
			else if (q==(conta.size()-1)){
				int num=conta.get(q)+conta.get(0)+conta.get(1);
				roll.add(num);
				q=2;
				}
			else if (q==(conta.size())){
				int num=conta.get(0)+conta.get(1)+conta.get(2);
				roll.add(num);
				q=3;
				}
			}

		for (int h=0;h<1000;h++){
			if ((h+1)%2==1){
				p1=p1+roll.get(h);
				if (p1>10){
					if(p1%10!=0){p1=p1%10;}
					else {p1=10;}
					}
				score1=score1+p1;
				}
			else if ((h+1)%2==0){
				p2=p2+roll.get(h);
				if (p2>10){
					if(p2%10!=0){p2=p2%10;}
					else {p2=10;}
					}
				score2=score2+p2;
				}
			if (score1>=x||score2>=x){
				t=h+1;
				ok=t*3*score1;
				ko=t*3*score2;
				break;
				}
			}
			if (score1>score2){
				fin=ko;
			}
			else {
				fin=ok;
			}
			
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		ok=0;
		ko=0;
		String[] righe=s.split("\\n");
		long p1 = Integer.parseInt(righe[0].substring(righe[0].length()-1));
		long p2 = Integer.parseInt(righe[1].substring(righe[0].length()-1));
		int[] possibility={3,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6,6,7,7,7,7,7,7,8,8,8,9};
		int t=1;
		
		ArrayList<long[]> roll=new ArrayList<long[]>();
		long[] inizio={p1,0,p2,0,1};
		roll.add(inizio);
		
		while(roll.size()>0) {
			System.out.println("Giro: "+t+" dimensione: "+roll.size());
			for (long[] rr:roll) {
				if (t%2!=0) {
					for (int y:possibility) {
						long[] tem={rr[0],rr[1],rr[2],rr[3],rr[4]};
						tem[0]=(tem[0]+y);
						if (tem[0]>10) {
							tem[0]=(tem[0]%10);
						}
						tem[1]=tem[1]+tem[0];
						aggiungi(tem);
					}
				}
				else {
					for (int y:possibility) {
						long[] tem={rr[0],rr[1],rr[2],rr[3],rr[4]};
						tem[2]=(tem[2]+y);
						if (tem[2]>10) {
							tem[2]=(tem[2]%10);
						}
						tem[3]=tem[3]+tem[2];
						aggiungi(tem);
					}
				}
			}
			t++;
			roll.clear();
			for (long[] tt:temp) {
				roll.add(tt);
			}
			temp.clear();
		}
		Tool.bell();
		if (ok>ko) {
			return ok;
		}
		
		return ko;
	}
	
	public static void aggiungi(long[] tem) {
		boolean tr=false;
		if (tem[1]>=21) {
			ko=ko+tem[4];
			return;
		}
		if (tem[3]>=21) {
			ok=ok+tem[4];
			return;
		}
		for (long[] x:temp) {
			if (x[0]==tem[0]&&x[1]==tem[1]&&x[2]==tem[2]&&x[3]==tem[3]) {
				x[4]=x[4]+tem[4];
				tr=true;
			}
		}
		if (tr==false) {
			temp.add(tem);
		}
	}
}
