package br.com.senac.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senac.domain.SenacCoinMovimentacao;
import br.com.senac.repository.SenacCoinMovimentacaoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SenacCoinMovimentacaoService {
	private SenacCoinMovimentacaoRepository repo;
	
	public SenacCoinMovimentacao buscarMovimentacaoPorId(Long id) {
		return repo.findById(id).get();
	}
	
	public List<SenacCoinMovimentacao> buscarTodasMovimentacoes(){
		return repo.findAll();
	}
	
	public SenacCoinMovimentacao cadastrarMovimentacao(SenacCoinMovimentacao senacCoinMovimentacao) {
		return repo.save(senacCoinMovimentacao);
	}
	
	public SenacCoinMovimentacao atualizarMovimentacao(Long id, SenacCoinMovimentacao senacCoinMovimentacaoAlterado) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		return repo.save(senacCoinMovimentacaoAlterado);
	}
	
	public String removerMovimentacao(Long id) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		repo.deleteById(id);
		return "Registro removido com sucesso.";
	}
}
