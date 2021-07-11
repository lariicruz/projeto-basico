package com.projeto.basico.projetobasico.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // diz que é uma tabela
@Table(name="tb_usuario") // como vai ser o nome da tabela
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "txt_nome") // como é o nome na tabela
    @NotNull(message = "O campo nome é Obrigatório")
    @Size(min=3,max = 150,message = "Tamanho Inválido")
    private String nome;
    private String email;
    private String senha;


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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;

    }
}

