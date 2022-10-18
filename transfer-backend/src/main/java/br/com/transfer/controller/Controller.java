package br.com.transfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transfer.entity.ContaBancaria;
import br.com.transfer.entity.Transferencia;
import br.com.transfer.entity.Usuario;
import br.com.transfer.service.ContaBancariaService;
import br.com.transfer.service.TransferenciaService;
import br.com.transfer.service.UsuarioService;
import br.com.transfer.service.exception.Exceptions;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081")
public class Controller {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ContaBancariaService contaBancariaService;

	@Autowired
	private TransferenciaService transferenciaService;

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(usuarioService.createUsuario(usuario));
	}

	@PutMapping("/usuarios/{usuarioId}")
	public ResponseEntity<?> updateUsuario(@PathVariable Integer usuarioId, @RequestBody Usuario usuario) {
		try {
			return ResponseEntity.ok().body(usuarioService.updateUsuario(usuarioId, usuario));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@DeleteMapping("/usuarios/{usuarioId}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Integer usuarioId) {	
		try {
			usuarioService.deleteUsuario(usuarioId);
			return ResponseEntity.status(200).body(null);
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return ResponseEntity.ok().body(usuarioService.getUsuarios());
	}
	
	@GetMapping("/usuarios/{usuarioId}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Integer usuarioId) {
		try {
			return ResponseEntity.ok().body(usuarioService.getUsuarioBydId(usuarioId));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@PostMapping("/contas_bancarias/{usuarioId}")
	public ResponseEntity<?> createContaBancaria(@PathVariable Integer usuarioId, @RequestBody ContaBancaria contaBancaria) {
		try {
			return ResponseEntity.ok().body(contaBancariaService.createContaBancaria(usuarioId, contaBancaria));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@PutMapping("/contas_bancarias/{contaBancariaId}")
	public ResponseEntity<?> updateContaBancaria(@PathVariable Integer contaBancariaId, @RequestBody ContaBancaria contaBancaria) {
		try {
			return ResponseEntity.ok().body(contaBancariaService.updateContaBancaria(contaBancariaId, contaBancaria));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@DeleteMapping("/contas_bancarias/{contaBancariaId}")
	public ResponseEntity<?> deleteContaBancaria(@PathVariable Integer contaBancariaId) {
		try {
			contaBancariaService.deleteContaBancaria(contaBancariaId);
			return ResponseEntity.status(200).body(null);
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@GetMapping("/contas_bancarias")
	public ResponseEntity<List<ContaBancaria>> getContasBancarias() {
		return ResponseEntity.ok().body(contaBancariaService.getContasBancarias());
	}

	@GetMapping("/contas_bancarias/{contaBancariaId}")
	public ResponseEntity<?> getContaBancariaById(@PathVariable Integer contaBancariaId) {
		try {
			return ResponseEntity.ok().body(contaBancariaService.getContaBancariaById(contaBancariaId));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@PostMapping("/transferencias/{contaBancariaOrigemId}/{contaBancariaDestinoId}")
	public ResponseEntity<?> createTransferencia(@PathVariable Integer contaBancariaOrigemId, @PathVariable Integer contaBancariaDestinoId, @RequestBody Transferencia transferencia) {
		try {
			return ResponseEntity.ok().body(transferenciaService.createTransferencia(contaBancariaOrigemId, contaBancariaDestinoId, transferencia));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@PutMapping("/transferencias/{transferenciaId}")
	public ResponseEntity<?> updateTransferencia(@PathVariable Integer transferenciaId, @RequestBody Transferencia transferencia) {		
		try {
			return ResponseEntity.ok().body(transferenciaService.updateTransferencia(transferenciaId, transferencia));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@DeleteMapping("/transferencias/{transferenciaId}")
	public ResponseEntity<?> deleteTransferencia(@PathVariable Integer transferenciaId) {
		try {
			transferenciaService.deleteTransferencia(transferenciaId);
			return ResponseEntity.status(200).body(null);
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

	@GetMapping("/transferencias")
	public ResponseEntity<List<Transferencia>> getTransferencias() {
		return ResponseEntity.ok().body(transferenciaService.getTransferencias());
	}

	@GetMapping("/transferencias/{transferenciaId}")
	public ResponseEntity<?> getTransferenciaById(@PathVariable Integer transferenciaId) {		
		try {
			return ResponseEntity.ok().body(transferenciaService.getTransferenciaById(transferenciaId));
		} catch (Exceptions e) {
			return ResponseEntity.status(e.getHttpCode()).body(e);
		}
	}

}
