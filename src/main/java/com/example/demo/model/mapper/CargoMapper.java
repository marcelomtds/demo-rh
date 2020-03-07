package com.example.demo.model.mapper;

import com.example.demo.model.dto.CargoDTO;
import com.example.demo.model.entity.Cargo;
import org.mapstruct.Mapper;

@Mapper
public interface CargoMapper extends BaseMapper<Cargo, CargoDTO> {

}