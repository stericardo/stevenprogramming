package com.stevenprogramming.spring.boot.react.repository;

import com.stevenprogramming.spring.boot.react.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
