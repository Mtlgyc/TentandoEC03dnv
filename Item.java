public abstract class Item {
    private String titulo; // Título do item (livro, periódico, etc.)

    public Item(String titulo) {
        this.titulo = titulo; // Construtor que define o título do item
    }

    public String getTitulo() {
        return titulo; // Retorna o título do item
    }

    public abstract boolean empresta(Usuario usuario); // Método abstrato para emprestar o item

    public abstract boolean retorna(Usuario usuario); // Método abstrato para devolver o item
}


//Tarefa 02: Identificar casos de reescrita de métodos
//Os casos de reescrita de métodos (override) ocorrem nas subclasses UsuarioAluno e UsuarioProfessor, onde os métodos getCotaMaxima() e getPrazoMaximo() são redefinidos para fornecer valores específicos para cada tipo de usuário.

//Tarefa 03: Identificar um caso de polimorfismo
//Um exemplo de polimorfismo no conjunto de códigos apresentados é o método empresta() na classe Livro e na classe Periodico. O método empresta() é chamado de forma diferente dependendo do tipo de objeto que o invoca (um Livro ou um Periodico).

//Tarefa 04: Importância de métodos auxiliares na codificação de classes
//Métodos auxiliares são importantes porque:

//Eles ajudam a manter o código organizado e legível, dividindo tarefas complexas em partes menores e mais gerenciáveis.
//Eles permitem a reutilização de código, evitando duplicação.
//Eles facilitam a manutenção e a atualização do código, pois mudanças em um método auxiliar não afetam diretamente outras partes do código.

//Tarefa 05: Mudança de estado de um objeto
//A mudança de estado de um objeto ocorre quando o valor de um ou mais atributos do objeto é alterado. Por exemplo, um livro muda de estado quando é emprestado (passa de disponível para emprestado) ou quando é devolvido (passa de emprestado para disponível). A construção de diagramas de estados facilita a codificação, pois fornece uma representação visual clara dos diferentes estados que um objeto pode ter e as transições entre esses estados.

//Tarefa 06: Importância da elaboração de diagramas de atividades
//Os diagramas de atividades são importantes porque:

//Eles ajudam a visualizar o fluxo de controle e as interações entre objetos durante a execução de um processo.
//Eles permitem identificar possíveis falhas ou omissões no design do sistema antes da implementação.
//Eles servem como documentação que pode ser útil para novos desenvolvedores que trabalham no projeto.