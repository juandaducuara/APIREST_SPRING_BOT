package med.volt.api.domain.consulta;

import med.volt.api.domain.consulta.validaciones.ValidadorDeConsultas;
import med.volt.api.domain.medico.Medico;
import med.volt.api.domain.medico.MedicoRepository;
import med.volt.api.domain.paciente.PacienteRepository;
import med.volt.api.infra.errores.ValidacionDeIntegirad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Las clases de alto nivel son aquellas que llevan las reglas de negocio
//Clases de bajo nivel se refiere a conecxiones
@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    //Llamar todas las validaciones de ValidadorDeConsultas
    @Autowired
    List<ValidadorDeConsultas> validadorDeConsultas;

    public DatosDetalleConsulta agendarConsulta(DatosAgendarConsulta datosAgendarConsulta) {
        if (!pacienteRepository.findById(datosAgendarConsulta.idPaciente()).isPresent()) {
            throw new ValidacionDeIntegirad("Este ID para el paciente no fue encontrado");
        }
        if (datosAgendarConsulta.idMedico() != null && !medicoRepository.existsById(datosAgendarConsulta.idMedico())) {
            throw new ValidacionDeIntegirad("Este ID para el medico no fue encontrado");
        }
        //Validaciones
        validadorDeConsultas.forEach(v -> v.validar(datosAgendarConsulta));
        var paciente = pacienteRepository.findById(datosAgendarConsulta.idPaciente()).get();
        var medico = asignarMedicoConsulta(datosAgendarConsulta);
        if (medico==null) {
            throw new ValidacionDeIntegirad("No existen medicos disponibles para este horario y especialidad");
        }
        var consulta = new Consulta(null, medico, paciente, datosAgendarConsulta.fecha());
        consultaRepository.save(consulta);
        return new DatosDetalleConsulta(consulta);
    }

    private Medico asignarMedicoConsulta(DatosAgendarConsulta datosAgendarConsulta) {
        if (datosAgendarConsulta.idMedico() != null) {
            return medicoRepository.getReferenceById(datosAgendarConsulta.idMedico());
        }
        if (datosAgendarConsulta.especialidad() == null) {
            throw new ValidacionDeIntegirad("Debe seleccionarse una especialidad para el medico");
        }
        return medicoRepository.asignarMedicoConEspecialidadEnFecha(datosAgendarConsulta.especialidad(), datosAgendarConsulta.fecha());
    }
}
