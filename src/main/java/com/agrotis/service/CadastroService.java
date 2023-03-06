package com.agrotis.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.agrotis.model.DadosPessoa;
import com.agrotis.model.Pessoa;
import com.agrotis.repository.PessoaRepository;

@Service
public class CadastroService {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DadosPessoa adicionar(DadosPessoa dados) {
		Pessoa pessoa = modelMapper.map(dados, Pessoa.class);
		repository.save(pessoa);
		return modelMapper.map(pessoa, DadosPessoa.class);
}
	
	public Page<Pessoa> obterCadastros(Pageable paginacao){
		return repository.findAll(paginacao).map(d -> modelMapper.map(d, Pessoa.class));
	}
	
	
	public DadosPessoa atualizarDados(Long id, DadosPessoa dados) {
		Pessoa pessoa = repository.getReferenceById(id);
		pessoa.setNome(dados.getNome());
		pessoa.setDataInicial(dados.getDataInicial());
		pessoa.setDataFinal(dados.getDataFinal());
		pessoa.setLaboratorio(dados.getLaboratorio());
		pessoa.setPropriedade(dados.getPropriedade());
		pessoa.setObservacoes(dados.getObservacoes());
		repository.save(pessoa);
		return modelMapper.map(pessoa, DadosPessoa.class);
	}
	
	public void deletarCadastro(Long id) {
		repository.deleteById(id);
	}
	
}
