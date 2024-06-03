package digito_unico.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultado> resultados = new ArrayList<>();

    public Object getNome(){
      return nome;
    }
    

    public void setNome(Object nome2){
      this.nome = (String) nome2;
    }

    public Object getEmail() {
      return email;
    }

    public void setEmail(Object email2) {
      this.email = (String) email2;
    }

    public List<Resultado> getResultados() {
      return resultados;
    }
}
