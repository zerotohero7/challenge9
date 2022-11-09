package com.example.challenge9.Repositories;

import com.example.challenge9.Entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegisterRepository extends JpaRepository<Register , Integer> {

    Register findByEmail(String email);
}
