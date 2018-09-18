package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import controller.AlunosJdbcDAO;
import controller.CoordenadoresJdbcDAO;
import controller.InspetoresJdbcDAO;
import controller.JdbUtil;
import controller.ProfessoresJdbcDAO;
import model.Alunos;
import model.Coordenadores;
import model.Inspetores;
import model.Professores;

public class Telas extends JFrame {
	
	public final static Alunos alunos = new Alunos();
	protected final Professores professores = new Professores();
	protected final Coordenadores coordenadores = new Coordenadores();
	protected final Inspetores inspetores = new Inspetores();
	
	final JLabel selecaoFuncao = new JLabel ("Selecione o que você quer fazer");
	final JButton btnSalvar = new JButton("Salvar");
	final JButton btnDeletar = new JButton("Deletar");
	final JButton btnAtualizar = new JButton("Atualizar");
	final JButton btnListar = new JButton("Listar");
	
	protected final JTextField txtId = new JTextField();
	
	protected final JTextField txtNome = new JTextField();
	final JLabel nome = new JLabel("Nome: ");
	
	protected final JTextField txtEnd = new JTextField();
	final JLabel end = new JLabel("Endereço: ");
	
	protected final JTextField txtBairro = new JTextField();
	final JLabel bairro = new JLabel("Bairro: ");
	
	protected final JTextField txtRc = new JTextField();
	final JLabel rc = new JLabel("RC (Registro do coordenador): ");
	
	public final JComboBox cbxTipoCadastro = new JComboBox();
	final JLabel tipo = new JLabel ("Tipo de cadastro:");
	
	final ButtonGroup bg = new ButtonGroup();
	protected final JRadioButton rdbSexoM = new JRadioButton();
	protected final JRadioButton rdbSexoF = new JRadioButton();	
	final JLabel sexo = new JLabel ("Sexo:");
	final JLabel sexoM = new JLabel ("Masc.");
	final JLabel sexoF = new JLabel ("Femin.");
	
	Container paine = this.getContentPane();
	JDesktopPane desktop = new JDesktopPane();
	JPanel panelPrincipal = new JPanel();
	
