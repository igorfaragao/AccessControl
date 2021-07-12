package com.dio.AccessControl.Controller;



import com.dio.AccessControl.Service.OcorrenciaService;
import com.dio.AccessControl.model.Ocorrencia;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @ApiOperation("Criando Nova Ocorrência")
    @PostMapping
    public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia){

        return ocorrenciaService.saveOcorrencia(ocorrencia);
    }
    @ApiOperation("Lista todas as Ocorrencias criadas")
    @GetMapping
    public List<Ocorrencia> getOcorrenciaList() {
        return ocorrenciaService.findAll();

    }
    @ApiOperation("Busca Ocorrência pelo ID")
    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<Ocorrencia> getEmpresaById(@PathVariable("idOcorrencia")Long idOcorrencia) throws Exception {

        return ResponseEntity.ok(ocorrenciaService.getById(idOcorrencia).orElseThrow(()-> new Exception("Ocorrência Não Encontrada")));

    }
    @ApiOperation("Atualiza a Ocorrência")
    @PutMapping
    public Ocorrencia updateOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.updateOcorrencia(ocorrencia);
    }
    @ApiOperation("Deleta Ocorrência")
    @DeleteMapping(value = "/{idOcorrencia}")
    public ResponseEntity deleteByID(@PathVariable("idOcorrencia")Long idOcorrencia) throws Exception {

        return  ocorrenciaService.deleteOcorrencia(idOcorrencia);

    }


}
