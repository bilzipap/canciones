package com.benjaminalarcon.canciones.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.benjaminalarcon.canciones.modelos.Canciones;

@Repository
public interface RepositorioCanciones extends CrudRepository<Canciones, Long>{
   /*
    * SELECT *
    * FROM canciones;
    */
   
    List<Canciones> findAll();

    /*
     * INSERT INTO canciones()
     * VALUES();
     * 
     * UPDATE canciones
     * SET cancion
     * WHERE id
     */
    Canciones save(Canciones Cancion);
}
