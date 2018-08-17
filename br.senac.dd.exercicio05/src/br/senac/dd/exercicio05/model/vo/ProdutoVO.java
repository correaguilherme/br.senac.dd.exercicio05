package br.senac.dd.exercicio05.model.vo;

public class ProdutoVO {
	
	private int id;
	private String nome;
	private String fabricante;
	private double valor;
	private double peso;
	
	public ProdutoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoVO(String nome, String fabricante, double valor, double peso, int id) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.valor = valor;
		this.peso = peso;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	

}
