package com.seed.pontointeligente.api.services;

import java.util.Optional;

import com.seed.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	Optional<Funcionario> buscarPorEmailOuCpf(String email, String cpf);
	
	Funcionario persistir(Funcionario funcionario);
	
	Optional<Funcionario> findById(Long id);
	

}
