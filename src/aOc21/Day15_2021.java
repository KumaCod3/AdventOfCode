package aOc21;
import java.util.ArrayList;
import java.util.LinkedList;
import program.Nope;
import program.Read;

public class Day15_2021 {

	static LinkedList<int[]> coordinate=new LinkedList<int[]>();
	static LinkedList<int[]> temp=new LinkedList<int[]>();
	
	public static long calculate1(String s) {
		int val=Integer.MAX_VALUE;
		int cont=0;
		ArrayList<int[]> input=Read.intArList(s);
		LinkedList<int[]> fine=new LinkedList<int[]>();
		int larghezza=input.get(0).length-1;
		int altezza=input.size()-1;
		int[] partenza={0,0,0};
		coordinate.add(partenza);
		
		while (coordinate.size()>0){
			int min=Integer.MAX_VALUE;
			for (int[] a:coordinate){
				if (a[0]==larghezza&&a[1]==altezza){
					fine.add(a);
					if (a[2]<val){
						val=a[2];
					}
				}
				else {
					int[] b=new int[a.length];
					int[] c=new int[a.length];
					int[] d=new int[a.length];
					int[] e=new int[a.length];
					
					b[0]=a[0]+1;
					b[1]=a[1];
					c[0]=a[0];
					c[1]=a[1]+1;
					d[0]=a[0]-1;
					d[1]=a[1];
					e[0]=a[0];
					e[1]=a[1]-1;
					
					if (b[0]<=larghezza){
						int bbb=input.get(b[0])[b[1]];
						b[2]=a[2]+bbb;
						if (b[2]<min){
							min=b[2];
						}
						if (b[2]<val){
							temp.add(b);
						}
					}
					if (c[1]<=altezza){
						int ccc=input.get(c[0])[c[1]];
						c[2]=a[2]+ccc;
						if (c[2]<min){
							min=c[2];
						}
						if (c[2]<val){
							temp.add(c);
						}
						
					}
					if (d[0]>=0){
						int bbb=input.get(d[0])[d[1]];
						d[2]=a[2]+bbb;
						if (d[2]<min){
							min=d[2];
						}
						if (d[2]<val){
							temp.add(d);
						}
					}
					if (e[1]>=0){
						int ccc=input.get(e[0])[e[1]];
						e[2]=a[2]+ccc;
						if (e[2]<min){
							min=e[2];
						}
						if (e[2]<val){
							temp.add(e);
						}
						
					}
				}
			}
			coordinate.clear();
			
			for (int[] a:temp){
	
				if (a[2]<min+(min/2)&&a[2]<val&&cont>10){
					aggiungi(a);
				}
				else {
					aggiungi(a);
				}
			}
						
			temp.clear();
			cont++;
		}
		return (long) val;
	}
	
	static void aggiungi(int[] a){
		boolean tr=false;
		if (coordinate.size()==0){
			coordinate.add(a);
		}
		else {
			for (int[] b:coordinate){
				if (b[1]==a[1]&&b[0]==a[0]){
					if (b[2]<a[2]){
						tr=true;
						break;
					}
					else {
						b[2]=a[2];
						tr=true;
						break;
					}
				}
			}
			if (tr==false){
				coordinate.add(a);
			}
		}
	}	
	
	public static long calculate2(String s) {
		Nope no=new Nope();
		no.setVisible(true);
		
		return (long) 0;
	}
}
