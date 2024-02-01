package com.example.warshipsfight.controllers;

import com.example.warshipsfight.models.dtos.StartBattleDTO;
import com.example.warshipsfight.services.BattleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {

    private BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
public String battle(@Valid StartBattleDTO startBattleDTO,
                     BindingResult bindingResult,
                     RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors() ){
            redirectAttributes.addFlashAttribute("startBattleDTO",startBattleDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.startBattleDTO.createShipDTO"
                    , bindingResult);

            return "redirect:/home";
        }

this.battleService.attack(startBattleDTO);
        return  "redirect:/home";
}

}
