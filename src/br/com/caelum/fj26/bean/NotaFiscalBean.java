package br.com.caelum.fj26.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.fj26.dao.DAO;
import br.com.caelum.fj26.model.Item;
import br.com.caelum.fj26.model.NotaFiscal;
import br.com.caelum.fj26.model.Produto;

@ManagedBean
@ViewScoped
public class NotaFiscalBean {

	private NotaFiscal notaFiscal = new NotaFiscal();
	
	private Item item = new Item();
	
	private Long produtoId;
	
	private List<NotaFiscal> notas;

	public void adicionaItem() {
		DAO<Produto> produtoDao = new DAO<Produto>(Produto.class);
		Produto produto = produtoDao.buscaPorId(produtoId);
		
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		item.setNotaFiscal(notaFiscal);
		notaFiscal.getItens().add(item);
		
		item = new Item();
	}
	
	public void cadastraNotaFiscal() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		this.notas = null;
		this.notaFiscal = new NotaFiscal();
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public List<NotaFiscal> getNotas() {
		if (notas == null) {
			DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
			notas = dao.buscaTodos();
		}
		return notas;
	}

	public void setNotas(List<NotaFiscal> notas) {
		this.notas = notas;
	}
}
