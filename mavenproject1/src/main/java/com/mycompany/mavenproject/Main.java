// No seu caso, este arquivo deve se chamar ExemploGRASP.java
// ou você pode renomeá-lo para Principal.java
package com.mycompany.mavenproject;

/**
 * Classe principal que simula a "Camada de Apresentação" (UI).
 *
 * Note como a Main/Principal NUNCA fala diretamente com o 'Pedido' ou 'ItemPedido'.
 * Ela só conhece e interage com o 'PedidoController'.
 */
public class Main { // Mude "Principal" para "ExemploGRASP" se esse for o nome do seu arquivo

    public static void main(String[] args) {
        // 1. Setup inicial (criação dos objetos)
        PedidoController controller = new PedidoController();
        Pedido meuPedido = new Pedido();

        // Produtos disponíveis
        Produto laptop = new Produto("Notebook Gamer", 4500.00);
        Produto mouse = new Produto("Mouse Óptico", 150.00);

        // 2. Simulação de "Eventos da UI"
        // Usuário "clicou" para adicionar um laptop
        controller.processarAdicaoItem(meuPedido, laptop, 1);

        // Usuário "clicou" para adicionar dois mouses
        controller.processarAdicaoItem(meuPedido, mouse, 2);

        // Usuário "clicou" para ver o resumo do carrinho
        controller.exibirResumo(meuPedido);
    }
}