package com.dio.AccessControl.Service;

import com.dio.AccessControl.Repository.CategoriaUsuarioRepository;
import com.dio.AccessControl.model.CategoriaUsuario;
import com.dio.AccessControl.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaUsuarioService {
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository categoriaUsuarioRepository){
        this.categoriaUsuarioRepository = categoriaUsuarioRepository;
    }
    public CategoriaUsuario saveCategoriaUsuario(CategoriaUsuario categoriaUsuario){

        return categoriaUsuarioRepository.save(categoriaUsuario);
    }
    public List<CategoriaUsuario> findAll(){
        return categoriaUsuarioRepository.findAll();

    }
    public Optional<CategoriaUsuario> getById(Long idCategoriaUsuario) {
        return categoriaUsuarioRepository.findById(idCategoriaUsuario);
    }

    public CategoriaUsuario updateCategoriaUsuario(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }
    public ResponseEntity deleteCategoriaUsuario(Long idCategoria){
        categoriaUsuarioRepository.deleteById(idCategoria);
        return null;
    }

}
