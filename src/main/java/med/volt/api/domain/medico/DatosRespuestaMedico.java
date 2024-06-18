package med.volt.api.domain.medico;

import med.volt.api.domain.direccion.DatosDireccion;

//Este solo retornaria los datos que puedan visualizar
public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        DatosDireccion direccion
) {
}
