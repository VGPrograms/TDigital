package Controlador;


import java.awt.Component;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
public class CurrencyCellRenderer extends DefaultTableCellRenderer {
  
    private static final Locale a = new Locale("es","MX");
    private static final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();
 
    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        final Component result = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            setHorizontalAlignment(JLabel.RIGHT);
            setText(FORMAT.format(value));
        } else {
            setText("");
        }
        return result;
    }
}