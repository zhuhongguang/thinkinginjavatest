package eleven;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetOfInterger {
public static void main(String[] args) {
	Random rand=new Random(47);
	Set<Integer> intset=new HashSet<Integer>();
	//Set<Integer> intset=new TreeSet<Integer>();
	for(int i=0;i<10000;i++){
		intset.add(rand.nextInt(56));
		
	}
	System.out.println(intset);
}
}
