# Modificado para analise e testes.

# Espa�o de Estados e Estrat�gias de Busca

Este projeto � um exemplo de implementa��o em Java dos m�todos de busca mais comuns da �rea de Intelig�ncia Artificial, que permitem resolver problemas dos mais diversos tipos desde que modelados na forma de um Espa�os de Estados.

A solu��o de um problema � encontrada atrav�s da explora��o do espa�o que o representa, transitando entre os diferentes estados poss�veis at� que seja alcan�ado um estado que atenda os objetivos estabelecidos para a busca (estado meta).


## Problemas modelados:

Dado o car�ter generalista que as buscas oferecem, escolhemos dois problemas diferentes e os modelamos como um espa�o de estados de maneira que seja poss�vel demonstrar essas t�cnicas em funcionamento.

- **Puzzle-8**

Um quebra-cabe�as combinat�rio e de deslizamento (do tipo _sliding tile puzzle_), composto por oito pe�as numeradas que s�o distribu�das no tabuleiro e organizadas em tr�s linhas e tr�s colunas.

Dentre as nove posi��es do arranjo h� sempre uma que encontra-se vazia. � poss�vel deslizar qualquer pe�a adjacente (tanto horizontalmente quanto verticalmente) para a posi��o livre, conferindo ao tabuleiro uma nova distribui��o.

As pe�as n�o podem ser retiradas do tabuleiro, tampouco podem ser movimentadas diagonalmente ou sobre uma outra pe�a. Vale ressaltar que nem sempre qualquer seq��ncia que o usu�rio possa imaginar seria poss�vel efetivamente, uma vez que  na realidade o processo de embaralhamento � feito usando as mesmas regras. Um referencial te�rico sobre como � poss�vel determinar se uma configura��o do tabuleiro � v�lidas ou n�o, pode ser encontradas [aqui](http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html).

- **Jogo da Velha (Tic-Tac-Toe)**

Consiste num jogo em que um quadriculado com nove posi��es, organizadas em tr�s linhas e tr�s colunas, � preenchido e no qual dois jogadores se confrontam fazendo suas jogadas alternadamente. Cada um deles faz a sua jogada marcando uma posi��o vazia com o seu s�mbolo.

Jogada ap�s jogada o tabuleiro vai sendo preenchido com os s�mbolos `X` e `O`. O ganhador da disputa ser� aquele que conseguir formar primeiro uma trinca de suas marcas numa disposi��o linear.


## Estrat�gias de Busca

### Busca Cega ###

Guiam-se por uma explora��o sistem�tica do espa�o de estados, segundo uma determinada estrat�gia e utilizam apenas a descri��o do problema para conduzir o processo.

M�todos deste grupo:
 
1. *Busca em Largura*:

Constroem a �rvore de busca expandindo n�vel-a-n�vel, de modo que o aprofundamento aconte�a ap�s todas as possibilidades do n�vel anterior tenham sido analisadas.
 
2. *Busca em Profundidade*:
 
Cria a �rvore de busca se aprofundando na seq��ncia de estados sucessivos, incrementando o n�vel da �rvore a cada passo e enquanto houver sucessores para o estado corrente. Os demais estados de um mesmo n�vel somente ser�o explorados ap�s o ramo do anterior ter sido completamente finalizado.
 
Note que esta abordagem � suscet�vel a problemas frente processos c�clicos no espa�o de estados e quando n�o h� detec��o de estados repetidos, podendo incorrer num aprofundamento infinito de um ramo e, por conseq��ncia, n�o sendo capaz de explorar outras �reas do espa�o de estado.
 
3. *Busca em Profundidade Limitada*:

Opera de forma an�loga ao anterior, por�m limitando o n�vel m�ximo de aprofundamento de um ramo e evitando assim o comportamento explorat�rio infinito de um ramo que n�o cont�m uma solu��o v�lida para o problema.


### Busca Informada ou Busca Heur�stica ###

Os algoritmos desta categoria empregam estrat�gias que procuram prover maior efici�ncia funcional e de mem�ria em rela��o as abordagens cl�ssicas. Al�m da descri��o do problema, fazem uso de fun��es de custo e de avalia��o  para orientar a escolha do pr�ximo estado a ser explorado durante o processo de busca.

1. *Hill-Climbing (Subida da Encosta ou Otimiza��o Discreta)*:
    
A estrat�gia deste algoritmo consiste em realizar uma busca em profundidade em conjunto com a fun��o de avalia��o (heur�stica), de modo a selecionar dentre os nodos descendentes do ramo atual aquele que for mais promissor. 
 
2. *Best-First Search - BFS (Melhor primeiro)*:
    
O algoritmo BFS explora o espa�o de estados realizando uma busca em largura, por�m diferenciando-se por utilizar a fun��o de avalia��o para determinar a ordem de visita��o dos nodos localizados no mesmo n�vel.
 
3. *Branch-and-Bound*:
    
Tamb�m utiliza uma estrat�gia explorat�ria em largura, entretanto considera a fun��o de custo como o elemento de sele��o para determinar qual o nodo, dentre aqueles do mesmo n�vel, ser� o pr�ximo a ser visitado.
    
4. *A\* (A-Star ou Busca �tima)*:
    
5. *Iterative Deepening A-Star - IDA\**:
    
6. *Recursive Best-First Search - RBFS*: