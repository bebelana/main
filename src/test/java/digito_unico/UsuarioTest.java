package digito_unico;


import digito_unico.Model.Usuario;
import digito_unico.Repository.UsuarioRepository;
import digito_unico.Service.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class UsuarioTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarUsuario() {
        Usuario usuario = new Usuario();
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario createdUsuario = usuarioService.criarUsuario(usuario);

        assertEquals(usuario, createdUsuario);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void obterUsuario_existingId() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Usuario retrievedUsuario = usuarioService.obterUsuario(id);

        assertEquals(usuario, retrievedUsuario);
        verify(usuarioRepository, times(1)).findById(id);
    }

    @Test
    void obterUsuario_nonExistingId() {
        Long id = 1L;
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        Usuario retrievedUsuario = usuarioService.obterUsuario(id);

        assertNull(retrievedUsuario);
        verify(usuarioRepository, times(1)).findById(id);
    }

    @Test
    void listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> retrievedUsuarios = usuarioService.listarUsuarios();

        assertEquals(usuarios, retrievedUsuarios);
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void atualizarUsuario_existingId() {
        Long id = 1L;
        Usuario usuarioAtualizado = new Usuario();
        Usuario usuario = new Usuario();
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario updatedUsuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);

        assertEquals(usuario, updatedUsuario);
        verify(usuarioRepository, times(1)).findById(id);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void atualizarUsuario_nonExistingId() {
        Long id = 1L;
        Usuario usuarioAtualizado = new Usuario();
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        Usuario updatedUsuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);

        assertNull(updatedUsuario);
        verify(usuarioRepository, times(1)).findById(id);
        verify(usuarioRepository, never()).save(any());
    }

    @Test
    void deletarUsuario() {
        Long id = 1L;

        usuarioService.deletarUsuario(id);

        verify(usuarioRepository, times(1)).deleteById(id);
    }
}
