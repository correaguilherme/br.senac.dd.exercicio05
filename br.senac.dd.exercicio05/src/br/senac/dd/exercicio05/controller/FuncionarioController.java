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
                    validacao = "Funcionário atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcionário";
                }
            }else{
                //INSERT
                if(bo.inserir(funcionario)) {
                    validacao = "Funcionário salvo com sucesso!";
                }else {
                    validacao = "Erro ao salvar funcionário";
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
                    validacao = "Funcionário atualizado com sucesso!";
                }else {
                    validacao = "Erro ao atualizar funcionário";
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
                    validacao = "Funcionário está NULO!";
		}else {
                    //Validar o preenchimento
                    if(funcionario.getNome().trim().equals("")) {
                        validacao += "- Nome é obrigatório \n";
                    }
                    if(funcionario.getCpf().trim().equals("")) {
                        validacao += "- CPF é obrigatório \n";
                    }
		}
		return validacao;
	}

}
