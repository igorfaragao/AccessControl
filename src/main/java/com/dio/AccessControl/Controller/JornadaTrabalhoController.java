package com.dio.AccessControl.Controller;


import com.dio.AccessControl.Service.JornadaTrabalhoService;
import com.dio.AccessControl.model.JornadaTrabalho;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @ApiOperation("Cria uma Nova Jornada de trabalho")
    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.saveJornada(jornadaTrabalho);
    }
    @ApiOperation("Lista todas as jornadas de trabalho criadas")
    @GetMapping
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaTrabalhoService.findAll();

    }
    @ApiOperation("Busca jornada de trabalho pelo ID")
    @GetMapping("/{idJornadaTrabalho}")
    public ResponseEntity<JornadaTrabalho>getJornadaListByID(@PathVariable("idJornadaTrabalho")Long idJornadaTrabalho) throws Exception {

        return ResponseEntity.ok(jornadaTrabalhoService.getById(idJornadaTrabalho).orElseThrow(()-> new Exception("Jornada Não Encontrada")));

    }
    @ApiOperation("Atualiza a Jornada de trabalho")
    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.updateJornada(jornadaTrabalho);
    }
    @ApiOperation("Deleta Jornada de trabalho")
      @DeleteMapping(value = "/{idJornadaTrabalho}")
     public ResponseEntity deleteByID(@PathVariable("idJornadaTrabalho")Long idJornadaTrabalho) throws Exception {

        return  jornadaTrabalhoService.deleteJornada(idJornadaTrabalho);

   }



}
