package aOc21;
import java.util.List;

import program.Read;

public class Day11_2021obj {
	int cont = 0;
	List<int[]> input;

	public Day11_2021obj(String s) {
		input = Read.intArList(s);
	}

// take a step
	public void flash(int x, int y) {
		if (x > 0 && y > 0 && x < input.size() - 1 && y < input.get(x).length - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x - 1)[y - 1] = this.input.get(x - 1)[y - 1] + 1;
			this.input.get(x - 1)[y] = this.input.get(x - 1)[y] + 1;
			this.input.get(x - 1)[y + 1] = this.input.get(x - 1)[y + 1] + 1;
			this.input.get(x)[y - 1] = this.input.get(x)[y - 1] + 1;
			this.input.get(x)[y + 1] = this.input.get(x)[y + 1] + 1;
			this.input.get(x + 1)[y - 1] = this.input.get(x + 1)[y - 1] + 1;
			this.input.get(x + 1)[y] = this.input.get(x + 1)[y] + 1;
			this.input.get(x + 1)[y + 1] = this.input.get(x + 1)[y + 1] + 1;
			this.cont++;
		} else if (x == 0 && y > 0 && y < input.get(x).length - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x)[y - 1] = this.input.get(x)[y - 1] + 1;
			this.input.get(x)[y + 1] = this.input.get(x)[y + 1] + 1;
			this.input.get(x + 1)[y - 1] = this.input.get(x + 1)[y - 1] + 1;
			this.input.get(x + 1)[y] = this.input.get(x + 1)[y] + 1;
			this.input.get(x + 1)[y + 1] = this.input.get(x + 1)[y + 1] + 1;
			this.cont++;
		} else if (x > 0 && y == 0 && x < input.size() - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x - 1)[y] = this.input.get(x - 1)[y] + 1;
			this.input.get(x - 1)[y + 1] = this.input.get(x - 1)[y + 1] + 1;
			this.input.get(x)[y + 1] = this.input.get(x)[y + 1] + 1;
			this.input.get(x + 1)[y] = this.input.get(x + 1)[y] + 1;
			this.input.get(x + 1)[y + 1] = this.input.get(x + 1)[y + 1] + 1;
			this.cont++;
		}
		if (y > 0 && x == input.size() - 1 && y < input.get(x).length - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x - 1)[y - 1] = this.input.get(x - 1)[y - 1] + 1;
			this.input.get(x - 1)[y] = this.input.get(x - 1)[y] + 1;
			this.input.get(x - 1)[y + 1] = this.input.get(x - 1)[y + 1] + 1;
			this.input.get(x)[y - 1] = this.input.get(x)[y - 1] + 1;
			this.input.get(x)[y + 1] = this.input.get(x)[y + 1] + 1;
			this.cont++;
		}
		if (x > 0 && x < input.size() - 1 && y == input.get(x).length - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x - 1)[y - 1] = this.input.get(x - 1)[y - 1] + 1;
			this.input.get(x - 1)[y] = this.input.get(x - 1)[y] + 1;
			this.input.get(x)[y - 1] = this.input.get(x)[y - 1] + 1;
			this.input.get(x + 1)[y - 1] = this.input.get(x + 1)[y - 1] + 1;
			this.input.get(x + 1)[y] = this.input.get(x + 1)[y] + 1;
			this.cont++;
		}
		if (x == 0 && y == 0) {
			this.input.get(x)[y] = -1000;
			this.input.get(x)[y + 1] = this.input.get(x)[y + 1] + 1;
			this.input.get(x + 1)[y] = this.input.get(x + 1)[y] + 1;
			this.input.get(x + 1)[y + 1] = this.input.get(x + 1)[y + 1] + 1;
			this.cont++;
		}
		if (x == input.size() - 1 && y == input.get(x).length - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x - 1)[y - 1] = this.input.get(x - 1)[y - 1] + 1;
			this.input.get(x - 1)[y] = this.input.get(x - 1)[y] + 1;
			this.input.get(x)[y - 1] = this.input.get(x)[y - 1] + 1;
			this.cont++;
		}
		if (x == 0 && y == input.get(x).length - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x)[y - 1] = this.input.get(x)[y - 1] + 1;
			this.input.get(x + 1)[y - 1] = this.input.get(x + 1)[y - 1] + 1;
			this.input.get(x + 1)[y] = this.input.get(x + 1)[y] + 1;
			this.cont++;
		}
		if (y == 0 && x == input.size() - 1) {
			this.input.get(x)[y] = -1000;
			this.input.get(x - 1)[y] = this.input.get(x - 1)[y] + 1;
			this.input.get(x - 1)[y + 1] = this.input.get(x - 1)[y + 1] + 1;
			this.input.get(x)[y + 1] = this.input.get(x)[y + 1] + 1;
			this.cont++;
		}
	}

// flash
	public void adda() {
		for (int a = 0; a < input.size(); a++) {
			for (int b = 0; b < input.get(a).length; b++) {
				input.get(a)[b] = input.get(a)[b] + 1;
			}
		}
	}

// check if absolute 
	public boolean azzera() {
		int quanti = 0;
		for (int a = 0; a < input.size(); a++) {
			for (int b = 0; b < input.get(a).length; b++) {
				if (input.get(a)[b] < 0) {
					input.get(a)[b] = 0;
					quanti++;
				}
			}
		}
		int tott = (input.size() * input.get(0).length);
//		System.out.println("flash " + quanti + " su " + tott);
		if (quanti == tott) {
			return true;
		}
		return false;
	}
}
