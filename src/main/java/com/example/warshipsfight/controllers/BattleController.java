package com.example.warshipsfight.controllers;

import com.example.warshipsfight.models.dtos.StartBattleDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BattleController {

    @PostMapping("/battle")
public String battle(@Valid StartBattleDTO startBattleDTO){
        System.out.println(startBattleDTO.getAttackerId() +
                " " + startBattleDTO.getDefenderId());

        return  "redirect:/home";
}

}
