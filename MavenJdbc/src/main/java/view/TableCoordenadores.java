package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.CoordenadoresJdbcDAO;
import model.Alunos;
import model.Coordenadores;

public class TableCoordenadores extends AbstractTableModel {

	private List<Coordenadores> dados;
	private String[] colunas = {"RC", "Nome", "Endereço", "Bairro", "Sexo"};
	
	public TableCoordenadores(){
        dados = new ArrayList<Coordenadores>();
    }
     
	public void addRow(Coordenadores c){
        this.dados.add(c);
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
            case 0: return dados.get(linha).getRc();
            case 1: return dados.get(linha).getNome();
            case 2: return dados.get(linha).getEndereco();
            case 3: return dados.get(linha).getBairro();
            case 4: return dados.get(linha).getSexo();
        }   
        return null;
    }
}
