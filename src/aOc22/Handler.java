package aOc22;

public class Handler {
	int day;
	int part;
	long ris;
	String inp;
	
	public Handler(int d, int p, String r) {
		day=d;
		part=p;
		inp=r;
	}

	public long calc() {
		for (int i=0;i<inp.length();i++) {
			ris=ris+inp.charAt(i);
		}
		
		
		
		
		return ris;
	}
}
