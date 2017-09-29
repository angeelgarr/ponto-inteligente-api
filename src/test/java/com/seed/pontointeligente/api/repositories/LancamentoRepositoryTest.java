package com.seed.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.seed.pontointeligente.api.entities.Empresa;
import com.seed.pontointeligente.api.entities.Funcionario;
import com.seed.pontointeligente.api.entities.Lancamento;
import com.seed.pontointeligente.api.enums.PerfilEnum;
import com.seed.pontointeligente.api.enums.TipoEnum;
import com.seed.pontointeligente.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	
	
	@Before
	public void setUp() {
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		
		Funcionario funcionario = this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		this.funcionarioId = funcionario.getId();
		
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
		this.lancamentoRepository.save(obterDadosLancamento(funcionario));
		
	}
	
	@After
	public void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(this.funcionarioId);
		
		assertEquals(2, lancamentos.size());
		
	}
	
	@Test
	public void testBuscarLancamentoPorFuncionarioIdPaginado() {
		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		
		assertEquals(2, lancamentos.getTotalElements());
	}
	
	
	private Lancamento obterDadosLancamento(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setFuncionario(funcionario);
		lancamento.setTipo(TipoEnum.INICIO_TRABALHO);
		lancamento.setDescricao("Entrada no trampo...vqv");
		
		return lancamento;
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("WAGNER BORGES");
		funcionario.setEmail("emaildowagnerborges@gmail.com");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
		funcionario.setCpf("00350690316");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("SEED SOFTWARE ON DEMAND");
		empresa.setCnpj("12345678912312");
		return empresa;
	}
	
}

