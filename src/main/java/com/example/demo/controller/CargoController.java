package com.example.demo.controller;

import com.example.demo.enums.MessageEnum;
import com.example.demo.model.dto.CargoDTO;
import com.example.demo.model.filter.CargoFilter;
import com.example.demo.model.filter.PageableFilter;
import com.example.demo.response.Response;
import com.example.demo.service.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/cargo")
public class CargoController {

    private CargoService service;

    @PostMapping(path = "/findByFilter")
    public ResponseEntity<Response<Page<CargoDTO>>> findByFilter(@RequestBody @Valid final PageableFilter<CargoFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(filter), MessageEnum.MSG0001.getMessage()));
    }

    @GetMapping
    public ResponseEntity<Response<List<CargoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0001.getMessage()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<CargoDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG0001.getMessage()));
    }

    @PostMapping
    public ResponseEntity<Response<CargoDTO>> create(@RequestBody final CargoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.create(dto), MessageEnum.MSG0001.getMessage()));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<CargoDTO>> update(@PathVariable final Long id, @RequestBody final CargoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.update(id, dto), MessageEnum.MSG0001.getMessage()));
    }

}
