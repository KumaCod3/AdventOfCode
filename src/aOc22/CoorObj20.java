package aOc22;
import java.math.BigInteger;

public class CoorObj20 {
	BigInteger val;
	int valInt=0;
	BigInteger valFin=BigInteger.valueOf(811589153);
	boolean tr=true;
	long inde=0;
	static long m;
	
	public CoorObj20(int vv, int ind) {
		if (vv==0) {
			tr=false;
		}
		valFin=valFin.multiply(BigInteger.valueOf(vv));
		inde=ind;
		BigInteger temp=valFin.mod(BigInteger.valueOf(m-1));
		val=temp.add(BigInteger.valueOf(m-1));
	}
	
	public CoorObj20(int v, int in,String ciao) {
		valInt=v;
		if (v==0) {
			tr=false;
		}
		inde=in;
	}
	
	public String toString() {
		return (valFin+" at index "+inde);
	}
}
