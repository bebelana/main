package digito_unico.Service;

// Removed unused import statement
import digito_unico.Model.Usuario;
import digito_unico.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario obterUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (!usuarioOptional.isPresent()) {
            return null;
        }
        Usuario usuario = usuarioOptional.get();
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
      usuarioRepository.deleteById(id);
    }

 
}
