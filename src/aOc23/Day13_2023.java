package aOc23;

import java.util.ArrayList;

import program.Read;

public class Day13_2023 {
	private static ArrayList<char[]> lista;
	private static ArrayList<ArrayList<char[]>> lis;

	public static long calculate1(String s) {
		lis = Read.copListOfLis(s);
		int verticale=0;
		int orizzontale=0;
		
		for (int h=0;h<lis.size();h++) {
			lista=lis.get(h);
			boolean trovato=false;
		//	cerco orizzontale
			int in=0;
			int fi=lista.size()-1;
			for (int j=1;j<lista.size();j++) {
				if (check(in,j,"s")) {
					System.out.println("trovo orizzontale da su ");
					int f=(((j-in)/2)+in+1)*100;
					orizzontale=orizzontale+f;
					System.out.println(f);
					trovato=true;
					break;
				}
				if (check(j-1,fi, "s")) {
					System.out.println("trovo orizzontale da giu");
					int f=(((fi-j)/2)+j)*100;
					orizzontale=orizzontale+f;
					System.out.println(f);
					trovato=true;
					break;
				}
			}
			
			// cerco verticale
			in=0;
			fi=lista.get(0).length-1;
			if (!trovato) {
				
				for (int j=1;j<lista.get(0).length;j++) {
					if (check(in,j)) {
						System.out.println("trovo verticale da sx");
						int f=((j-in)/2)+1;
						verticale=verticale+f;
						System.out.println(f);
						trovato=true;
						break;
					}
					if (check(j,fi)) {
						System.out.println("trovo verticale da dx "+fi+" "+j);
						int f=((fi-j)/2)+j+1;
						verticale=verticale+f;
						System.out.println(f);
						trovato=true;
						break;
					}
				}
			}
		}
		return (long) orizzontale+verticale;
	}
	
	static private boolean check(int in, int j, String g) {
		if (j-in<1) {
			return false;
		}
		char[] a=lista.get(in);
		char[] b=lista.get(j);
		for (int i=0;i<a.length;i++) {
			if (a[i]!=b[i]) {
				return false;
			}
		}
		if (j-in==1) {
			return true;
		}
		return check(in+1, j-1, g);
	}
	static private boolean check(int a, int b) {
		if (b-a<1) {
			return false;
		}
		for (int i=0;i<lista.size();i++) {
			if (lista.get(i)[a]!=lista.get(i)[b]) {
				return false;
			}
		}
		if (b-a==1) {
			return true;
		}
		return check(a+1, b-1);
	}

	public static long calculate2(String s) {
		lis = Read.copListOfLis(s);
		int verticale=0;
		int orizzontale=0;
		for (int h=0;h<lis.size();h++) {
			System.out.println(h+" su "+lis.size());
			boolean vert=true;
			int control=0;
			lista=lis.get(h);
			boolean trovato=false;
		//	cerco control orizzontale
			int in=0;
			int fi=lista.size()-1;
			for (int j=1;j<lista.size();j++) {
				if (check(in,j,"s")) {
					control=(((j-in)/2)+in+1);
					trovato=true;
					vert=false;
					break;
				}
				if (check(j-1,fi, "s")) {
					control=(((fi-j)/2)+j);
					trovato=true;
					vert=false;
					break;
				}
			}
			if (!trovato) {
		// cerco control verticale
				in=0;
				fi=lista.get(0).length-1;
				for (int j=1;j<lista.get(0).length;j++) {
					if (check(in,j)) {
						control=((j-in)/2)+1;
						trovato=true;
						break;
					}
					if (check(j,fi)) {
						control=((fi-j)/2)+j+1;
						trovato=true;
						break;
					}
				}
			}
			trovato=false;
			
			
			while (!trovato) {
				for (int x=0;x<lis.get(h).size();x++) {
					for (int y=0;y<lis.get(h).get(0).length;y++) {
						// per ogni pixel da cambiare
						if (trovato) {
							break;
						}
						lista=(ArrayList<char[]>)lis.get(h).clone();
						char[] temp=new char[lista.get(0).length];
						for (int i=0;i<temp.length;i++) {
							temp[i]=lista.get(x)[i];
						}
						if (temp[y]=='.') {
							temp[y]='#';
						}
						else if (temp[y]=='#') {
							temp[y]='.';
						}
						lista.set(x,temp);
						
						//	cerco orizzontale
						in=0;
						fi=lista.size()-1;
						for (int j=1;j<lista.size();j++) {
							if (check(in,j,"s")) {
								int f=(((j-in)/2)+in+1);
								if (f!=control||vert) {
									f=f*100;
									orizzontale=orizzontale+f;
									trovato=true;
									break;
								}
							}
							if (check(j,fi, "s")) {
								int f=(((fi-j)/2)+j+1);
								if (f!=control||vert) {
									f=f*100;
									orizzontale=orizzontale+f;
									trovato=true;
									break;
								}
							}
						}
					
						// cerco verticale
						in=0;
						fi=lista.get(0).length-1;
						if (!trovato) {
							
							for (int j=1;j<lista.get(0).length;j++) {
								if (check(in,j)) {
									int f=((j-in)/2)+1;
									if (f!=control||!vert) {
										verticale=verticale+f;
										trovato=true;
										break;
									}
								}
								if (check(j,fi)) {
									int f=((fi-j)/2)+j+1;
									if (f!=control||!vert) {
										verticale=verticale+f;
										trovato=true;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		return (long) orizzontale+verticale;
	}
}