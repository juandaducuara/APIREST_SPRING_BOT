package med.volt.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

//Repositorio donde se guardan las consultas

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    Boolean existsByPacienteIdAndFechaBetween(Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);

    Boolean existsByMedicoIdAndFecha(Long aLong, LocalDateTime fecha);
}
