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
			else if (day==13) {
				if (part==1) {
					ris=Day13_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day13_2021.calculate2(inp);
				}
			}
			else if (day==14) {
				if (part==1) {
//					ris=Day14_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day14_2021.calculate2(inp);
				}
			}
			else if (day==15) {
				if (part==1) {
//					ris=Day15_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day15_2021.calculate2(inp);
				}
			}
			else if (day==16) {
				if (part==1) {
//					ris=Day16_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day16_2021.calculate2(inp);
				}
			}
			else if (day==17) {
				if (part==1) {
					ris=Day17_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day17_2021.calculate2(inp);
				}
			}
			else if (day==18) {
				if (part==1) {
//					ris=Day18_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day18_2021.calculate2(inp);
				}
			}
			else if (day==19) {
				if (part==1) {
//					ris=Day19_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day19_2021.calculate2(inp);
				}
			}
			else if (day==20) {
				if (part==1) {
//					ris=Day20_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day20_2021.calculate2(inp);
				}
			}
			else if (day==21) {
				if (part==1) {
//					ris=Day21_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day21_2021.calculate2(inp);
				}
			}
			else if (day==22) {
				if (part==1) {
//					ris=Day22_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day22_2021.calculate2(inp);
				}
			}
			else if (day==23) {
				if (part==1) {
//					ris=Day23_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day23_2021.calculate2(inp);
				}
			}
			else if (day==24) {
				if (part==1) {
//					ris=Day24_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day24_2021.calculate2(inp);
				}
			}
			else if (day==25) {
				if (part==1) {
//					ris=Day25_2021.calculate1(inp);
				}
				else if (part==2) {
//					ris=Day25_2021.calculate2(inp);
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
