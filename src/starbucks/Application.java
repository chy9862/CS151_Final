package starbucks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static starbucks.menu.products;


    public class Application {
        Scanner scanner = new Scanner(System.in);
        public menu m;
        public order o = new order();


        public payment p;

        String filepath;
    public Application (String filepath) { // constructor
        this.filepath = filepath;
        m = new menu(filepath);
        m.loading(); //load all the products in txt file
        System.out.println("Loading complete!");
        startApp(); //start the app
    }


    public void startApp(){

        System.out.println("Welcome to StarBucks!\n Choose the option(choose number)");
        System.out.println("1. Update Menu (Manage Menu)");
        System.out.println("2. Order");
        System.out.println("3. Quit");
        int selectOption = scanner.nextInt();

        //update the menu
        if(selectOption == 1 ){
            updateMenu();

        }
        //take the order
        else if(selectOption == 2){


            int checkout;
            do {

                checkout = chooseMenu();

            }
            while (checkout == 2);

            if (checkout == 1) {

                boolean completePayment;
                do {
                    System.out.printf("\nThe total price : $%.2f\n", o.calculateTotalPrice());
                    System.out.println("Type the cash amount : ");
                    double cashAmount = scanner.nextDouble();
                    p = new payment(o, cashAmount);
                    completePayment = p.processPayment();
                }
                while (!completePayment);
                m.update(filepath);
                System.out.println("You're all set! Thank You!\n\n\n\n\n");
                startApp();

            }

            if (checkout == 3) {
                m.update(filepath); //update the data
                System.out.println("quit the app!");
                System.exit(0); //quit all process

            }
        }
        //quit the app in main menu
        else{
            m.update(filepath); //update the products
            System.out.println("quit the app!");
            System.exit(0); //quit all process
        }
    }

    public HashMap<Integer, String> orderlist(){
            int listNum = 1;
            HashMap<Integer, String> numWithOrder = new HashMap<>();

            for (Map.Entry<String, ArrayList<String>> order : o.orderList.entrySet()) {
                String Order = order.getKey();
                String Name = Order.substring(0, Order.length() - 1);
                String Size = Order.substring(Order.length() - 1);

                for(Product p : products){

                    if(p.getName().equals(Name) && Size.equals("s")){
                        System.out.println(listNum+". " + Name + " SHORT " + " x " + order.getValue().get(0));

                        if(order.getValue().size() >=2){
                            for(int i =1 ; i < order.getValue().size() ; i++){

                                String customizeQuantity = order.getValue().get(i).substring(order.getValue().get(i).length() - 1);
                                try {
                                    int value = Integer.parseInt(customizeQuantity);
                                    String customizeMenuName = order.getValue().get(i).substring(0,order.getValue().get(i).length() - 1);

                                    //index 1 => espresso shots
                                    if(i==1){
                                        System.out.println("     " + customizeMenuName + " " + customizeQuantity + " Shots");
                                    }else {
                                        System.out.println("     " + customizeMenuName + " x " + customizeQuantity);
                                    }


                                } catch (NumberFormatException e) {
                                    System.out.println("  " + order.getValue().get(i));
                                }


                            }
                        }

                        numWithOrder.put(listNum,Order);
                        listNum++;
                    }else if(p.getName().equals(Name) && Size.equals("t")){
                        System.out.println(listNum+". "+Name + " TALL " + " x " + order.getValue().get(0));

                        if(order.getValue().size() >=2){
                            for(int i =1 ; i < order.getValue().size() ; i++){

                                String customizeQuantity = order.getValue().get(i).substring(order.getValue().get(i).length() - 1);
                                try {
                                    int value = Integer.parseInt(customizeQuantity);
                                    String customizeMenuName = order.getValue().get(i).substring(0,order.getValue().get(i).length() - 1);

                                    //index 1 => espresso shots
                                    if(i==1){
                                        System.out.println("  " + customizeMenuName + " x " + customizeQuantity + " Shots");
                                    }else {
                                        System.out.println("  " + customizeMenuName + " x " + customizeQuantity);
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("  " + order.getValue().get(i));
                                }

                            }
                        }

                        numWithOrder.put(listNum,Order);
                        listNum++;
                    }else if(p.getName().equals(Name) && Size.equals("g")){
                        System.out.println(listNum+". "+Name + " GRANDE " + " x " + order.getValue().get(0));

                        if(order.getValue().size() >=2){
                            for(int i =1 ; i < order.getValue().size() ; i++){

                                String customizeQuantity = order.getValue().get(i).substring(order.getValue().get(i).length() - 1);
                                try {
                                    int value = Integer.parseInt(customizeQuantity);
                                    String customizeMenuName = order.getValue().get(i).substring(0,order.getValue().get(i).length() - 1);

                                    //index 1 => espresso shots
                                    if(i==1){
                                        System.out.println("  " + customizeMenuName + " x " + customizeQuantity + " Shots");
                                    }else {
                                        System.out.println("  " + customizeMenuName + " x " + customizeQuantity);
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("  " + order.getValue().get(i));
                                }

                            }
                        }
                        numWithOrder.put(listNum,Order);
                        listNum++;
                    }else if(p.getName().equals(Name) && Size.equals("v")){
                        System.out.println(listNum+". "+ Name + " VENTI " + " x " + order.getValue().get(0));

                        if(order.getValue().size() >=2){
                            for(int i =1 ; i < order.getValue().size() ; i++){

                                String customizeQuantity = order.getValue().get(i).substring(order.getValue().get(i).length() - 1);
                                try {
                                    int value = Integer.parseInt(customizeQuantity);
                                    String customizeMenuName = order.getValue().get(i).substring(0,order.getValue().get(i).length() - 1);

                                    //index 1 => espresso shots
                                    if(i==1){
                                        System.out.println("  " + customizeMenuName + " x " + customizeQuantity + " Shots");
                                    }else {
                                        System.out.println("  " + customizeMenuName + " x " + customizeQuantity);
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("  " + order.getValue().get(i));
                                }

                            }
                        }

                        numWithOrder.put(listNum,Order);
                        listNum++;
                    }

//                    else{
//                        System.out.println(listNum+". " + Order + " x" + order.getValue());
//                        numWithOrder.put(listNum,Order);
//                        listNum++;
//                    }

                }

            }

            return numWithOrder;

    }

    public void updateMenu(){
        boolean passUpdate =true;
        double doubleprice = 0.0;
        int Integerquantity =0;
        int listNum =1;
        HashMap<Integer,Product> menuWithListnumber = new HashMap<>();
                do {
                    System.out.println("Choose the option to update (choose number)");
                    System.out.println("1. Add the Menu");
                    System.out.println("2. Remove");
                    System.out.println("3. Update Quantity");
                    System.out.println("4. Check the Quantity");
                    System.out.println("5. Back to main");
                    int chooseUpdate = scanner.nextInt();
                    //add the new menu
                    if (chooseUpdate == 1) {
                        boolean pass;
                        System.out.println("Select the type of product to add (choose number)");
                        System.out.println("1. Drink");
                        System.out.println("2. Food");
                        System.out.println("3. Merchandise");
                        System.out.println("4. back to update menu");
                        int choosetype = scanner.nextInt();

                        if(choosetype == 4){
                            passUpdate = false;
                        }
                        else{
                        System.out.println("Type menu name: ");
                        String name = scanner.next();

                        do {

                            System.out.println("Type the price(USD) : ");
                            String price = scanner.next();
                            try {
                                doubleprice = Double.parseDouble(price);
                                pass = true;

                            }
                            catch (NumberFormatException e) {
                                pass = false;
                                System.out.println("Invalid input. Please enter a valid double value.(i.e 5.0)");
                            }

                        }while(!pass);


                        do {

                            System.out.println("Type the quantity : ");
                            String quantity = scanner.next();
                            try {
                                Integerquantity = Integer.parseInt(quantity);
                                pass = true;

                            }
                            catch (NumberFormatException e) {
                                pass = false;
                                System.out.println("Invalid input. Please enter a valid double value.(i.e 12)");
                            }

                        }while(!pass);

                        //add for Drink
                        if(choosetype==1){

                            Product newMenu = new Drink(name,Integerquantity,doubleprice);
                            products.add(newMenu);
                            m.update(filepath);
                            System.out.println("Successfully add the product!");

                        }
                        //add for Food
                        else if(choosetype == 2){
                            Product newMenu = new Food(name,Integerquantity,doubleprice);
                            products.add(newMenu);
                            m.update(filepath);
                            System.out.println("Successfully add the product!");
                        }
                        //add for merchandise
                        else{
                            Product newMenu = new Merchandise(name,Integerquantity,doubleprice);
                            products.add(newMenu);
                            m.update(filepath);
                            System.out.println("Successfully add the product!");
                        }
                        }//end of else
                    }

                    //remove the menu
                    else if (chooseUpdate == 2) {
                        System.out.println("Choose option or the product to remove (choose number)");
                        for(Product p :  products){

                            System.out.println(listNum +". "+ p.getName() + " $"+p.getPrice());
                            menuWithListnumber.put(listNum,p);
                            listNum++;

                        }
                        System.out.println(listNum +". Back to Update menu");
                        int chooseMenuToRemove = scanner.nextInt();

                        if(chooseMenuToRemove == listNum){
                            passUpdate = false;
                        }
                        else {
                            String menuName = menuWithListnumber.get(chooseMenuToRemove).getName();

                            for (Product p : products) { //remove the product in products list
                                if (menuName.equals(p.getName())) {
                                    products.remove(p);
                                    break;
                                }
                            }
                            m.update(filepath);
                            System.out.println("Successfully update the menu!");
                            startApp();
                        }

                    }

                    //update the quantity
                    else if (chooseUpdate == 3) {
                        System.out.println("Choose the product to update the quantity or option (choose number)");
                        for(Product p :  products){

                            System.out.println(listNum +". "+ p.getName() + " x "+p.getQuantity());
                            menuWithListnumber.put(listNum,p);
                            listNum++;

                        }
                        System.out.println(listNum + ". go back to update menu");
                        int chooseMenuToUpdateQuantity = scanner.nextInt();

                        if(chooseMenuToUpdateQuantity == listNum){
                            passUpdate =false;
                        }else {

                            String menuName = menuWithListnumber.get(chooseMenuToUpdateQuantity).getName();

                            //Update the product quantity in products list
                            for (Product p : products) {
                                if (menuName.equals(p.getName())) {
                                    System.out.printf("Type the quantity : ");
                                    int quantity = scanner.nextInt();
                                    p.setQuantity(quantity);
                                    break;
                                }
                            }

                            m.update(filepath);
                            System.out.println("Successfully update the menu!");
                            startApp();

                        }
                    }

                    //Check the quantity
                    else if (chooseUpdate == 4){

                        boolean goCheckQuantityMenu = false;

                        do {

                            System.out.println("Select the type of product to check the quantity");
                            System.out.println("1. Drink");
                            System.out.println("2. Food");
                            System.out.println("3. Merchandise");
                            System.out.println("4. Back to update menu");

                            int choosetype = scanner.nextInt();

                            if (choosetype == 4) {
                                goCheckQuantityMenu = false;
                                passUpdate = false;
                            }
                            else { // choose other options (1,2,3)

                                if (choosetype == 1) {
                                    for (Product p : products) {
                                        if (p instanceof Drink) {
                                            System.out.println(p.getName() + "\n Quantity :  " + p.getQuantity());
                                        }
                                    }
                                    System.out.println("Back to menu" );

                                        goCheckQuantityMenu = true;

                                }

                                else if (choosetype == 2) {
                                    for (Product p : products) {
                                        if (p instanceof Food) {
                                            System.out.println(p.getName() + "\n Quantity :  " + p.getQuantity());
                                        }
                                    }

                                    System.out.println("Back to menu" );

                                    goCheckQuantityMenu = true;
                                }

                                else if (choosetype == 3) {
                                    for (Product p : products) {
                                        if (p instanceof Merchandise) {
                                            System.out.println(p.getName() + "\n Quantity :  " + p.getQuantity());
                                        }
                                    }

                                    System.out.println("Back to menu" );

                                    goCheckQuantityMenu = true;
                                }

                            }


                        }while(goCheckQuantityMenu);



                    }

                    //back to the main menu
                    else if(chooseUpdate ==5){
                       startApp();
                    }

                    // select the wrong update
                    else {
                        System.out.println("Select the Wrong Option\n" + "Select again");
                        passUpdate = false;
                    }

                } while(!passUpdate);

    }

    public int chooseMenu(){

        String CompleteCustomized="";

        if(products.size()==0){
            System.out.println("Sorry.. There is currently no available menu");
            //go back to start menu again
            startApp();
        }

        System.out.println("Order item? (choose number)");
        System.out.println("1. Drink");
        System.out.println("2. Food");
        System.out.println("3. Merchandise");
        System.out.println("4. Remove the item from the list");
        System.out.println("5. Go back to main menu");
        int chooseNum = scanner.nextInt();

        // go back to main menu
        if(chooseNum == 5){
            startApp();
        }


        HashMap <Integer,Product> menuWithListnumber;

        boolean SelectAgain = false;
        int listNum = 0;
        int quantityForstock = 0 ;

        switch(chooseNum) {

            case 1:
                int chooseproduct = 0 ;
                int chooseQuantity;
                int chooseSize = 0;
                boolean drinkmenu = false;


                do { // loop drink menu
                    listNum = 0;
                    menuWithListnumber = new HashMap<>();
                    System.out.println("Choose your drink with the number");


                    // show the drink list
                    for (Product p : products) {
                        if (p instanceof Drink) {

                            if (p.getQuantity() == 0) {// when the quantity is 0.
                                ++listNum;
                                System.out.println(listNum + ". " + p.getName() + " $" + p.getPrice() + "-> Out Of Stock");
                                menuWithListnumber.put(listNum, p);

                            } else {
                                ++listNum;
                                System.out.println(listNum + ". " + p.getName() + " $" + p.getPrice() + " (SHORT size (8oz))");
                                menuWithListnumber.put(listNum, p);
                                quantityForstock += p.getQuantity();
                            }
                        }
                    }

                    //display option for 'back to menu'
                    System.out.println(listNum + 1 + "." + " Back to menu");


                    //if there is no drink
                    if (listNum == 0) {
                        System.out.println("No available drink currently");
                        chooseMenu(); // go back to order menu

                        // all menu out of stock
                    } else if (quantityForstock == 0) {
                        System.out.println("All drink is out of stock");
                        chooseMenu(); // go back to order menu
                    }

                    //choose the product
                    chooseproduct = scanner.nextInt();

                    //go back to menu
                    if (chooseproduct == listNum + 1) {
                        chooseMenu();
                    }


                    //choose the size
                    while (chooseSize < 1 || chooseSize > 5) {
                        System.out.println("What size? (choose number)");
                        System.out.println("1. SHORT (8oz)" + " ( $" + menuWithListnumber.get(chooseproduct).getPrice() + ")");
                        System.out.println("2. TALL (12oz)" + " ( $" + (menuWithListnumber.get(chooseproduct).getPrice() + 0.25) + ")");
                        System.out.println("3. GRANDE (16oz)" + " ( $" + (menuWithListnumber.get(chooseproduct).getPrice() + 0.95) + ")");
                        System.out.println("4. VENTI (20oz)" + " ( $" + (menuWithListnumber.get(chooseproduct).getPrice() + 1.45) + ")");
                        System.out.println("5. Change the Drink (Go Back to Previous Page");

                        chooseSize = scanner.nextInt();

                        // If the choice is out of range, inform the user and prompt again
                        if (chooseSize < 1 || chooseSize > 5) {
                            System.out.println("Invalid choice. Please select a number between 1 and 4.");
                        }


                    }
                    // go back to drink menu
                    if (chooseSize == 5) {
                        drinkmenu = true;
                    }

                }while(drinkmenu);

                scanner.nextLine(); // consume the newline character

                //Start customize
                boolean escapeCustomize = true;
                do{

                    System.out.println("Customize? Type if yes[y] or No[n]");
                    String customized  = scanner.nextLine();

                    if(customized.equals("y")){


                        CompleteCustomized = customizeForDrink();

                        //if it is customized
                        if(!CompleteCustomized.equals("")){
                            escapeCustomize = false; //pass the do while loop
                        }

                        else {
                            escapeCustomize = true;
                        }

                    }
                    else if(customized.equals("n")){
                        escapeCustomize = false; //pass the do while loop without customizing
                    }
                  else{
                        System.out.println("Invalid type");
                        escapeCustomize = true;
                  }

                }while(escapeCustomize);



                // choose quantity
                do{

                    System.out.println("How many cups? (the quantity left : " + menuWithListnumber.get(chooseproduct).getQuantity() +" )");


                    chooseQuantity = scanner.nextInt();


                    if(chooseQuantity > menuWithListnumber.get(chooseproduct).getQuantity() || chooseQuantity<=0){
                        System.out.println("Over the limit of Quantity in stock");
                        System.out.println("Type it again");
                        SelectAgain = true;
                    }


                }

                while(SelectAgain); // if the chosen quantity greater than quantity in stock
                                    // choose it again

                // update the quantity
                int updateTheQuantity =  menuWithListnumber.get(chooseproduct).getQuantity();
                menuWithListnumber.get(chooseproduct).setQuantity(updateTheQuantity-chooseQuantity);

                //add order

                //short
                if(chooseSize ==1){
                    StringBuilder sb = new StringBuilder();
                    //add order size and quantity
                    o.addOrderDrink(menuWithListnumber.get(chooseproduct),chooseQuantity,1);

                    //add the customized
                    sb.append(menuWithListnumber.get(chooseproduct).getName());
                    sb.append("s");
                    String orderListItem = sb.toString();
                    System.out.println(orderListItem);
                    o.orderList.get(orderListItem).add(CompleteCustomized);
                }
                //tall
                else if(chooseSize ==2){
                    StringBuilder sb = new StringBuilder();
                    //add order size and quantity
                    o.addOrderDrink(menuWithListnumber.get(chooseproduct),chooseQuantity,2);

                    //add the customized
                    sb.append(menuWithListnumber.get(chooseproduct).getName());
                    sb.append("t");
                    String orderListItem = sb.toString();
                    o.orderList.get(orderListItem).add(CompleteCustomized);
                }
                //grande
                else if(chooseSize ==3){
                    StringBuilder sb = new StringBuilder();
                    //add order size and quantity
                    o.addOrderDrink(menuWithListnumber.get(chooseproduct),chooseQuantity,3);
                    //add the customized
                    sb.append(menuWithListnumber.get(chooseproduct).getName());
                    sb.append("g");
                    String orderListItem = sb.toString();
                    o.orderList.get(orderListItem).add(CompleteCustomized);
                }
                //venti
                else if(chooseSize ==4){
                    StringBuilder sb = new StringBuilder();
                    //add order size and quantity
                    o.addOrderDrink(menuWithListnumber.get(chooseproduct),chooseQuantity,4);
                    //add the customized
                    sb.append(menuWithListnumber.get(chooseproduct).getName());
                    sb.append("v");
                    String orderListItem = sb.toString();
                    o.orderList.get(orderListItem).add(CompleteCustomized);
                }


                System.out.printf("\nThe order summary :\n");
                orderlist();
                System.out.printf("The total price : $%.2f\n", o.calculateTotalPrice());
                break;

            case 2:
                SelectAgain = false;
                System.out.println("Choose your Food with the number");
                listNum = 1;
                menuWithListnumber = new HashMap<>();
                System.out.println("Choose The number");
                for(Product p :  products){
                    if(p instanceof Food){

                        System.out.println(listNum + p.getName() + " $"+p.getPrice());
                        menuWithListnumber.put(listNum,p);
                        listNum++;
                    }
                }
                chooseproduct = scanner.nextInt();


                do{
                    System.out.println("How many pieces? (the quantity left : " + menuWithListnumber.get(chooseproduct).getQuantity() +" )");
                    chooseQuantity = scanner.nextInt();

                    if(chooseQuantity > menuWithListnumber.get(chooseproduct).getQuantity()){
                        System.out.println("Over the limit of Quantity in stock");
                        System.out.println("Type it again");
                        SelectAgain = true;
                    }
                }
                while(SelectAgain); // if the chosen quantity greater than quantity in stock
                                    // choose it again

                // update the quantity
                updateTheQuantity =  menuWithListnumber.get(chooseproduct).getQuantity();
                menuWithListnumber.get(chooseproduct).setQuantity(updateTheQuantity-1);
                o.addOrder(menuWithListnumber.get(chooseproduct),chooseQuantity);
                System.out.printf("\nThe total price : $%.2f\n", o.calculateTotalPrice());
                break;

            case 3:
                SelectAgain = false;
                System.out.println("Choose your Merchandise with the number");
                listNum = 1;
                menuWithListnumber = new HashMap<>();
                System.out.println("Choose The number");
                for(Product p :  products){
                    if(p instanceof Merchandise){

                        System.out.println(listNum + p.getName() + " $"+p.getPrice());
                        menuWithListnumber.put(listNum,p);
                        listNum++;
                    }
                }
                chooseproduct = scanner.nextInt();
                do{
                    System.out.println("How many? (the quantity left : " + menuWithListnumber.get(chooseproduct).getQuantity() +" )");
                    chooseQuantity = scanner.nextInt();

                    if(chooseQuantity > menuWithListnumber.get(chooseproduct).getQuantity()){
                        System.out.println("Over the limit of Quantity in stock");
                        System.out.println("Type it again");
                        SelectAgain = true;
                    }
                }
                while(SelectAgain); // if the chosen quantity greater than quantity in stock
                                    // choose it again

                // update the quantity
                updateTheQuantity =  menuWithListnumber.get(chooseproduct).getQuantity();
                menuWithListnumber.get(chooseproduct).setQuantity(updateTheQuantity-1);
                o.addOrder(menuWithListnumber.get(chooseproduct),chooseQuantity);
                System.out.printf("\nThe total price : $%.2f\n", o.calculateTotalPrice());
                break;
            case 4 :
                //no item in the list
                if(o.orderList==null){
                    System.out.println("No item in the order list");
                    chooseMenu();

                }
                // item exists in the list
                else {
                    boolean selectAgain = true;
                    do {
                        System.out.println("What items you want to edit the quantity(choose number)");
                        HashMap<Integer, String> editmenu = orderlist();

                        int chooseitem = scanner.nextInt();
                        if (chooseitem <= 0 || chooseitem > editmenu.size()) {
                            System.out.println("Choose invalid option(number)");
                        } else {

                            for (Map.Entry<Integer, String> order : editmenu.entrySet()) {
                                int quantity =0;
                                if (order.getKey().equals(chooseitem)) {
                                    String Order = order.getValue();
                                    String Name = Order.substring(0, Order.length() - 1);
                                    String Size = Order.substring(Order.length() - 1);

                                    for(Product p : products){

                                        if(p.getName().equals(Name)){ //drink
                                            quantity =  p.getQuantity();

                                            break;
                                        }
                                        else if(p.getName().equals(Order)){ //other item
                                            quantity =  p.getQuantity();
                                            break;
                                        }
                                    }

                                    if(quantity == 0){
                                        System.out.println("This item is out of stock");
                                    }

                                    System.out.println("Type the quantity you want to remove: ");
                                    int removeQuantity = scanner.nextInt();
                                    //remove the item...


                                    if(removeQuantity==0){
                                        o.orderList.remove(Order);
                                        System.out.println("Update the list!");

                                    }else if(removeQuantity >0 && removeQuantity <= quantity ){
                                        o.orderList.remove(Order);
                                        for(Product p : products ){
                                            if(p.getName().equals(Name) && Size.equals("s") ){
                                                o.addOrderDrink(p,removeQuantity,1);
                                            }

                                            else if(p.getName().equals(Name) && Size.equals("t")){
                                                o.addOrderDrink(p,removeQuantity,2);
                                            }

                                            else if(p.getName().equals(Name) && Size.equals("g")){
                                                o.addOrderDrink(p,removeQuantity,3);
                                            }

                                            else if(p.getName().equals(Name) && Size.equals("v")){
                                                o.addOrderDrink(p,removeQuantity,4);
                                            }

                                            else{
                                                o.addOrder(p,removeQuantity);
                                            }
                                        }
                                        System.out.println("Update the list!");
                                    }

                                    break;
                                }
                            }
                            selectAgain = false;
                        }


                    } while (selectAgain);

                }
                System.out.printf("\nThe order summary :\n");
                orderlist();
                System.out.printf("The total price : $%.2f\n", o.calculateTotalPrice());
        }

        System.out.println("\nCheck out or Edit items? (choose the number)");
        System.out.println("1. Proceed to Check out");
        System.out.println("2. Go back to Menu to edit items");
        System.out.println("3. Quit the app");
        int chooseMenuOrCheckcout = scanner.nextInt();

        if(chooseMenuOrCheckcout==1){
            return 1;
        }else if(chooseMenuOrCheckcout==2){
            return 2;
        }else{
            return 3;
        }
    }

    public String customizeForDrink(){
        String result= "";
        System.out.println("Espresso Roast Options (Choose Option)");
        System.out.println("Extra charges(50 cents) more than 3 shots");
        System.out.println("1. Signature Espresso Roast (default : 3 Shots) ");
        System.out.println("2. Blonde Espresso Roast (default : 3 Shots) ");
        System.out.println("3. Decaf Espresso Roast (default : 3 Shots) ");

        int ChooseRoast = scanner.nextInt();

        if(ChooseRoast ==1){
            String Roast = "Signature Espresso Roast" ;
            StringBuilder sb = new StringBuilder();
            sb.append(Roast);
            boolean passShots = false;

            //loop shots menu
            do {
                System.out.println("type the shots (1 ~ 9 shots)");
                int shots = scanner.nextInt();

                if(shots < 1 || shots > 9){
                    System.out.println("type the wrong number");
                    passShots = true;
                }

                // 1~3 shots
                else if(shots >= 1 && shots <=3){
                    String Shot = Integer.toString(shots);
                    sb.append(Shot);
                    result = sb.toString();
                }

                //4~9 shots
                else if(shots >= 4){
                    String Shot = Integer.toString(shots);
                    sb.append(Shot);
                    result = sb.toString();
                }

            }while(passShots);

        }

        //Blonde Espresso Roast
        else if(ChooseRoast ==2){

            String Roast = "Blonde Espresso Roast" ;
            StringBuilder sb = new StringBuilder();
            sb.append(Roast);
            boolean passShots = false;

            //loop shots menu
            do {
                System.out.println("type the shots (1 ~ 9 shots)");
                int shots = scanner.nextInt();

                if(shots < 1 || shots > 9){
                    System.out.println("type the wrong number");
                    passShots = true;
                }

                // 1~3 shots
                else if(shots >= 1 && shots <= 3){
                    String Shot = Integer.toString(shots);
                    sb.append(Shot);
                    result = sb.toString();
                }

                //4~9 shots
                else if(shots >= 4){
                    String Shot = Integer.toString(shots);
                    sb.append(Shot);
                    result = sb.toString();
                }

            }while(passShots);
        }

        //
        else if(ChooseRoast ==3){
            String Roast = "Decaf Espresso Roast" ;
            StringBuilder sb = new StringBuilder();
            sb.append(Roast);
            boolean passShots = false;

            //loop shots menu
            do {
                System.out.println("type the shots (1 ~ 9 shots)");
                int shots = scanner.nextInt();

                if(shots < 1 || shots > 9){
                    System.out.println("type the wrong number");
                    passShots = true;
                }

                // 1~3 shots
                else if(shots >= 1 && shots <=3){
                    String Shot = Integer.toString(shots);
                    sb.append(Shot);
                    result = sb.toString();
                }

                //4~9 shots
                else if(shots >= 4){
                    String Shot = Integer.toString(shots);
                    sb.append(Shot);
                    result = sb.toString();
                }

            }while(passShots);
        }


        return result;

    }
}
