package com.rico.ordemservico.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.rico.ordemservico.domain.enumeration.StatusOrdemServico;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ordem_servico")
@Entity
public class OrdemServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
//	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@NotBlank
	private String descrição;
	
	@NotBlank
	private BigDecimal preco;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	
	@NotBlank
	private LocalDateTime dataAbertura;
	
	private LocalDateTime dataFinalizacao;
	

}
