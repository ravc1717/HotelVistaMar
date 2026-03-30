package com.hotel.vistamar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotel.vistamar.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Métodos CRUD listos
}
