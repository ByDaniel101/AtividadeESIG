package br.com.dnl.atvESIG2;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "BuscaBean")
public class BuscaAtividadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int numero;
	private String descricao;
	private String responsavel;
	private String situacao;
	
	private Atividade atv = new Atividade();
	private String sqlComand;
	
	public String sqlAjust() {
		
		String sql = "SELECT * FROM Atividades WHERE deadline != '' ";
		
		if(getNumero() > 0) {
			sql = sql + " and id = " + getNumero();
			
		}
		
		if(getDescricao() != null && getDescricao() != "") {
			sql = sql + " and (titulo = '"+getDescricao()+"' or descricao = '"+getDescricao()+"')";
			
		}
		
		if(getResponsavel() != "") {
			sql = sql + " and responsavel = '"+getResponsavel()+"'";
		}
		
		if(getSituacao() != "") {
			sql = sql + " and situacao = '"+ getSituacao()+"'";
			
		}
		
		setSqlComand(sql);
		
		return "";
	}
	
	public String sqlAjustDefault() {

		setSqlComand("SELECT * FROM Atividades order by id");
		
		return "";
	}
	
	public ResultSet findAll() throws SQLException{
		
		if(getSqlComand() == null) {
			
			setSqlComand("SELECT * FROM Atividades order by id");
		}
		
		PostgreSQLConexao con = new PostgreSQLConexao();
		con.conectar();
		
		ResultSet res = con.query(getSqlComand());
		
		con.desconectar();
		return res;
	}
	
	
	public String index() {
		return "index";
	}
	
	//gets and sets
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Atividade getAtv() {
		return atv;
	}
	public void setAtv(Atividade atv) {
		this.atv = atv;
	}
	public String getSqlComand() {
		return sqlComand;
	}
	public void setSqlComand(String sqlComand) {
		this.sqlComand = sqlComand;
	}		
}