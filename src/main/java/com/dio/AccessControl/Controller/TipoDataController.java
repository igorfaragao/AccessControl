package com.dio.AccessControl.Controller;


import com.dio.AccessControl.Service.TipoDataService;
import com.dio.AccessControl.model.Empresa;
import com.dio.AccessControl.model.TipoData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tipoData")
public class TipoDataController {

    @Autowired
    TipoDataService tipoDataService;

    @ApiOperation("Criando Novo Tipo de Data")
    @PostMapping
    public TipoData createTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.saveTipoData(tipoData);
    }
    @ApiOperation("Lista todos os tipos de Data")
    @GetMapping
    public List<TipoData> getTipoDataList() {
        return tipoDataService.findAll();

    }
    @ApiOperation("Busca os Tipos de Data pelo ID")
    @GetMapping("/{idTipoData}")
    public ResponseEntity<TipoData> getTipoDataById(@PathVariable("idTipoData")Long idTipoData) throws Exception {

        return ResponseEntity.ok(tipoDataService.getById(idTipoData).orElseThrow(()-> new Exception("Tipo de Data Não Encontrada")));

    }
    @ApiOperation("Atualiza o Tipo de Data")
    @PutMapping
    public TipoData updateTipoData(@RequestBody TipoData tipoData){
        return tipoDataService.updateTipoData(tipoData);
    }
    @ApiOperation("Deleta o Tipo de Data")
    @DeleteMapping(value = "/{idTipoData}")
    public ResponseEntity deleteByID(@PathVariable("idTipoData")Long idTipoData) throws Exception {

        return  tipoDataService.deleteTipoData(idTipoData);

    }



}
