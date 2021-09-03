package com.rico.ordemservico.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.rico.ordemservico.domain.enums.StatusOrdemServico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
public class OrdemServicoDTO {
	
	private Long id;
	private String nomeCliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;

}
