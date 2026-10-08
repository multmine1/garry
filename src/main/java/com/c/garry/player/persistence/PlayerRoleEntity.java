/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.persistence;

import com.c.garry.catalog.persistence.PositionEntity;
import com.c.garry.common.persistence.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Objects;
/**
 *
 * @author avs
 */
@Entity
@Table(
        name = "player_role_ratings",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"player_id", "position_id"}
        )
)
public class PlayerRoleEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerEntity player_;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "position_id", nullable = false)
    private PositionEntity position_;

    @Column(name = "rating", nullable = false)
    private int rating_;

    protected PlayerRoleEntity() {
    }

    public PlayerRoleEntity(
            PlayerEntity player,
            PositionEntity position,
            int rating
    ) {
        player_ = Objects.requireNonNull(player);
        position_ = Objects.requireNonNull(position);
        rating_ = validate_rating(rating);
    }

    public PositionEntity getPosition() {
        return position_;
    }

    public int getRating() {
        return rating_;
    }

    public void setRating(int rating) {
        rating_ = validate_rating(rating);
    }

    private static int validate_rating(int rating) {
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 100"
            );
        }

        return rating;
    }
}
