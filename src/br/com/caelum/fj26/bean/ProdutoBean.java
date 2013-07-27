package br.com.caelum.fj26.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.fj26.dao.DAO;
import br.com.caelum.fj26.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	private double total;
	
	public ProdutoBean() {
		System.out.println("Criando..");
	}
	
	public void cadastrar() {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		if (produto.getId() != null)
			dao.atualiza(produto);
		else 
			dao.adiciona(produto);
		this.produto = new Produto();
		this.produtos = null;
	}

	public List<Produto> getLista() {
		if (this.produtos == null) {
			DAO<Produto> dao = new DAO<Produto>(Produto.class);
			this.produtos = dao.buscaTodos();
		}
		return produtos;
	}
	
	public void remove(Produto produto) {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = null;
	}
	
	public void comecaComMaiuscula(FacesContext fc, UIComponent uiComponent, Object object) throws ValidatorException {
		String nome = (String) object;
		
		if (!nome.matches("[A-Z].*")) {
			throw new ValidatorException(new FacesMessage("O nome deve começar com maiúscula"));
		}
	}
	
	public void edita(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getTotal() {
		if (this.produtos != null) {
			this.total = 0;
			for (Produto p : this.produtos) {
				this.total += p.getPreco();
			}
		}
		return total;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
