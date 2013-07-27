package br.com.caelum.fj26.bean;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.fj26.dao.DAO;
import br.com.caelum.fj26.model.NotaFiscal;

public class DataModelNotaFiscal extends LazyDataModel<NotaFiscal> {

	private static final long serialVersionUID = 1L;
	
	@Override
	public List<NotaFiscal> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		
		return dao.listaTodosPaginada(first, pageSize);
	}

}
