package com.iconos.taller;

import com.ens.user.userprotocol.UserEntity;
import com.ens.user.userrest.UserRestClient;
import com.iconos.taller.entidades.Modelo;
import com.iconos.taller.entidades.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Controlador {

    private final Repositorio repo;

    private final UserRestClient userRestClient;// = feign

    @GetMapping
    public List<UserEntity> holaMundo() {

//        List<UserEntity> users = userRestClient.readAll();

        return userRestClient.readAll();
    }


    @GetMapping("/{id}/usuarios")
    public List<Usuario> obtenerUsuarios(@PathVariable("id") String id) {
        Modelo m = repo.findOne(id);

        return m.getUsuarios();
    }

    @GetMapping("/{id}")
    public Modelo obtenerUno(@PathVariable("id") String id) {
        return repo.findOne(id);
    }

    @PutMapping("/{id}")
    public Modelo editarModelo(@PathVariable("id") String id, @RequestBody Modelo modelo) {

//        Modelo m = repo.findOne(id);
//
//        if (m == null) {
//            throw
//        }

        return repo.save(modelo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Modelo nuevoModelo(@RequestBody Modelo modelo) {
        return repo.save(modelo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus
    public void eliminarModelo(@PathVariable("id") String id) {
        repo.delete(id);
    }
}
