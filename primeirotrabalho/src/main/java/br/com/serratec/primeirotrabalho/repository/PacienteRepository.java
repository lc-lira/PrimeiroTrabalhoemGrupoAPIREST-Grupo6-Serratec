package br.com.serratec.primeirotrabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.primeirotrabalho.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
