package br.senac.dd.exercicio05.model.vo;

public class FuncionarioVO {

	private int idFuncionario;
	private String nome;
	private double salario;
	private String cpf;
	
	public FuncionarioVO() {
		
	}
	
	public FuncionarioVO(String nome, double salario, String cpf, int idFuncionario) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.cpf = cpf;
		this.idFuncionario = idFuncionario;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
