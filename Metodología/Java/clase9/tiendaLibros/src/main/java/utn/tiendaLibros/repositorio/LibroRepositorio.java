package utn.tiendaLibros.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.tiendaLibros.modelo.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
        }
