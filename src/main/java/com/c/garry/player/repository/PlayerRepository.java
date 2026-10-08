/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.player.repository;

import com.c.garry.player.domain.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 *
 * @author avs
 */
public interface PlayerRepository {

    Player create(String name, int health_rating);

    Player update(Player player);

    Optional<Player> find_by_id(UUID id);

    List<Player> find_all();

    void delete_by_id(UUID id);
}