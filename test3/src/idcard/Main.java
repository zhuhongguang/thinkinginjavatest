package idcard;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("½Y³ÇºÆ");
        Product card2 = factory.create("¤È¤à¤é");
        Product card3 = factory.create("×ôÌÙ»¨×Ó");
        card1.use();
        card2.use();
        card3.use();
    }
}
