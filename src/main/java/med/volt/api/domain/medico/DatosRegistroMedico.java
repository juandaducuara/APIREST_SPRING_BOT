package med.volt.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.volt.api.domain.direccion.DatosDireccion;


//Solo los datos que quiere actuzaliar
//Anotacion @NotNull para valirdar si viene vacio
//Pattern para acerptar parametros
// Especialidad es un ENUM
public record DatosRegistroMedico(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono,
        @NotBlank
        @Pattern(regexp = "\\d{4,10}")
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DatosDireccion direccion
) {
}
