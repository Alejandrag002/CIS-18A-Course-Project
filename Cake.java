package cakepackage;

import java.text.DecimalFormat;
import java.time.LocalDateTime; // This will import the LocalDateTime class
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter; // This will import the DateTimeFormatter class
import java.util.Scanner;

class CakeOrder implements Order 
{
    CakeService cake[] = new CakeService[100];
    int serviceIndex = 0;
    CakeService extratoppings[] = new CakeService[100];
    int serviceIn = 0;

    String custName;
    String date;
    String month;
    double totCost;
    int year;
    int day;
    LocalTime midnight = LocalTime.MIDNIGHT;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a"); // this will format the date in month day year and the time
    int deliverydays = 7; // This will generate the number of days and the time slots available for delivery
    int bakerybegins = 11; // bakery opens at 11am
    int hoursOpened = 7; // shop is opened for 7 hours 
    int arrayTimeIndex = 0;
    String timeArray[] = new String[deliverydays * hoursOpened];

    CakeOrder() 
    { 
    	
    }

    void change(CakeOrder ob) 
    {

    }

    
    public String[] Dates() // this creates available delivery times for the next 7 days from 11am - 6pm
    { 
        for (int i = 1; i <= deliverydays; i++) // this is was the death of meeeee lol!
        {

            LocalDate today = LocalDate.now(ZoneId.of("America/Los_Angeles"));
            LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
            LocalDateTime tomorrowMidnight = todayMidnight.plusDays(i);

           for (int h = bakerybegins; h <= bakerybegins + hoursOpened - 1; h++) 
           {
                String formattedDate = tomorrowMidnight.plusHours(h).format(dateFormat);
                timeArray[arrayTimeIndex] = formattedDate; //
                arrayTimeIndex++;

           }
        }
       return this.timeArray; // returns time array to later ask user for delivery day
    }

	    public void printDates() 
	    {
	
	    }
	
	    public void addToppings(CakeService service) 
	    {
	    	
	        this.cake[serviceIndex] = service;
	        serviceIndex++;
	
	    }
	
	    public void addExtraToppings(CakeService service) 
	    {
	    	
	        this.extratoppings[serviceIn] = service;
	        serviceIn++;
	        
	    }
	
	    // add method return the cakes
	    public String getMonth() 
	    {
	    	
	        return this.month;
	        
	    }
	
	    public void setMonth(String month) 
	    {
	        this.month = month;
	    }
	
	    public int getDay() 
	    {
	    	
	        return this.day;
	        
	    }
	
	    public void setDay(int day) 
	    {
	    	
	        this.day = day;
	        
	    }
	
	    public String getDate() 
	    {
	    	
	        return this.date;
	        
	    }
	
	    public void setDate(String date) 
	    {
	    	
	        this.date = date;
	        
	    }
	
	    public String getCustName() 
	    {
	    	
	        return this.custName;
	        
	    }
	
	    public void setCustName(String customerName)
	    {
	    	
	        this.custName = customerName;
	        
	    }

    public double getTotCost() 
    {
        double total = 0;

        // loop all services
        for (int i = 0; i <= this.serviceIndex - 1; i++) 
        {
            total += this.cake[i].getCost();
        }

        for (int i = 0; i <= this.serviceIn - 1; i++) 
        {
            total += this.extratoppings[i].getCost();
        }

        // save the cost of each service to the total var +=

        return total;
    }

