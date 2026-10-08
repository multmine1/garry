/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.domain;

import com.c.garry.common.domain.Identifiable;

import java.util.List;
import java.util.UUID;
/**
 *
 * @author avs
 */
public interface Player
        extends Identifiable<UUID>, HealthRatingProvider {

    String getName();

    List<RoleRatingProvider> getRoles();

    List<HealthRecord> getHealthRecords();
    
    void addHealthRecord(HealthRecord record);

    void updateHealthRecord(HealthRecord record);

    void removeHealthRecord(UUID record_id);
    
    void setName(String name);

    void setHealthRating(int rating);

    void addRole(RoleRatingProvider role);

    void updateRole(RoleRatingProvider role);

    void removeRole(UUID role_id);
}
