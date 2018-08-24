package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class App extends JFrame{

	JLabel selecaoFuncao = new JLabel ("Selecione o que você quer fazer");
	JButton btnSalvar = new JButton("Salvar");
	JButton btnDeletar = new JButton("Deletar");
	JButton btnAtualizar = new JButton("Atualizar");
	JButton btnListar = new JButton("Listar");
	
	JTextField txtId = new JTextField();
	
	JTextField txtNome = new JTextField();
	JLabel nome = new JLabel("Nome: ");
	
	JTextField txtEnd = new JTextField();
	JLabel end = new JLabel("Endereço: ");
	
	JTextField txtBairro = new JTextField();
	JLabel bairro = new JLabel("Bairro: ");
	
	JTextField txtRc = new JTextField();
	JLabel rc = new JLabel("RC (Registro do coordenador): ");
	
	JComboBox cbxTipoCadastro = new JComboBox();
	JLabel tipo = new JLabel ("Tipo de cadastro:");
	
	JRadioButton rdbSexoM = new JRadioButton();
	JRadioButton rdbSexoF = new JRadioButton();
	JLabel sexo = new JLabel ("Sexo:");
	JLabel sexoM = new JLabel ("Masc.");
	JLabel sexoF = new JLabel ("Femin.");

	public App(){
		super("CRUD");
		
		Container paine = this.getContentPane();
		final JDesktopPane desktop = new JDesktopPane();
		paine.add(desktop);
				
		desktop.setLayout(null);
		desktop.add(cbxTipoCadastro);
		desktop.add(tipo);
		cbxTipoCadastro.addItem("Aluno");
		cbxTipoCadastro.addItem("Professor");
		cbxTipoCadastro.addItem("Coordenador");
		cbxTipoCadastro.addItem("Inspetor");
		tipo.setBounds(70, 10, 100, 30);
		cbxTipoCadastro.setBounds(70, 40, 100, 30);
		
		desktop.add(selecaoFuncao);
		desktop.add(btnSalvar);
		desktop.add(btnDeletar);
		desktop.add(btnAtualizar);
		desktop.add(btnListar);
		selecaoFuncao.setBounds(25, 100, 200, 20);
		btnSalvar.setBounds(10, 120, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame jif = new JInternalFrame("Novo cadastro");
			
				JButton btn = new JButton("Cadastrar");
				
				jif.add(nome);
				jif.add(txtNome);	
				nome.setBounds(10, 15, 45, 30);
				txtNome.setBounds(115, 15, 225, 30);
				
				jif.add(end);
				jif.add(txtEnd);	
				end.setBounds(10, 50, 70, 30);
				txtEnd.setBounds(115, 50, 225, 30);	
				
				jif.add(bairro);
				jif.add(txtBairro);	
				bairro.setBounds(10, 85, 70, 30);
				txtBairro.setBounds(115, 85, 225, 30);
				
				jif.add(rdbSexoM);
				jif.add(rdbSexoF);
				jif.add(sexo);
				jif.add(sexoM);
				jif.add(sexoF);
				sexo.setBounds(10, 145, 70, 30);
				rdbSexoM.setBounds(120, 150, 20, 15);
				rdbSexoF.setBounds(180, 150, 20, 15);
				sexoM.setBounds(115, 155, 50, 30);
				sexoF.setBounds(175, 155, 50, 30);
				if(cbxTipoCadastro.getSelectedItem().equals("Professor")) {
					jif.setSize(400, 350);
					
					jif.add(txtRc);
					jif.add(rc);
					rc.setBounds(10, 185, 300, 20);
					txtRc.setBounds(10, 215, 225, 30);
					jif.add(btn);
					btn.setBounds(120, 270, 100, 30);
				}else {
					jif.setSize(400, 300);
					jif.add(btn);
					btn.setBounds(120, 210, 100, 30);
				}			
				jif.setLayout(null);
				jif.setClosable(true);
				jif.setVisible(true);
				desktop.add(jif);
			}
		});
		
		btnDeletar.setBounds(125, 120, 100, 30);
		btnDeletar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JInternalFrame jif = new JInternalFrame("Deletar dados");
				
				JButton btn = new JButton("Deletar");
				
				JLabel informarId = new JLabel ("Informe o ID para excluir o cadastro");
				JTextField txtId = new  JTextField();
				
				jif.add(informarId);
				jif.add(txtId);
				informarId.setBounds(15, 30, 220, 15);
				txtId.setBounds(40, 60, 150, 25);
				jif.add(btn);
				btn.setBounds(70, 100, 80, 30);
				
				jif.setLayout(null);
				jif.setSize(250, 200);
				jif.setClosable(true);
				jif.setVisible(true);
				desktop.add(jif);
			}
		});
		
		btnAtualizar.setBounds(10, 170, 100, 30);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame jif = new JInternalFrame("Atualizar dados");
				
				JButton btn = new JButton("Atualizar");
				
				JLabel id = new JLabel ("Selecione o ID para alteração:"); 
				
				jif.add(nome);
				jif.add(txtNome);	
				nome.setBounds(10, 15, 45, 30);
				txtNome.setBounds(115, 15, 225, 30);
				
				jif.add(end);
				jif.add(txtEnd);	
				end.setBounds(10, 50, 70, 30);
				txtEnd.setBounds(115, 50, 225, 30);	
				
				jif.add(bairro);
				jif.add(txtBairro);	
				bairro.setBounds(10, 85, 70, 30);
				txtBairro.setBounds(115, 85, 225, 30);
				
				jif.add(rdbSexoM);
				jif.add(rdbSexoF);
				jif.add(sexo);
				jif.add(sexoM);
				jif.add(sexoF);
				sexo.setBounds(10, 145, 70, 30);
				rdbSexoM.setBounds(120, 150, 20, 15);
				rdbSexoF.setBounds(180, 150, 20, 15);
				sexoM.setBounds(115, 155, 50, 30);
				sexoF.setBounds(175, 155, 50, 30);
				
				jif.add(id);
				jif.add(txtId);
				id.setBounds(10, 200, 250, 30);
				txtId.setBounds(10, 240, 225, 30);
				if(cbxTipoCadastro.getSelectedItem().equals("Professor")) {
					jif.setSize(400, 450);
					
					jif.add(txtRc);
					jif.add(rc);
					rc.setBounds(10, 280, 300, 20);
					txtRc.setBounds(10, 305, 225, 30);
					jif.add(btn);
					btn.setBounds(120, 355, 100, 30);
				}else {
					jif.setSize(400, 400);
					jif.add(btn);
					btn.setBounds(120, 290, 100, 30);
				}
				jif.setLayout(null);
				jif.setClosable(true);
				jif.setVisible(true);
				desktop.add(jif);
				
			}
		});
		
		btnListar.setBounds(125, 170, 100, 30);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame jif = new JInternalFrame("Listar cadastros");
				
				JButton btn = new JButton("Listar");
				
				JLabel id = new JLabel ("Selecione por ID:"); 
				JLabel nome = new JLabel ("Selecione por nome:"); 
				
				DefaultTableModel tabela = new DefaultTableModel();
				
				JTable table = new JTable(tabela);
				
				jif.add(id);
				jif.add(txtId);	
				id.setBounds(10, 20, 200, 20);
				txtId.setBounds(10, 50, 225, 20);
				
				jif.add(nome);
				jif.add(txtNome);	
				nome.setBounds(10, 80, 200, 20);
				txtNome.setBounds(10, 110, 225, 20);
	
				tabela.addColumn("ID");
				tabela.addColumn("Nome");
				tabela.addColumn("Endereço");
				tabela.addColumn("Bairro");
				tabela.addColumn("Sexo");
				
				jif.add(btn);
				btn.setBounds(120, 370, 100, 30);
				
				JScrollPane scrollPane = new JScrollPane(table);
				jif.add(scrollPane);
				
				if(cbxTipoCadastro.getSelectedItem().equals("Professor")) {
					jif.setSize(450, 460);
					tabela.addColumn("RC");
			        scrollPane.setBounds(30, 140, 350, 200);
					
				}else {
					jif.setSize(410, 460);
			        scrollPane.setBounds(30, 140, 330, 200);
				}
				
				jif.setLayout(null);
				jif.setClosable(true);
				jif.setVisible(true);
				desktop.add(jif);
			}
		});
		
		desktop.setVisible(true);
				
		this.setVisible(true);
		this.setSize(550, 550);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
	}			
		public static void main(String[] args) {
			
			App app = new App();			
	}
}
