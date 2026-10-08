/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;
/**
 *
 * @author avs
 */
public final class DefaultPlayer implements Player {

    private final UUID id_;
    private String name_;
    private int health_rating_;

    private final List<RoleRatingProvider> roles_ = new ArrayList<>();
    private final List<HealthRecord> health_records_ = new ArrayList<>();

    public DefaultPlayer(
            UUID id,
            String name,
            List<? extends RoleRatingProvider> roles,
            List<HealthRecord> health_records,
            int health_rating
    ) {
        id_ = Objects.requireNonNull(id);

        setName(name);
        setHealthRating(health_rating);

        Objects.requireNonNull(roles).forEach(this::addRole);
        Objects.requireNonNull(health_records)
                .forEach(this::addHealthRecord);
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
    public int getHealthRating() {
        return health_rating_;
    }

    @Override
    public List<RoleRatingProvider> getRoles() {
        return List.copyOf(roles_);
    }

    @Override
    public List<HealthRecord> getHealthRecords() {
        return List.copyOf(health_records_);
    }

    @Override
    public void setName(String name) {
        String value = Objects.requireNonNull(name).trim();

        if (value.isEmpty()) {
            throw new IllegalArgumentException("Empty player name");
        }

        name_ = value;
    }

    @Override
    public void setHealthRating(int rating) {
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException("Invalid health rating");
        }

        health_rating_ = rating;
    }

    @Override
    public void addRole(RoleRatingProvider role) {
        UUID role_id = Objects.requireNonNull(
                Objects.requireNonNull(role).getRating()
        ).roleId();

        boolean exists = roles_.stream()
                .anyMatch(r -> r.getRating().roleId().equals(role_id));

        if (exists) {
            throw new IllegalArgumentException("Role already exists");
        }

        roles_.add(role);
    }

    @Override
    public void updateRole(RoleRatingProvider role) {
        UUID role_id = Objects.requireNonNull(
                Objects.requireNonNull(role).getRating()
        ).roleId();

        for (int i = 0; i < roles_.size(); i++) {
            if (roles_.get(i).getRating().roleId().equals(role_id)) {
                roles_.set(i, role);
                return;
            }
        }

        throw new NoSuchElementException("Role not found");
    }

    @Override
    public void removeRole(UUID role_id) {
        Objects.requireNonNull(role_id);

        boolean removed = roles_.removeIf(
                role -> role.getRating().roleId().equals(role_id)
        );

        if (!removed) {
            throw new NoSuchElementException("Role not found");
        }
    }

    @Override
    public void addHealthRecord(HealthRecord record) {
        Objects.requireNonNull(record);

        boolean exists = health_records_.stream()
                .anyMatch(r -> r.id().equals(record.id()));

        if (exists) {
            throw new IllegalArgumentException(
                    "Health record already exists"
            );
        }

        health_records_.add(record);
    }
    
    @Override
    public void updateHealthRecord(HealthRecord record) {
        Objects.requireNonNull(record);

        for (int i = 0; i < health_records_.size(); i++) {
            if (health_records_.get(i).id().equals(record.id())) {
                health_records_.set(i, record);
                return;
            }
        }

        throw new NoSuchElementException("Health record not found");
    }

    @Override
    public void removeHealthRecord(UUID record_id) {
        Objects.requireNonNull(record_id);

        boolean removed = health_records_.removeIf(
                record -> record.id().equals(record_id)
        );

        if (!removed) {
            throw new NoSuchElementException("Health record not found");
        }
    }
}