import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class FrmFrecuencias extends JFrame {

    JComboBox cmbRespuesta;
    JList lstRespuestas;
    JTable tblFrecuencias;
    String[] opciones = new String[] { "Excelente", "Buena", "Regular", "Mala" };
    String[] encabezados = new String[] { "Variable", "Frecuencia absoluta (f)", "Frecuencia acumulada (F)",
            "Frecuencia relativa (fr)", "Frecuencia porcentual (%f)" };

    String[] respuestas = new String[1000];
    int totalRespuestas = -1;

    public FrmFrecuencias() {
        setSize(600, 500);
        setTitle("Tabla deDistribución");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(null);

        JTextArea txtPregunta = new JTextArea(
                "¿Cómo considera la calidad de la señal de internet que entra al barrio?");
        txtPregunta.setBounds(10, 10, 250, 50);
        txtPregunta.setEditable(false);
        txtPregunta.setLineWrap(true);
        getContentPane().add(txtPregunta);

        cmbRespuesta = new JComboBox();
        cmbRespuesta.setBounds(10, 60, 100, 25);
        DefaultComboBoxModel mdlRespuesta = new DefaultComboBoxModel(opciones);
        cmbRespuesta.setModel(mdlRespuesta);
        getContentPane().add(cmbRespuesta);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(80, 90, 100, 25);
        getContentPane().add(btnAgregar);

        JButton btnQuitar = new JButton("Quitar");
        btnQuitar.setBounds(80, 120, 100, 25);
        getContentPane().add(btnQuitar);

        lstRespuestas = new JList();
        JScrollPane spRespuestas = new JScrollPane(lstRespuestas);
        spRespuestas.setBounds(270, 10, 100, 150);
        getContentPane().add(spRespuestas);

        JButton btnCalcular = new JButton("Frecuencias");
        btnCalcular.setBounds(10, 200, 150, 25);
        getContentPane().add(btnCalcular);

        tblFrecuencias = new JTable();
        JScrollPane spFrecuencias = new JScrollPane(tblFrecuencias);
        spFrecuencias.setBounds(10, 230, 550, 150);
        getContentPane().add(spFrecuencias);

        DefaultTableModel dtmFrecuencias = new DefaultTableModel(null, encabezados);
        tblFrecuencias.setModel(dtmFrecuencias);

        // Eventos
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                agregarDato();
            }
        });

        btnQuitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                quitarDato();
            }
        });

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calcularFrecuencias();
            }
        });

    }

    private void agregarDato() {
        totalRespuestas++;
        String respuesta = opciones[cmbRespuesta.getSelectedIndex()];
        respuestas[totalRespuestas] = respuesta;
        mostrarDatos();
    }

    private void quitarDato() {
        int posicion = lstRespuestas.getSelectedIndex();
        if (posicion >= 0) {
            for (int i = posicion; i < totalRespuestas; i++) {
                respuestas[i] = respuestas[i + 1];
            }
            totalRespuestas--;
            mostrarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una posición");
        }
    }

    private void mostrarDatos() {
        String[] respuestasActuales = new String[totalRespuestas + 1];
        for (int i = 0; i <= totalRespuestas; i++) {
            respuestasActuales[i] = respuestas[i];
        }
        lstRespuestas.setListData(respuestasActuales);
    }

    private void calcularFrecuencias() {
        double[][] tabla = new double[opciones.length][encabezados.length - 1];
        String[][] strTabla = new String[opciones.length][encabezados.length];

        for (int i = 0; i <= totalRespuestas; i++) {
            // buscar fila de la opcion de la respuesta
            int posicion = -1;
            for (int j = 0; j < opciones.length; j++) {
                if (respuestas[i].equals(opciones[j])) {
                    posicion = j;
                    break;
                }
            }
            tabla[posicion][0]++;
        }

        for (int i = 0; i < opciones.length; i++) {
            strTabla[i][0] = opciones[i];
            strTabla[i][1] = String.valueOf(tabla[i][0]);
        }

        DefaultTableModel dtmFrecuencias = new DefaultTableModel(strTabla, encabezados);
        tblFrecuencias.setModel(dtmFrecuencias);
    }
}
