package com.dio.AccessControl.Service;


import com.dio.AccessControl.Repository.OcorrenciaRepository;
import com.dio.AccessControl.model.Ocorrencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }
    public Ocorrencia saveOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
    public List<Ocorrencia> findAll(){
        return ocorrenciaRepository.findAll();

    }
    public Optional<Ocorrencia> getById(Long idOcorrencia) {
        return ocorrenciaRepository.findById(idOcorrencia);
    }

    public Ocorrencia updateOcorrencia(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
    public ResponseEntity deleteOcorrencia(Long idOcorrencia){
        ocorrenciaRepository.deleteById(idOcorrencia);
        return null;
    }

}
