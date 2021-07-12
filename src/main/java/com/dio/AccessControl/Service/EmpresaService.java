package com.dio.AccessControl.Service;


import com.dio.AccessControl.Repository.EmpresaRepository;
import com.dio.AccessControl.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }
    public Empresa saveEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }
    public List<Empresa> findAll(){
        return empresaRepository.findAll();

    }
    public Optional<Empresa> getById(Long idEmpresa) {
        return empresaRepository.findById(idEmpresa);
    }

    public Empresa updateEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }
    public ResponseEntity deleteEmpresa(Long idEmpresa){
        empresaRepository.deleteById(idEmpresa);
        return null;
    }


}
