/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.repository;

import com.c.garry.catalog.domain.Position;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 *
 * @author avs
 */

public interface PositionRepository {

    Position create(String name);

    Position update(Position position);

    Optional<Position> find_by_id(UUID id);

    List<Position> find_all();

    void delete_by_id(UUID id);
}