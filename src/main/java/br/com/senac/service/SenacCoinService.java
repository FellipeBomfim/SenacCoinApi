package br.com.senac.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senac.domain.SenacCoin;
import br.com.senac.repository.SenacCoinRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SenacCoinService {
	private SenacCoinRepository repo;
	
	public SenacCoin buscarSenacCoinPorId(Long id) {
		return repo.findById(id).get();
	}
	
	public List<SenacCoin> buscarTodosSenacCoin(){
		return repo.findAll();
	}
	
	public SenacCoin cadastrarSenacCoin(SenacCoin senacCoin) {
		return repo.save(senacCoin);
	}
	
	public SenacCoin atualizarSenacCoin(Long id, SenacCoin senacCoinAlterado) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		return repo.save(senacCoinAlterado);
	}
	
	public String removerSenacCoin(Long id) {
		if(!repo.existsById(id)) {
			return null;
		}
		
		repo.deleteById(id);
		return "Registro removido com sucesso.";
	}
}
