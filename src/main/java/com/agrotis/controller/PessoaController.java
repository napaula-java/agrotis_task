package com.agrotis.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agrotis.model.DadosPessoa;
import com.agrotis.model.Pessoa;
import com.agrotis.service.CadastroService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("cadastro")
public class PessoaController {
	
	@Autowired
	private CadastroService service;
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosPessoa dados) {
	   service.adicionar(dados);
	   return ResponseEntity.status(HttpStatus.OK).body("Cadastro realizado com sucesso!");
	}

	@GetMapping
	public ResponseEntity<Page<Pessoa>> list(@PageableDefault(size = 8, sort = {"nome"}) Pageable paginacao) {
		var page =  service.obterCadastros(paginacao);
		return ResponseEntity.ok(page);
	}	

	 @PutMapping("/atualizar/{id}")
	 @Transactional
	    public ResponseEntity<DadosPessoa> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid DadosPessoa dados) {
	        DadosPessoa atualizado = service.atualizarDados(id, dados);

	        return ResponseEntity.ok(atualizado);
	    }
	 
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		service.deletarCadastro(id);
		return ResponseEntity.noContent().build();
}
	
	
}
