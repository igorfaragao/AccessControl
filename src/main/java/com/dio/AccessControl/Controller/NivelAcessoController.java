package com.dio.AccessControl.Controller;



import com.dio.AccessControl.Service.NivelAcessoService;
import com.dio.AccessControl.model.NivelAcesso;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nivelAcesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService nivelAcessoService;

    @ApiOperation("Criando Nova Nivel de Acesso")
    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.saveNivelAcesso(nivelAcesso);
    }
    @ApiOperation("Lista todos os Níveis de acesso criado")
    @GetMapping
    public List<NivelAcesso> getNivelAcessoList() {
        return nivelAcessoService.findAll();

    }
    @ApiOperation("Busca Níveis de acesso pelo ID")
    @GetMapping("/{idNivelAcesso}")
    public ResponseEntity<NivelAcesso> getNivelAcessoById(@PathVariable("idNivelAcesso")Long idNivelAcesso) throws Exception {

        return ResponseEntity.ok(nivelAcessoService.getById(idNivelAcesso).orElseThrow(()-> new Exception("Nivel de Acesso Não Encontrada")));

    }
    @ApiOperation("Atualiza a Nivel de Acesso")
    @PutMapping
    public NivelAcesso updateNivelAcesso(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.updateNivelAcesso(nivelAcesso);
    }
    @ApiOperation("Deleta Nivel de acesso")
    @DeleteMapping(value = "/{idNivelAcesso}")
    public ResponseEntity deleteByID(@PathVariable("idNivelAcesso")Long idNivelAcesso) throws Exception {

        return  nivelAcessoService.deleteNivelAcesso(idNivelAcesso);

    }


}
