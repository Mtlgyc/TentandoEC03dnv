public class Periodico extends Item {
    public Periodico(String titulo) {
        super(titulo); // Chama o construtor da superclasse Item
    }

    @Override
    public boolean empresta(Usuario usuario) {
        // Verifica se o usuário é um professor
        if (usuario.isProfessor()) {
            System.out.println("Periódico não pode ser emprestado. Uso apenas para consulta.");
            return false;
        }
        return false;
    }

    @Override
    public boolean retorna(Usuario usuario) {
        return true; // Periódicos não podem ser emprestados, então sempre retorna true
    }

    @Override
    public String toString() {
        return getTitulo() + " disponível para consulta"; // Descrição apropriada do periódico
    }
}
