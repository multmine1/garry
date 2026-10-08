/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.persistence;

/**
 *
 * @author avs
 */
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionJpaRepository
        extends JpaRepository<PositionEntity, UUID> {
}