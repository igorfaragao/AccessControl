package com.dio.AccessControl.Service;

import com.dio.AccessControl.Repository.JornadaTrabalhoRepository;
import com.dio.AccessControl.model.JornadaTrabalho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JornadaTrabalhoService {


    JornadaTrabalhoRepository jornadaTrabalhoRepository;

    @Autowired
    public JornadaTrabalhoService(JornadaTrabalhoRepository jornadaTrabalhoRepository) {
        this.jornadaTrabalhoRepository = jornadaTrabalhoRepository;
    }

    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho){
       return jornadaTrabalhoRepository.save(jornadaTrabalho);

    }

    public List<JornadaTrabalho> findAll() {
        return jornadaTrabalhoRepository.findAll();
    }

    public Optional<JornadaTrabalho> getById(Long idJornadaTrabalho) {
        return jornadaTrabalhoRepository.findById(idJornadaTrabalho);
    }

    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaTrabalhoRepository.save(jornadaTrabalho);

    }

    public ResponseEntity deleteJornada(Long idJornadaTrabalho) {
        jornadaTrabalhoRepository.deleteById(idJornadaTrabalho);
        return null;
    }

}
