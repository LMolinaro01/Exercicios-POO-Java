public class Estudante {

    private float nota;
    private float nota2;
    private int matricula;
    private String nome;
    private float media;
    private String aprovacao;

    public Estudante(int matricula, String nome, float nota,float nota2,float media, String aprovacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
        this.nota2 = nota2;
        this.media = media;
        this.aprovacao = aprovacao;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(String aprovacao) {
        this.aprovacao = aprovacao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "___________________________\n\nMatricula: " + getMatricula() +  "\n\n- Nome: " + getNome();
    }
}