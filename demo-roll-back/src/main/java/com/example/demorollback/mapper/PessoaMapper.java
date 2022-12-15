package com.example.demorollback.mapper;

import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toEntity(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa pessoa);

}
