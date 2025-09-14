package com.benjaminalarcon.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.benjaminalarcon.canciones.modelos.Canciones;
import com.benjaminalarcon.canciones.repositorios.RepositorioCanciones;
import com.benjaminalarcon.canciones.servicios.ServicioCanciones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ControladorCanciones {

    private final RepositorioCanciones repositorioCanciones;
    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones (ServicioCanciones servicioCanciones, RepositorioCanciones repositorioCanciones){
        this.servicioCanciones = servicioCanciones;
        this.repositorioCanciones = repositorioCanciones;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo){
        List<Canciones> listaCanciones = this.servicioCanciones.obtenerCanciones();
        modelo.addAttribute("listaCanciones", listaCanciones);
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{id}")
    public String desplegarDetalleCancion(@PathVariable Long id, Model modelo) {
        Canciones cancionA = servicioCanciones.obtenerCancionesporId(id);
        modelo.addAttribute("cancion", cancionA);
        return "detalleCancion";
    }
    
    
}
