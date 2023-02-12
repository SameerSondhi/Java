public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 1.5;
        double lattePrice = 2.5;
        double cappuccinoPrice = 2.8;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

    
        // APP INTERACTION SIMULATION
        //Order status for Cindhuri
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer1 + pendingMessage);
        
        //Order status for Noah
        System.out.println(isReadyOrder4 ? customer4 + readyMessage : customer4 + pendingMessage);
        System.out.println(isReadyOrder4 ? displayTotalMessage + cappuccinoPrice : customer4 + pendingMessage);

        //Order status for Sam
        System.out.println(generalGreeting + customer2);
        System.out.println(displayTotalMessage + (cappuccinoPrice*2));
        System.out.println(isReadyOrder2 ? readyMessage : customer2 + pendingMessage);

        //Order status for Jimmy
        System.out.println(generalGreeting + customer3);
        System.out.println(displayTotalMessage + (lattePrice-dripCoffeePrice));


        
    }
}
