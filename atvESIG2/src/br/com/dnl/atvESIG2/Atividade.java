package br.com.dnl.atvESIG2;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;

import org.postgresql.util.PSQLException;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@ManagedBean(name="atividade")
public class Atividade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String responsavel; 
	private String prioridade; 
	private String deadline;
	private String descricao;
	private List<String> resultList = new ArrayList<String>();
	
    private HtmlDataTable dataTable;

    public HtmlDataTable getDataTable() {
          return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
          this.dataTable = dataTable;
    }
	
	public Atividade (String Titulo,String Descricao,String Responsavel,String Prioridade,String Deadline) {
		this.titulo = Titulo;
		this.descricao = Descricao;
		this.responsavel = Responsavel;
		this.prioridade = Prioridade;
		this.deadline = Deadline;
	}
	public Atividade() {
		
	} 
	

	public String salvar() {
	
		PostgreSQLConexao con = new PostgreSQLConexao();
		con.conectar();
		
		ResultSet res = con.query(
				"INSERT INTO atividades(titulo, descricao, responsavel, prioridade, deadline, situacao) "
				+ "VALUES('"+getTitulo()+"','"+getDescricao()+"','"+getResponsavel()+"','"+getPrioridade()+"','"+getDeadline()+"','Em andamento')");
		
		con.desconectar();
		return "index";
	} 
	
	
	public void addList (String item) {
		resultList.add(item);
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<String> getResultList() {
		return resultList;
	}
	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}
	
}
