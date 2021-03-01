package br.com.dnl.atvESIG2;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "buscarAtv")
public class BuscarAtv implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String responsavel; 
	private String prioridade; 
	private String deadline;
	private String descricao;

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
