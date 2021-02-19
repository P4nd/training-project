package com.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.management.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{}
