package model;

public class PricePair {

    private int price;
    private int priceWithDiscount;

    public PricePair(int price, int priceWithDiscount) {
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(int priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PricePair{");
        sb.append("price=").append(price);
        sb.append(", priceWithDiscount=").append(priceWithDiscount);
        sb.append('}');
        return sb.toString();
    }
}
