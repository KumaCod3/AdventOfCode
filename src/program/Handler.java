package program;
import aOc21.Day01_2021;
import aOc21.Day02_2021;
import aOc21.Day03_2021;
import aOc21.Day04_2021;
import aOc21.Day05_2021;
import aOc21.Day06_2021;
import aOc21.Day07_2021;
import aOc21.Day08_2021;
import aOc21.Day09_2021;
import aOc21.Day10_2021;
import aOc21.Day11_2021;
import aOc21.Day12_2021;
import aOc21.Day13_2021;
import aOc21.Day14_2021;
import aOc21.Day15_2021;
import aOc21.Day16_2021;
import aOc21.Day17_2021;
import aOc21.Day18_2021;
import aOc21.Day19_2021;
import aOc21.Day20_2021;
import aOc21.Day21_2021;
import aOc21.Day22_2021;
import aOc21.Day23_2021;
import aOc21.Day24_2021;
import aOc21.Day25_2021;
import aOc22.Day01_2022;
import aOc22.Day02_2022;
import aOc22.Day03_2022;
import aOc22.Day04_2022;
import aOc22.Day05_2022;
import aOc22.Day06_2022;
import aOc22.Day07_2022;
import aOc22.Day08_2022;
import aOc22.Day09_2022;
import aOc22.Day10_2022;
import aOc22.Day11_2022;
import aOc22.Day12_2022;
import aOc22.Day13_2022;
import aOc22.Day14_2022;
import aOc22.Day15_2022;
import aOc22.Day16_2022;
import aOc22.Day17_2022;
import aOc22.Day18_2022;
import aOc22.Day19_2022;
import aOc22.Day20_2022;
import aOc22.Day21_2022;
import aOc22.Day22_2022;
import aOc22.Day23_2022;
import aOc22.Day24_2022;
import aOc22.Day25_2022;

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
					ris=Day14_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day14_2021.calculate2(inp);
				}
			}
			else if (day==15) {
				if (part==1) {
					ris=Day15_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day15_2021.calculate2(inp);
				}
			}
			else if (day==16) {
				if (part==1) {
					ris=Day16_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day16_2021.calculate2(inp);
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
					ris=Day18_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day18_2021.calculate2(inp);
				}
			}
			else if (day==19) {
				if (part==1) {
					ris=Day19_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day19_2021.calculate2(inp);
				}
			}
			else if (day==20) {
				if (part==1) {
					ris=Day20_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day20_2021.calculate2(inp);
				}
			}
			else if (day==21) {
				if (part==1) {
					ris=Day21_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day21_2021.calculate2(inp);
				}
			}
			else if (day==22) {
				if (part==1) {
					ris=Day22_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day22_2021.calculate2(inp);
				}
			}
			else if (day==23) {
				if (part==1) {
					ris=Day23_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day23_2021.calculate2(inp);
				}
			}
			else if (day==24) {
				if (part==1) {
					ris=Day24_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day24_2021.calculate2(inp);
				}
			}
			else if (day==25) {
				if (part==1) {
					ris=Day25_2021.calculate1(inp);
				}
				else if (part==2) {
					ris=Day25_2021.calculate2(inp);
				}
			}
		}
		
		else if (yea==2) {
			if (day==1) {
				if (part==1) {
					ris=Day01_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day01_2022.calculate2(inp);
				}
			}
			else if (day==2) {
				if (part==1) {
					ris=Day02_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day02_2022.calculate2(inp);
				}
			}
			else if (day==3) {
				if (part==1) {
					ris=Day03_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day03_2022.calculate2(inp);
				}
			}
			else if (day==4) {
				if (part==1) {
					ris=Day04_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day04_2022.calculate2(inp);
				}
			}
			else if (day==5) {
				if (part==1) {
					ris=Day05_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day05_2022.calculate2(inp);
				}
			}
			else if (day==6) {
				if (part==1) {
					ris=Day06_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day06_2022.calculate2(inp);
				}
			}
			else if (day==7) {
				if (part==1) {
					ris=Day07_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day07_2022.calculate2(inp);
				}
			}
			else if (day==8) {
				if (part==1) {
					ris=Day08_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day08_2022.calculate2(inp);
				}
			}
			else if (day==9) {
				if (part==1) {
					ris=Day09_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day09_2022.calculate2(inp);
				}
			}
			else if (day==10) {
				if (part==1) {
					ris=Day10_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day10_2022.calculate2(inp);
				}
			}
			else if (day==11) {
				if (part==1) {
					ris=Day11_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day11_2022.calculate2(inp);
				}
			}
			else if (day==12) {
				if (part==1) {
					ris=Day12_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day12_2022.calculate2(inp);
				}
			}
			else if (day==13) {
				if (part==1) {
					ris=Day13_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day13_2022.calculate2(inp);
				}
			}
			else if (day==14) {
				if (part==1) {
					ris=Day14_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day14_2022.calculate2(inp);
				}
			}
			else if (day==15) {
				if (part==1) {
					ris=Day15_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day15_2022.calculate2(inp);
				}
			}
			else if (day==16) {
				if (part==1) {
					ris=Day16_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day16_2022.calculate2(inp);
				}
			}
			else if (day==17) {
				if (part==1) {
					ris=Day17_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day17_2022.calculate2(inp);
				}
			}
			else if (day==18) {
				if (part==1) {
					ris=Day18_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day18_2022.calculate2(inp);
				}
			}
			else if (day==19) {
				if (part==1) {
					ris=Day19_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day19_2022.calculate2(inp);
				}
			}
			else if (day==20) {
				if (part==1) {
					ris=Day20_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day20_2022.calculate2(inp);
				}
			}
			else if (day==21) {
				if (part==1) {
					ris=Day21_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day21_2022.calculate2(inp);
				}
			}
			else if (day==22) {
				if (part==1) {
					ris=Day22_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day22_2022.calculate2(inp);
				}
			}
			else if (day==23) {
				if (part==1) {
					ris=Day23_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day23_2022.calculate2(inp);
				}
			}
			else if (day==24) {
				if (part==1) {
					ris=Day24_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day24_2022.calculate2(inp);
				}
			}
			else if (day==25) {
				if (part==1) {
					ris=Day25_2022.calculate1(inp);
				}
				else if (part==2) {
					ris=Day25_2022.calculate2(inp);
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
