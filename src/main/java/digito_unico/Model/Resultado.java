package digito_unico.Model;

public class Resultado {
    private Long id;
    private String numero;
    private Integer digitoUnico;

    public Resultado() {
    }

    public Resultado(Long id, String numero, Integer digitoUnico) {
        this.id = id;
        this.numero = numero;
        this.digitoUnico = digitoUnico;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Integer getDigitoUnico() {
        return digitoUnico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDigitoUnico(Integer digitoUnico) {
        this.digitoUnico = digitoUnico;
    }

    public void setParametros(String numero, Integer digitoUnico) {
        this.numero = numero;
        this.digitoUnico = digitoUnico;
    }
    
    
    
    public void setResultado(int resultado) {
        this.digitoUnico = resultado;
    }

}
