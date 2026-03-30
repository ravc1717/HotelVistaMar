package com.hotel.vistamar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hotel.vistamar.model.Reserva;
import com.hotel.vistamar.model.Habitacion;
import com.hotel.vistamar.model.Usuario;
import com.hotel.vistamar.service.ReservaService;
import com.hotel.vistamar.service.HabitacionService;
import com.hotel.vistamar.service.UsuarioService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final HabitacionService habitacionService;
    private final UsuarioService usuarioService;

    public ReservaController(ReservaService reservaService, HabitacionService habitacionService, UsuarioService usuarioService) {
        this.reservaService = reservaService;
        this.habitacionService = habitacionService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarReservas());
        return "reservas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Reserva reserva, Model model) {
        model.addAttribute("habitaciones", habitacionService.listarHabitaciones());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "reservas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Reserva reserva = reservaService.obtenerPorId(id).orElseThrow();
        model.addAttribute("reserva", reserva);
        model.addAttribute("habitaciones", habitacionService.listarHabitaciones());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "reservas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}