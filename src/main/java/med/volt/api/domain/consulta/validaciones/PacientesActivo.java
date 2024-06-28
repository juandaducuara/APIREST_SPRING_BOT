package med.volt.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import med.volt.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacientesActivo implements ValidadorDeConsultas{
    @Autowired
    private PacienteRepository pacienteRepository;
    public void validar(DatosAgendarConsulta datosAgendarConsulta){
        if(datosAgendarConsulta.idPaciente()==null){
            return;
        }
        var pacienteActivo = pacienteRepository.findActivoById(datosAgendarConsulta.idPaciente());
        if(!pacienteActivo){
            throw new ValidationException("No se permiten agendamientos a pacientes INACTIVOS");
        }
    }
}
