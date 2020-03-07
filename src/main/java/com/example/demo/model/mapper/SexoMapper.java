package com.example.demo.model.mapper;
import com.example.demo.model.dto.SexoDTO;
import com.example.demo.model.entity.Sexo;
import org.mapstruct.Mapper;

@Mapper
public interface SexoMapper extends BaseMapper<Sexo, SexoDTO> {

}