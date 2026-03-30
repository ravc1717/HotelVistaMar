package com.hotel.vistamar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hotel.vistamar.model.Habitacion;
import com.hotel.vistamar.service.HabitacionService;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("habitaciones", habitacionService.listarHabitaciones());
        return "habitaciones/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Habitacion habitacion) {
        return "habitaciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Habitacion habitacion) {
        habitacionService.guardar(habitacion);
        return "redirect:/habitaciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Habitacion habitacion = habitacionService.obtenerPorId(id).orElseThrow();
        model.addAttribute("habitacion", habitacion);
        return "habitaciones/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        habitacionService.eliminar(id);
        return "redirect:/habitaciones";
    }
}