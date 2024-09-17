import java.util.Calendar;
import java.util.Date;

public class Livro extends Item {
    private Usuario retiradoPor; // Usuário que retirou o livro
    private Date dtEmprestimo; // Data do empréstimo
    private Date dtDevolucao; // Data da devolução
    private Usuario bloqueadoPor; // Usuário que bloqueou o livro
    private Date dtBloqueio; // Data do bloqueio
    private Date dtDesbloqueio; // Data do desbloqueio

    public Livro(String titulo) {
        super(titulo); // Chama o construtor da superclasse Item
    }

    public boolean isDisponivel() {
        Date hoje = new Date(); // Data atual
        return this.retiradoPor == null && (this.bloqueadoPor == null || this.dtDesbloqueio.before(hoje));
    }

    public boolean isEmprestado() {
        return this.retiradoPor != null;
    }

    public boolean isBloqueado() {
        Date hoje = new Date();
        return this.bloqueadoPor != null && this.dtDesbloqueio.after(hoje);
    }

    @Override
    public boolean empresta(Usuario usuario) {
        if (isDisponivel()) {
            this.retiradoPor = usuario;
            this.dtEmprestimo = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, usuario.getPrazoMaximo());
            this.dtDevolucao = cal.getTime();
            return true;
        }
        return false;
    }

    @Override
    public boolean retorna(Usuario usuario) {
        if (usuario == this.retiradoPor) {
            this.retiradoPor = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isDisponivel()) {
            return getTitulo() + " disponível";
        } else if (isEmprestado()) {
            return getTitulo() + " retirado por " + retiradoPor.getNome() + " até " + dtDevolucao;
        } else {
            return getTitulo() + " bloqueado por " + bloqueadoPor.getNome();
        }
    }
}
