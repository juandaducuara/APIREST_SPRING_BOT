package med.volt.api.infra.errores;

public class ValidacionDeIntegirad extends RuntimeException {
    public ValidacionDeIntegirad(String mensajeValidacion) {
        super(mensajeValidacion);
    }
}
