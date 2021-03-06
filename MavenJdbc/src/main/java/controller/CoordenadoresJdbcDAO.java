package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Coordenadores;

public class CoordenadoresJdbcDAO {

	private Connection conn;
	List<Coordenadores> coordenadores = new ArrayList<Coordenadores>();
	
	public CoordenadoresJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Coordenadores c) throws SQLException{
		String sql="insert into coordenadores (nome, endereco, bairro, sexo) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException{
		String sql = "delete from coordenadores where rc = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Coordenadores c, int id) {
		String sql = "update coordenadores set nome = '"+c.getNome()+"', endereco = '"+c.getEndereco()+"', bairro = '"+c.getBairro()+"', sexo='"+c.getSexo()+"'where rc = '"+id+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Coordenadores> listar(){
		String sql = "select * from coordenadores";
		System.out.println(sql);
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				System.out.println("rc="+rs.getInt("rc")+" nome="+rs.getString("nome")+" endereco="+rs.getString("endereco")+" bairro="+rs.getString("bairro")+" sexo="+rs.getString("sexo"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return coordenadores;
	}
}