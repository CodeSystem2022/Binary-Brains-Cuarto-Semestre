package utn.tiendaLibros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tiendaLibros.servicio.LibroServicio;
import utn.tiendaLibros.modelo.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component

public class LibroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField libroTexto;
    private JLabel Libro;
    private JTextField autorTexto;
    private JTextField existenciasTexto;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton agregarButton;
    private JTextField precioTexto;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio = libroServicio;
        iniciarForma();
        agregarButton.addActionListener(e -> agregarLibro());
    }

    private void iniciarForma(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        // Para obtener las dimensiones de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth()/2);
        int y = (tamanioPantalla.height - getHeight()/2);
        setLocation(x,y);
    }

    private void agregarLibro(){
        //leer los valores del formulario
        if(libroTexto.getText().equals("")){
            mostrarMensaje("Ingresa el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(precioTexto.getText());
        var existencias = Integer.parseInt(existenciasTexto.getText());
        //creamos objeto libro
        var libro = new Libro(null,nombreLibro,autor,precio,existencias);
        //libro.setNombreLibro(nombreLibro);
        //libro.setAutor(autor);
        //libro.setPrecio(precio);
       // libro.setExistencias(existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agregó el libro...");
        limpiarFormulario();
        listarLibros();
    }

    private void limpiarFormulario(){
        libroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        existenciasTexto.setText("");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this,mensaje);
    }

    private void createUIComponents() {
        this.tablaModeloLibros = new DefaultTableModel(0,5);
        String[] cabecera = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabecera);
        //Instanciar el objeto de JTable
        this.tablaLibros = new JTable(tablaModeloLibros);
        listarLibros();
    }

    private void listarLibros(){
        //Limpiar cualquier registro/información de ña tabla
        tablaModeloLibros.setRowCount(0);
        //Obtener los libros d ela BD
        var libros = libroServicio.listarLibros();
        //Iteramos cada libro
        libros.forEach((libro) -> {//Función Lambda
            //creamos cada registro para agregarle a la tabla
            Object [] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tablaModeloLibros.addRow(renglonLibro);
        });
    }
}
