package br.senac.dd.exercicio05.model.bo;

import br.senac.dd.exercicio05.model.dao.ProdutoDAO;
import br.senac.dd.exercicio05.model.vo.ProdutoVO;

public class ProdutoBO {
	
	ProdutoDAO dao = new ProdutoDAO();
	public boolean inserir(ProdutoVO produto) {
		int idGerado = dao.inserir(produto);
		return idGerado > 0;
	}
	public ProdutoVO buscarProdutoPorId(String textoId) {
		ProdutoVO produtoBuscado = dao.obterPorId(Integer.parseInt(textoId));
		return produtoBuscado;
	}
	public boolean atualizar(ProdutoVO produto) {
		boolean sucesso = dao.atualizar(produto);
		return sucesso;
	}

}
