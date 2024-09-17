import java.util.ArrayList;

public class Usuario {
    private String nome; // Nome do usuário
    private ArrayList<Item> itensRetirados; // Lista de itens retirados pelo usuário

    public Usuario(String nome) {
        this.nome = nome;
        this.itensRetirados = new ArrayList<>();
    }

    public String getNome() {
        return nome; // Retorna o nome do usuário
    }

    public boolean retiraItem(Item item) {
        if (item.empresta(this)) {
            itensRetirados.add(item); // Adiciona o item à lista de itens retirados
            return true;
        }
        return false;
    }

    public boolean devolveItem(Item item) {
        if (item.retorna(this)) {
            itensRetirados.remove(item); // Remove o item da lista de itens retirados
            return true;
        }
        return false;
    }

    public int getCotaMaxima() {
        return 2; // Cota padrão
    }

    public int getPrazoMaximo() {
        return 4; // Prazo padrão
    }

    public boolean isProfessor() {
        return false; // Não é professor por padrão
    }
}
