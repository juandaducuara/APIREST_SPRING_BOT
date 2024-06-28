package med.volt.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

//Repositorio donde se guardan las consultas

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);

    @Query("""
            SELECT m FROM Medico m
            WHERE m.activo = true
            AND m.especialidad = :especialidad
            AND m.id NOT IN (
                SELECT c.medico.id FROM Consulta c
                WHERE c.fecha = :fecha
            )
            ORDER BY RAND()
            LIMIT 1
            """)
    Medico asignarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);

    @Query("""
            select m.activo
            from Medico m
            where m.id=:idMedico 
            """)
    Boolean findActivoById(Long idMedico);
}
