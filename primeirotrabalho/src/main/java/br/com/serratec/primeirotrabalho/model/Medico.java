package br.com.serratec.primeirotrabalho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_medico")
public class Medico extends Pessoa {

    private Long crm;
    private String especialidade;

    // Getters e Setters
    @Override
    public Long getCodigo() { return codigo; }
    @Override
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public Long getCrm() { return crm; }
    public void setCrm(Long crm) { this.crm = crm; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}