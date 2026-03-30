package com.hotel.vistamar.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Float total;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public LocalDate getFecha_inicio() { return fecha_inicio; }
    public void setFecha_inicio(LocalDate fecha_inicio) { this.fecha_inicio = fecha_inicio; }
    public LocalDate getFecha_fin() { return fecha_fin; }
    public void setFecha_fin(LocalDate fecha_fin) { this.fecha_fin = fecha_fin; }
    public Float getTotal() { return total; }
    public void setTotal(Float total) { this.total = total; }
}