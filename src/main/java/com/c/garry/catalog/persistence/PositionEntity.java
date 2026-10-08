/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.persistence;

import com.c.garry.common.persistence.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/**
 *
 * @author avs
 */
@Entity
@Table(name = "positions")
public class PositionEntity extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name_;

    protected PositionEntity() {
    }

    public PositionEntity(String name) {
        name_ = validate_name(name);
    }

    public String getName() {
        return name_;
    }

    public void setName(String name) {
        name_ = validate_name(name);
    }

    private static String validate_name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid position name");
        }

        String value = name.trim();

        if (value.length() > 100) {
            throw new IllegalArgumentException("Position name is too long");
        }

        return value;
    }
}