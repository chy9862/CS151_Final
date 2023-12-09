package starbucks;

public class Drink implements Product{


    public enum Size {
        SHORT, TALL, GRANDE, VENTI;
    }




    private String name;
    private int quantity;

    private double price;

    private Size size = Size.SHORT; // default size is SHORT

    public Drink(String productName, int quantity, double price){
        setName(productName);
        setQuantity( quantity);
        setPrice(price);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPrice() {

        if(this.size == Size.SHORT){
            return price;
        }else if(this.size == Size.TALL){
            return price + 0.25;
        }else if(this.size == Size.GRANDE){
            return price + 0.95;
        }else{
            return price + 1.45;
        }
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
