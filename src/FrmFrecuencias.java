import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class FrmFrecuencias extends JFrame {

    JComboBox cmbRespuesta;
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
        DefaultComboBoxModel mdlRespuesta=new DefaultComboBoxModel(opciones);
        cmbRespuesta.setModel(mdlRespuesta);
        getContentPane().add(cmbRespuesta);
    }
}
