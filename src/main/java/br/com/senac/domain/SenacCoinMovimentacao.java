package br.com.senac.domain;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SenacCoinMovimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "senac_coin_movimentacao_id", nullable = false)
	private Long id;
	@Column(name = "senac_coin_movimentacao_data", nullable = false)
	private Date data;
	@Column(name = "senac_coin_movimentacao_observacao", columnDefinition = "LONGTEXT", nullable = false)
	private String observacao;
	@Column(name = "senac_coin_movimentacao_valor", nullable = false)
	private Long valor;
	@Column(name = "senac_coin_movimentacao_status", nullable = false)
	private int status;
	@Column(name = "senac_coin_id", nullable = false)
	private Long senacCoinId;
	@Column(name = "usuario_id", nullable = false)
	private String usuarioId;
}
