package com.example.dto_game_store.model.dto;

import java.math.BigDecimal;

public class GameShowDto {

    private String title;
    private BigDecimal price;

    public GameShowDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
