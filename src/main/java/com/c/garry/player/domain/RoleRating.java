/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.c.garry.player.domain;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author avs
 */
public record RoleRating(
        UUID roleId,
        int rating
) {

    public RoleRating {
        Objects.requireNonNull(roleId);

        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 100"
            );
        }
    }

}