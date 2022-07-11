package se.lexicon.mvcexercise.controllers;

import com.sun.org.apache.xml.internal.resolver.CatalogEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    List<String> contactViewList = new ArrayList<>();

    @GetMapping("/index")
    public String index() {
        System.out.println("Index method has been executed.");
        return "index";
    }


    @GetMapping("/contact")
    public String displayContactForm() {
        System.out.println("Contact method executed.");
        //model.addAttribute("contact", contact)
        return "contact";
    }
    //todo: see below
    @PostMapping("/contact")
    public String contact(@RequestParam String contact) {
        System.out.println("Contact method executed.");
        //todo: add contact value to list
        contactViewList.add(contact);
        System.out.println("contact:" + contact);
        return "contact";
    }

    @GetMapping("/contactList")
    public String showAllData(Model model) {
        System.out.println(contactViewList);
        model.addAttribute("contactList", contactViewList);
        return "contactList";

    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        System.out.println("About method has been executed");
        return "about";
    }

}
