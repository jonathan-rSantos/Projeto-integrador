package com.projetorango.Rango.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetorango.Rango.model.Usuario;
import com.projetorango.Rango.model.UsuarioLogin;
import com.projetorango.Rango.repository.UsuarioRepository;
import com.projetorango.Rango.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
    private UsuarioRepository repository;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	
	@GetMapping("/{id}")
    public ResponseEntity<Usuario> GetById(@PathVariable long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		try {
			return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/cadastrar")
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.AtualizarUsuario(usuario));
		
	}
}