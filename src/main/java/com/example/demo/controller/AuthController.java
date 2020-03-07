package com.example.demo.controller;

import com.example.demo.enums.MessageEnum;
import com.example.demo.model.dto.AuthDTO;
import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.response.Response;
import com.example.demo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private AuthService service;

    @PostMapping
    public ResponseEntity<Response<UsuarioDTO>> authentication(@RequestBody final AuthDTO dto) {
        return ResponseEntity.ok().body(new Response(service.authentication(dto), MessageEnum.MSG0001.getMessage()));
    }

}
