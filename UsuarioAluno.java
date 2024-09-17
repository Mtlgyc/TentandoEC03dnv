import java.util.Date;

public class UsuarioAluno extends Usuario {
    private Date dataLimite; // Data limite para regularidade do aluno

    public UsuarioAluno(String nome, Date dataLimite) {
        super(nome);
        this.dataLimite = dataLimite;
    }

    @Override
    public int getCotaMaxima() {
        return isRegular() ? 3 : super.getCotaMaxima();
    }

    @Override
    public int getPrazoMaximo() {
        return isRegular() ? 7 : super.getPrazoMaximo();
    }

    public boolean isRegular() {
        return dataLimite.after(new Date()); // Verifica se o aluno está regular
    }

    @Override
    public String toString() {
        return "Aluno " + getNome();
    }
}
