package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.domain.SenacCoin;

public interface SenacCoinRepository extends JpaRepository<SenacCoin, Long>{
	SenacCoin findByUsuarioId(String usuarioId);
}
