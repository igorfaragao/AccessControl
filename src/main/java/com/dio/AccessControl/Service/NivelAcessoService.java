package com.dio.AccessControl.Service;


import com.dio.AccessControl.Repository.NivelAcessoRepository;
import com.dio.AccessControl.model.NivelAcesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelAcessoService {
     NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    public NivelAcessoService(NivelAcessoRepository nivelAcessoRepository){
        this.nivelAcessoRepository = nivelAcessoRepository;
    }
    public NivelAcesso saveNivelAcesso(NivelAcesso nivelAcesso){

        return nivelAcessoRepository.save(nivelAcesso);
    }
    public List<NivelAcesso> findAll(){
        return nivelAcessoRepository.findAll();

    }
    public Optional<NivelAcesso> getById(Long idNivelAcesso) {
        return nivelAcessoRepository.findById(idNivelAcesso);
    }

    public NivelAcesso updateNivelAcesso(NivelAcesso nivelAcesso){

        return nivelAcessoRepository.save(nivelAcesso);
    }
    public ResponseEntity deleteNivelAcesso(Long idNivelAcesso){
        nivelAcessoRepository.deleteById(idNivelAcesso);
        return null;
    }



}