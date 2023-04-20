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
	
	public SenacCoin buscarSenacCoinPorUsuarioId(String usuarioId) {
		return repo.findByUsuarioId(usuarioId);
	}
	
	public SenacCoin gastarSenacCoin(SenacCoin senacCoin, int valor) {
		if(senacCoin.getSaldo() < valor) {
			return null;
		}
		
		senacCoin.setSaldo(senacCoin.getSaldo() - valor);
		return atualizarSenacCoin(senacCoin.getId(), senacCoin);
	}
	
	public SenacCoin receberSenacCoin(SenacCoin senacCoin, int valor) {
		senacCoin.setSaldo(senacCoin.getSaldo() + valor);
		return atualizarSenacCoin(senacCoin.getId(), senacCoin);
	}
	
	public String transacionarSenacCoin(SenacCoin senacCoin1, SenacCoin senacCoin2, int valor) {
		if(senacCoin1.getUsuarioId() == senacCoin2.getUsuarioId()) {
			return null;
		}
		
		gastarSenacCoin(senacCoin1, valor);
		receberSenacCoin(senacCoin2, valor);
		return "Transação concluda.";
	}
}
