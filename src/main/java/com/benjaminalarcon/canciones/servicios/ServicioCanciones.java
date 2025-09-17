package com.benjaminalarcon.canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.benjaminalarcon.canciones.modelos.Canciones;
import com.benjaminalarcon.canciones.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    @Autowired
    private final RepositorioCanciones repositorioCanciones;

    public ServicioCanciones(RepositorioCanciones repositorioCanciones){
        this.repositorioCanciones = repositorioCanciones;
    }
    
    public List<Canciones> obtenerCanciones(){
        return this.repositorioCanciones.findAll();
    }

    public Canciones obtenerCancionesporId(Long id){
        return this.repositorioCanciones.findById(id).orElse(null);        
    }

    public Canciones agregarCancion(Canciones Cancion){
        return this.repositorioCanciones.save(Cancion);
    }
    
    public Canciones actualizarCancion(Canciones Cancion){
        return this.repositorioCanciones.save(Cancion);
    }
}
