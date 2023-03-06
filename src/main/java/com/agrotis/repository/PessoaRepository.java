package com.agrotis.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.agrotis.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
