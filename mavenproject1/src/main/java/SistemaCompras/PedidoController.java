// PedidoController.java
package SistemaCompras;



/**
 * =========================================================================
 * Padrão GRASP Aplicado: CONTROLLER (Controlador)
 * =========================================================================
 *
 * 1. QUAL PADRÃO?
 * Controller (Controlador).
 *
 * 2. EM QUAL CLASSE/MÉTODO?
 * Classe: PedidoController (a classe inteira)
 * Métodos: processarAdicaoItem(...), exibirResumo(...)
 *
 * 3. POR QUE ESSA ESCOLHA ATENDE AO PRINCÍPIO?
 * O padrão Controller atua como um intermediário entre a camada de
 * apresentação (UI / a classe 'Principal') e a camada de
 * domínio/lógica (a classe 'Pedido').
 *
 * O 'PedidoController' recebe eventos do sistema (como "adicionar item")
 * e DELEGA o trabalho para os objetos de domínio apropriados
 * (ex.: 'pedido.adicionarItem(...)').
 *
 * BENEFÍCIOS:
 * a) BAIXO ACOPLAMENTO: A UI (Principal) não conhece a lógica de negócios
 * (Pedido, ItemPedido). Ela só conhece o Controller.
 * b) ALTA COESÃO: As classes de domínio (Pedido, Produto) focam
 * apenas em regras de negócio, sem se preocupar com a UI.
 */
public class PedidoController {

    // O Controller coordena o fluxo de trabalho.
    public void processarAdicaoItem(Pedido pedido, Produto produto, int quantidade) {
        if (pedido == null || produto == null || quantidade <= 0) {
            System.err.println("Erro: Dados inválidos para adicionar item.");
            return;
        }

        // O Controller DELEGA a responsabilidade para o objeto de domínio
        pedido.adicionarItem(produto, quantidade);
    }

    public void exibirResumo(Pedido pedido) {
        System.out.println("\n--- Resumo do Pedido ---");
        
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("Produto: %s | Qtd: %d | Total Item: R$ %.2f\n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.getPrecoTotal());
        }
        
        System.out.printf("TOTAL GERAL: R$ %.2f\n", pedido.getTotal());
        System.out.println("------------------------");
    }
}