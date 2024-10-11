package br.org.serratec.domain;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Publicacao {
	
	@NotBlank(message = "Campo autor vazio, por favor preencha")
	@Size(min = 2, max = 40, message = "O nome do autor precisa estar entre {min} à {max} caracteres")
	private String autor;
	
	private LocalDate dataPublicacao;
	
	private String editora;

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
}
