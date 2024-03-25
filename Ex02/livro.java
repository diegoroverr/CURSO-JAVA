class livro {
    private String titulo;
    private String autor;
    private int anopublicacao;

    public livro(String titulo, String autor, int anopublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacao = anopublicacao;
    }

    public void exibirinfo() {

        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " + anopublicacao);
    }
}