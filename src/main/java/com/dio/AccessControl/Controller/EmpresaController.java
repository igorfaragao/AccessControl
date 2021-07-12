package com.dio.AccessControl.Controller;


import com.dio.AccessControl.Service.EmpresaService;
import com.dio.AccessControl.model.Empresa;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @ApiOperation("Criando Nova Empresa")
    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }
    @ApiOperation("Lista todas as Empresas criadas")
    @GetMapping
    public List<Empresa> getEmpresaList() {
        return empresaService.findAll();

    }
    @ApiOperation("Busca Empresa pelo ID")
    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("idEmpresa")Long idEmpresa) throws Exception {

        return ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(()-> new Exception("Empresa Não Encontrada")));

    }
    @ApiOperation("Atualiza a Empresa")
    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }
    @ApiOperation("Deleta Empresa")
    @DeleteMapping(value = "/{idEmpresa}")
    public ResponseEntity deleteByID(@PathVariable("idEmpresa")Long idEmpresa) throws Exception {

        return  empresaService.deleteEmpresa(idEmpresa);

    }





}
