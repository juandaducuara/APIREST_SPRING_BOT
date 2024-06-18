package med.volt.api.domain.medico;


//Solo los datos que quiere actuzaliar
//Anotacion @NotNull para valirdar si viene vacio
public record DatosListadoMedico(
        Long id,
        String nombre,
        String email,
        String documento,
        Especialidad especialidad
) {
    public DatosListadoMedico(Medico medico){
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad()
        );
    }
}
