public class Pessoa {
    private int id;
    private String nome;
    private float altura;
    private int idade;
    private String email;
    private String profissao;

    public Pessoa(int id, String nome, float altura, int idade, String email, String profissao){
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.idade = idade;
        this.email = email;
        this.profissao = profissao;
    }

    public Pessoa(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try{
            if (!nome.equals(null) && !nome.isEmpty()){
                if (nome.matches(".*[;,'\\-+\\.].*")){
                    System.out.println("O nome não pode conter caracteres especiais.");
                }
                else {
                    this.nome = nome;
                }
            }else {
                System.out.println("O nome não pode estar vazio.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        try {
            if (idade > 0 && idade < 120) {
                this.idade = idade;
            }
            else {
                System.out.println("Idade inválida");
            }
        } catch (ClassCastException e){
            System.out.println("Houve um Erro na validação da Idade.");
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", altura=" + altura +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", profissao='" + profissao + '\'' +
                '}';
    }
}