	public void criarTelas(){
				
		panelPrincipal.setLayout(null);
		panelPrincipal.add(cbxTipoCadastro);
		panelPrincipal.add(tipo);
		cbxTipoCadastro.addItem("Aluno");
		cbxTipoCadastro.addItem("Professor");
		cbxTipoCadastro.addItem("Coordenador");
		cbxTipoCadastro.addItem("Inspetor");
		tipo.setBounds(70, 10, 100, 30);
		cbxTipoCadastro.setBounds(70, 40, 100, 30);
		
		panelPrincipal.add(selecaoFuncao);
		panelPrincipal.add(btnSalvar);
		panelPrincipal.add(btnDeletar);
		panelPrincipal.add(btnAtualizar);
		panelPrincipal.add(btnListar);
		
		bg.add(rdbSexoM);
		bg.add(rdbSexoF);
		

//		tabela.addColumn("ID");
//		tabela.addColumn("Nome");
//		tabela.addColumn("Endereço");
//		tabela.addColumn("Bairro");
//		tabela.addColumn("Sexo");
//		if(cbxTipoCadastro.getSelectedItem().equals("Professor")) {
//			tabela.addColumn("RC");
//		}
		
		selecaoFuncao.setBounds(25, 100, 200, 20);
		btnSalvar.setBounds(10, 120, 100, 30);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaSalvar();
				panelPrincipal.setVisible(false);
			}
		});
		
		btnDeletar.setBounds(125, 120, 100, 30);
		btnDeletar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				abrirTelaDeletar();
				panelPrincipal.setVisible(false);
			}
		});
		
		btnAtualizar.setBounds(10, 170, 100, 30);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaAtualizar();
				panelPrincipal.setVisible(false);
			}
		});
		
		btnListar.setBounds(125, 170, 100, 30);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaListar(); 
				panelPrincipal.setVisible(false);
			}
		});
		
		panelPrincipal.setVisible(true);
		panelPrincipal.setSize(550, 550);
		desktop.setSize(550, 550);
		desktop.setVisible(true);
		desktop.add(panelPrincipal);
		paine.add(desktop);
		
		this.setVisible(true);
		this.setSize(550, 550);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void abrirTelaSalvar() {
		
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
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		jif.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			@Override
			public void internalFrameClosed(InternalFrameEvent evt)
	        {
				panelPrincipal.setVisible(true);
				//desktop.setVisible(false);
	        }

			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jif.setLayout(null);
		jif.setClosable(true);
		jif.setVisible(true);
		desktop.add(jif);
	}
	
	public void abrirTelaDeletar() {
		JInternalFrame jif = new JInternalFrame("Deletar dados");
		
		JButton btn = new JButton("Deletar");
		
		JLabel informarId = new JLabel ("Informe o ID para excluir o cadastro");
		final JTextField txtId = new  JTextField();
		
		jif.add(informarId);
		jif.add(txtId);
		informarId.setBounds(15, 30, 220, 15);
		txtId.setBounds(40, 60, 150, 25);
		jif.add(btn);
		btn.setBounds(70, 100, 80, 30);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		jif.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			@Override
			public void internalFrameClosed(InternalFrameEvent evt)
	        {
				panelPrincipal.setVisible(true);
				//desktop.setVisible(false);
	        }

			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jif.setLayout(null);
		jif.setSize(250, 200);
		jif.setClosable(true);
		jif.setVisible(true);
		desktop.add(jif);
	}
	
	public void abrirTelaAtualizar(){
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
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		jif.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			@Override
			public void internalFrameClosed(InternalFrameEvent evt)
	        {
				panelPrincipal.setVisible(true);
				//desktop.setVisible(false);
	        }

			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jif.setLayout(null);
		jif.setClosable(true);
		jif.setVisible(true);
		desktop.add(jif);
	}
	
	public void abrirTelaListar() {
		JInternalFrame jif = new JInternalFrame("Listar cadastros");
		
		JButton btn = new JButton("Listar");
		
		JLabel id = new JLabel ("Selecione por ID:"); 
		JLabel nome = new JLabel ("Selecione por nome:"); 
		
		
		jif.add(id);
		jif.add(txtId);	
		id.setBounds(10, 20, 200, 20);
		txtId.setBounds(10, 50, 225, 20);
		
		jif.add(nome);
		jif.add(txtNome);	
		nome.setBounds(10, 80, 200, 20);
		txtNome.setBounds(10, 110, 225, 20);
		
		jif.add(btn);
		btn.setBounds(120, 370, 100, 30);
		
		jif.add(AlunosJdbcDAO.scrollPane);
		
			
		if(cbxTipoCadastro.getSelectedItem().equals("Professor")) {
			jif.setSize(450, 460);
//			tabela.addColumn("RC");
			AlunosJdbcDAO.scrollPane.setBounds(30, 140, 350, 200);
			
		}else {
			jif.setSize(410, 460);
			AlunosJdbcDAO.scrollPane.setBounds(30, 140, 330, 200);
		}
		
		
		btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//				while (tabela.getRowCount() > 0) {
//					tabela.removeRow(0);
//				}
				 try {
					 Connection connection = JdbUtil.getConnection();
					 AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
					 alunosJdbcDao.listar();
				 }catch(Exception ex){
						 ex.printStackTrace();
				 }
			}
		});
		jif.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
			@Override
			public void internalFrameClosed(InternalFrameEvent evt)
	        {
				panelPrincipal.setVisible(true);
				//desktop.setVisible(false);
	        }

			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
		});		
		jif.setLayout(null);
		jif.setClosable(true);
		jif.setVisible(true);
		desktop.add(jif);	
	}
}
