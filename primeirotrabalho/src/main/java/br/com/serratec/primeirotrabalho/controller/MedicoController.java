package br.com.serratec.primeirotrabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.primeirotrabalho.model.Medico;
import br.com.serratec.primeirotrabalho.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository MedicoRepository;

    // Método para inserir um médico 
    @PostMapping
    public ResponseEntity<Medico> inserir(@Valid @RequestBody Medico medico) {
        Medico novoMedico = MedicoRepository.save(medico);
        return new ResponseEntity<>(novoMedico, HttpStatus.CREATED);
    }

    // Método para listar todos os médicos 
    @GetMapping
    public ResponseEntity<List<Medico>> listarTodos() {
        List<Medico> medicos = MedicoRepository.findAll();
        return ResponseEntity.ok(medicos);
    }
}
