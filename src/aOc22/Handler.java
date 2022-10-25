package aOc22;

public class Handler {
	private int day;
	private int part;
	private int yea;
	private long ris;
	private String inp;
	
	public Handler(int y,int d, int p, String r) {
		yea=y;
		day=d;
		part=p;
		inp=r;
	}

	public long calc() {
		if (yea==1) {
			if (day==1) {
				if (part==1) {
					ris=Day01_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day01_2021.calculate2(inp);
				}
			}
			else if (day==2) {
				if (part==1) {
					ris=Day02_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day02_2021.calculate2(inp);
				}
			}
			else if (day==3) {
				if (part==1) {
					ris=Day03_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day03_2021.calculate2(inp);
				}
			}
			else if (day==4) {
				if (part==1) {
					ris=Day04_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day04_2021.calculate2(inp);
				}
			}
			else if (day==5) {
				if (part==1) {
					ris=Day05_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day05_2021.calculate2(inp);
				}
			}
			else if (day==6) {
				if (part==1) {
					ris=Day06_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day06_2021.calculate2(inp);
				}
			}
			else if (day==7) {
				if (part==1) {
					ris=Day07_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day07_2021.calculate2(inp);
				}
			}
			else if (day==8) {
				if (part==1) {
					ris=Day08_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day08_2021.calculate2(inp);
				}
			}
			else if (day==9) {
				if (part==1) {
					ris=Day09_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day09_2021.calculate2(inp);
				}
			}
			else if (day==10) {
				if (part==1) {
					ris=Day10_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day10_2021.calculate2(inp);
				}
			}
			else if (day==11) {
				if (part==1) {
					ris=Day11_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day11_2021.calculate2(inp);
				}
			}
			else if (day==12) {
				if (part==1) {
					ris=Day12_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day12_2021.calculate2(inp);
				}
			}
		}
		
		else {
			for (int i=0;i<inp.length();i++) {
				ris=ris+inp.charAt(i);
			}
		}
		
		
		
		
		return ris;
	}
}
