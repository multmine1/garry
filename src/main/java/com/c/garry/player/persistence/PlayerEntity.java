/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.persistence;

import com.c.garry.common.persistence.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.c.garry.catalog.persistence.PositionEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 *
 * @author avs
 */
@Entity
@Table(name = "players")
public class PlayerEntity extends BaseEntity {

    @OneToMany(
        mappedBy = "player_",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<PlayerRoleEntity> roles_ = new ArrayList<>();
    
    @Column(name = "name", nullable = false, length = 100)
    private String name_;

    @Column(name = "health_rating", nullable = false)
    private int health_rating_;

    protected PlayerEntity() {
    }

    public PlayerEntity(String name, int health_rating) {
        name_ = validate_name(name);
        health_rating_ = validate_health_rating(health_rating);
    }

    public String getName() {
        return name_;
    }

    public int getHealthRating() {
        return health_rating_;
    }

    public void setName(String name) {
        name_ = validate_name(name);
    }

    public void setHealthRating(int rating) {
        health_rating_ = validate_health_rating(rating);
    }

    private static String validate_name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid player name");
        }

        String value = name.trim();

        if (value.length() > 100) {
            throw new IllegalArgumentException("Player name is too long");
        }

        return value;
    }

    private static int validate_health_rating(int rating) {
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException("Invalid health rating");
        }

        return rating;
    }
    
    public List<PlayerRoleEntity> getRoles() {
        return List.copyOf(roles_);
    }

    public void addRole(PositionEntity position, int rating) {
        if (position == null || position.getId() == null) {
            throw new IllegalArgumentException(
                    "Position must exist in database"
            );
        }

        UUID role_id = position.getId();

        boolean exists = roles_.stream()
                .anyMatch(role ->
                        role.getPosition().getId().equals(role_id)
                );

        if (exists) {
            throw new IllegalArgumentException(
                    "Role already assigned"
            );
        }

        roles_.add(new PlayerRoleEntity(this, position, rating));
    }

    public void removeRole(UUID role_id) {
        boolean removed = roles_.removeIf(
                role -> role.getPosition().getId().equals(role_id)
        );

        if (!removed) {
            throw new IllegalArgumentException("Role not found");
        }
    }
}