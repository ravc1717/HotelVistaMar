package com.hotel.vistamar.service;

import org.springframework.stereotype.Service;
import com.hotel.vistamar.repository.HabitacionRepository;
import com.hotel.vistamar.model.Habitacion;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<Habitacion> listarHabitaciones() {
        return habitacionRepository.findAll();
    }

    public Optional<Habitacion> obtenerPorId(Integer id) {
        return habitacionRepository.findById(id);
    }

    public Habitacion guardar(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    public void eliminar(Integer id) {
        habitacionRepository.deleteById(id);
    }
}