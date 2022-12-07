package aOc22;
import java.util.ArrayList;
import program.Read;

public class Day07_2022 {
	public static long calculate1(String s) {
		long fin=0;
		ArrayList<String[]> list=Read.copListS(s);
		final long max=100000;
		
		Day07_2022tree nn=new Day07_2022tree("0");
		nn.parent=nn;
		Day07_2022tree.list.add(nn);
		for (String[] com:list) {
			if (com[0].equals("commandcd")) {
				if (com[1].equals("..")) {
					nn=nn.parent;
				}
				else  {
					try {
						nn=nn.getChild(com[1]);
					}
					catch (Exception e) {
					}
				}
			}
			else if (com[0].equals("commandls")) {
				continue;
			}
			else if (com[0].equals("dir")) {
				nn.addChild(com[1]);
			}
			else {
				try {
					int x=Integer.parseInt(com[0]);
					nn.add(x);
				}
				catch (Exception eee) {}
			}
		}
		ArrayList<Long> ccc=new ArrayList<Long>();
		
		for (Day07_2022tree tr:Day07_2022tree.list) {
			if (!tr.name.equals("0")) {
				long dd=tr.conta();
				ccc.add(dd);
			}
		}
		for (Long ll:ccc) {
			if (ll<=max) {
				fin=fin+ll;
			}
		}
		return fin;
	}
	
	public static long calculate2(String s) {
		ArrayList<String[]> list=Read.copListS(s);
		long max=Integer.MAX_VALUE;
		final long tre=30000000;
		final long set=70000000;
		
		int cun=0;
		Day07_2022tree nn=new Day07_2022tree("0");
		nn.parent=nn;
		Day07_2022tree.list.add(nn);
		for (String[] com:list) {
			if (com[0].equals("commandcd")) {
				if (com[1].equals("..")) {
					nn=nn.parent;
					System.out.println(" salgo a  "+nn.name);
				}
				else  {
					try {
						nn=nn.getChild(com[1]);
						System.out.println(" entro in "+nn.name+nn.parent.name);
					}
					catch (Exception e) {
						System.out.println("NONOnoNon "+nn.name);
					}
				}
			}
			
			else if (com[0].equals("commandls")) {
				continue;
			}
			
			else if (com[0].equals("dir")) {
				cun++;
				nn.addChild(com[1]);
				System.out.println(" aggiungo  "+com[1]+" ad "+nn.name);
			}
			
			else {
				try {
					int x=Integer.parseInt(com[0]);
					System.out.println("  metto file "+x+" in "+nn.name);
					nn.add(x);
				}
				catch (Exception eee) {					System.out.println(" non parso");}
			}
		}
		System.out.println("FINEEE "+Day07_2022tree.list.size()+" = "+cun);
		ArrayList<Long> ccc=new ArrayList<Long>();
		
		for (Day07_2022tree tr:Day07_2022tree.list) {
			if (!tr.name.equals("0")) {
				long dd=tr.conta();
				ccc.add(dd);
			}
		}
		long root=0l;
		for (Day07_2022tree tr:Day07_2022tree.list) {
			if (tr.name.equals("0")) {
				root=tr.conta();
			}
		}
		long dif=tre-(set-root);
		for (Long ll:ccc) {
			if (ll>=dif) {
				if (ll<max) {
					max=ll;
				}
			}
		}
		return max;
	}
}
