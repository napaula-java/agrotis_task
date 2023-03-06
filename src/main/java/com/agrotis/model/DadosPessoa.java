package com.agrotis.model;

import java.time.LocalDateTime;
import com.agrotis.enums.Laboratorio;
import com.agrotis.enums.Propriedade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoa {
		
		@NotBlank
		String nome;
		@NotNull
		LocalDateTime dataInicial;
		@NotNull
		LocalDateTime dataFinal;
		@NotNull
		Propriedade propriedade;
		@NotNull
		Laboratorio laboratorio;
		String observacoes;

}
