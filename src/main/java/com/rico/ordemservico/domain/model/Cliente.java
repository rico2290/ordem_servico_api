package com.rico.ordemservico.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ctc.wstx.osgi.ValidationSchemaFactoryProviderImpl;
import com.rico.ordemservico.domain.model.validators.ValidationGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@JsonSerialize
@Getter
@Setter
@Table(name = "cliente")
@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(groups =  ValidationGroups.ClienteId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 2, max = 60)
	@Column(name = "nome")
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	
	@NotBlank
//	@NotNull
	@Size(max = 20)
	@Column(name = "fone")
	private String fone;
	
//	@OneToMany
//	private OrdemServico ordemServico;


}
