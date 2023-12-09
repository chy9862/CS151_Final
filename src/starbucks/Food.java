package starbucks;

public class Food implements Product{

    private String name;
    private int quantity;

    private double price;

    public Food(String productName, int quantity, double price){
        setName(productName);
        setQuantity( quantity);
        setPrice(price);
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setPrice(double price){
        this.price = price;
    }


}
