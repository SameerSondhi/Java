//METHODS GO IN THIS FILE
import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil{

    public int getStreakGoal(){
        int i=0;
        int sum=0;
        while(i<11){
            sum+=i;
            i++;
        }
        return sum;
    }

    public double getOrderTotal(double[]prices){
        double total = 0.0;
        for(int i =0; i<prices.length; i++){
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0; i<menuItems.size(); i++){
            System.out.println(i + ":" + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        while(customers.size()<4){
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(userName);
        }
        System.out.println(customers);
        }
}