package com.rico.ordemservico.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rico.ordemservico.api.dto.OrdemServicoDTO;
import com.rico.ordemservico.domain.model.OrdemServico;



public interface OrdemServicoController {

	
	public OrdemServico criar(OrdemServico orndemServico);
	
	public List<OrdemServico> listar();
	
	public ResponseEntity<OrdemServicoDTO> buscar(Long ordemServicoId);
	
	
	

}
