package com.example.advquerying.repositories;

import com.example.advquerying.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository <EntityType extends BaseEntity> extends JpaRepository<EntityType, Long> {

}
