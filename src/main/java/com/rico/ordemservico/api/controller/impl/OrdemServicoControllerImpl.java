package com.rico.ordemservico.api.controller.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.rico.ordemservico.api.controller.OrdemServicoController;
import com.rico.ordemservico.api.dto.OrdemServicoDTO;
import com.rico.ordemservico.domain.model.OrdemServico;
import com.rico.ordemservico.domain.repository.OrdemServicoRespository;
import com.rico.ordemservico.domain.service.OrdemServicoService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoControllerImpl implements OrdemServicoController {
	
	private OrdemServicoService ordemServicoService;
	
	private OrdemServicoRespository ordemServicoRepository;
	
	ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico orndemServico) {
		return ordemServicoService.criar(orndemServico);
	}
	
	@GetMapping
	@Override
	public List<OrdemServico> listar(){
		return ordemServicoRepository.findAll();
	}

	@Override
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServicoDTO> buscar(@PathVariable Long ordemServicoId) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(ordemServicoId);
		if(ordemServico.isPresent()) {
			OrdemServicoDTO dto = modelMapper.map(ordemServico.get(), OrdemServicoDTO.class);
//			OrdemServicoDTO dto = new OrdemServicoDTO();
//			BeanUtils.copyProperties(ordemServico.get(), dto);
			
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}
	
}
