package com.example.warshipsfight.models.dtos;

import com.example.warshipsfight.models.ShipType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CreateShipDTO {
    @NotBlank
    @Size(min = 2,max = 10)
    private String name;
    @Positive
    private long power;
    @Positive
    private long health;
    @PastOrPresent
    private LocalDate created;
    @NotNull
    private ShipType category;

    public CreateShipDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public ShipType getCategory() {
        return category;
    }

    public void setCategory(ShipType category) {
        this.category = category;
    }
}
