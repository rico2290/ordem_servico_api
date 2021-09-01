package com.rico.ordemservico.api.dto;

import javax.validation.constraints.NotNull;

public class ClienteDTO {
	
	@NotNull(message = "Campo nome é obrigatório")
	private String nome;

}
