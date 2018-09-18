package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.ProfessoresJdbcDAO;
import model.Inspetores;
import model.Professores;

public class TableProfessores extends AbstractTableModel {

	private List<Professores> dados;
	private String[] colunas = {"RM", "Nome", "Endereço", "Bairro", "Sexo", "RC"};
	
	public TableProfessores(){
        dados = new ArrayList<Professores>();
    }
     
	public void addRow(Professores p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
 
    public String getColumnName(int num){
        return this.colunas[num];
    }
 
    @Override
    public int getRowCount() {
        return dados.size();
    }
 
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
 
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0: return dados.get(linha).getRp();
            case 1: return dados.get(linha).getNome();
            case 2: return dados.get(linha).getEndereco();
            case 3: return dados.get(linha).getBairro();
            case 4: return dados.get(linha).getSexo();
            case 5: return dados.get(linha).getRc();
        }   
        return null;
    }
}
