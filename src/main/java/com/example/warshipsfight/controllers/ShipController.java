package com.example.warshipsfight.controllers;

import com.example.warshipsfight.models.dtos.CreateShipDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    @ModelAttribute("CreateShipDTO")
    public CreateShipDTO initCreateShipDTO(){
        return new CreateShipDTO();
    }

    @GetMapping("/ships")
    public String ships(){
        return "ship-add";
    }
    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDTO createShipDTO,
                  BindingResult bindingResult,
                  RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("createShipDTO",createShipDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createShipDTO"
                    , bindingResult);

            return "redirect:/ships/add";
        }
        return "redirect:/home";
    }

}
