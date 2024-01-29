package com.example.warshipsfight.repositories;

import com.example.warshipsfight.models.Ship;
import com.example.warshipsfight.models.User;
import com.example.warshipsfight.models.dtos.ShipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

    Optional<Ship> findByName(String name);

    List<Ship> findByUserId(long ownerId);
}
