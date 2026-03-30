package com.hotel.vistamar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hotel.vistamar.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    // JpaRepository ya proporciona métodos CRUD: findAll, findById, save, deleteById, etc.
}