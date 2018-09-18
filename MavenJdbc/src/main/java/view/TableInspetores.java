package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.InspetoresJdbcDAO;
import model.Coordenadores;
import model.Inspetores;

public class TableInspetores extends AbstractTableModel {

	private List<Inspetores> dados;
	private String[] colunas = {"RI", "Nome", "Endereço", "Bairro", "Sexo"};
	
	public TableInspetores(){
        dados = new ArrayList<Inspetores>();
    }
     
	public void addRow(Inspetores i){
        this.dados.add(i);
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
            case 0: return dados.get(linha).getRi();
            case 1: return dados.get(linha).getNome();
            case 2: return dados.get(linha).getEndereco();
            case 3: return dados.get(linha).getBairro();
            case 4: return dados.get(linha).getSexo();
        }   
        return null;
    }
}
