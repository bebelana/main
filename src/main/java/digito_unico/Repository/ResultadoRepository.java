package digito_unico.Repository;

import digito_unico.Model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
