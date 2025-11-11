// Pedido.java
package SistemaCompras;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o pedido (ou carrinho de compras).
 * Esta classe é um "agregado" ou "container" de ItensPedido.
 */
public class Pedido {
    private List<ItemPedido> itens = new ArrayList<>();
    private double total = 0;

    /**
     * =========================================================================
     * Padrão GRASP Aplicado: CREATOR (Criador)
     * =========================================================================
     *
     * 1. QUAL PADRÃO?
     * Creator (Criador).
     *
     * 2. EM QUAL CLASSE/MÉTODO?
     * Classe: Pedido
     * Método: adicionarItem(Produto produto, int quantidade)
     *
     * 3. POR QUE ESSA ESCOLHA ATENDE AO PRINCÍPIO?
     * O padrão Creator sugere que a classe B deve criar a classe A se B
     * "contém" ou "agrega" A.
     *
     * Neste caso, a classe 'Pedido' "contém" ou "agrega"
     * objetos 'ItemPedido' em sua lista 'itens'.
     * Portanto, 'Pedido' é a classe mais lógica e apropriada para ser
     * responsável por CRIAR as instâncias de 'ItemPedido'.
     *
     * Isso também promove Alta Coesão (a lógica de adicionar um item
     * ao pedido está toda contida aqui).
     */
    public void adicionarItem(Produto produto, int quantidade) {
        // A classe 'Pedido' cria a instância de 'ItemPedido'
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        
        this.itens.add(novoItem);
        this.total += novoItem.getPrecoTotal();
        System.out.println("Item adicionado ao pedido: " + produto.getNome());
    }

    public double getTotal() {
        return total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}