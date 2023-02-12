import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello " + name;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "Today is " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        return conversation;
    }
    public String respondBeforeAlexis(String conversation, String name) {
        // YOUR CODE HERE
        return name + conversation;
    }

    public String goodMorning(String breakfast, String name){
        Date date = new Date();
        return breakfast + "Today is " + date + "You are supposed to meet with " + name;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

