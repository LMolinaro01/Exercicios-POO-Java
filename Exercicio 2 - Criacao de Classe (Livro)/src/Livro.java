public class Livro {
    private int paginas;
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private String codBarra;
    private String genero;

    public Livro (){
    }

    public Livro(int paginas,int id,String titulo,String autor,String editora,String codBarra, String genero) {
        this.paginas = paginas;
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.codBarra = codBarra;
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public String getGenero() {
        return genero;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString(){
        return "------------------------------------------------\n Livro (" + id + "): " + titulo + "\n\n Número de Páginas: " + paginas + "\n\n Autor: " + autor + "\n\n Gênero: " + genero + "\n\n Editora: " + editora + "\n\n Código de barras: " + codBarra + "\n------------------------------------------------";
    }
}
