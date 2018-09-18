package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professores;

public class ProfessoresJdbcDAO {
	
	private Connection conn;
	List<Professores> professores = new ArrayList<Professores>();
	
	public ProfessoresJdbcDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar (Professores c) throws SQLException{
		String sql="insert into professores (nome, endereco, bairro, rc, sexo) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getRc()+"','"+c.getSexo()+"')"; 
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException{
		String sql = "delete from professores where rp = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Professores c, int id) {
		String sql = "update professores set nome = '"+c.getNome()+"', endereco = '"+c.getEndereco()+"', bairro = '"+c.getBairro()+"', rc = '"+c.getRc()+"', sexo='"+c.getSexo()+"'where rp = '"+id+"';";
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
	
	public List<Professores> listar(){
		String sql = "select * from professores";
		System.out.println(sql);
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				System.out.println("rp="+rs.getInt("rp")+" nome="+rs.getString("nome")+" endereco="+rs.getString("endereco")+" bairro="+rs.getString("bairro")+" sexo="+rs.getString("sexo")+" rc="+rs.getInt("rc"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return professores;
	}
}

