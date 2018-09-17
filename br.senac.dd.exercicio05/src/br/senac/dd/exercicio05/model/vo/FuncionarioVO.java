package br.senac.dd.exercicio05.model.vo;

public class FuncionarioVO {

	private int idFuncionario;
	private String nome;
        private String cpf;
	private double salario;
	
	public FuncionarioVO() {
		
	}
	
	public FuncionarioVO(int idFuncionario, String nome, String cpf, double salario) {
		super();
                this.idFuncionario = idFuncionario;
		this.nome = nome;
                this.cpf = cpf;
		this.salario = salario;
			
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
