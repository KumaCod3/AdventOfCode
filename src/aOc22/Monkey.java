package aOc22;
import java.util.ArrayList;

public class Monkey {
	int name;
	int oper;
	int operVal;
	int condit;
	ArrayList<Integer> ogg=new ArrayList<Integer>();
	int tr;
	int fl;
	int act=0;
	
	public Monkey(int na, int op, int ov,int co, int t,  int f, ArrayList<Integer> o) {;
		name=na;
		oper=op;
		operVal=ov;
		condit=co;
		tr=t;
		fl=f;
		ogg=o;
	}
	
	public boolean check(int x) {
		if ((x%condit)==0) {
			return true;
		}
		return false;
	}
	
	public int stress(int x) {
		int fin=0;
		if (oper==1) {
			fin=x+operVal;
		}
		else if (oper==2) {
			fin=x*operVal;
		}
		else if (oper==3) {
			fin=x*x;
		}
		
		return fin/3;
	}
	
	public void doo() {
		for (int i:ogg) {
			int x=stress(i);
			if (check(x)) {
				Day11_2022.scimmie.get(tr).add(x);
			}
			else {
				Day11_2022.scimmie.get(fl).add(x);
			}
			act++;
		}
		ogg.clear();
	}
	
	public void add(int x) {
		ogg.add(x);
	}
}
