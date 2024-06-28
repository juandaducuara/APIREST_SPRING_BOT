package med.volt.api.domain.consulta.validaciones;

import med.volt.api.domain.consulta.DatosAgendarConsulta;
//Interface que lo que hace es polimorfismo del metodo validar yq ue se llama en todas clases de validar
public interface ValidadorDeConsultas {
    void validar(DatosAgendarConsulta datosAgendarConsulta);
}
