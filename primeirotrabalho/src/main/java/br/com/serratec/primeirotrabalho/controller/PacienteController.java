package br.com.serratec.primeirotrabalho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.primeirotrabalho.model.Paciente;
import br.com.serratec.primeirotrabalho.repository.PacienteRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public Paciente inserir(@RequestBody @Valid Paciente paciente) {
        return repository.save(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> alterar(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        Optional<Paciente> pacienteOptional = repository.findById(id);

        if (pacienteOptional.isPresent()) {
            paciente.setCodigo(id);
            return ResponseEntity.ok(repository.save(paciente));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Paciente> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
    Optional<Paciente> pacienteOptional = repository.findById(id);

    if (pacienteOptional.isPresent()) {
        return ResponseEntity.ok(pacienteOptional.get());
    }

    return ResponseEntity.notFound().build();
    }

}
