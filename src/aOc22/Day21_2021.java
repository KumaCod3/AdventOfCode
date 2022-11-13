package aOc22;
import java.util.ArrayList;

public class Day21_2021 {
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
//		ArrayList<String[]> lista=Read.copList(s);
		int fin=0;
		
		
		
		
		return (long) fin;
	}
}
