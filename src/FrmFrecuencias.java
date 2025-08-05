import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrmFrecuencias extends JFrame {

    JComboBox cmbRespuesta;
    JList lstRespuestas;
    String[] opciones = new String[] { "Excelente", "Buena", "Regular", "Mala" };

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

        lstRespuestas=new JList();
        JScrollPane spRespuestas = new JScrollPane(lstRespuestas);
        spRespuestas.setBounds(270, 10, 100, 150);
        getContentPane().add(spRespuestas);

        JButton btnCalcular = new JButton("Frecuencias");
        btnCalcular.setBounds(10, 200, 150, 25);
        getContentPane().add(btnCalcular);
    }
}
