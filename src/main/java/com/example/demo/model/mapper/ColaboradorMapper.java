package com.example.demo.model.mapper;

import com.example.demo.model.dto.ColaboradorDTO;
import com.example.demo.model.entity.Colaborador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {SexoMapper.class, CargoMapper.class})
public interface ColaboradorMapper extends BaseMapper<Colaborador, ColaboradorDTO> {

    @Mapping(target = "sexoId", source = "sexo.id")
    @Mapping(target = "sexoDescricao", source = "sexo.descricao")
    @Mapping(target = "cargoId", source = "cargo.id")
    @Mapping(target = "cargoDescricao", source = "cargo.descricao")
    ColaboradorDTO toDTO(Colaborador entity);

    @Mapping(source = "sexoId", target = "sexo.id")
    @Mapping(source = "sexoDescricao", target = "sexo.descricao")
    @Mapping(source = "cargoId", target = "cargo.id")
    @Mapping(source = "cargoDescricao", target = "cargo.descricao")
    Colaborador toEntity(ColaboradorDTO dto);

}