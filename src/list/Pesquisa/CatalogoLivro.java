package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivro {
    // atributo

    private List<Livro> livroList;

    public CatalogoLivro() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervalo(int anoInicial, int anoFinal) {
        List<Livro> livrosPorIntervalo = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervalo.add(l);
                }
            }
        }
        return livrosPorIntervalo;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if (!livroList.isEmpty()) {
          for(Livro l : livroList){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                livroPorTitulo = l;
                break;
            }
          }  
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivro catalogoLivro = new CatalogoLivro();
        catalogoLivro.adicionarLivro("Livro 1", "Autor 1", 2024);
        catalogoLivro.adicionarLivro("Livro 1", "Autor 2", 2023);
        catalogoLivro.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivro.adicionarLivro("Livro 3", "Autor 3", 2021);
        catalogoLivro.adicionarLivro("Livro 4", "Autor 4", 1995);


        System.out.println("LIVRO PESQUISADO POR TITULO: " + catalogoLivro.pesquisarPorTitulo("Livro 1"));
        System.out.println("LIVRO PESQUISADO POR AUTOR: " + catalogoLivro.pesquisarPorAutor("Autor 2"));
        System.out.println("LIVRO PESQUISADO POR INTERVALO DE TEMPO: " + catalogoLivro.pesquisarPorIntervalo(1995, 2021));
    }
}
