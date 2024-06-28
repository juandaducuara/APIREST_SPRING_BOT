package med.volt.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import med.volt.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicosActivo implements ValidadorDeConsultas {
    @Autowired
    private MedicoRepository medicoRepository;
    @Override
    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        if (datosAgendarConsulta.idMedico() == null) {
            return;
        }
        var medicoActivo = medicoRepository.findActivoById(datosAgendarConsulta.idMedico());
        if (!medicoActivo) {
            throw new ValidationException("No se permiten agendamientos a medicos INACTIVOS");
        }
    }
}
