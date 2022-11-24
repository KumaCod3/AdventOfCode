package aOc21;

public class Day11_2021 {
	public static long calculate1(String s) {
		Day11_2021obj obj = new Day11_2021obj(s);
		int giri = 0;
		int rip = 100;

		while (giri < rip) {
			obj.adda();
			boolean tr = true;
			while (tr == true) {
				tr = false;
				for (int x = 0; x < obj.input.size(); x++) {
					for (int y = 0; y < obj.input.get(x).length; y++) {
						if (obj.input.get(x)[y] > 9) {
							obj.flash(x, y);
							tr = true;
						}
					}
				}
			}
			if (obj.azzera()) {
//				gg = giri + 1;
				break;
			}
			giri++;
			int ress=rip-giri;
			System.out.println("Restano: "+ress);
		}
		return (long) obj.cont;
	}
	
	public static long calculate2(String s) {
		Day11_2021obj obj = new Day11_2021obj(s);
		int gg = 0;
		int giri = 0;
		int rip = 1000;
		
		while (giri < rip) {
			obj.adda();
			boolean tr = true;
			while (tr == true) {
				tr = false;
				for (int x = 0; x < obj.input.size(); x++) {
					for (int y = 0; y < obj.input.get(x).length; y++) {
						if (obj.input.get(x)[y] > 9) {
							obj.flash(x, y);
							tr = true;
						}
					}
				}
			}
			if (obj.azzera()) {
				gg = giri + 1;
				break;
			}
			giri++;
		}
		return (long) gg;
	}
}
