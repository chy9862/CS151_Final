package starbucks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class menu {
    // Store the menu and price
    public static ArrayList<Product> products = new ArrayList<Product>();
    String textfilePath;


    public menu(String textfilePath){

        this.textfilePath = textfilePath;

    }

    public void loading(){
        try {
            File file = new File(textfilePath);
            Scanner scanner = new Scanner(file);

            // Read and print each line of the text file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                switch (words[0]){
                    case "Drink":
                        StringBuilder sb = new StringBuilder();

                        int index = 0;

                        for(int i = 1 ; i < words.length ; i++){
                            boolean canParseToInt = true;

                            try {
                                Integer.parseInt(words[i]);
                            } catch (NumberFormatException e) {
                                canParseToInt = false;
                            }

                            if(!canParseToInt){
                                sb.append(words[i]);
                                sb.append(" ");
                            }
                            if(canParseToInt){
                                index = i;
                                break;
                            }
                        }

                        String productName = sb.toString();

                        int quantity = Integer.parseInt(words[index]);

                        double price = Double.parseDouble(words[index+1]);

                        Product drink = new Drink(productName,quantity,price);
                        products.add(drink);
                        break;
                    case "Food":
                        productName  = words[1];
                        quantity = Integer.parseInt(words[2]);
                        price = Double.parseDouble(words[3]);
                        Product food = new Food(productName,quantity,price);
                        products.add(food);
                        break;
                    case "Merchandise":
                        productName = words[1];
                        quantity = Integer.parseInt(words[2]);
                        price = Double.parseDouble(words[3]);
                        Product merchandise= new Merchandise(productName,quantity,price);
                        products.add(merchandise);

                }
            }

            // Close the scanner when done
            scanner.close();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


    public void add(String typeOfProduct, String productName ,int quantity, double price){

        switch (typeOfProduct){
            case "Drink" :
                Product d = new Drink(productName,quantity,price);
                products.add(d);
                break;

            case "Food":
                Product f = new Food(productName,quantity,price);
                products.add(f);
                break;

            case "Merchandise" :
                Product m = new Merchandise(productName,quantity,price);
                products.add(m);
                break;
        }



    }

    public void update(String filePath){

        try {
            // Create a FileWriter with append mode to clear existing content
            FileWriter fileWriter = new FileWriter(filePath, false);

            for(Product p : products){
                if(p instanceof Drink ){ //drink

                    fileWriter.write("Drink");
                    fileWriter.write(" ");
                    fileWriter.write(p.getName());
                    fileWriter.write(" ");
                    fileWriter.write(String.valueOf(((Drink) p).getQuantity()));
                    fileWriter.write(" ");
                    fileWriter.write(Double.toString(((Drink) p).getPrice()));
                    fileWriter.write("\n");

                }else if(p instanceof Food){ //food

                    fileWriter.write("Food");
                    fileWriter.write(" ");
                    fileWriter.write(p.getName());
                    fileWriter.write(" ");
                    fileWriter.write(String.valueOf(((Drink) p).getQuantity()));
                    fileWriter.write(" ");
                    fileWriter.write(Double.toString(((Drink) p).getPrice()));
                    fileWriter.write("\n");

                }else{ //merchandise

                    fileWriter.write("Merchandise");
                    fileWriter.write(" ");
                    fileWriter.write(p.getName());
                    fileWriter.write(" ");
                    fileWriter.write(String.valueOf(((Drink) p).getQuantity()));
                    fileWriter.write(" ");
                    fileWriter.write(Double.toString(((Drink) p).getPrice()));
                    fileWriter.write("\n");

                }

            }

            // Close the fileWriter when done
            fileWriter.close();

            System.out.println("Update successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }





    }

    public void remove (String productName){

        boolean result = false;

        for(Product p : products ){
            if(productName.equals(p.getName())) {
                products.remove(p);
                System.out.println("Success to Remove the Item!");
                result = true;
                return;
            }

        }

        if(!result){
            System.out.println("Can not Find the item");
        }

    }


}
