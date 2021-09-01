package com.rico.ordemservico.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rico.ordemservico.domain.enumeration.StatusOrdemServico;
import com.rico.ordemservico.domain.model.OrdemServico;
import com.rico.ordemservico.domain.repository.OrdemServicoRespository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdemServicoService {
	
	private OrdemServicoRespository ordemServicoRespository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(LocalDateTime.now());
			
		return ordemServicoRespository.save(ordemServico);
		
	}

}
