/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.c.garry.common.domain;

import java.time.Instant;

/**
 *
 * @author avs
 */

public interface AuditableEntity<ID> extends Identifiable<ID> {

    Instant getCreatedAt();

    Instant getLastUpdeteAt();

}
