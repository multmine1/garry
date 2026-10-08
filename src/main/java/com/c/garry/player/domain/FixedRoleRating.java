/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.c.garry.player.domain;

import java.util.Objects;

/**
 *
 * @author avs
 */
public record FixedRoleRating(
        RoleRating value
) implements RoleRatingProvider {

    public FixedRoleRating {
        Objects.requireNonNull(value);
    }

    @Override
    public RoleRating getRating() {
        return value;
    }

}