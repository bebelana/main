package digito_unico.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import digito_unico.Model.Resultado;
import digito_unico.Model.Usuario;
import digito_unico.Service.DigitoUnicoService;
import digito_unico.Service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DigitoUnicoService digitoUnicoService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok(usuarioCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.obterUsuario(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/calcular-digito-unico")
    public ResponseEntity<Integer> calcularDigitoUnico(@PathVariable Long id, @RequestParam String n, @RequestParam int c) {
        int resultado = digitoUnicoService.calcularDigitoUnico(n, c);
        Resultado resultadoObj = new Resultado();
        resultadoObj.setParametros("n=" + n + ", c=" + c, resultado); // Fix: Change the second argument to 'resultado'
        resultadoObj.setResultado(resultado);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}/resultados")
    public ResponseEntity<List<Resultado>> listarResultados(@PathVariable Long id) {
        Usuario usuario = usuarioService.obterUsuario(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario.getResultados());
    }
}
