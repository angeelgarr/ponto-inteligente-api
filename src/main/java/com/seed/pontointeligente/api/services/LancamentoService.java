package com.seed.pontointeligente.api.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.seed.pontointeligente.api.entities.Lancamento;

public interface LancamentoService {

	List<Lancamento> findByFuncionarioId(Long funcionarioId);

	Page<Lancamento> findByFuncionarioId(Long funcionarioId, Pageable pageable);
	
	Lancamento persistir(Lancamento lancamento);

}
