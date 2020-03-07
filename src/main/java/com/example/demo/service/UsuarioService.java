package com.example.demo.service;

import com.example.demo.model.dto.AuthDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.model.mapper.UsuarioMapper;
import com.example.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;
    private UsuarioMapper mapper;

    public UsuarioDTO findByCpfAndSenha(final AuthDTO authDTO) {
        return mapper.toDTO(repository.findByCpfAndSenha(authDTO.getCpf(), authDTO.getSenha()));
    }

}
