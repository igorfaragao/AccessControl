package com.dio.AccessControl.Controller;


import com.dio.AccessControl.Service.JornadaTrabalhoService;
import com.dio.AccessControl.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.saveJornada(jornadaTrabalho);
    }
    @GetMapping
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaTrabalhoService.findAll();

    }

    @GetMapping("/list")
    public ResponseEntity<JornadaTrabalho>getJornadaListByID(@PathVariable("idJornada")Long idJornada) throws Exception {

        return ResponseEntity.ok(jornadaTrabalhoService.getById(idJornada).orElseThrow(()-> new Exception("Jornada Não Encontrada")));

    }
    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoService.updateJornada(jornadaTrabalho);
    }

   @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada")Long idJornada) throws Exception {

       try{
           jornadaTrabalhoService.deleteJornada(idJornada);
       }catch (Exception e){
           System.out.println(e.getMessage());

       }
          return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }



}
