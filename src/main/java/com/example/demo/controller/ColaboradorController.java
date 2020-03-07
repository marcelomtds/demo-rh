package com.example.demo.controller;

import com.example.demo.enums.MessageEnum;
import com.example.demo.model.dto.ColaboradorDTO;
import com.example.demo.model.filter.ColaboradorFilter;
import com.example.demo.model.filter.PageableFilter;
import com.example.demo.response.Response;
import com.example.demo.service.ColaboradorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/colaborador")
public class ColaboradorController {

    private ColaboradorService service;

    @PostMapping(path = "/findByFilter")
    public ResponseEntity<Response<Page<ColaboradorDTO>>> findByFilter(@RequestBody @Valid final PageableFilter<ColaboradorFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(filter), MessageEnum.MSG0001.getMessage()));
    }

    @GetMapping
    public ResponseEntity<Response<List<ColaboradorDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0001.getMessage()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<ColaboradorDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG0001.getMessage()));
    }

    @PostMapping
    public ResponseEntity<Response<ColaboradorDTO>> create(@RequestBody final ColaboradorDTO dto) {
        return ResponseEntity.ok().body(new Response(service.create(dto), MessageEnum.MSG0001.getMessage()));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<ColaboradorDTO>> update(@PathVariable final Long id, @RequestBody final ColaboradorDTO dto) {
        return ResponseEntity.ok().body(new Response(service.update(id, dto), MessageEnum.MSG0001.getMessage()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response> update(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response(null, MessageEnum.MSG0001.getMessage()));
    }

}
