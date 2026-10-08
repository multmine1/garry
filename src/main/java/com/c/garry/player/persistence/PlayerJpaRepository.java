/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.persistence;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author avs
 */
public interface PlayerJpaRepository
        extends JpaRepository<PlayerEntity, UUID> {
}