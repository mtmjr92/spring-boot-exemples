package com.example.demorollback.mapper;

import com.example.demorollback.domain.Empresa;
import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.dto.EmpresaDTO;
import com.example.demorollback.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    Empresa toEntity(EmpresaDTO dto);

    EmpresaDTO toDTO(Empresa empresa);

}
