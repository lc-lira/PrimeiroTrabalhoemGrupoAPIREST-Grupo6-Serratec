package br.com.serratec.primeirotrabalho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.primeirotrabalho.model.Paciente;
import br.com.serratec.primeirotrabalho.repository.PacienteRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @DeleteMapping
    public void excluir(@PathVariable Long codigo){
        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);
            ResponseEntity.noContent();
        }
        ResponseEntity.notFound().build();
    }

}
