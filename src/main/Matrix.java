package main;

import java.util.ArrayList;
import java.util.List;

/*
You are given a 2-d matrix where each cell represents number of coins in tha cell.
Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.
For example, in this matrix
0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is: 0 + 2 + 1 + 5 + 3 + 1 = 12 coins
*/
public class Matrix {
    public static void main(String[] args) {

        List<List<Integer>> matrix = List.of(
                // rows/cols       0  1  2  3
                /* 0 */    List.of(0, 3, 1, 1),
                /* 1 */    List.of(2, 0, 0, 4),
                /* 2 */    List.of(1, 5, 3, 1)
        );

        final int matrixWidth = matrix.get(0).size();
        final int matrixHeight = matrix.size();

        // definir o nó inicial
        // indice da matrix 0,0
        int startRow = 0;
        int startCol = 0;

        int currRow = startRow;
        int currCol = startCol;
        Node startingNode = new Node(currRow, currCol, matrix.get(currRow).get(currCol), 0);


        // declara lista aberta e lista fechada
        // lista aberta para colocar os nodes que ainda estão sendo visitados
        // lista fechada para colocar os nodes que já foram visistados
        List<Node> openList = new ArrayList<>();
        List<Node> closedList = new ArrayList<>();

        // inicializa lista aberta com o nó inicial
        openList.add(startingNode);

        // enquanto a lista aberta contiver elementos faça
        do {
            // retira um elemento da lista aberta
            Node currNode = openList.remove(0);
            // adiciona o elemento na lista fechada
            closedList.add(currNode);

            // descobre os próximos nós a partir do nó atual (os caminhos possíveis)
            // descobre o vizinho a direita
            if (currNode.col + 1 < matrixWidth) { // verifica se há algum elemento a direita se sim, continua
                // Calcula a posição do nó a direita
                int nextRow = currNode.row;
                int nextCol = currNode.col + 1;
                // Recupera o valor/custo do nó a direita
                int value = matrix.get(nextRow).get(nextCol);
                // Calcula o custo total para o novo nó (nó visitado + nó atual)
                int totalCost = currNode.totalCost + value;
                // Cria um novo nó a direita
                Node neighborRight = new Node(nextRow, nextCol, value, totalCost);
                // Salva referencia do nó de origem no novo nó (por onde passa pra chegar no novo nó)
                neighborRight.setPreviousNode(currNode);
                // adiciona o novo nó na lista aberta
                openList.add(neighborRight);
            }

            // descobre o vizinho abaixo
            if (currNode.row + 1 < matrixHeight) {
                int nextRow = currNode.row + 1;
                int nextCol = currNode.col;
                int value = matrix.get(nextRow).get(nextCol);
                int totalCost = currNode.totalCost + value;
                Node neighborDown = new Node(nextRow, nextCol, value, totalCost);
                neighborDown.setPreviousNode(currNode);
                openList.add(neighborDown);
            }

        } while(openList.size() > 0);

        System.out.println(closedList);

        // Descobre o nó com maior custo na lista fechada
        Node maxTotalCostNode = closedList.get(0); // acessa o primeiro elemento da lista fechada
        for (Node currNode : closedList) { // para cada valor na lista fechada faça
            // verifica se o total custo do nodo atual é maior que o máximo total custo
            if (currNode.totalCost > maxTotalCostNode.totalCost) {
                // se sim, salva no o nó atual
                maxTotalCostNode = currNode;
            }
        }

        System.out.println("Max total cost node: " + maxTotalCostNode);

        // print o caminho partindo do nó de maior custo até chegar no nó inicial
        Node currNode = maxTotalCostNode;
        System.out.println(currNode.id + " (" + currNode.value + ")");

        while (currNode.hasPreviousNode()) { // enquanto o nó atual possuir vizinhos prévios, faça
            currNode = currNode.previousNode; // acessa e salva o valor do nó anterior no nó atual
            System.out.println(currNode.id + " (" + currNode.value + ")");
        }

    }

    public static class Node {
        String id;
        int value;
        int row;
        int col;
        Node previousNode;
        int totalCost;

        public Node(int row, int col, int value, int totalCost) {
            this.id = row + "," + col;
            this.row = row;
            this.col = col;
            this.value = value;
            this.totalCost = totalCost;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }

        public boolean hasPreviousNode() {
            return previousNode != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id='" + id + '\'' +
                    ", value=" + value +
                    ", row=" + row +
                    ", col=" + col +
                    ", previousNode=" + ((previousNode != null) ? previousNode.id : "none") +
                    ", totalCost=" + totalCost +
                    '}';
        }
    }

        /*
        int currRow = startRow;
        int currCol = startCol;

        // 0,0 (0) + 0,1 (3) + 0,2 (1)
        Integer count = matrix.get(startRow).get(startCol);

        // right
        currRow = currRow;
        currCol = currCol + 1;

        count += matrix.get(currRow).get(currCol);

        System.out.println(count);

        // right
        currRow = currRow;
        currCol = currCol + 1;

        count += matrix.get(currRow).get(currCol);

        System.out.println(count);

        // down
//        int nextRow = currRow + 1;
//        int nextCol = currCol;
    }
         */
}
