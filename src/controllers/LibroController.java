package controllers;

import models.Book;

import java.util.*;

public class LibroController {

    public Map<Book, Book> procesarLibros(List<Book> libros) {
        Comparator<Book> comparador = Comparator
                .comparing(Book::getTitulo, Comparator.reverseOrder())
                .thenComparing(Book::getAnio);

        Set<Book> ordenados = new TreeSet<>(comparador);
        ordenados.addAll(libros);

        Map<Book, Book> resultado = new LinkedHashMap<>();
        for (Book libro : ordenados) {
            resultado.put(libro, libro);
        }

        return resultado;
    }
}