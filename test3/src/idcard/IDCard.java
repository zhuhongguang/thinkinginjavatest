package idcard;

public class IDCard extends Product {
    private String owner;
    IDCard(String owner) {
        System.out.println(owner + "及市奈玉毛釬曰引允﹝");
        this.owner = owner;
    }
    public void use() {
        System.out.println(owner + "及市奈玉毛妏中引允﹝");
    }
    public String getOwner() {
        return owner;
    }
}
