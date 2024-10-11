package br.org.serratec.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotBlank(message = "Está faltando o título, por favor adicione um título")
	@Size(min = 2, max = 50, message = "O Titulo precisa estar entre {min} à {max} caracteres")
	private String titulo;

	@Column
	@NotNull(message = "Quantidade de página precisam ser indicadas")
	private Integer qtdPaginas;

	@Embedded
	@Valid
	private Publicacao publicacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
