package hello;
enum PaperCurrencyTypes{
	ONE,TWO,FIVE,TEN,TWENTY,FIFTY
}
public class E21_PaperCurrencyTypesEnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(PaperCurrencyTypes s:PaperCurrencyTypes.values())
			System.out.println(s+", ordinal "+s.ordinal());
	}

}
