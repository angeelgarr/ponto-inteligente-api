package com.seed.pontointeligente.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.seed.pontointeligente.api.entities.Lancamento;
import com.seed.pontointeligente.api.repositories.LancamentoRepository;
import com.seed.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public List<Lancamento> findByFuncionarioId(Long funcionarioId) {
		return lancamentoRepository.findByFuncionarioId(funcionarioId);
	}

	@Override
	public Page<Lancamento> findByFuncionarioId(Long funcionarioId, Pageable pageable) {

		return lancamentoRepository.findByFuncionarioId(funcionarioId, pageable);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

}
