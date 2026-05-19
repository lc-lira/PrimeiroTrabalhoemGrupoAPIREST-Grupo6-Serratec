package br.com.serratec.primeirotrabalho.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

}
