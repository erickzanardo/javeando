Javeando
========

Repositório com desafios em Java para treinar ensinamentos na linguagem e se divertir um pouco :D

**Importante:** Caso seja a primeira vez que está fazendo algum desafio deste repositório, é necessário instalar o motor de jogo antes, para fazer isso basta entrar na pasta GameEngine e executar o comando mvn clean install.

Lembre-se também, caso não tenha ainda, configurar a variável M2_REPO no seu eclipse, faça isso no eclipse indo no menu Window -> Preferences - Classpath Variables e adicione o caminho do seu repositório maven com uma variavel de nome M2_REPO. O repositório maven normalmente fica no diretório .m2 dentro do seu user, por exemplo: C:/Users/erick.zanardo/.m2/repository

### Panetteria

Francesco é o dono de uma cafeteria perto de um polo de empresas de desenvolvimento de Software, mas seu estabelecimento está um tanto quanto desorganizado e precisamos ajuda-lo a atender seus clientes.

Em sua cafeteria Francesco costuma receber três tipos de clientes, os programadors, os arquitetos e os coordenadores e cada tipo de cliente tem sua peculiaridade:

* Programadores compram um produto da cafeteria e um doce, pagam com dinheiro e as escolhas são sempre as mais baratas de seus tipos
* Arquitetos compram um produto da cafeteria e um salgado, pagam no débito e as escolhas são sempre as mais caras de seus tipos
* Coordenadores compram dois produtos naturais e sempre pagam no crédito

Para ajudar Francesco temos que codificar as rotinas que ajudam os clientes a escolherem o seu pedido e realizar o pagamento, ao baixar o projeto você encontrará os seguintes testes já implementados
- ClienteTeste (Obs.: O teste de escolha de produto espera que a classe Pedido trate os itens de forma ordenada alfabeticamente)
- ContaTeste
- PagamentoTeste
- MenuTeste

Estes testes estão garantindo que se estiverem passando, Francesco irá faturar uma boa quantia de $$$$

Para realizar esta brincadeira, faça um fork e/ou um clone dos fontes, depois entre na pasta panetteria pela linha de comando e rode mvn eclipse:eclipse para preparar o ambiente. Agora é só importar o projeto no Eclipse usando o menu File - Import - Existing Projects into Workspace.

Para ver como está a situação atual da cafeteria do Francesco execute a classe Panetteria.

### Golden Hammer

Golden Hammer é o nome da fábrica de armas que os anões Larry, John, Charles e Rudolf estão montando. Mas estão tendo problemas em organizar a sua linha de produção e precisam da tua ajuda para que sejam reconhecidos como os melhores armeiros de toda a terra média!

Para isso precisamos fazer alguns testes passarem, FerreiroTest, LenhadorTest, MineradorTest e VendedorTest, estes testes garantem que as ações escolhidas pelos anões sejam as quais irão fazer com que a produção da fábrica funcione. Para a escolha das ações deve ser implementado o método retornaAcoes das classes Ferreiro, Lenhador, Mineiro e Vendedor. Para isto devem ser respeitadas as seguintes regras para cada tipo de anão:

Vendedor: Quando houver um cliente na loja deve retornar as seguintes ações
- Ir para a loja receber o cliente
- Requisitar o produto que o cliente está querendo comprar
- Esperar até que o produto esteja disponível no depósito
- Recolher o produto no depósito
- Entregar o produto para o cliente

Ferreiro: Quando for requisitado um item do tipo produto deve retornar as seguintes ações
- Requisitar materiais necessários para a construção do produto
- Esperar até que os materiais requisitados anteriormente estejam disponíveis no depósito
- Recolher os materiais requisitados no depósito
- Forjar o produto

Lenhador: Quando for requisitado um material tábua deve retornar as seguintes ações
- Colher madeira na floresta
- Processar a madeira em tabuas
- Depositar as tabuas no depósito
 
Mineiro: Quando for requisitado um material lingote de ferro deve retornar as seguintes ações
- Minerar
- Fundir os minérios
- Depositar o lingote de ferro no depósito

Para realizar requisição de materias/produto utilize _Pedidos.instance().requisitar()_

**Importante** Todos os anões retornam para a taverna após chegarem ao fim de suas ações, pois nenhum anão confiavel trabalharia bem sem antes uma bela caneca de cerveja e um farto pedaço de javali na brasa!!!!!
