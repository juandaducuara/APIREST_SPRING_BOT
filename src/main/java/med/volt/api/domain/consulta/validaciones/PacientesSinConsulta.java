package med.volt.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.volt.api.domain.consulta.ConsultaRepository;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Se implementa ValdadorDeconsultas
@Component
public class PacientesSinConsulta implements ValidadorDeConsultas{
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta){
        var primerHorario = datosAgendarConsulta.fecha().withHour(7);
        var ultimoHorario = datosAgendarConsulta.fecha().withHour(18);

        var pacienteConsulta=consultaRepository.existsByPacienteIdAndFechaBetween(datosAgendarConsulta.idPaciente(),primerHorario,ultimoHorario);
        if (pacienteConsulta){
            throw new ValidationException("El paciente ya tiene consulta ese dia");
        }

    }
}
