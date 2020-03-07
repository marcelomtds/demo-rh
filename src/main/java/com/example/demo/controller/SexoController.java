package com.example.demo.controller;

import com.example.demo.enums.MessageEnum;
import com.example.demo.model.mapper.SexoMapper;
import com.example.demo.response.Response;
import com.example.demo.service.SexoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/sexo")
public class SexoController {

    private SexoService service;

    @GetMapping
    public ResponseEntity<Response<List<SexoMapper>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0001.getMessage()));
    }

}
