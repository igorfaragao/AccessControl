package com.dio.AccessControl.Controller;


import com.dio.AccessControl.Service.UsuarioService;
import com.dio.AccessControl.model.Empresa;
import com.dio.AccessControl.model.Usuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @ApiOperation("Cadastrando Novo Usuario")
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }
    @ApiOperation("Lista todos Usuarios")
    @GetMapping
    public List<Usuario> getUsuarioList() {
        return usuarioService.findAll();

    }
    @ApiOperation("Buscando Usuario Pelo Id")
    @GetMapping("{/idUsuario}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario")Long idUsuario) throws Exception{

        return ResponseEntity.ok(usuarioService.getById(idUsuario).orElseThrow(()-> new Exception("Usuario Não Encontrado")));

    }

    @ApiOperation("Atualiza Usuario")
    @PutMapping
    public Usuario updateEmpresa(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }
    @ApiOperation("Deleta Usuario")
    @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity deleteByID(@PathVariable("idUsuario")Long idUsuario) throws Exception {

        return  usuarioService.deleteUsuario(idUsuario);

    }






}
