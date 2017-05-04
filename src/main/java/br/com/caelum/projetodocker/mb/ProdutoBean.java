package br.com.caelum.projetodocker.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.projetodocker.dao.ProdutoDao;
import br.com.caelum.projetodocker.modelo.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos;

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			ProdutoDao dao = new ProdutoDao();
			this.produtos = dao.listaTodos();
		}

		return this.produtos;
	}

	public void grava() {
		ProdutoDao dao = new ProdutoDao();
		if (produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}

	public void remove(Produto produto) {
		ProdutoDao dao = new ProdutoDao();
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

}
