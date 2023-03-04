package com.codingdojo.fruityloops;

//need to import arrayList in order to use it
import java.util.ArrayList;

//imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller
@Controller
public class ItemController {
    
	//Mapping
    @RequestMapping("/")
    public String index(Model model) {
        
    	//Creating an arrayList of fruits
        ArrayList<ItemModel> fruits = new ArrayList<ItemModel>();
        fruits.add(new ItemModel("Kiwi", 1.5));
        fruits.add(new ItemModel("Mango", 2.0));
        fruits.add(new ItemModel("Goji Berries", 4.0));
        fruits.add(new ItemModel("Guava", .75));
        
        // Adding fruit attributes to model
        model.addAttribute("fruits", fruits );
        
        //returning index.jsp file
        return "index.jsp";
    }
}

