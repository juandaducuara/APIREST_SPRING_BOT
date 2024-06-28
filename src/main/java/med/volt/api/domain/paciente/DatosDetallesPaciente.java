package med.volt.api.domain.paciente;

import med.volt.api.domain.direccion.Direccion;

public record DatosDetallesPaciente(
        Long id,
        String nombre,
        String email,
        String documento,
        String telefono,
        Direccion direccions
) {
    public DatosDetallesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento(), paciente.getTelefono(), paciente.getDireccion());
    }
}
