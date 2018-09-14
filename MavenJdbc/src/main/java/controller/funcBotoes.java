package controller;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

import controller.AlunosJdbcDAO;
import controller.ProfessoresJdbcDAO;
import view.Telas;
import controller.CoordenadoresJdbcDAO;
import controller.InspetoresJdbcDAO;

public class funcBotoes extends Telas {

	public void salvar(){
		if(cbxTipoCadastro.getSelectedItem().equals("Aluno")){
			try {
				alunos.setNome(txtNome.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				if(rdbSexoM.isSelected()) {
					alunos.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					alunos.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.salvar(alunos);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(cbxTipoCadastro.getSelectedItem().equals("Professor")){
			try {
				professores.setNome(txtNome.getText());
				professores.setEndereco(txtEnd.getText());
				professores.setBairro(txtBairro.getText());
				professores.setRc(Integer.parseInt(txtRc.getText()));
				if(rdbSexoM.isSelected()) {
					professores.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					professores.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				ProfessoresJdbcDAO professoresJdbcDao = new ProfessoresJdbcDAO(connection);
				
				professoresJdbcDao.salvar(professores);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
		}else if(cbxTipoCadastro.getSelectedItem().equals("Coordenador")){
			try {
				coordenadores.setNome(txtNome.getText());
				coordenadores.setEndereco(txtEnd.getText());
				coordenadores.setBairro(txtBairro.getText());
				if(rdbSexoM.isSelected()) {
					coordenadores.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					coordenadores.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				CoordenadoresJdbcDAO coordenadoresJdbcDAO = new CoordenadoresJdbcDAO(connection);
				
				coordenadoresJdbcDAO.salvar(coordenadores);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
		}else {
			try {
				inspetores.setNome(txtNome.getText());
				inspetores.setEndereco(txtEnd.getText());
				inspetores.setBairro(txtBairro.getText());
				if(rdbSexoM.isSelected()) {
					inspetores.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					inspetores.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				InspetoresJdbcDAO inspetoresJdbcDao = new InspetoresJdbcDAO(connection);
				
				inspetoresJdbcDao.salvar(inspetores);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
		}	
	}
	public void deletar(){
		
		if(cbxTipoCadastro.getSelectedItem().equals("Aluno")){
			try {
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.deletar(Integer.parseInt(txtId.getText()));
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(cbxTipoCadastro.getSelectedItem().equals("Professor")){
			try {
				Connection connection = JdbUtil.getConnection();
				ProfessoresJdbcDAO professoresJdbcDao = new ProfessoresJdbcDAO(connection);
				
				professoresJdbcDao.deletar(Integer.parseInt(txtId.getText()));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(cbxTipoCadastro.getSelectedItem().equals("Coordenador")){
			try {
				Connection connection = JdbUtil.getConnection();
				CoordenadoresJdbcDAO coordenadoresJdbcDAO = new CoordenadoresJdbcDAO(connection);
				
				coordenadoresJdbcDAO.deletar(Integer.parseInt(txtId.getText()));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else {
			try {
				Connection connection = JdbUtil.getConnection();
				InspetoresJdbcDAO inspetoresJdbcDao = new InspetoresJdbcDAO(connection);
				
				inspetoresJdbcDao.deletar(Integer.parseInt(txtId.getText()));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public void atualizar(){
		if(cbxTipoCadastro.getSelectedItem().equals("Aluno")){
			try {
				alunos.setNome(txtNome.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				if(rdbSexoM.isSelected()) {
					alunos.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					alunos.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.alterar(alunos, Integer.parseInt(txtId.getText()));
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(cbxTipoCadastro.getSelectedItem().equals("Professor")){
			try {
				professores.setNome(txtNome.getText());
				professores.setEndereco(txtEnd.getText());
				professores.setBairro(txtBairro.getText());
				professores.setRc(Integer.parseInt(txtRc.getText()));
				if(rdbSexoM.isSelected()) {
					professores.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					professores.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				ProfessoresJdbcDAO professoresJdbcDao = new ProfessoresJdbcDAO(connection);
				
				professoresJdbcDao.alterar(professores, Integer.parseInt(txtId.getText()));
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
		}else if(cbxTipoCadastro.getSelectedItem().equals("Coordenador")){
			try {
				coordenadores.setNome(txtNome.getText());
				coordenadores.setEndereco(txtEnd.getText());
				coordenadores.setBairro(txtBairro.getText());
				if(rdbSexoM.isSelected()) {
					coordenadores.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					coordenadores.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				CoordenadoresJdbcDAO coordenadoresJdbcDAO = new CoordenadoresJdbcDAO(connection);
				
				coordenadoresJdbcDAO.alterar(coordenadores, Integer.parseInt(txtId.getText()));
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
		}else {
			try {
				inspetores.setNome(txtNome.getText());
				inspetores.setEndereco(txtEnd.getText());
				inspetores.setBairro(txtBairro.getText());
				if(rdbSexoM.isSelected()) {
					inspetores.setSexo("Masculino");
				}else if(rdbSexoF.isSelected()) {
					inspetores.setSexo("Feminino");
				}
				
				Connection connection = JdbUtil.getConnection();
				InspetoresJdbcDAO inspetoresJdbcDao = new InspetoresJdbcDAO(connection);
				
				inspetoresJdbcDao.alterar(inspetores, Integer.parseInt(txtId.getText()));
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			
		}
		
	}
	public static void retornar(){
		Telas tela = new Telas();
		while (tela.tabela.getRowCount() > 0) {
			tela.tabela.removeRow(0);
	     }
		 try {
			 Connection connection = JdbUtil.getConnection();
			 AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
			 alunosJdbcDao.listar();
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	}
}	
