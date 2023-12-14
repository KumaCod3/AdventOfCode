package aOc23;

import java.util.ArrayList;
import java.util.Arrays;

import program.Read;

public class Day14_2023 {
	private static char[][] lista;
	private static int ciclo=1;
	public static long calculate1(String s) {
		lista=Read.pips(s);
		int fin=0;
		
		stampa();
		for (int x=0;x<lista.length;x++) {
			for (int y=0;y<lista[0].length;y++) {
				if (lista[x][y]=='O') {
					muoviN(x,y);
				}
			}
		}
		stampa();
		for (int x=0;x<lista.length;x++) {
			for (int y=0;y<lista[0].length;y++) {
				if (lista[x][y]=='O') {
					fin=fin+(lista.length-x);
				}
			}
		}
		
		return fin;
	}
	
	public static long calculate2(String s) {
		lista=Read.pips(s);
		int fin=0;
		int giri=10000;
		for (int i=giri;i>0;i--) {
			gira();
		}
		int[] prova=new int[40];
		for (int i=0;i<40;i++) {
			fin=0;
			for (int x=0;x<lista.length;x++) {
				for (int y=0;y<lista[0].length;y++) {
					if (lista[x][y]=='O') {
						fin=fin+(lista.length-x);
					}
				}
			}
			prova[i]=fin;
			gira();
		}
		
		for (int h=1;h<prova.length;h++) {
			ciclo=h;
			if (check(0,h,prova)) {
				break;
			}
		}

		int res=(1000000000-giri)%ciclo;
		fin=prova[res];

		return fin;
	}
	
	static void gira() {
		for (int x=0;x<lista.length;x++) {
			for (int y=0;y<lista[0].length;y++) {
				if (lista[x][y]=='O') {
					muoviN(x,y);
				}
			}
		}
		for (int y=0;y<lista[0].length;y++) {
			for (int x=0;x<lista.length;x++) {
				if (lista[x][y]=='O') {
					muoviW(x,y);
				}
			}
		}

		for (int x=lista.length-1;x>=0;x--) {
			for (int y=0;y<lista[0].length;y++) {
				if (lista[x][y]=='O') {
					muoviS(x,y);
				}
			}
		}
		
		for (int y=lista[0].length-1;y>=0;y--) {
			for (int x=0;x<lista.length;x++) {
				if (lista[x][y]=='O') {
					muoviE(x,y);
				}
			}
		}
		
	}
	
	static private void muoviN(int x, int y) {
		lista[x][y]='.';
		if (x>0) {
			if (lista[x-1][y]=='.') {
				muoviN(x-1,y);
			}
			else {
				lista[x][y]='O';
			}
		}
		else {
			lista[x][y]='O';
		}
	}
	
	static private void muoviS(int x, int y) {
		lista[x][y]='.';
		if (x<lista.length-1) {
			if (lista[x+1][y]=='.') {
				muoviS(x+1,y);
			}
			else {
				lista[x][y]='O';
			}
		}
		else {
			lista[x][y]='O';
		}
	}
	
	static private void muoviW(int x, int y) {
		lista[x][y]='.';
		if (y>0) {
			if (lista[x][y-1]=='.') {
				muoviW(x,y-1);
			}
			else {
				lista[x][y]='O';
			}
		}
		else {
			lista[x][y]='O';
		}
	}
	
	static private void muoviE(int x, int y) {
		lista[x][y]='.';
		if (y<lista[0].length-1) {
			if (lista[x][y+1]=='.') {
				muoviE(x,y+1);
			}
			else {
				lista[x][y]='O';
			}
		}
		else {
			lista[x][y]='O';
		}
	}
	
	static void stampa() {
		for (char[] ch:lista) {
			System.out.println(Arrays.toString(ch));
		}
	}
	
	static private boolean check(int a, int b, int[] lis) {
		if (b==lis.length-1) {
			return false;
		}
		if (lis[a]!=lis[b]) {
			return false;
		}
		if (a==ciclo+1) {
			return true;
		}
		return check(a+1, b+1, lis);
	}
}