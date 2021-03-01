package br.com.dnl.atvESIG2;

import java.sql.*;

public class PostgreSQLConexao {
	
	private String url;
	private String user;
	private String senha;
	private Connection c;
	private Statement statment;
	
	public PostgreSQLConexao() {
		this.url = "jdbc:postgresql://localhost:5432/atvESIG";
		this.user = "postgres";
		this.senha = "123";
		
	}
	
	public void conectar() {
		
		try {
			Class.forName("org.postgresql.Driver");
			setC(DriverManager.getConnection(url, user, senha));
			setStatment(getC().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY));
			
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		
		try {
			getC().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet query(String query){
		try {
			return getStatment().executeQuery(query);
			
		}catch (SQLException ex) {
			
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Connection getC() {
		return c;
	}

	public void setC(Connection c) {
		this.c = c;
	}

	public Statement getStatment() {
		return statment;
	}

	public void setStatment(Statement statment) {
		this.statment = statment;
	}
}
