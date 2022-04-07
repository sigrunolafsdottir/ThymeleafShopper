package com.example.thymeleafshopper.shopping.controllers;


import com.example.thymeleafshopper.shopping.models.Kund;
import com.example.thymeleafshopper.shopping.repositories.KundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/kund")
public class KundController {

    @Autowired
    private KundRepository kundRepository;

    @RequestMapping( "/add")
    public @ResponseBody
    String addNewKund(@RequestParam String name, @RequestParam (required=false) String adress) {

        Kund n = new Kund();
        n.setName(name);
        n.setAdress(adress);
        kundRepository.save(n);
        return name + " is Saved";
    }

    @GetMapping("/addByView")
    public String formGreeting(Model model) {
        Kund kund = new Kund();
        model.addAttribute("kund", kund);
        return "addKundThymeLeaf";
    }

    @RequestMapping("/all")
    public String getAll(Model model) {
        Iterable<Kund> k = kundRepository.findAll();
        model.addAttribute("allCustomers", k);
        model.addAttribute("nameTitle", "Namn");
        model.addAttribute("addressTitle", "Address");
        model.addAttribute("customerTitle", "Alla kunder");
        return "allCustomerListing";
    }

    @RequestMapping("/allEdit")
    public String getAllEditDelete(Model model) {
        Iterable<Kund> k = kundRepository.findAll();
        model.addAttribute("allCustomers", k);
        model.addAttribute("nameTitle", "Namn");
        model.addAttribute("addressTitle", "Address");
        model.addAttribute("customerTitle", "Alla kunder");
        return "allKundListingEdit";
    }

    @RequestMapping("/allDelete")
    public String getAllDelete(Model model) {
        Iterable<Kund> k = kundRepository.findAll();
        model.addAttribute("allCustomers", k);
        model.addAttribute("nameTitle", "Namn");
        model.addAttribute("addressTitle", "Address");
        model.addAttribute("customerTitle", "Alla kunder");
        return "allKundListingDelete";
    }

    @GetMapping(path = "/getAllAfterAddByView")
    public String addNewKundByView(@RequestParam String name, @RequestParam String adress,
                                      Model model) {
        Kund n = new Kund();
        n.setName(name);
        n.setAdress(adress);
        kundRepository.save(n);
        return getAll(model);
    }

    @RequestMapping("/getById")
    public Kund getKundById(@RequestParam Long id) {
        return kundRepository.findById(id).get();
    }


    @RequestMapping(path = "/deleteById/{id}")
    public String deleteCap(@PathVariable Long id, Model model) {
        kundRepository.deleteById(id);
        return getAll(model);
    }

    @RequestMapping("/editByView/{id}")
    public String editByView(Model model, @PathVariable Long id) {
        Kund kund = kundRepository.findById(id).get();
        model.addAttribute("kund", kund);
        return "editKundThymeLeaf";
    }

    @PostMapping(path = "/update")
    public String editCap(@ModelAttribute Kund kund, Model model) {
        kundRepository.save(kund);
        return getAll(model);
    }
}
