package aOc22;
import java.util.LinkedList;
import program.Read;

public class Day4_2022 {
	public static long calculate1(String s) {
		int fin=0;
		LinkedList<int[]> list=Read.coorDop(s);
		
		for (int[] in:list) {
			if (in[0]<=in[2]&&in[1]>=in[3]) {
				fin=fin+1;
			}
			else if (in[0]>=in[2]&&in[1]<=in[3]){
				fin=fin+1;
			}
		}
		return (long) fin;
	}
	
	public static long calculate2(String s) {
		int fin=0;
		LinkedList<int[]> list=Read.coorDop(s);
		
		for (int[] in:list) {
			if (in[0]<=in[2]&&in[1]>=in[3]) {
				fin=fin+1;
			}
			else if (in[0]>=in[2]&&in[1]<=in[3]){
				fin=fin+1;
			}
			else if (in[0]<=in[3]&&in[1]>=in[3]){
				fin=fin+1;
			}
			else if (in[0]<=in[2]&&in[1]>=in[2]){
				fin=fin+1;
			}
		}
		return (long) fin;
	}
}