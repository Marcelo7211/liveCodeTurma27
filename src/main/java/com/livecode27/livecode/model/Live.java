package com.livecode27.livecode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Palavras de Nubia -> Entidade é basicamente uma classe que irá virar uma tabela no
 * banco de dados =) 
 * */


@Entity
@Table(name = "tb_live")
public class Live {
	
	@Id //Vira uma chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerando auto increment na chave primária
	private long id;
	
	@NotBlank(message = "O campo não pode ser vazio ou nulo")  // nulo e nem " "
	@Size(min = 2, max = 100, message = "Tamanho minumo de 2 e maximo de 100 caracteres" ) //Define uma quantidade minima e maxima de caracteres 
	private String nome;
	
	@Min(value = 18, message = "Idade minima 18 anos") // Defino um valor numerio minimo (tambem podemos usar o @Max)
	private int idade;
	
	private boolean ativo;	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
