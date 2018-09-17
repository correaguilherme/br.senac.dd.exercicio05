package br.senac.dd.exercicio05.model.bo;

import br.senac.dd.exercicio05.model.dao.FuncionarioDAO;
import br.senac.dd.exercicio05.model.vo.FuncionarioVO;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioBO {
    
        private FuncionarioDAO dao = new FuncionarioDAO();
        
	public boolean inserir(FuncionarioVO funcionario) {
            int idGerado = dao.inserir(funcionario);
            return idGerado > 0;
	}
	public FuncionarioVO buscarFuncionarioPorId(String textoId) {
            FuncionarioVO funcionarioBuscado = dao.obterPorId(Integer.parseInt(textoId));
            return funcionarioBuscado;
	}
        
        public List<FuncionarioVO> listarFuncionarios() {
		ArrayList<FuncionarioVO> funcionarios = dao.listarTodos();
		return funcionarios;
	}
        
	public boolean atualizar(FuncionarioVO funcionario) {
            boolean sucesso = dao.atualizar(funcionario);
            return sucesso;
	}
}
