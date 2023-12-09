package starbucks;

public class payment {

    private double cash;

    public order Order;
    public boolean completePay;


    public payment( order o ,double cash){

        setCash(cash);
        this.Order = o;

    }

    public void setCash(double cash) {
        this.cash = cash;

    }

    public double getCash() {
        return cash;
    }

    public boolean processPayment(){

        if(Order.calculateTotalPrice() > getCash()){  //cash amount is insufficient
            System.out.println("Not Enough to Cover the Price");
            completePay = false;
        }else {
            setCash(getCash() - Order.calculateTotalPrice()); // calculate the change
            System.out.println("Complete the Payment");
            System.out.printf("The change : $ %.2f\n", getCash());
            completePay = true;
        }

        return completePay;

    }


}


