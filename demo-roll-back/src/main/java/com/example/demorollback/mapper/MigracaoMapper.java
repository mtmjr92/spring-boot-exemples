package com.example.demorollback.mapper;

import com.example.demorollback.dto.EmpresaDTO;
import com.example.demorollback.dto.MigracaoDTO;
import com.example.demorollback.dto.PessoaDTO;
import com.example.demorollback.dto.SetorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MigracaoMapper {

    default MigracaoDTO montarMigracaoDTO(EmpresaDTO empresaDTO, PessoaDTO pessoaDTO , SetorDTO setorDTO) {
        MigracaoDTO migracaoDTO = new MigracaoDTO();

        migracaoDTO.setEmpresa(empresaDTO);
        migracaoDTO.setPessoa(pessoaDTO);
        migracaoDTO.setSetor(setorDTO);

        return migracaoDTO;
    }

}
