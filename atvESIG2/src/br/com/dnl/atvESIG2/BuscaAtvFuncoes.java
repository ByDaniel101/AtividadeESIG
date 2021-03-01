package br.com.dnl.atvESIG2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class BuscaAtvFuncoes {
	
	@ManagedProperty(value = "BuscaBean") 
	BuscaAtividadeBean BuscaBean;
	
	public int test() {
		
		return getBuscaBean().getNumero();
	}
	
	public BuscaAtividadeBean getBuscaBean() {
		return BuscaBean;
	}

	public void setBuscaBean(BuscaAtividadeBean buscaBean) {
		BuscaBean = buscaBean;
	}
	
	
}
