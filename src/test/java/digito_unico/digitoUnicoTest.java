package digito_unico;

import org.junit.jupiter.api.Test;

import digito_unico.Service.DigitoUnicoService;

import static org.junit.jupiter.api.Assertions.*;

public class digitoUnicoTest {

    private final DigitoUnicoService digitoService = new DigitoUnicoService();

    @Test
    public void testCalculateUniqueDigitSingle() {
        assertEquals(9, digitoService.calcularDigitoUnico("9", 1));
        assertEquals(5, digitoService.calcularDigitoUnico("5", 1));
    }

    @Test
    public void testCalculateUniqueDigitMultiple() {
        assertEquals(2, digitoService.calcularDigitoUnico("9875", 1));
        assertEquals(8, digitoService.calcularDigitoUnico("9875", 4));
    }

}
