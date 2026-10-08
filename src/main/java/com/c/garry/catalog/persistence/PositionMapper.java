/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.persistence;

import com.c.garry.catalog.domain.DefaultPosition;
import com.c.garry.catalog.domain.Position;

import org.springframework.stereotype.Component;
/**
 *
 * @author avs
 */
@Component
public class PositionMapper {

    public Position to_domain(PositionEntity entity) {
        return new DefaultPosition(
                entity.getId(),
                entity.getName()
        );
    }

    public void update_entity(
            Position position,
            PositionEntity entity
    ) {
        entity.setName(position.getName());
    }
}