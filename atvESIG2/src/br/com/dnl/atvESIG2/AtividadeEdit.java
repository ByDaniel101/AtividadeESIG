package br.com.dnl.atvESIG2;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Edit")
@SessionScoped
public class AtividadeEdit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String titulo;
	private String responsavel; 
	private String prioridade; 
	private String deadline;
	private String descricao;
	private String situacao;
	private String idProcura;
	
	
	public String goId (String id) {
		
		setIdProcura(id);
		return "editar";
		
		
	}
	
	public String atualizarGo(String id) throws SQLException {
		
		System.out.println(id);
		String sql = "update Atividades SET id = " + getIdProcura();
		
		if(getTitulo() != "") {
			sql = sql + " , titulo = '"+ getTitulo()+"'";
					
		}
		
		if(getDescricao() != "") {
			
			sql = sql + " , descricao = '"+ getDescricao()+"'";
		}
		
		if(getResponsavel() != "") {
			sql = sql + " , responsavel = '"+getResponsavel()+"'";
			
		}
		
		if(getPrioridade() != "") {
			
			sql = sql + " , prioridade = '"+getPrioridade()+"'";
		}
		
		if(getSituacao() != "") {
			
			sql = sql + " , situacao = '"+getSituacao()+"'";
		}
		
		if(getDeadline() != "") {
			
			sql = sql + " , deadline = '"+getDeadline()+"'";
		}
		
		sql = sql + " WHERE id = " + getIdProcura();
		
		PostgreSQLConexao con = new PostgreSQLConexao();
		con.conectar();
		ResultSet res = con.query(sql);
		
		return "index";
	}

	
	public String excluir (String in) {
		
		PostgreSQLConexao con = new PostgreSQLConexao();
		con.conectar();
		ResultSet res = con.query("DELETE FROM Atividades WHERE id = " + in);
		
		
		return "index";
	}
	
	public String situacaoAtualizar(String in) {
		
		PostgreSQLConexao con = new PostgreSQLConexao();
		con.conectar();
		ResultSet res = con.query("UPDATE Atividades SET situacao = 'concluido' WHERE id = " + in);
		
		return "index";
	}
	
	public ResultSet findAll() throws SQLException{
		
		PostgreSQLConexao con = new PostgreSQLConexao();
		con.conectar();
		
		ResultSet res = con.query("SELECT * FROM Atividades WHERE id = "+ getIdProcura());
		
		con.desconectar();
		return res;
	}
	
	
	public String getIdProcura() {
		return idProcura;
	}


	public void setIdProcura(String id) {
		this.idProcura = id;
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
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
