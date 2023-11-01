package utn.tiendaLibros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import utn.tiendaLibros.servicio.LibroServicio;

import javax.swing.*;

public class LibroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();
    }

    private void iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
    }

}
