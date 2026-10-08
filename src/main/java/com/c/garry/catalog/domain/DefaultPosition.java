/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.domain;

import java.util.Objects;
import java.util.UUID;
/**
 *
 * @author avs
 */
public final class DefaultPosition implements Position {

    private final UUID id_;
    private String name_;

    public DefaultPosition(UUID id, String name) {
        id_ = Objects.requireNonNull(id);
        setName(name);
    }

    @Override
    public UUID getId() {
        return id_;
    }

    @Override
    public String getName() {
        return name_;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid position name");
        }

        String value = name.trim();

        if (value.length() > 100) {
            throw new IllegalArgumentException("Position name is too long");
        }

        name_ = value;
    }
}