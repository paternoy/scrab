package com.coopnex.scrab.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coopnex.scrab.data.entity.AbstractEntity;

public interface AbstractRepository<T extends AbstractEntity<PK>, PK extends Serializable> extends JpaRepository<T, PK> {

}
