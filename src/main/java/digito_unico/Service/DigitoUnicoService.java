package digito_unico.Service;

import org.springframework.stereotype.Service;

@Service
public class DigitoUnicoService {

    public int calcularDigitoUnico(String n, int c) {
      StringBuilder concatenado = new StringBuilder();
      for (int i = 0; i < c; i++) {
        concatenado.append(n);
      }
      return calcularDigitoUnico(concatenado.toString());
    }

    private int calcularDigitoUnico(String n) {
      while (n.length() > 1) {
        int soma = 0;
        for (char digito : n.toCharArray()) {
          soma += Character.getNumericValue(digito);
        }
        n = String.valueOf(soma);
      }
      return Integer.parseInt(n);
    }
}
