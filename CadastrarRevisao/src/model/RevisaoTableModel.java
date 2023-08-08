package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RevisaoTableModel extends AbstractTableModel {

    private List<Revisao> dados = new ArrayList<>();
    private String[] colunas = {"CPF", "Modelo", "Ano", "Km", "Data"};

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
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
        switch (coluna) {
            case 0:
                return dados.get(linha).getCpf();
            case 1:
                return dados.get(linha).getModelo();
            case 2:
                return dados.get(linha).getAno();
            case 3:
                return dados.get(linha).getKm();
            case 4:
                return dados.get(linha).getData();
        }
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
        switch (coluna)
        {
            case 0:
                dados.get(linha).setCpf( (String) valor);
                break;
            case 1:
                dados.get(linha).setModelo( (String) valor);
                break;
            case 2:
                dados.get(linha).setAno( Integer.parseInt( (String) valor));
                break;
            case 3:
                dados.get(linha).setKm( (String) valor);
                break;
            case 4:
                dados.get(linha).setData((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
        
    }

    public void adicionaLinha(Revisao p) {
        this.dados.add(p);
        this.fireTableDataChanged();
    }

    public void removeLinha(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Revisao getDados (int linha){
        return dados.get(linha);
    }

}
