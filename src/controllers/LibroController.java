package controllers;

import models.Book;

import java.util.*;

public class LibroController {

    public Map<Book, Book> procesarLibros(List<Book> libros) {
        Comparator<Book> comparador = (b1, b2) -> {
            int cmpTitulo = b2.getTitulo().compareToIgnoreCase(b1.getTitulo());
            if (cmpTitulo != 0) return cmpTitulo;

            int cmpAnio = Integer.compare(b1.getAnio(), b2.getAnio());
            if (cmpAnio != 0) return cmpAnio;

            return 0;
        };

        Set<Book> setOrdenado = new TreeSet<>(comparador);
        setOrdenado.addAll(libros);

        Map<Book, Book> resultado = new LinkedHashMap<>();
        for (Book libro : setOrdenado) {
            resultado.put(libro, libro); // Clave y valor iguales
        }

        return resultado;
    }
}
