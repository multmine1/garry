/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.common.persistence;

import com.c.garry.common.domain.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
/**
 *
 * @author avs
 */
@MappedSuperclass
public abstract class BaseEntity implements AuditableEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id_;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant created_at_;

    @UpdateTimestamp
    @Column(name = "last_updete_at", nullable = false)
    private Instant last_updete_at_;

    @Override
    public UUID getId() {
        return id_;
    }

    @Override
    public Instant getCreatedAt() {
        return created_at_;
    }

    @Override
    public Instant getLastUpdeteAt() {
        return last_updete_at_;
    }
}
