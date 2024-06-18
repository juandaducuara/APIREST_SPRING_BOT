package med.volt.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratodorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
}
