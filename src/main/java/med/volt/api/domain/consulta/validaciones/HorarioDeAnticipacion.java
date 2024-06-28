package med.volt.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas{
    public void validar(DatosAgendarConsulta datosAgendarConsulta) {
       var horaActual = LocalDateTime.now();
       var horaDeConsulta = datosAgendarConsulta.fecha();

       var diferenciaDe30Min = Duration.between(horaActual,horaDeConsulta).toMinutes()<30;

       if(diferenciaDe30Min){
            throw new ValidationException("Las consultas deben tener al menos 30 minutos de anticipacion");
       }

    }
}
