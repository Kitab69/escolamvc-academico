package br.senai.sp.escolamvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import java.sql.Date;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipo",
        length = 1,
        discriminatorType = DiscriminatorType.STRING
)
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O campo nome deve ser preenchido")
    private String nome;
    @NotEmpty(message = "O campo cpf deve ser preenchido")
    @CPF(message = "Digite um CPF valido!")
    private String cpf;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @NotEmpty(message = "O campo nome deve ser preenchido")
    @Email(message = "Digite um email valido!")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  String getNome() {
        return nome;
    }

    public void setNome( String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf( String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
