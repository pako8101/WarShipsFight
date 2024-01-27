package com.example.warshipsfight.services;

import com.example.warshipsfight.models.Category;
import com.example.warshipsfight.models.Ship;
import com.example.warshipsfight.models.ShipType;
import com.example.warshipsfight.models.User;
import com.example.warshipsfight.models.dtos.CreateShipDTO;
import com.example.warshipsfight.repositories.CategoryRepository;
import com.example.warshipsfight.repositories.ShipRepository;
import com.example.warshipsfight.repositories.UserRepository;
import com.example.warshipsfight.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {

    final private ShipRepository shipRepository;
    private final LoggedUser loggedUser;
    final private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    public ShipService(ShipRepository shipRepository, CategoryRepository categoryRepository,
                       LoggedUser loggedUser, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;

    }

    public boolean created(CreateShipDTO createShipDTO) {
        Optional<Ship> byName = this.shipRepository.findByName(createShipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

     ShipType type =  switch (createShipDTO.getCategory()){
            case 0 -> ShipType.BATTLE;
            case 1 -> ShipType.CARGO;
            case 2 -> ShipType.PATROL;
         default ->  ShipType.BATTLE;

        };
        Category category = this.categoryRepository.findByName(type);
        Optional<User> owner = this.userRepository.findById(this.loggedUser.getId());
        Ship ship = new Ship();
ship.setName(createShipDTO.getName());
ship.setPower(createShipDTO.getPower());
ship.setHealth(createShipDTO.getHealth());
ship.setCreated(createShipDTO.getCreated());
ship.setCategory(category);
ship.setUser(owner.get());

        this.shipRepository.save(ship);
        return true;
    }
}
