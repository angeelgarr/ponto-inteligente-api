package com.seed.pontointeligente.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.seed.pontointeligente.api.entities.Funcionario;
import com.seed.pontointeligente.api.repositories.FuncionarioRepository;
import com.seed.pontointeligente.api.services.FuncionarioService;

public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {

		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorEmailOuCpf(String email, String cpf) {
		
		return Optional.ofNullable(this.funcionarioRepository.findByCpfOrEmail(cpf, email));
		
	}

	@Override
	public Funcionario persistir(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> findById(Long id) {
		
		return Optional.ofNullable(this.funcionarioRepository.findOne(id));
	}

}
