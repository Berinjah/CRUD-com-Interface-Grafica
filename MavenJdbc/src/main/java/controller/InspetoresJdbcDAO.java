package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Inspetores;

public class InspetoresJdbcDAO {

	private Connection conn;
	List<Inspetores> inspetores = new ArrayList<Inspetores>();
	
	public InspetoresJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Inspetores c) throws SQLException{
		String sql="insert into inspetores (nome, endereco, bairro, sexo) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException{
		String sql = "delete from inspetores where ri = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Inspetores c, int id) {
		String sql = "update inspetores set nome = '"+c.getNome()+"', endereco = '"+c.getEndereco()+"', bairro = '"+c.getBairro()+"', sexo='"+c.getSexo()+"'where ri = '"+id+"';";
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
	
	public List<Inspetores> listar(){
		String sql = "select * from inspetores";
		System.out.println(sql);
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				System.out.println("ri="+rs.getInt("ri")+" nome="+rs.getString("nome")+" endereco="+rs.getString("endereco")+" bairro="+rs.getString("bairro")+" sexo="+rs.getString("sexo"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return inspetores;
	}
}