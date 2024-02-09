package com.example.warshipsfight.controllers;

import com.example.warshipsfight.models.dtos.CreateShipDTO;
import com.example.warshipsfight.services.AuthService;
import com.example.warshipsfight.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {

    private final ShipService shipService;
    private final AuthService authService;

    public ShipController(ShipService shipService, AuthService authService) {
        this.shipService = shipService;
        this.authService = authService;
    }

    @ModelAttribute("CreateShipDTO")
    public CreateShipDTO initCreateShipDTO(){
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String ships(){
        if (!this.authService.isLoggedIn()){
            return "redirect:/";
        }
        return "ship-add";
    }
    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDTO createShipDTO,
                  BindingResult bindingResult,
                  RedirectAttributes redirectAttributes){

        if (!this.authService.isLoggedIn()){
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.shipService.created(createShipDTO)){
            redirectAttributes.addFlashAttribute("createShipDTO",createShipDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.createShipDTO"
                    , bindingResult);

            return "redirect:/ships/add";
        }
        return "redirect:/home";
    }

}
