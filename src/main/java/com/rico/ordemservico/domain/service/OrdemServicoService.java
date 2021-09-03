package com.rico.ordemservico.domain.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.rico.ordemservico.domain.enums.StatusOrdemServico;
import com.rico.ordemservico.domain.model.Cliente;
import com.rico.ordemservico.domain.model.OrdemServico;
import com.rico.ordemservico.domain.repository.ClienteRespository;
import com.rico.ordemservico.domain.repository.OrdemServicoRespository;
import com.rico.ordemservico.exception.NegocioException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrdemServicoService {
	
	private OrdemServicoRespository ordemServicoRespository;
	
	private ClienteRespository clienteRespository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRespository.findById(ordemServico.getCliente().getId())
					.orElseThrow(()-> new NegocioException("Cliente não encontrado"));
		ordemServico.setCliente(cliente);
		
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
			
		return ordemServicoRespository.save(ordemServico);
		
	}

}
