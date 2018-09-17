package br.senac.dd.exercicio05.controller;

import br.senac.dd.exercicio05.model.bo.FuncionarioBO;
import br.senac.dd.exercicio05.model.vo.FuncionarioVO;
import java.util.List;

public class FuncionarioController {
    
    private FuncionarioBO bo = new FuncionarioBO();
    
    public String salvar(FuncionarioVO funcionario) {
              
        String validacao = validarFuncionario(funcionario);

        if(validacao.equals("")) {
            if(funcionario.getIdFuncionario() > 0) {
                //UPDATE
                if(bo.atualizar(funcionario)) {
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
                }
            }else{
                //INSERT
                if(bo.inserir(funcionario)) {
                    validacao = "Funcion�rio salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcion�rio";
                }
            }
        }
        return validacao;
    }
        
        public String atualizar(FuncionarioVO funcionario) {
              
        String validacao = validarFuncionario(funcionario);

        if(validacao.equals("")) {
            if(funcionario.getIdFuncionario() > 0) {
               
                if(bo.atualizar(funcionario)) {
                    validacao = "Funcion�rio atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcion�rio";
                }
            }
        }
        return validacao;
    }
        
        public List<FuncionarioVO> listarTodosFuncionarios(){
		return bo.listarFuncionarios();
	}
        
        

	private String validarFuncionario(FuncionarioVO funcionario) {
		String validacao = "";

		if(funcionario == null) {
                    validacao = "Funcion�rio est� NULO!";
		}else {
                    //Validar o preenchimento
                    if(funcionario.getNome().trim().equals("")) {
                        validacao += "- Nome � obrigat�rio \n";
                    }
                    if(funcionario.getCpf().trim().equals("")) {
                        validacao += "- CPF � obrigat�rio \n";
                    }
		}
		return validacao;
	}

}
