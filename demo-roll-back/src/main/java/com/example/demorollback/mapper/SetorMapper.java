package com.example.demorollback.mapper;

import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.domain.Setor;
import com.example.demorollback.dto.PessoaDTO;
import com.example.demorollback.dto.SetorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SetorMapper {

    Setor toEntity(SetorDTO dto);

    SetorDTO toDTO(Setor setor);

}
