package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view.App;
import view.Telas;
import model.Alunos;

public class AlunosJdbcDAO {

	private Connection conn;
	
	public AlunosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void salvar (Alunos c) throws SQLException{
		String sql="insert into alunos (nome, endereco, bairro, sexo) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getSexo()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void deletar (int id) throws SQLException{
		String sql = "delete from alunos where rm = '"+id+"'";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public void alterar(Alunos c, int id) {
		String sql = "update alunos set nome = '"+c.getNome()+"', endereco = '"+c.getEndereco()+"', bairro = '"+c.getBairro()+"', sexo='"+c.getSexo()+"' where rm= "+id+";";
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
	
	public List<Alunos> listar(){
		String sql = "select * from alunos";
		System.out.println(sql);
		List<Alunos> listaAlunos = new ArrayList<Alunos>();
		  	try {
			  	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			  	ResultSet rs = prepareStatement.executeQuery();
			  	while(rs.next()) {
					
					Telas.alunos.setRm(rs.getInt("rm"));
					Telas.alunos.setNome(rs.getString("nome"));
					Telas.alunos.setEndereco(rs.getString("endereco"));
					Telas.alunos.setBairro(rs.getString("bairro"));
					Telas.alunos.setSexo(rs.getString("sexo"));
					
					listaAlunos.add(Telas.alunos);
					
					
					Telas.tabela.addRow(new Object[] {Telas.alunos.getRm(), Telas.alunos.getNome(),  
							Telas.alunos.getEndereco(), Telas.alunos.getBairro(), Telas.alunos.getSexo()});
										
					System.out.println(Telas.alunos.getRm());
					System.out.println("id="+rs.getInt("rm")+" nome="+rs.getString("nome")+" endereco="+rs.getString("endereco")+" bairro="+rs.getString("bairro")+" sexo="+rs.getString("sexo"));
				}
			  	prepareStatement.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}	
		   	return listaAlunos;		
	}
}
