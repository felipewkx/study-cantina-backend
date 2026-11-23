
public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String email, String telefone) {
        this(0, nome, email, telefone);
    }

    // Construtor de 4 parâmetros que estava faltando
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = limparNome(nome);
        this.email = email;
        this.telefone = telefone;
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
        this.nome = limparNome(nome);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Nomes ajustados para seguir o padrão do atributo 'telefone'
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + '}';
    }

    private static String limparNome(String nome) {
        return nome == null ? "" : nome.trim().replaceAll("\\s+", " ");
    }
}
