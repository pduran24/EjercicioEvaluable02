package ui;

import model.Usuario;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Logger;

public class UsuarioDialog extends JDialog {
    private static Logger logger = Logger.getLogger(UsuarioDialog.class.getName());

    private JPanel contentPane;
    private JButton btnOk;
    private JButton btnCancelar;
    private JTextField txtCorreo;
    private JComboBox bxPais;
    private JComboBox bxPlataforma;

    private Principal parentScreen = new Principal();

    public UsuarioDialog(Principal parent) {
        logger.info("Iniciando usuario");

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnOk);
        setLocationRelativeTo(parent);
        setSize(400, 500);

        bxPais.addItem("España");
        bxPais.addItem("Francia");
        bxPais.addItem("Italia");
        bxPais.addItem("Alemania");

        bxPlataforma.addItem("Windows");
        bxPlataforma.addItem("MacOS");
        bxPlataforma.addItem("Linux");

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        logger.info("Guardando usuario");

        String email = txtCorreo.getText();
        String pais = bxPais.getSelectedItem().toString();
        String plataforma = bxPlataforma.getSelectedItem().toString();

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPais(pais);
        usuario.setPlataforma(plataforma);

        var fila =  new Object[]{ usuario.getEmail(), usuario.getPais(),usuario.getPlataforma() };
        parentScreen.cargarUsuario().addRow(fila);

        dispose();
    }


    private void onCancel() {
        logger.info("Cancelando Añadir usuario");
        dispose();
    }



}
