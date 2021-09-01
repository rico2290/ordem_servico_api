package com.rico.ordemservico.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rico.ordemservico.domain.model.OrdemServico;
import com.rico.ordemservico.domain.service.OrdemServicoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {
	
	private OrdemServicoService ordemServicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@RequestBody OrdemServico orndemServico) {
		return ordemServicoService.criar(orndemServico);
	}
	
	

}
