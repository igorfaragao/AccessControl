package com.dio.AccessControl.Controller;


import com.dio.AccessControl.Service.CategoriaUsuarioService;
import com.dio.AccessControl.Service.EmpresaService;
import com.dio.AccessControl.model.CategoriaUsuario;
import com.dio.AccessControl.model.Empresa;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioController {


    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @ApiOperation("Criando Nova Categoria de Usuario")
    @PostMapping
    public CategoriaUsuario createCategoriaUsuario(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.saveCategoriaUsuario(categoriaUsuario);
    }
    @ApiOperation("Lista todas as Categorias de Usuario criadas")
    @GetMapping
    public List<CategoriaUsuario> getCategoriaUsuarioList() {
        return categoriaUsuarioService.findAll();

    }
    @ApiOperation("Busca Categoria de Usuario pelo ID")
    @GetMapping("/{idCategoriaUsuario}")
    public ResponseEntity<CategoriaUsuario> getCategoriaUsuarioById(@PathVariable("idCategoriaUsuario")Long idCategoriaUsuario) throws Exception {

        return ResponseEntity.ok(categoriaUsuarioService.getById(idCategoriaUsuario).orElseThrow(()-> new Exception("Categoria de Usuario Não Encontrada")));

    }
    @ApiOperation("Atualiza a Categoria")
    @PutMapping
    public CategoriaUsuario updateCategoria(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.updateCategoriaUsuario(categoriaUsuario);
    }
    @ApiOperation("Deleta Categoria de Usuario")
    @DeleteMapping(value = "/{idCategoriaUsuario}")
    public ResponseEntity deleteByID(@PathVariable("idCategoriaUsuario")Long idCategoriaUsuario) throws Exception {

        return  categoriaUsuarioService.deleteCategoriaUsuario(idCategoriaUsuario);

    }


}
