package aOc22;

import java.math.BigInteger;
import java.util.ArrayList;
import program.Read;

public class Day20_2022 {
	
	public static long calculate1(String s) {
		int fin=0;
		ArrayList<Integer> lis=Read.intList(s);
		System.out.println(lis.size());
		ArrayList<CoorObj20> lista=new ArrayList<CoorObj20>();
		int in=0;
		for (Integer x:lis) {
			CoorObj20 tt=new CoorObj20(x,in,"ciao");
			lista.add(tt);
			in++;
		}

		for (CoorObj20 ob:lista) {
			int index=(int)ob.inde;
			int indexN;

			indexN=index+ob.valInt;

			while (indexN<=0) {
				indexN=lista.size()+indexN-1;
			}
			while (indexN>lista.size()-1) {
				indexN=indexN-lista.size()+1;
			}
			for (CoorObj20 par:lista) {
				if (indexN>index) {
					if (par.inde>index&&par.inde<=indexN) {
						par.inde=par.inde-1;
					}
				}
				else if (indexN<index) {
					if (par.inde<index&&par.inde>=indexN) {
						par.inde=par.inde+1;
					}
				}

			}
			ob.inde=indexN;
		}

		int index=0;
		for (CoorObj20 ob:lista) {
			if (ob.valInt==0) {
				index=(int)ob.inde;
				break;
			}
		}
		int mil=(1000+index)%lista.size();
		int duem=(2000+index)%lista.size();
		int trem=(3000+index)%lista.size();
		for (CoorObj20 ob:lista) {
			if (ob.inde==mil) {
				mil=ob.valInt;
				break;
			}
		}
		for (CoorObj20 ob:lista) {
			if (ob.inde==duem) {
				duem=ob.valInt;
				break;
			}
		}
		for (CoorObj20 ob:lista) {
			if (ob.inde==trem) {
				trem=ob.valInt;
				break;
			}
		}
		fin=mil+duem+trem;
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		long fin=0;
		ArrayList<Integer> lis=Read.intList(s);
		ArrayList<CoorObj20> lista=new ArrayList<CoorObj20>();
		int in=0;
		CoorObj20.m=lis.size();
		for (Integer x:lis) {
			CoorObj20 tt=new CoorObj20(x,in);
			lista.add(tt);
			in++;
		}
		
		for (int i=0; i<10;i++) {
			for (CoorObj20 ob:lista) {
				long index=ob.inde;
				BigInteger indexN;
	
				indexN=ob.val.add(BigInteger.valueOf(index));
	
				while (indexN.compareTo(BigInteger.valueOf(0))<=0) {	// indexN<=0
					indexN=indexN.add(BigInteger.valueOf(lista.size()-1));
				}
				while (indexN.compareTo(BigInteger.valueOf(lista.size()-1))>0) { // indexN>lista.size()-1
					indexN=indexN.subtract(BigInteger.valueOf(lista.size()-1));
				}
				for (CoorObj20 par:lista) {
					if (indexN.compareTo(BigInteger.valueOf(index))>0) {	// indexN>index
						if (par.inde>index&&indexN.compareTo(BigInteger.valueOf(par.inde))>=0) {	// par.inde<=indexN
							par.inde=par.inde-1;
						}
					}
					else if (indexN.compareTo(BigInteger.valueOf(index))<0) {
						if (par.inde<index&&indexN.compareTo(BigInteger.valueOf(par.inde))<=0) {
							par.inde=par.inde+1;
						}
					}
				}
				ob.inde=indexN.longValue();
			}
		}

		long index=0;
		for (CoorObj20 ob:lista) {
			if (ob.valFin.compareTo(BigInteger.valueOf(0))==0) {
				index=ob.inde;
				break;
			}
		}
		long mil=(1000+index)%lista.size();
		long duem=(2000+index)%lista.size();
		long trem=(3000+index)%lista.size();
		BigInteger primo=BigInteger.valueOf(0);
		BigInteger secondo=BigInteger.valueOf(0);
		BigInteger terzo=BigInteger.valueOf(0);
		BigInteger finale;
		for (CoorObj20 ob:lista) {
			if (ob.inde==mil) {
				primo=ob.valFin;
				break;
			}
		}
		for (CoorObj20 ob:lista) {
			if (ob.inde==duem) {
				secondo=ob.valFin;
				break;
			}
		}
		for (CoorObj20 ob:lista) {
			if (ob.inde==trem) {
				terzo=ob.valFin;
				break;
			}
		}
		finale=primo.add(secondo.add(terzo));
		fin=finale.longValue();
		return fin;
	}
}
