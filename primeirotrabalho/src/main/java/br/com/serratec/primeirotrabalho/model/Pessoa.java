package br.com.serratec.primeirotrabalho.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass 
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long codigo;

    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(max = 60, message = "O nome deve ter no máximo 60 caracteres")
    private String nome;

    @Email(message = "O e-mail deve ser válido")
    private String email;

    @NotBlank(message = "O telefone não pode ser nulo ou vazio")
    @Size(max = 11, message = "O telefone deve ter no máximo 11 caracteres")
    @Pattern(regexp = "\\d+", message = "O telefone deve conter apenas números") 
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(Long codigo, String nome, String email, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}