package com.example.warshipsfight.services;

import com.example.warshipsfight.models.Ship;
import com.example.warshipsfight.models.dtos.StartBattleDTO;
import com.example.warshipsfight.repositories.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {

    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public  void  attack(StartBattleDTO attackData){
        Optional<Ship> attackerOpt = this.shipRepository.findById((long) attackData.getAttackerId());
       Optional<Ship>defenderOpt= this.shipRepository.findById((long) attackData.getDefenderId());

       if (attackerOpt.isEmpty() || defenderOpt.isEmpty()){
           throw new NoSuchElementException();
       }

       Ship attacker = attackerOpt.get();
       Ship defender = defenderOpt.get();

long newDefenderHealth = defender.getHealth()- attacker.getPower();
if (newDefenderHealth<=0){
    this.shipRepository.delete(defender);
}else {
    defender.setHealth(newDefenderHealth) ;
    this.shipRepository.save(defender);

}


    }
}
