package br.com.senac.domain;

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
public class SenacCoin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "senac_coin_id", nullable = false)
	private Long id;
	@Column(name = "senac_coin_saldo", nullable = false)
	private Long saldo;
	@Column(name = "senac_coin_status", nullable = false)
	private int status;
	@Column(name = "usuario_id", nullable = false)
	private String usuarioId;
}
