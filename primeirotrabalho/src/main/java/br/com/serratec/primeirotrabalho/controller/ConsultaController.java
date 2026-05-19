package br.com.serratec.primeirotrabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.primeirotrabalho.model.Consulta;
import br.com.serratec.primeirotrabalho.model.Medico;
import br.com.serratec.primeirotrabalho.model.Paciente;
import br.com.serratec.primeirotrabalho.repository.ConsultaRepository;
import br.com.serratec.primeirotrabalho.repository.MedicoRepository;
import br.com.serratec.primeirotrabalho.repository.PacienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<Consulta> inserir(@Valid @RequestBody Consulta consulta) {
        Long pacienteId = consulta.getPaciente().getCodigo();
        Long medicoId = consulta.getMedico().getCodigo();

        Optional<Paciente> pacienteOptional = pacienteRepository.findById(pacienteId);
        Optional<Medico> medicoOptional = medicoRepository.findById(medicoId);

        if (pacienteOptional.isEmpty() || medicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        consulta.setPaciente(pacienteOptional.get());
        consulta.setMedico(medicoOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(consulta));
    }

    @GetMapping
        public List<Consulta> listar() {
            return repository.findAll();
    }

    @PutMapping("{id}")
    public ResponseEntity<Consulta> alterar(@Valid @RequestBody Consulta consulta, @PathVariable Long id) {
        Optional<Consulta> consultaOptional = repository.findById(id);
        if (consultaOptional.isPresent()) {
            return ResponseEntity.ok(repository.save(consulta));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
