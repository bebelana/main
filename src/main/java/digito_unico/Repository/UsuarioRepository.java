package digito_unico.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digito_unico.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
