package com.example.demo.service;

import com.example.demo.enums.MessageEnum;
import com.example.demo.exception.BusinessException;
import com.example.demo.model.dto.AuthDTO;
import com.example.demo.model.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class AuthService {

    private UsuarioService usuarioService;

    @Transactional(readOnly = true)
    public UsuarioDTO authentication(final AuthDTO authDTO) {
        UsuarioDTO usuario = usuarioService.findByCpfAndSenha(authDTO);
        if (Objects.isNull(usuario)) {
            throw new BusinessException(MessageEnum.MSG0007.getMessage());
        }
        return usuario;
    }

}
