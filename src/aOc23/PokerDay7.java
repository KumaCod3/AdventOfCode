package aOc23;
import java.util.HashMap;

public class PokerDay7 implements Comparable<PokerDay7>{
	public String carte;
	public Long bid;
	public Long valoreF;
	HashMap<Character,Integer>mazzo=new HashMap<Character,Integer>();
	int tipo;

	public PokerDay7(String[] a) {
		carte=a[0];
		bid=Long.parseLong(a[1]);
		popola();
		tipo=calTipo();
	}
	
	@Override
	public int compareTo(PokerDay7 o){
		Integer mio=tipo;
		Integer altro=o.tipo;
		if (mio>altro) {
			return 1;
		}
		else if (mio<altro) {
			return -1;
		}
		else {
			return contaV(o);
		}
	}
	
	private int contaV (PokerDay7 o){
		for (int i=0;i<carte.length();i++) {
			int mio=converto(carte.charAt(i));
			int altro=converto(o.carte.charAt(i));
			if (mio>altro) {
				return 1;
			}
			else if (altro>mio) {
				return -1;
			}
		}
		return 0;
	}

	private static int converto(char ch) {
		switch (ch) {
		case 'A':
			return 14;
		case 'K':
			return 13;
		case 'Q':
			return 12;
		case 'J':
			return 11;
		case 'T':
			return 10;
		default:
			return Integer.parseInt(ch+"");
		}
	}

	public int calTipo() {
		int[] va= {0,0,0,0,0,0};
		int ind=0;
		for (Integer e:mazzo.values()) {
			if (e!=0) {
				va[ind]=e;
				ind++;
			}
		}
		if (va[0]==5) {
			return 6;
		}
		else if (va[0]==4||va[1]==4) {
			return 5;
		}
		else if((va[0]==3&&va[1]==2)||(va[1]==3&&va[0]==2)) {
			return 4;
		}
		else if (va[0]==3||va[1]==3||va[2]==3||va[3]==3) {
			return 3;
		}
		else if ((va[0]==2&&va[1]==2)||(va[0]==2&&va[2]==2)||(va[2]==2&&va[1]==2)) {
			return 2;
		}
		else if (va[0]==2||va[1]==2||va[2]==2||va[3]==2) {
			return 1;
		}
		else {
			return 0;
		}
	}
	private void popola() {
		mazzo.put('A', 0);
		mazzo.put('K', 0);
		mazzo.put('Q', 0);
		mazzo.put('J', 0);
		mazzo.put('T', 0);
		mazzo.put('9', 0);
		mazzo.put('8', 0);
		mazzo.put('7', 0);
		mazzo.put('6', 0);
		mazzo.put('5', 0);
		mazzo.put('4', 0);
		mazzo.put('3', 0);
		mazzo.put('2', 0);
		for (int i=0;i<carte.length();i++) {
			mazzo.put(carte.charAt(i), mazzo.get(carte.charAt(i))+1);
		}
	}
}
