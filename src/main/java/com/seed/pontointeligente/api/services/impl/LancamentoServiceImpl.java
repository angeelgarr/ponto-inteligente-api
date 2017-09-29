package com.seed.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.seed.pontointeligente.api.entities.Lancamento;
import com.seed.pontointeligente.api.repositories.LancamentoRepository;
import com.seed.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> findByFuncionarioId(Long funcionarioId, PageRequest page) {
		return lancamentoRepository.findByFuncionarioId(funcionarioId, page);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		this.lancamentoRepository.delete(id);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
	}

}
