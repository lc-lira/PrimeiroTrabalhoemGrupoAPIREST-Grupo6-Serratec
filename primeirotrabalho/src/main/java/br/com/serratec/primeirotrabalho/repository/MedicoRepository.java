package br.com.serratec.primeirotrabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.primeirotrabalho.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Não precisa de nenhum método escrito aqui dentro! 
    // O JpaRepository já te dá o save, o findAll, o delete e muito mais de graça.
}