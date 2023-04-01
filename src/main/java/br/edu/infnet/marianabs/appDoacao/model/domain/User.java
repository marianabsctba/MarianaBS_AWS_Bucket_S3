package br.edu.infnet.marianabs.appDoacao.model.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "idEndereco")
    private Address endereco;
    private String arquivoUrl;

    public User(){

    }

    public User(String nome, String email, String telefone, Address endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getEndereco() {
        return endereco;
    }

    public void setEndereco(Address endereco) {
        this.endereco = endereco;
    }

    public String getArquivoUrl() {
        return arquivoUrl;
    }

    public void setArquivoUrl(String arquivoUrl) {
        this.arquivoUrl = arquivoUrl;
    }
}
