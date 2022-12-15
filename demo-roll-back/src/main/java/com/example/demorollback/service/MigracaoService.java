package com.example.demorollback.service;

import com.example.demorollback.domain.Empresa;
import com.example.demorollback.domain.Erro;
import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.domain.Setor;
import com.example.demorollback.dto.EmpresaDTO;
import com.example.demorollback.dto.MigracaoDTO;
import com.example.demorollback.dto.PessoaDTO;
import com.example.demorollback.dto.SetorDTO;
import com.example.demorollback.mapper.EmpresaMapper;
import com.example.demorollback.mapper.MigracaoMapper;
import com.example.demorollback.mapper.PessoaMapper;
import com.example.demorollback.mapper.SetorMapper;
import com.example.demorollback.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class MigracaoService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private SetorService setorService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Autowired
    private SetorMapper setorMapper;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private MigracaoMapper migracaoMapper;

    @Autowired
    private ErroService erroService;

    @Lazy
    @Autowired
    private MigracaoService service;

    @Transactional
    public MigracaoDTO salvar(MigracaoDTO migracao) {
        EmpresaDTO migracaoEmpresaDTO = migracao.getEmpresa();
        PessoaDTO migracaoPessoaDTO = migracao.getPessoa();
        SetorDTO migracaoSetorDTO = migracao.getSetor();

        Pessoa toEntityPessoa = pessoaMapper.toEntity(migracaoPessoaDTO);
        Empresa toEntityEmpresa = empresaMapper.toEntity(migracaoEmpresaDTO);
        Setor toEntitySetor = setorMapper.toEntity(migracaoSetorDTO);

        Pessoa pessoa = pessoaService.salvar(toEntityPessoa);
        Empresa empresa = empresaService.salvar(toEntityEmpresa);
        Setor setor = setorService.salvar(toEntitySetor);

        EmpresaDTO empresaDTO = empresaMapper.toDTO(empresa);
        SetorDTO setorDTO = setorMapper.toDTO(setor);
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        if (migracao.getPessoa().getNome().equals("JOAO")) {
            throw new RuntimeException("ERRO ALEATORIO");
        }

        return montarMigracaoDTO(pessoaDTO, empresaDTO, setorDTO);
    }

    public MigracaoDTO salvarTryCatch(List<MigracaoDTO> dto) {

        for (MigracaoDTO m: dto) {

            try {
                service.salvar(m);
            } catch (Exception e) {
                Throwable cause = e.getCause();
                String message = e.getMessage();

                service.montarErroDTO(cause, message);
            }

        }

        return null;
    }

    private MigracaoDTO montarMigracaoDTO(PessoaDTO pessoaDTO, EmpresaDTO empresaDTO, SetorDTO setorDTO) {
        return  migracaoMapper.montarMigracaoDTO(empresaDTO, pessoaDTO, setorDTO);
    }

    @Transactional
    public void montarErroDTO(Throwable cause, String message){
        String msgCausa = "null";
        String msgMessage = "null";
        String dsErro;

        if (Objects.nonNull(cause)) {
            msgCausa = StringUtils.limit(cause.toString(), 100);
        }

        if (Objects.nonNull(message)) {
            msgMessage = StringUtils.limit(message, 100);
        }

        dsErro = "CAUSA: ".concat(msgCausa).concat(";")
                .concat("MESSAGE: ").concat(msgMessage);

        Erro erro = new Erro();
        erro.setErro(dsErro);

        erroService.salvar(erro);
    }
}
