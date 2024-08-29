package com.example.demoJava.dto;

import java.util.List;

public class CategoryDTO {
    private int id;
    private String name;
    private List<MenuDTO> menus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MenuDTO> getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }

    public void setMenus(List<MenuDTO> menus) {
        this.menus = menus;
    }

    public void setName(String name) {
        this.name = name;
    }
}
