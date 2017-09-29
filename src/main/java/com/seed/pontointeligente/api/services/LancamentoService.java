package com.seed.pontointeligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.seed.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	Page<Lancamento> findByFuncionarioId(Long funcionarioId, PageRequest page);

	Optional<Lancamento> buscarPorId(Long id);
	
	Lancamento persistir(Lancamento lancamento);
	
	void remover(Long id);

}
