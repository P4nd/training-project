package com.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.management.entity.CargoEntity;

public interface CargoRepository extends JpaRepository<CargoEntity, Long> {}
