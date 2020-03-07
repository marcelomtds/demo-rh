package com.example.demo.service;

import com.example.demo.enums.MessageEnum;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.dto.CargoDTO;
import com.example.demo.model.filter.CargoFilter;
import com.example.demo.model.filter.PageableFilter;
import com.example.demo.model.mapper.CargoMapper;
import com.example.demo.repository.CargoRepository;
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
public class CargoService {

    private CargoRepository repository;
    private CargoMapper mapper;

    @Transactional(readOnly = true)
    public Page<CargoDTO> findByFilter(final PageableFilter<CargoFilter> filter) {
        Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        return repository.findByFilter(
                filter.getFilter().getDescricao(),
                pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public List<CargoDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Transactional(readOnly = true)
    public CargoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0005.getMessage())));
    }

    public CargoDTO create(final CargoDTO dto) {
        validateDuplicityByDescription(dto);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    public CargoDTO update(final Long id, final CargoDTO dto) {
        findById(id);
        return create(dto);
    }

    private void validateDuplicityByDescription(final CargoDTO request) {
        final CargoDTO response = mapper.toDTO(repository.findByDescricao(request.getDescricao()));
        if (Objects.nonNull(response) && !response.getId().equals(request.getId())) {
            throw new BusinessException(MessageEnum.MSG0006.getMessage());
        }
    }

}
