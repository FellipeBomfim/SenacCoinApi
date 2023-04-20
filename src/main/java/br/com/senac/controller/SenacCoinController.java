package br.com.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.domain.SenacCoin;
import br.com.senac.service.SenacCoinService;

@RestController
@RequestMapping("senaccoin")
public class SenacCoinController {
	@Autowired
	private SenacCoinService scService;
	
	@GetMapping("/{id}")
	public ResponseEntity<SenacCoin> buscarSenacCoinPorId(@PathVariable Long id){
		SenacCoin sc = scService.buscarSenacCoinPorId(id);
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@GetMapping
	public ResponseEntity<List<SenacCoin>> buscarTodosSenacCoin(){
		List<SenacCoin> scLista = scService.buscarTodosSenacCoin();
		if(scLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(scLista);
	}
	
	@PostMapping
	public ResponseEntity<SenacCoin> cadastrarSenacCoin(@RequestBody SenacCoin senacCoin){
		SenacCoin sc = scService.cadastrarSenacCoin(senacCoin);
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SenacCoin> atualizarSenacCoin(@PathVariable Long id, @RequestBody SenacCoin senacCoinAlterado){
		SenacCoin sc = scService.atualizarSenacCoin(id, senacCoinAlterado);
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerSenacCoin(@PathVariable Long id){
		String msg = scService.removerSenacCoin(id);
		if(msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<SenacCoin> buscarSenacCoinPorUsuarioId(@PathVariable String usuarioId){
		SenacCoin sc = scService.buscarSenacCoinPorUsuarioId(usuarioId);
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
	
	@PutMapping("/gastar")
	public ResponseEntity<SenacCoin> gastarSenacCoin(@RequestParam(defaultValue = "0") Long id, @RequestParam(defaultValue = "0") int valor){
		
		SenacCoin sc = scService.buscarSenacCoinPorId(id);
		if(valor < 0 && sc.getSaldo() < (valor * (-1))) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		sc.setSaldo(sc.getSaldo() + valor);
		sc = scService.atualizarSenacCoin(id, sc);
		
		if(sc == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}
}
