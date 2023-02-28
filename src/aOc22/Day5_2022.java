package aOc22;
import java.util.HashMap;
import java.util.LinkedList;
import program.Read;
import program.Show;

public class Day5_2022 {
	public static long calculate1(String s) {
		int fin=0;
		
		String[] inp=s.split("\\n\\n");
		LinkedList<int[]> list=Read.coorDopD(inp[1]);
		HashMap<Integer,LinkedList<String>> car=Read.schem(inp[0]);
		
		for (int[] in:list) {
			for (int i=0;i<in[0];i++) {
				car.get(in[2]).addFirst(car.get(in[1]).remove());
			}
			
		}
		String fine="";
		for (LinkedList<String> j:car.values()) {
			fine=fine+(j.get(0));
		}
		
		Show f=new Show(fine);
		f.setVisible(true);
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		String[] inp=s.split("\\n\\n");
		LinkedList<int[]> list=Read.coorDopD(inp[1]);
		HashMap<Integer,LinkedList<String>> car=Read.schem(inp[0]);
		
		for (int[] in:list) {
			LinkedList<String> tt=new LinkedList<String>();
			for (int i=0;i<in[0];i++) {
				tt.add(car.get(in[1]).remove(0));
			}
			car.get(in[2]).addAll(0,tt);
			
		}
		String fine="";
		for (LinkedList<String> j:car.values()) {
			fine=fine+(j.get(0));
		}
		
		Show f=new Show(fine);
		f.setVisible(true);
		return (long) fin;
	}
}
