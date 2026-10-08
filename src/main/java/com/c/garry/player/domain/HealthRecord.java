/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
/**
 *
 * @author avs
 */
public record HealthRecord(
        UUID id,
        HealthEventType type,
        LocalDate startDate,
        LocalDate endDate,
        String description
) {

    public HealthRecord {
        Objects.requireNonNull(id);
        Objects.requireNonNull(type);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(description);

        if (endDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException(
                    "End date cannot be before start date"
            );
        }
    }

    public boolean isActive(LocalDate date) {
        Objects.requireNonNull(date);

        return !date.isBefore(startDate)
                && (endDate == null || !date.isAfter(endDate));
    }
}