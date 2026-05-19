package br.com.serratec.primeirotrabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.serratec.primeirotrabalho.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
