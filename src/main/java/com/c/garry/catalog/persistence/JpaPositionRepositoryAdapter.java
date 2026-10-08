/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.c.garry.catalog.persistence;

import com.c.garry.catalog.domain.Position;
import com.c.garry.catalog.repository.PositionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author avs
 */
@Repository
@Transactional(readOnly = true)
public class JpaPositionRepositoryAdapter
        implements PositionRepository {

    private final PositionJpaRepository jpa_repository_;
    private final PositionMapper mapper_;

    public JpaPositionRepositoryAdapter(
            PositionJpaRepository jpa_repository,
            PositionMapper mapper
    ) {
        jpa_repository_ = jpa_repository;
        mapper_ = mapper;
    }

    @Override
    @Transactional
    public Position create(String name) {
        PositionEntity entity = new PositionEntity(name);

        return mapper_.to_domain(
                jpa_repository_.save(entity)
        );
    }

    @Override
    @Transactional
    public Position update(Position position) {
        Objects.requireNonNull(position);

        PositionEntity entity = jpa_repository_
                .findById(position.getId())
                .orElseThrow(() ->
                        new NoSuchElementException("Position not found")
                );

        mapper_.update_entity(position, entity);

        return mapper_.to_domain(
                jpa_repository_.save(entity)
        );
    }

    @Override
    public Optional<Position> find_by_id(UUID id) {
        return jpa_repository_
                .findById(id)
                .map(mapper_::to_domain);
    }

    @Override
    public List<Position> find_all() {
        return jpa_repository_
                .findAll()
                .stream()
                .map(mapper_::to_domain)
                .toList();
    }

    @Override
    @Transactional
    public void delete_by_id(UUID id) {
        if (!jpa_repository_.existsById(id)) {
            throw new NoSuchElementException("Position not found");
        }

        jpa_repository_.deleteById(id);
    }
}