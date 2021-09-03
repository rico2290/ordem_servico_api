package com.rico.ordemservico.api.controller;



import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.rico.ordemservico.domain.model.Cliente;


public interface ClienteController {

	public Page<Cliente> listar();
	
	
	public List<Cliente>  listarPorNome( String nome);

	public ResponseEntity<Cliente>  buscarPorId(Long clienteId);
	
	public Cliente adicionar(Cliente cliente) ;
	

	public ResponseEntity<Cliente> atualizar(Long clienteId, Cliente cliente);

	public ResponseEntity<Void> remover( Long clienteId);
	
}