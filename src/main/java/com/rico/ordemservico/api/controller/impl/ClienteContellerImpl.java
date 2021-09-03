package com.rico.ordemservico.api.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rico.ordemservico.api.controller.ClienteController;
import com.rico.ordemservico.domain.model.Cliente;
import com.rico.ordemservico.domain.repository.ClienteRespository;
import com.rico.ordemservico.domain.service.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteContellerImpl  implements ClienteController{
	
private ClienteRespository clienteRepository;
	
	private ClienteService clienteService;
	
	
	@GetMapping
	public Page<Cliente>  listar() {
		return clienteService.listarClientes();	
	}
	
	@GetMapping("/buscarPorNome/{nome}")
	public List<Cliente>  listarPorNome(@PathVariable String nome) {
		return clienteRepository.findByNome(nome);	
	}
	

	@GetMapping("/buscarPorId/{clienteId}")
	public ResponseEntity<Cliente>  buscarPorId(@PathVariable Long clienteId) {	
		return clienteRepository.findById(clienteId)
		.map(cliente -> ResponseEntity.ok(cliente))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("/update/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, Cliente cliente){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		} 
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/deletar/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		 clienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}

}
