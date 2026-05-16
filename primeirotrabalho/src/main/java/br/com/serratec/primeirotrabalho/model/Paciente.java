package br.com.serratec.primeirotrabalho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente extends Pessoa {
    public Paciente() {
        super();
    }

    public Paciente(Long codigo, String nome, String email, String telefone) {
        super(codigo, nome, email, telefone);
    }
}
