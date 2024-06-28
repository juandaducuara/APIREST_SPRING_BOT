package med.volt.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.volt.api.domain.consulta.AgendaDeConsultaService;
import med.volt.api.domain.consulta.DatosAgendarConsulta;
import med.volt.api.domain.consulta.DatosDetalleConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService agendarConsultaServie;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleConsulta> agendar(@RequestBody @Valid DatosAgendarConsulta datosAgendarConsulta) {
        var response = agendarConsultaServie.agendarConsulta(datosAgendarConsulta);
        return ResponseEntity.ok(response);
    }
}
