package br.bliblioteca.livros.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LIVRO")
public class Livro implements Serializable {

    private static final long serialVersionUID = 5663066928725353351L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Min(10)
    @Column(name = "QUANTIDADEPAGINAS")
    private int quantidadePaginas;
    //eager faz completar os selects
    //lazy nao completa
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.MERGE)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(final int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(final Autor autor) {
        this.autor = autor;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

}