    public void setTotCost(double totalCost) 
    {
        this.totCost = totalCost;
    }

    
    // This will print the receipt the,order name, delivery date, cake selected, toppings selected, and the total of the order 
    public void printServices() 
    {
        final DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("\r\nHere is your receipt! Thank You!");

        System.out.println("............................................");
        System.out.println("    Ale's Cake Service \r\n");
        System.out.println("        Order for: " + this.custName);
        System.out.println("        Cake Delivery Date: " + this.getDate());
        
        for (int i = 0; i <= serviceIndex - 1; i++)
        {
        	
            System.out.println( "        Cake: " + this.cake[i].getName());
                   
        }
        
        for (int i = 0; i <= serviceIn - 1; i++) 
        {
        	
            System.out.println("        Toppings selected: " + this.extratoppings[i].getName());
            
        }
        
        System.out.println("        Today's Total: $" + df.format(this.getTotCost()) + "\r\n");
        System.out.println("   S.");

        String data = "\r\n..........................................\r\n";
        data += "Cake Delivery\r\n";
        data += "Cake for: " + this.custName + "\r\n" + "Cake Delivery: " + this.getDate() + "\r\n";
        
        for (int i = 0; i <= serviceIndex - 1; i++)
        {
        	
            data += "Cake: " + this.cake[i].getName() + "\r\n";
            
        }
        
        for (int i = 0; i <= serviceIn - 1; i++) 
        {
        	
            data += "Toppings selected: " + this.extratoppings[i].getName() + "\r\n";
            
        }
        
        data += "Your Total: " + df.format(this.getTotCost());
        data += "\r\nThank you Ordering from Ale's Cake's.";
        
    }

}

/// class sets and gets name and cost of the cake order
class CakeService implements Service
{
	String name;
    double cost;
   
    CakeService(String name, double cost) 
    {
        this.setName(name);
        this.setCost(cost);
  
    }

