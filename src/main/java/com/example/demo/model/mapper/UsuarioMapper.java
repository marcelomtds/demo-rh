package com.example.demo.model.mapper;

import com.example.demo.model.dto.UsuarioDTO;
import com.example.demo.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {SexoMapper.class})
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

    @Mapping(target = "sexoId", source = "sexo.id")
    @Mapping(target = "sexoDescricao", source = "sexo.descricao")
    @Mapping(target = "senha", ignore = true)
    UsuarioDTO toDTO(Usuario entity);

    @Mapping(source = "sexoId", target = "sexo.id")
    @Mapping(source = "sexoDescricao", target = "sexo.descricao")
    Usuario toEntity(UsuarioDTO dto);

}