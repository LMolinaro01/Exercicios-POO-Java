/*Agrupamento de Objetos em Java -> Organização de Objetos em Base de critérios. Não é um conceito de POO, mas é comum em interaçõs com bancos de dados, semelhando ao "group by" do SQL

Coleções: Set, List, Queue, Deque e etc

- Collection (Coleção): É como o chefe de todas as coleções. Ele define operações básicas que todas as coleções devem ter, como adicionar, remover e esvaziar.

- Set (Conjunto): É uma coleção que não permite elementos duplicados. Pense nisso como uma lista onde cada item é único.

- SortedSet (Conjunto Ordenado): É um tipo de conjunto que organiza seus elementos em ordem, por exemplo, em ordem alfabética.

- List (Lista): É uma coleção ordenada onde elementos podem ser duplicados. É como uma lista de compras onde você pode ter mais de um item igual e você pode pegar itens em qualquer ordem.

- Queue (Fila): É uma coleção que mantém uma lista de prioridades. Os elementos são adicionados na parte de trás da fila e removidos da frente, seguindo uma ordem específica.

- Map (Mapa): É uma coleção que armazena pares de chaves e valores únicos. Pense nisso como um dicionário, onde cada palavra (chave) tem um significado (valor) único.

- SortedMap (Mapa Ordenado): É um mapa onde as chaves são organizadas em ordem, por exemplo, em ordem alfabética.

- Deque: É uma coleção que combina as funcionalidades de uma fila (Queue) e uma pilha (Stack). Você pode adicionar ou remover elementos tanto no início quanto no final da deque.
*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Usando o Set para armazenar os pratos pedidos
        Set<String> pratosUnicos = new HashSet<>();

        //Usando o List para guardar a ordem dos pedidos
        List<Pedido> pedidos = new ArrayList<>();

        //Usando o Queue para simular a Fila dos pedidos
        Queue<Pedido> filaPedidos = new LinkedList<>();

        //Usando o Deque para simular as ações do Cozinheiro (retirar da fila)
        Deque<Pedido> acoesChef = new LinkedList<>();

        //Adicionando os Pedidos
        Pedido[] pedido = new Pedido[5];

        pedido[0] = new Pedido(1, "Macarrão a Bolonhesa");
        pedido[1] = new Pedido(2, "Arroz a Grega");
        pedido[2] = new Pedido(3, "Feijoada");
        pedido[3] = new Pedido(4, "Estrogonofe de Frango");
        pedido[4] = new Pedido(5, "Peixe a Milanesa");

        Pedido p1 = new Pedido(6, "Lasanha");
        Pedido p2 = new Pedido(7, "Pizza de Frango com Catupiry");
        Pedido p3 = new Pedido(8, "Pão na Chapa");

        //Armazenar os pratos pedidos
        pratosUnicos.add(pedido[0].getPrato());
        pratosUnicos.add(pedido[1].getPrato());
        pratosUnicos.add(pedido[2].getPrato());
        pratosUnicos.add(pedido[3].getPrato());
        pratosUnicos.add(pedido[4].getPrato());
        pratosUnicos.add(p1.getPrato());
        pratosUnicos.add(p2.getPrato());
        pratosUnicos.add(p3.getPrato());

        //Guardar a Ordem dos Pedidos
        pedidos.add(pedido[0]);
        pedidos.add(pedido[1]);
        pedidos.add(pedido[2]);
        pedidos.add(pedido[3]);
        pedidos.add(pedido[4]);
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);

        //Fila dos Pedidos
        filaPedidos.add(p3);
        filaPedidos.add(pedido[0]);
        filaPedidos.add(pedido[1]);
        filaPedidos.add(pedido[2]);
        filaPedidos.add(pedido[3]);
        filaPedidos.add(pedido[4]);
        filaPedidos.add(p1);
        filaPedidos.add(p2);


        //Simulação do Cozinheiro retirando da fila e preparando o Prato:

        //Retira o primeiro pedido da fila e coloca na ação do chef
        acoesChef.offer(filaPedidos.poll()); //Poll pega o primeiro da Fila (Mesma lógica em Estrutura de Dados)

        //Retira o segundo pedido da fila e coloca na ação do chef
        acoesChef.offer(filaPedidos.poll());

        //Exibindo as informações na tela:
        System.out.println("\nPratos únicos Pedidos: " + pratosUnicos);
        System.out.println("\nOrdem dos Pedidos: " + pedidos);
        System.out.println("\nFila de Pedidos: " + filaPedidos);
        System.out.println("\nAções do Chef: " + acoesChef);

    }
}