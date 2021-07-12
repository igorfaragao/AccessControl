package com.dio.AccessControl.Service;


import com.dio.AccessControl.Repository.UsuarioRepository;
import com.dio.AccessControl.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();

    }
    public Optional<Usuario> getById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Usuario updateUsuario(Usuario usario){
        return usuarioRepository.save(usario);
    }
    public ResponseEntity deleteUsuario(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
        return null;
    }
}
