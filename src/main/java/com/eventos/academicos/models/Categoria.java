package com.eventos.academicos.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    /// ONE TO MANY (1 - *)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Atividade> atividades = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
