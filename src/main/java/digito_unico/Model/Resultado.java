package digito_unico.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resultado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Integer digitoUnico;

    public Resultado(){

    }

    public  Resultado(Long id, String numero, Integer digitoUnico) {
        this.id = id;
        this.numero =numero;
        this.digitoUnico =digitoUnico;
    }


    public void setResultado(int resultado) {
        this.digitoUnico = resultado;
    }

    public void setParametros(String s, int resultado) {
    }
}