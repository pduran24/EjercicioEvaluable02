package ui;

import model.Usuario;

import javax.swing.*;
import java.util.logging.Logger;

public class Principal extends JFrame{
    private static Logger  logger = Logger.getLogger(Principal.class.getName());

    private JButton btnSalir;
    private JButton btnAniadir;
    private JPanel panel1;
    private JTable tablaUsuarios;
    private Usuario usuario;

    public Principal() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);


        btnAniadir.addActionListener(e -> {
            onAniadirButton();
        });

        btnSalir.addActionListener(e -> {
            logger.info("Salir");
            System.exit(0);
        });

        cargarUsuario();
    }


    public void onAniadirButton(){
        logger.info("Iniciando añadir usuario");
        UsuarioDialog usuarioDialog = new UsuarioDialog(this);
        usuarioDialog.setVisible(true);
    }

    public void cargarUsuario() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement(usuario.getEmail());

    }


    public void init() {
        logger.info("Iniciando el principal");
        this.setVisible(true);
    }

}
