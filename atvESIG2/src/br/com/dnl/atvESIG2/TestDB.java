package br.com.dnl.atvESIG2;

import java.sql.ResultSet;

import br.com.dnl.atvESIG2.PostgreSQLConexao;
public class TestDB {

	public static void main(String[] args) throws UnsupportedClassVersionError{
		
		PostgreSQLConexao con = new PostgreSQLConexao();
		
		con.conectar();
		
		ResultSet res = con.query("INSERT INTO test(id, nome) VALUES(2, 'pfv')");
		
		con.desconectar();
		
	}

}
