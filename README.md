![TAD](https://github.com/TCriGa/TAD_LLCircular_Ex_Tabuleiro/assets/90049866/350d4ad5-310b-43e1-88e8-50ba349e6017)

![Static Badge](https://img.shields.io/badge/java%20-%20java?style=flat&color=BF50E8)
![Static Badge](https://img.shields.io/badge/estruturaDeDados%20-%20estruturaDeDados?style=plastic&logoColor=FFFFFF&color=CCFFFF)
![Static Badge](https://img.shields.io/badge/L2L%20-%20L2L?color=%23E660E1)

## <h1 align="center"> Exercício L2L: </h1>

- O tabuleiro (a lista) deverá ter no mínimo 10 elementos.
- Cada um dos elementos representa uma casa do tabuleiro.
- O jogo deve ter no mínimo 2 jogadores e no máximo 4.
- Um gerador aleatório deverá simular um dado (números inteiros entre 1 e 6).

As regras são:
1. As casas são numeradas sequencialmente iniciando por 1.
   
3.  Cada jogador possui uma peça que marcará sua posição no tabuleiro. O jogador pode decidir, na sua vez de jogar, após lançado o dado, se vai movimentar a sua peça no sentido horário (da esquerda para a direita, utilizando o método getProximo()) ou no anti-horário (da direita para a esquerda, utilizando o método getAnterior()).
4. Cada casa do tabuleiro tem 3 possíveis status: livre, marcada e proprietária:
> - Ao cair em uma casa livre, esta será marcada a favor do jogador.
> - Ao cair em uma casa marcada por outro jogador, esta será desmarcada e voltará ao status livre.
4. O jogador, ao cair pela segunda vez em uma casa anteriormente marcada por ele, passará a ser proprietário desta casa.
5. O jogador que cair em uma casa proprietária de outro jogador não joga na próxima rodada.
6. O jogador que conquistar uma casa contígua a outra de sua propriedade, ganha uma nova casa, já com o status de sua propriedade, a ser inserida entre as duas primeiras. As casas deverão ser renumeradas para manter a sequência numérica.
7. O jogador que conquistar 2 casas, uma de cada lado de uma casa proprietária de outro jogador, destrói esta casa (extrai da lista, devendo também ser feito o acerto da numeração). Esta regra só é válida para o caso de 2 casasenvolverem 1. Duas ou mais casas contíguas, de propriedade do mesmo jogador, não podem mais ser eliminadas.

8. O jogo se encerra em duas possíveis situações (a que ocorrer primeiro):
   <p class="has-line-data" data-line-start="26" data-line-end="31">
     a. Após a quantidade de jogadas estabelecidas no início do jogo.<br>
- Ganha quem tiver mais casas proprietárias com os seguintes critérios de desempate:<br>
i. Soma das casas marcadas<br>
ii. Quantidade de ligações entre casas de mesma propriedade (2 casas tem 1 ligação)<br>
b. Quando a soma de casas de propriedade de um jogador for maior que a soma das casas proprietárias do segundo jogador com maior número de casas proprietária somadas às casas livres.</p>
