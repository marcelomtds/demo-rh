package com.example.demo.service;

import com.example.demo.enums.MessageEnum;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.dto.SexoDTO;
import com.example.demo.model.mapper.SexoMapper;
import com.example.demo.repository.SexoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SexoService {

    private SexoRepository repository;
    private SexoMapper mapper;

    @Transactional(readOnly = true)
    public List<SexoDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Transactional(readOnly = true)
    public SexoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0004.getMessage())));
    }

}
