package com.example.demo.service;

import com.example.demo.enums.MessageEnum;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.dto.ColaboradorDTO;
import com.example.demo.model.filter.ColaboradorFilter;
import com.example.demo.model.filter.PageableFilter;
import com.example.demo.model.mapper.ColaboradorMapper;
import com.example.demo.repository.ColaboradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ColaboradorService {

    private ColaboradorRepository repository;
    private ColaboradorMapper mapper;

    @Transactional(readOnly = true)
    public Page<ColaboradorDTO> findByFilter(final PageableFilter<ColaboradorFilter> filter) {
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        return repository.findByFilter(
                filter.getFilter().getNomeCompleto(),
                filter.getFilter().getCpf(),
                filter.getFilter().getSexoId(),
                filter.getFilter().getCargoId(),
                pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public List<ColaboradorDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    public void delete(final Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public ColaboradorDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0002.getMessage())));
    }

    public ColaboradorDTO create(final ColaboradorDTO dto) {
        validateDuplicityByCpf(dto);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public ColaboradorDTO update(final Long id, final ColaboradorDTO dto) {
        findById(id);
        return create(dto);
    }

    private void validateDuplicityByCpf(final ColaboradorDTO request) {
        final ColaboradorDTO response = mapper.toDTO(repository.findByCpf(request.getCpf()));
        if (Objects.nonNull(response) && !response.getId().equals(request.getId())) {
            throw new BusinessException(MessageEnum.MSG0003.getMessage());
        }
    }

}
