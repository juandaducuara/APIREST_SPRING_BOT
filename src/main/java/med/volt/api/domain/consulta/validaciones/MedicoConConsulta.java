package med.volt.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.volt.api.domain.consulta.ConsultaRepository;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas{
    @Autowired
    private ConsultaRepository consultaRepository;
    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        var medicoConsulta = consultaRepository.existsByMedicoIdAndFecha(datosAgendarConsulta.idMedico(),datosAgendarConsulta.fecha());
        if(datosAgendarConsulta.idMedico()==null){
            return;
        }
        if (medicoConsulta){
            throw new ValidationException("Este medico ya tiene una consulta en ese horario");
        }



    }
}
