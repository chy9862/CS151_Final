package starbucks;


import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static starbucks.menu.products;

public class order {
    public HashMap<String, ArrayList<String>> orderList = new HashMap<>();

    public order(){

    }

    public void addOrderDrink(Product p, int quantity, int size){
            //small
            if(size ==1){
                String orderAndSize = p.getName()+"s";
                if(orderList.containsKey(orderAndSize)){
                    if(orderList.get(orderAndSize).get(0)!=null){ // the first index is quantity

                        ArrayList<String> temp = orderList.get(orderAndSize);
                        int tempQuantity = parseInt(orderList.get(orderAndSize).get(0));
                        tempQuantity += quantity;
                        String quantities = Integer.toString(tempQuantity);

                        //remove and add the updated one
                        temp.remove(0);
                        temp.add(0,quantities);

//                        orderList.put(orderAndSize,tempList);

                    }

                }

                else{
                    String quantities = Integer.toString(quantity);
                    ArrayList<String> tempList =  new ArrayList<>();
                    tempList.add(quantities);
                    orderList.put(p.getName()+"s",tempList);
                }

                ((Drink) p).setSize(Drink.Size.SHORT);
            }
            //tall
            else if(size ==2){

                String orderAndSize = p.getName()+"t";
                if(orderList.containsKey(orderAndSize)){
                    if(orderList.get(orderAndSize).get(0)!=null){ // the first index is quantity

                        ArrayList<String> temp = orderList.get(orderAndSize);
                        int tempQuantity = parseInt(orderList.get(orderAndSize).get(0));
                        tempQuantity += quantity;
                        String quantities = Integer.toString(tempQuantity);

                        //remove and add the updated one
                        temp.remove(0);
                        temp.add(0,quantities);

//                        orderList.put(orderAndSize,tempList);

                    }

                }

                else{
                    String quantities = Integer.toString(quantity);
                    ArrayList<String> tempList =  new ArrayList<>();
                    tempList.add(quantities);
                    orderList.put(p.getName()+"t",tempList);
                }

                ((Drink) p).setSize(Drink.Size.TALL);
            }
            //grande
            else if(size ==3){
                String orderAndSize = p.getName()+"g";
                if(orderList.containsKey(orderAndSize)){
                    if(orderList.get(orderAndSize).get(0)!=null){ // the first index is quantity

                        ArrayList<String> temp = orderList.get(orderAndSize);
                        int tempQuantity = parseInt(orderList.get(orderAndSize).get(0));
                        tempQuantity += quantity;
                        String quantities = Integer.toString(tempQuantity);

                        //remove and add the updated one
                        temp.remove(0);
                        temp.add(0,quantities);

//                        orderList.put(orderAndSize,tempList);

                    }

                }

                else{
                    String quantities = Integer.toString(quantity);
                    ArrayList<String> tempList =  new ArrayList<>();
                    tempList.add(quantities);
                    orderList.put(p.getName()+"g",tempList);
                }
                ((Drink) p).setSize(Drink.Size.GRANDE);
            }
            //venti
            else {
                String orderAndSize = p.getName()+"v";
                if(orderList.containsKey(orderAndSize)){
                    if(orderList.get(orderAndSize).get(0)!=null){ // the first index is quantity

                        ArrayList<String> temp = orderList.get(orderAndSize);
                        int tempQuantity = parseInt(orderList.get(orderAndSize).get(0));
                        tempQuantity += quantity;
                        String quantities = Integer.toString(tempQuantity);

                        //remove and add the updated one
                        temp.remove(0);
                        temp.add(0,quantities);

//                        orderList.put(orderAndSize,tempList);

                    }

                }

                else{
                    String quantities = Integer.toString(quantity);
                    ArrayList<String> tempList =  new ArrayList<>();
                    tempList.add(quantities);
                    orderList.put(p.getName()+"v",tempList);
                }
                ((Drink) p).setSize(Drink.Size.VENTI);
            }


    }

    public void addOrder(Product p, int quantity){
        ArrayList<String> Customize = new ArrayList<>();
        String quantities = Integer.toString(quantity);
        Customize.add(quantities);
        orderList.put(p.getName(),Customize);
    }


    public double calculateTotalPrice(){

            double totalCost = 0.0;

            for(Map.Entry<String, ArrayList<String>> order : orderList.entrySet()){
                String Order = order.getKey();
                String Name = Order.substring(0, Order.length() - 1);
                String Size = Order.substring(Order.length() - 1);

                for(Product p : products){

                    if(p instanceof Drink){

                        if(Name.equals(p.getName())&& Size.equals("s")){
                            ((Drink) p).setSize(Drink.Size.SHORT);
                            ArrayList<String> quantityAndCustomized  = order.getValue();
                            int quantityInt = parseInt(quantityAndCustomized.get(0));
                            totalCost += p.getPrice() * quantityInt;

                            //calculate customize
                            if(quantityAndCustomized.get(1) != null){
                                int shots  = parseInt(quantityAndCustomized.get(1).substring(quantityAndCustomized.get(1).length() - 1));
                                if(shots > 3){
                                    totalCost += 0.5;
                                }
                            }

                        }
                        //tall
                        else if(Name.equals(p.getName())&& Size.equals("t")){
                            ((Drink) p).setSize(Drink.Size.TALL);
                            ArrayList<String> quantityAndCustomized  = order.getValue();
                            int quantityInt = parseInt(quantityAndCustomized.get(0));
                            totalCost += p.getPrice() * quantityInt;

                            //calculate customize
                            if(quantityAndCustomized.get(1) != null){
                                int shots  = parseInt(quantityAndCustomized.get(1).substring(quantityAndCustomized.get(1).length() - 1));
                                if(shots > 3){
                                    totalCost += 0.5;
                                }
                            }

                        }
                        //grande
                        else if(Name.equals(p.getName())&& Size.equals("g")){
                            ((Drink) p).setSize(Drink.Size.GRANDE);
                            ArrayList<String> quantityAndCustomized  = order.getValue();
                            int quantityInt = parseInt(quantityAndCustomized.get(0));
                            totalCost += p.getPrice() * quantityInt;

                            //calculate customize
                            if(quantityAndCustomized.get(1) != null){
                                int shots  = parseInt(quantityAndCustomized.get(1).substring(quantityAndCustomized.get(1).length() - 1));
                                if(shots > 3){
                                    totalCost += 0.5;
                                }
                            }

                        }
                        //venti
                        else if(Name.equals(p.getName())&& Size.equals("v")){
                            ((Drink) p).setSize(Drink.Size.VENTI);
                            ArrayList<String> quantityAndCustomized  = order.getValue();
                            int quantityInt = parseInt(quantityAndCustomized.get(0));
                            totalCost += p.getPrice() * quantityInt;

                            //calculate customize
                            if(quantityAndCustomized.get(1) != null){
                                int shots  = parseInt(quantityAndCustomized.get(1).substring(quantityAndCustomized.get(1).length() - 1));
                                if(shots > 3){
                                    totalCost += 0.5;
                                }
                            }

                        }

                    }


                }




            }


            return totalCost;

    }


}
