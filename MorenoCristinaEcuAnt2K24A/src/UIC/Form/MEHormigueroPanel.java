package UIC.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import BLC.MEHormigueroBL;

public class MEHormigueroPanel extends JPanel {

    private JLabel titleLabel;
    private JTable tableHormigas;
    private JComboBox<String> comboBox1, comboBox2;
    private JButton btnCrearLarva, btnAlimentar, btnEliminar, btnGuardar;
    private JLabel footerLabel;
    private DefaultTableModel modeloTabla;
    private MEHormigueroBL hormigueroBL;

    public MEHormigueroPanel() {
        // Inicializar lógica de negocio
        hormigueroBL = new MEHormigueroBL();

        setLayout(new BorderLayout());

        // Parte superior: Imagen
        String PathHormiga = "MorenoCristinaEcuAnt2K24A\\src\\UIC\\Resource\\Hormiga.png";
        ImageIcon iconofoto = new ImageIcon(PathHormiga);
        JLabel imageLabel = new JLabel(iconofoto, SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // Título centrado
        titleLabel = new JLabel("GENO HORMIGUERO EXPERIMENTAL", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.CENTER);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[][]{}, new String[]{"IdHormiga", "Tipo", "Sexo", "Alimentación", "Estado"});
        tableHormigas = new JTable(modeloTabla);
        add(new JScrollPane(tableHormigas), BorderLayout.CENTER);

        // Panel inferior
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Botones
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        btnCrearLarva = new JButton("Crear Larva");
        btnAlimentar = new JButton("Alimentar");
        btnEliminar = new JButton("Eliminar");
        btnGuardar = new JButton("Guardar");

        buttonPanel.add(btnCrearLarva);
        buttonPanel.add(btnAlimentar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnGuardar);

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Pie de página
        footerLabel = new JLabel("PROGRAMACION II | Cedula: 1727200352 | MorenoCristina", SwingConstants.LEFT);
        bottomPanel.add(footerLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Configurar acciones de los botones
        configurarAcciones();
    }

    private void configurarAcciones() {
        // Crear Larva
        btnCrearLarva.addActionListener(e -> {
            try {
                String mensaje = hormigueroBL.crearLarva();
                actualizarTabla();
                JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                mostrarError(ex);
            }
        });

        // Alimentar
        btnAlimentar.addActionListener(e -> {
            try {
                int idSeleccionado = tableHormigas.getSelectedRow();
                if (idSeleccionado == -1) {
                    JOptionPane.showMessageDialog(this, "Seleccione una hormiga para alimentar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int idHormiga = (int) modeloTabla.getValueAt(idSeleccionado, 0);
                String alimentoGeno = (String) JOptionPane.showInputDialog(this, "Seleccione el GenoAlimento:", "Alimentar Hormiga", JOptionPane.PLAIN_MESSAGE, null, new String[]{"XX", "X"}, "XX");
                String alimentoNativo = (String) JOptionPane.showInputDialog(this, "Seleccione el Alimento Nativo:", "Alimentar Hormiga", JOptionPane.PLAIN_MESSAGE, null, new String[]{"Insectívoro"}, "Insectívoro");

                String mensaje = hormigueroBL.alimentarHormiga(idHormiga, alimentoGeno, alimentoNativo);
                actualizarTabla();
                JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                mostrarError(ex);
            }
        });

        // Eliminar
        btnEliminar.addActionListener(e -> {
            try {
                int idSeleccionado = tableHormigas.getSelectedRow();
                if (idSeleccionado == -1) {
                    JOptionPane.showMessageDialog(this, "Seleccione una hormiga para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int idHormiga = (int) modeloTabla.getValueAt(idSeleccionado, 0);
                String mensaje = hormigueroBL.eliminarHormiga(idHormiga);
                actualizarTabla();
                JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                mostrarError(ex);
            }
        });

        // Guardar
        btnGuardar.addActionListener(e -> {
            try {
                String mensaje = hormigueroBL.guardarHormiguero();
                JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                mostrarError(ex);
            }
        });
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        hormigueroBL.lstHormiguero.forEach(hormiga -> modeloTabla.addRow(new Object[]{
                hormiga.getMEIdHormiga(),
                hormiga.getMETipo(),
                hormiga.getMESexo(),
                hormiga.getMEAlimentacion(),
                hormiga.getMEEstado()
        }));
    }

    private void mostrarError(Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
