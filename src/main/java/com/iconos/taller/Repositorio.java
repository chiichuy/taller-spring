package com.iconos.taller;

import com.iconos.taller.entidades.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio  extends JpaRepository<Modelo, String > {


//    @Override
//    @NamedQuery(query = "SELECT * from modelo")
//    @NamedNativeQuery(query = "select * from ckt_r399 where nombre=?1)")
//    List<Modelo> findAll(String param1);


//    List<Modelo> findTopByNombreIn(Collection<String> nombre);
}
