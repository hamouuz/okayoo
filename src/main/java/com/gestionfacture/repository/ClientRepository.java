package com.gestionfacture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionfacture.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
