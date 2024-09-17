public class UsuarioProfessor extends Usuario {
    public UsuarioProfessor(String nome) {
        super(nome);
    }

    @Override
    public int getCotaMaxima() {
        return 5; // Cota maior para professores
    }

    @Override
    public int getPrazoMaximo() {
        return 14; // Prazo maior para professores
    }

    @Override
    public boolean isProfessor() {
        return true; // Indica que este usuário é um professor
    }

    @Override
    public String toString() {
        return "Professor " + getNome();
    }
}
