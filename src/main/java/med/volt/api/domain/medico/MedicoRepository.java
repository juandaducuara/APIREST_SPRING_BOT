package med.volt.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio donde se guardan las consultas

public interface MedicoRepository extends JpaRepository<Medico,Long> {
    Page<Medico> findByActivoTrue(Pageable paginacion);
}
