package br.com.caelum.fj26.bean;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.fj26.dao.DAO;
import br.com.caelum.fj26.model.NotaFiscal;

@ManagedBean
public class ListagemNotaFiscalBean {

	private LazyDataModel<NotaFiscal> dataModel;
	
	public ListagemNotaFiscalBean() {
		this.dataModel = new DataModelNotaFiscal();
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		int contaTodos = dao.contaTodos();

		this.dataModel.setRowCount(contaTodos);
	}
	
	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
	
}
