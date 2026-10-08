/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.domain;

import com.c.garry.common.domain.Identifiable;

import java.util.UUID;
/**
 *
 * @author avs
 */
public interface Position extends Identifiable<UUID> {

    String getName();

    void setName(String name);
}