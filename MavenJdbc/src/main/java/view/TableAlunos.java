package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.AlunosJdbcDAO;
import model.Alunos;
import model.Coordenadores;

public class TableAlunos extends AbstractTableModel {

	public List<Object> dados;
    private String[] colunas = {"RM", "Nome", "Endereço", "Bairro", "Sexo"};
	public TableAlunos(){
        dados = new ArrayList<Object>();
    }
     
	public void addRow(Object[] objects){
        this.dados.add(objects);
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
 
    //@Override
//    public Object getValueAt(int linha, int coluna) {
//        switch(coluna){
//        case 0: return dados.get(linha).getRm();
//        case 1: return dados.get(linha).getNome();
//        case 2: return dados.get(linha).getEndereco();
//        case 3: return dados.get(linha).getBairro();
//        case 4: return dados.get(linha).getSexo();
//        }   
//        return null;
//    }
//    
//    public void removeRow(int linha){
//        this.dados.remove(linha);
//        this.fireTableRowsDeleted(linha, linha);
//    }
//    
//    public Alunos get(int linha){
//        return this.dados.get(linha);
//    }
//    
//    public void setValueAt(Object valor, int linha, int coluna){
//        if( valor == null) return;
//        switch(coluna){
//            case 0:  dados.get(linha).setRm(Integer.parseInt((String) valor));break;
//            case 1:  dados.get(linha).setNome((String) valor);break;
//            case 2:  dados.get(linha).setEndereco((String) valor);break;
//            case 3:  dados.get(linha).setBairro((String) valor);break;
//            case 4:  dados.get(linha).setSexo((String) valor);break;
//        } 
//        this.fireTableRowsUpdated(linha, linha);
//    }
}