    public double getCost()
    {
        return this.cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public String getName() 
    {
        return this.name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}


class cakes {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    CakeService cake[] = new CakeService[5];

    // for the any toppings
    CakeService extrastoppings[] = new CakeService[2];

    // constructor for cakes class
    cakes() 
    {
    	//types of cakes offered at bakery
        this.cake[0] = new CakeService("Single-Tier Cake (flavor and frosting  of choice!)", 30.00);
        
        this.cake[1] = new CakeService("Two-Tier Cake (flavor and frosting  of choice!)\"", 60.00);
        
        this.cake[2] = new CakeService("Beautiful Vanilla Rainbow Cake Covered in Sprinkles!", 50.00);
        
        this.cake[3] = new CakeService("Single-Tier Ice Cream Cake (Ice Cream made in-house!)", 40.00);
        
        this.cake[4] = new CakeService("4-Layer Cake (flavor and frosting  of choice!)", 35.00);
        
        // extra toppings available for an extra cost
        this.extrastoppings[0] = new CakeService("Tier", 15.00);
        this.extrastoppings[1] = new CakeService("Decorations", 10.00);

        this.startOrder();

    }

    public void showCakes() //prints out all available options and extra toppings for customer as well as their price
    {
        for (int i = 0; i < this.cake.length; i++) 
        {
            // print option
            System.out.println("Option: " + i + " " + cake[i].getName() + "  $" + df.format(cake[i].getCost()));
        }
        
        System.out.println("\r\nAvailable Toppings:");// prints available toppings for customer
        
        for (int i = 0; i < this.extrastoppings.length; i++) // prints available toppings for customer as well as their price
        {
            // print option
            System.out.println(
                    "Option: " + i + " " + extrastoppings[i].getName() + "    $" + df.format(extrastoppings[i].getCost()));
        }

        // gets users input
        System.out.println("\r\nPlease select a Cake: ");
    }

    public void showExtraToppings() 
    {
        System.out.println("\r\nAvailable Toppings:");
        for (int i = 0; i < this.extrastoppings.length; i++) 
        {
            // print option
            System.out.println(
                    "Option: " + i + " " + extrastoppings[i].getName() + "    $" + df.format(extrastoppings[i].getCost()));
        }
        System.out.println("\r\nPlease select and an extra topping: ");
    }

    public void startOrder() 
    {
        
        // ask user which cake - loop through cakes
        CakeOrder order = new CakeOrder();

        System.out.println("\r\n** Hey, Hi, Hello Welcome to Ale's Cakes! ** ");
        System.out.println("\r\n** We are open everyday from MONDAY - FRIDAY from 11:00 AM to 6:00 PM **\r\n");

        System.out.println("Here are the Cakes we offer: ");

        showCakes();
        // Construct Scanner object from System.in
        Scanner sc = new Scanner(System.in);
        
        int option = Integer.parseInt(sc.nextLine());

        // check if user cake option input is svalid
        if (option < 0 || option > 4) // if option is less than 0 or grater than 5 (it does not exist)
        {
            do {

                System.out.println("\r\n" + option + " sorry this is not a valid option. Please select from the following: ");
                
                showCakes();
                
                option = Integer.parseInt(sc.nextLine());

                // prints options
              } 
            
            while (option < 0 || option > 4); //option should be between 0 and 5 (meaning it does exist and input is valid)
            {
            	
            	System.out.println("You selected Cake: " + option);
            }

        }
        
        // this is adding a valid topping to the cake
        order.addToppings(cake[option]);

        System.out.println("\r\nWould you like any Toppings? (Yes or No)");
        
        String topping = sc.nextLine();
        
        if (topping.equals("Yes")) //id customer inputs "Yes" topping options show
        {
            showExtraToppings();
         
            int toppingOption = Integer.parseInt(sc.nextLine());

            // check if the topping option is valid
            if (toppingOption == 0 || toppingOption == 1) // only two options of toppings 
            {
                switch (toppingOption) //switch statement slayyyy
                {

                    // if users chooses topping 0, print out the choosen topping
                    case 0:
                        System.out.println();
                        System.out.println("Topping of Choice: Tier ");

                        break;

                    // if user chooses topping 1, print out the choosen topping
                    case 1:
                        System.out.println();
                        System.out.println("Topping of Choice: Decorations");

                }

                // any other input is will be invalid bc there are only 2 topping options
            } 
            
            else 
            {
            
                // print out topping options until valid input
                do 
                {
                	// prints if user input is invalid
                    System.out.println("\r\n" + toppingOption + " sorry this is not a valid option. Please select from the following: ");
                            
                    showExtraToppings(); //displays available toppings again
                    
                    toppingOption = Integer.parseInt(sc.nextLine());

                    // print topping
                } 
                
                while (toppingOption < 0 || toppingOption > 1);

            }
            
            order.addExtraToppings(extrastoppings[toppingOption]);

            
        } 
        
        // if the customer does not want an toppings
        else if (topping.equals("No")) 
        {
        	
            System.out.println("No Toppings selected.");

            
        }
        
         // if user does not enter yes or no, it will prompt user to correct input
        else 
        {
        	
            System.out.println("Sorry invalid answer, please type Yes to select an Toppings or No for no Toppings.");
            topping = sc.nextLine();
            
        }

        // Instance of class starOrder

        sc.reset();
        
        // Get the customer name for their order
        System.out.println("\r\nName for Cake Order: ");
        
        String customerName = sc.nextLine();
        
        order.setCustName(customerName);
        
        // date   // thank you google for helping me out hahahaha
        String[] dateOptions = order.Dates(); // this generates the dates and fills in local string array of dates
        System.out.println("Select a Delivery date shown below: ");
        
        for (int dateIndex = 0; dateIndex < dateOptions.length; dateIndex++) 
        {
            System.out.println(dateIndex + ") " + dateOptions[dateIndex]); // prints out all available options
        }
        
        int datePicked;
        
        do 
        {
            datePicked = Integer.parseInt(sc.nextLine());
        }
        
        while (datePicked > dateOptions.length || datePicked < 0);
        

        order.setDate(dateOptions[datePicked]);
        // end of new date code
       

        order.printServices();

    }// end of startOrder

}// end of cakes class

class Main 
{
    public static void main(String[] args) 
    {
        cakes testService = new cakes();

    }
}
