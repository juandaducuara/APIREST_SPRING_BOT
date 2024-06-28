package med.volt.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class HorariosDeFuncionamientoClinica implements ValidadorDeConsultas{
    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
        var domingo = DayOfWeek.SUNDAY.equals(datosAgendarConsulta.fecha().getDayOfWeek());
        var antesDeApertura = datosAgendarConsulta.fecha().getHour() < 7;
        var despuesCierre = datosAgendarConsulta.fecha().getHour() > 19;
        if (domingo || antesDeApertura || despuesCierre) {
            throw new ValidationException("El horario de atencion es de Lunes a Sabado, de 07:00 a 19:00 horas");
        }
    }
}
