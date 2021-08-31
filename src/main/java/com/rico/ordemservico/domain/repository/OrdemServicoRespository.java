/**
 * 
 */
package com.rico.ordemservico.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rico.ordemservico.domain.model.Cliente;
import com.rico.ordemservico.domain.model.OrdemServico;

/**
 * @author rico22
 *
 */
@Repository
public interface OrdemServicoRespository extends JpaRepository<OrdemServico, Long> {

}
