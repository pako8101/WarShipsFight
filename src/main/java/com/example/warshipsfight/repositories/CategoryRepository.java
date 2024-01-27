package com.example.warshipsfight.repositories;

import com.example.warshipsfight.models.Category;
import com.example.warshipsfight.models.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(ShipType name);
}
