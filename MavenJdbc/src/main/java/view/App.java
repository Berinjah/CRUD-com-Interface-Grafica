package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class App extends JFrame{

	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("Nome: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("Endereço: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("Bairro: ");
	
	JComboBox cbxTipoCadastro = new JComboBox();
	JLabel tipo = new JLabel ("Tipo de cadastro:");
	
	JRadioButton rdbSexoM = new JRadioButton();
	JRadioButton rdbSexoF = new JRadioButton();
	JLabel sexo = new JLabel ("Sexo:");
	JLabel sexoM = new JLabel ("Masc.");
	JLabel sexoF = new JLabel ("Femin.");

	JButton btnSalvar = new JButton("Salvar");

	public App(){
		super("Cadastro Alunos");
		
		Container paine = this.getContentPane();
		
		
		
		paine.add(nome);
		paine.add(txtNome);	
		nome.setBounds(10, 15, 45, 30);
		txtNome.setBounds(115, 15, 225, 30);
		
		paine.add(end);
		paine.add(txtEnd);	
		end.setBounds(10, 50, 70, 30);
		txtEnd.setBounds(115, 50, 225, 30);	
		
		paine.add(bairro);
		paine.add(txtBairro);	
		bairro.setBounds(10, 85, 70, 30);
		txtBairro.setBounds(115, 85, 225, 30);
		
		paine.add(cbxTipoCadastro);
		paine.add(tipo);
		cbxTipoCadastro.addItem("Aluno");
		cbxTipoCadastro.addItem("Professor");
		cbxTipoCadastro.addItem("Coordenador");
		cbxTipoCadastro.addItem("Inspetor");
		tipo.setBounds(10, 125, 100, 30);
		cbxTipoCadastro.setBounds(115, 125, 225, 30);
		
		paine.add(rdbSexoM);
		paine.add(rdbSexoF);
		paine.add(sexo);
		paine.add(sexoM);
		paine.add(sexoF);
		sexo.setBounds(10, 180, 70, 30);
		rdbSexoM.setBounds(120, 185, 20, 15);
		rdbSexoF.setBounds(180, 185, 20, 15);
		sexoM.setBounds(115, 190, 50, 30);
		sexoF.setBounds(175, 190, 50, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(250, 250, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				Alunos alunos = new Alunos();
				alunos.setNome(txtNome.getText());
				alunos.setEndereco(txtEnd.getText());
				alunos.setBairro(txtBairro.getText());
				
				Connection connection = JdbUtil.getConnection();
				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
				
				alunosJdbcDao.salvar(alunos);
				
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(600, 330);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
		public static void main(String[] args) {
			
			App app = new App();			
//			Alunos alunos = new Alunos();
//			
//			try {
//				alunos.setNome("Manu Cardoso");
//										
//				Connection connection = JdbUtil.getConnection();
//				AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
//				
//				alunosJdbcDao.salvar(alunos);
//				//alunosJdbcDao.deletar(2);
//				//alunosJdbcDao.alterar(alunos, 2);
//				//alunosJdbcDao.listar();
//			}catch(Exception e) {
//				e.printStackTrace();
//		}
	}
}
