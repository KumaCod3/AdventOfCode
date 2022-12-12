package aOc22;

import java.util.ArrayList;

public class MonkeyBig {
	int name;
	int oper;
	int operVal;
	int condit;
	ArrayList<Long> ogg=new ArrayList<Long>();
	int tr;
	int fl;
	int act=0;
	static int mod=1;

	
	public MonkeyBig(int na, int op, int ov,int co, int t,  int f, ArrayList<Long> o) {;
		name=na;
		oper=op;
		operVal=ov;
		condit=co;
		tr=t;
		fl=f;
		ogg=o;
		mod=mod*condit;
	}
	
	public boolean check(long x) {
		if ((x%condit)==0) {
			return true;
		}
		return false;
	}
	
	public long stress(long x) {
		long fin=0;
		if (oper==1) {
			fin=x+operVal;
		}
		else if (oper==2) {
			fin=x*operVal;
		}
		else if (oper==3) {
			fin=x*x;
		}
		fin=fin%mod;
		return fin;
	}
	
	public void doo() {
		for (long i:ogg) {
			long x=stress(i);
			if (check(x)) {
				Day11_2022.scimmione.get(tr).add(x);
			}
			else {
				Day11_2022.scimmione.get(fl).add(x);
			}
			act++;
		}
		ogg.clear();
	}
	
	public void add(long x) {
		ogg.add(x);
	}
}
