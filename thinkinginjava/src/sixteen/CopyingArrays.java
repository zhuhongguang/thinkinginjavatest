package sixteen;

import java.util.Arrays;

public class CopyingArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i=new int[7];
		int[] j=new int[10];
		Arrays.fill(i, 47);
		Arrays.fill(j,99);
		System.out.println("i= "+Arrays.toString(i));
		System.out.println("j= "+Arrays.toString(j));
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("j= "+Arrays.toString(j));
		int[] k=new int[5];
		Arrays.fill(k, 103);
		System.arraycopy(i, 0, k, 0, k.length);
		System.out.println("k= "+Arrays.toString(k));
		Arrays.fill(k, 103);
		System.arraycopy(k, 0, i, 0, k.length);
		System.out.println("i= "+Arrays.toString(i));
	}

}
