package com.rico.ordemservico.domain.service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.rico.ordemservico.domain.model.Cliente;
import com.rico.ordemservico.domain.repository.ClienteRespository;
import com.rico.ordemservico.exception.NegocioException;

import lombok.AllArgsConstructor;


//@AllArgsConstructor
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRespository clienteRespository;
	

	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRespository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe cliente cadastrado com este e-mail");
		}
		
		return clienteRespository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRespository.deleteById(clienteId);
	}
	
	@Transactional
	public Cliente atualizar(Long clienteId, Cliente cliente) {
		return clienteRespository.save(cliente);
	}
	
	public Page<Cliente> listarClientes(){
		int pageNumber = 0;
		int pageSize = 10;
		PageRequest paginacao = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "nome");
		return new PageImpl<>(clienteRespository.findAll(), paginacao, pageSize);
	}


}
