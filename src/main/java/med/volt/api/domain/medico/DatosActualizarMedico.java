package med.volt.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.volt.api.domain.direccion.DatosDireccion;
//Solo los datos que quiere actuzaliar
//Anotacion @NotNull para valirdar si viene vacio
public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {
}
