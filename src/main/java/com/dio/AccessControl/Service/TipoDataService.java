package com.dio.AccessControl.Service;

import com.dio.AccessControl.Repository.EmpresaRepository;
import com.dio.AccessControl.Repository.TipoDataRepository;
import com.dio.AccessControl.model.TipoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDataService {



    TipoDataRepository tipoDataRepository;

    @Autowired
    public TipoDataService(TipoDataRepository tipoDataRepository){
        this.tipoDataRepository = tipoDataRepository;
    }
    public TipoData saveTipoData(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }
    public List<TipoData> findAll(){
        return tipoDataRepository.findAll();

    }
    public Optional<TipoData> getById(Long idTipoData) {
        return tipoDataRepository.findById(idTipoData);
    }

    public TipoData updateTipoData(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }
    public ResponseEntity deleteTipoData(Long idTipoData){
        tipoDataRepository.deleteById(idTipoData);
        return null;
    }



}
