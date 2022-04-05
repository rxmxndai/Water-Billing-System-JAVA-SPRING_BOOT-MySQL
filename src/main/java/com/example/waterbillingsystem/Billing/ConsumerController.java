package com.example.waterbillingsystem.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class ConsumerController {

    static ArrayList<String> provinceList = new ArrayList<String>();
    static  {
        provinceList.add("Kathmandu Kshetra");
        provinceList.add("Arun Kshetra");
        provinceList.add("Janakpur Kshetra");
        provinceList.add("Gandak Kshetra");
        provinceList.add("Karnali Kshetra");
        provinceList.add("Kapilavastu Kshetra");
        provinceList.add("Mahakali Kshetra");
    }



    @Autowired private ConsumerService service;

    @GetMapping("/consumer/details")
    public String showConsumerList(Model model) {

        List<Consumer> consumerList = service.listAll();
        model.addAttribute("consumerList", consumerList);

        return "ConsumerDetails";
    }

    @GetMapping("/consumer/newform")
    public String showConsumerForm(Model model) {
        model.addAttribute("consumer", new Consumer());
        model.addAttribute("provinceList", provinceList);
        model.addAttribute("pageTitle", "Add new Consumer Details");
        return "consumerForm";
    }

    @PostMapping("/consumer/save")

    public String saveConsumer (Consumer consumer, RedirectAttributes rr) {

        service.save(consumer);

        rr.addFlashAttribute("message", "Consumer details saved Successfully");

        return  "redirect:/consumer/details";
    }

    @GetMapping("/consumer/edit/{id}")
    public String showEditConsumerForm(@PathVariable("id") Integer id, Model model, RedirectAttributes rr) {
        try {
            Consumer consumer = service.get(id);
            model.addAttribute("consumer", consumer);
            model.addAttribute("pageTitle", "Edit Consumer (ID: " + id + ")");
            return "consumerForm";
        } catch (ConsumerNotFoundException e) {
            rr.addFlashAttribute("message", e.getMessage());
            return "redirect:/consumer/details";
        }

    }


    @GetMapping("/consumer/remove/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes rr) {

        try {
            service.delete(id);
            rr.addFlashAttribute("message", "User id: " +  id + " Successfully Deleted");
        } catch (ConsumerNotFoundException e) {
            rr.addFlashAttribute("message", e.getMessage());
        }

        return  "redirect:/consumer/details";
    }


}
