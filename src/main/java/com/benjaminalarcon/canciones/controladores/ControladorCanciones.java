package com.benjaminalarcon.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.benjaminalarcon.canciones.modelos.Canciones;
import com.benjaminalarcon.canciones.repositorios.RepositorioCanciones;
import com.benjaminalarcon.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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
    
    @GetMapping("/canciones/formulario/agregar/{id}")
    public String formularioAgregarCancion(@ModelAttribute("Cancion") Canciones Cancion, @PathVariable Long id, Model modelo){
        Canciones cancionA = servicioCanciones.obtenerCancionesporId(id);
        modelo.addAttribute("cancion", cancionA);
        return "agregarCancion";
    }
    
    @PostMapping("/canciones/procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute("Cancion") Canciones Cancion, BindingResult validaciones){
        if(validaciones.hasErrors()){
            return "agregarCancion";
        }
        this.servicioCanciones.agregarCancion(Cancion);
        return "redirect:/canciones";

    }
}
