<a name="readme-top"></a>

<p align="center">
  <a href="#">
    <img src="https://ibb.co/LpQkcpk" />
  </a>
</p>
&nbsp;


![GitHub Repo size](https://img.shields.io/github/repo-size/ma-elissa/LocateCar)
![GitHub issues](https://img.shields.io/github/issues/ma-elissa/LocateCar)
![Build with Maven](https://img.shields.io/badge/Build%20with-Maven-brightblue)
[![Java Version](https://img.shields.io/badge/Java-21-red)](https://docs.oracle.com/javase/21/docs/api/)
![Open Source](https://img.shields.io/badge/Open%20Source-Yes-green)


# LOCATECAR - JAVA APP ☕
O projeto *LocateCar* é uma aplicação em Java desenvolvida como parte de um sistema de gerenciamento de uma locadora de veículos. A aplicação tem como objetivo principal facilitar o processo de locação de veículos, proporcionando uma experiência rápida e conveniente para clientes e funcionários da locadora.

## Indice

- <a href="#intro">Introdução</a>
- <a href="#conceito">Conceitos do módulo</a>
- <a href="#arq">Arquitetura de Pastas do projeto</a>
- <a href="#meto">A metodologia</a>
- <a href="#demo">Demonstração do APP</a>
- <a href="#fluxo">Fluxo para alocar veículo</a>
- <a href="#acao">Ações</a>
- <a href="#rn">Regras de negócios </a>
- <a href="#acaoafazer">Ações a fazer</a>
- <a href="#front">Interface - Java Swing</a>

<!-- <img src="#" fullwidth/> -->

## Introdução ☕
<a name="intro"></a>
Ao longo do módulo de Programação Orientada o Objetos II, nos aprofundamos nos conceitos e aplicações de Interfaces, Generics e SOLID em Java.
Aqui você vai encontrar a resolução do projeto final, onde desenvolvemos um sistema utilizando os novos conhecimentos adquiridos.


## Conceitos do módulo ☕
<a name="conceito"></a>
Dentre os conceitos estudados: Generics, Interfaces, Collectins, Comparable, e SOLID, o que tivemos mais facilidade de aplicar no projeto foram Generics e Interfaces. A medida que o projeto crescia aumentava a complexidade e sentimos dificuldades em aplicar o Open/Closed Principle (Princípio Aberto/Fechado).

## Arquitetura de Pastas do projeto ☕
<p align="center">
  <a href="#">
    <img src="https://ibb.co/wwvkxV0" />
  </a>
</p>
<p align="center"> Figura: Organização de pastas do projeto na data de 17/03/24</p>

## A metodologia ☕
<a name="meto"></a>

<p align="center">
  <a href="#">
    <img src="https://ibb.co/VxrwYvY" />
  </a>
</p>

<p align="center"> Figura: Quadro de tarefas do projeto</p>

Foi utilizada uma abordagem de resolução de problemas e desenvolvimento de software.

Algumas etapas do desenvolvimento foram:

**1. Entendimento do problema:** Procuramos entender os requisitos do negócio e os objetivos a serem alcançados.

**2. Planejamento:** Dividimos o problema em partes menores e mais gerenciáveis. Isso ajudou a abordar cada etapa de forma mais eficaz.

**3. Escolha da metodologia de desenvolvimento:** Metodologias ágeis, usamos um quadro Kanban do Github projects, para lidar com organização e autogerenciamento.

**4. Implementação e Desenvolvimento:** A escolha das ferramentas adequadas para implementar a solução foi a mesma utilizada nos módulos anteriores: IntelliJ, Maven e Java 21. Além disso,  decidimos incluir mais um desafio como parte deste projeto para nosso aprendizados e experiência, que foi fazer implementações do Java Swing para criar um experiência mais agradável ao usuário.

**5. Documentação:** A documentação consiste na escrita deste README mantendo registros detalhados do processo de desenvolvimento, incluindo decisões, problemas encontrados e soluções implementadas e também este docuemento no [Notion](https://www.notion.so/Documenta-o-c2443f038dbc42f8b87242e78771ab69) utilizado durante as reuniões de planning.

**6. Comunicação:** Fizemos dailys e reuniões regulares para assegurar que a solução proposta atendesse às expectativas do negócio.

🧰 Ferramentas úteis:

- Controle de versão:  Git. Também utilizamos Gitflow durante o desenvolvimento.
- Ambientes de Desenvolvimento Integrado -(IDEs): Visual Studio Code e IntelliJ.
- Plataformas de Gerenciamento de Projetos: - Github Projects.
- outros: Miro, Draw.io.

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>

## Demonstração da Aplicação ☕
<a name="demo"></a>

 <p align="center">
  <a href="#">
    <img src="https://ibb.co/FmRVSQ8" />
  </a>
</p>

<p align="center"> Figura: Demonstração da aplicação</p>

## Fluxo para alocar veículo ☕
<a name="fluxo"></a>

<p align="center">
  <a href="#">
    <img src="https://ibb.co/TcxjTxk" />
  </a>
</p>

<p align="center"> Figura: Fluxo para realizar uma locação</p>

## Ações ☕
<a name="acao"></a>
<h3>
Clientes
</h3>

|Ação  | Descrição | Requer                         
--------------------------------------------------------------------------------------------------------------|------------|------------------------------|
| Criar um novo cliente por tipo de id            | `CREATE`    | CNPJ ou CPF   |
| Listar cliente por identificação                | `READ`      | CNPJ ou CPF   | 
| Atualizar as informações de um cliente          | `UPDATE`    | CNPJ eou CPF   |
| Deletar o cliente por identificação             | `DELETE`    | CNPJ ou CPF   |

<h3>
    Veículos
</h3>

| Ação     | Descrição | Requer Tipo de Veículo                         
|--------------------------------------------------------------------------------------------------------------|------------|------------------------------|
| Criar um novo veículo                   | `CREATE`     | PEQUENO, MÉDIO E SUV   |
| Listar todos os veículos                | `READ`      | PEQUENO, MÉDIO E SUV    | 
| Atualizar as informações de um veículo  | `UPDATE`    | PEQUENO, MÉDIO E SUV    |
| Deletar um veículo                      | `DELETE`    | PEQUENO, MÉDIO E SUV  |

<h3>
    Locação
</h3>

| Ação                                                                                                         | Descrição | Requer                         
|--------------------------------------------------------------------------------------------------------------|------------|------------------------------|
| Criar uma nova locação                     | `CREATE`    | CNPJ/CPF e PLACA |
| Listar uma locação                         | `READ`      | CNPJ ou CPF e PLACA | 
| Deletar uma locação                        | `DELETE`    | CNPJ ou CPF e PLACA    |


<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>

<h1> Regras de negócios </h1>
<a name="rn"></a>

| Regra de negócio    | Descrição                     
|----------|------------
|`RN1:`|  Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;|----------|------------
|`RN2:`|  Tipos de veículos que serão considerados: PEQUENO, MEDIO e SUV;|----------|------------
|`RN3:`|  Os aluguéis e devoluções terão o local, data e horário;|----------|------------
|`RN4:`| Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.|----------|------------
|`RN5:`| Os veículos que estiverem alugados não poderão estar disponíveis;|----------|------------
|`RN6:`| Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;|----------|------------
|`RN7.1:`| Devolução: Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.|-|-|
|`RN7.2:`| Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.|-|-|


## Ações a Fazer ☕
<a name="acaoafazer"></a>

- **O sistema deverá iniciar com um Administrador primordial (Adão).**

### Cliente pessoa física e jurídica
- [x] : Cadastrar cliente
- [x] : Listar cliente por identificador
- [x] : Atualização dados do cliente
- [ ] : O Usuário não poderá cadastrar o cpf ou cnpj caso já estejam cadastrados.
- [x] : O Usuário poderá alterar email, senha, endereço, telefone, porém não o cpf ou cnpj.

### Veículo
- [x] : Cadastrar um veículo por tipo
- [x] : Listar veículos por disponibilidade
- [x] : Listar veículo por atributo
- [x] : Atualizar dados de um veículo
- [x] : Deletar um veículo

### Locação
- [x] : Cadastrar uma locação
- [x] : Listar locação por identificador de cliente e veículo
- [x] : Deletar uma locação
- [x] : Atualizar disponibilide de veículo devolvido
----------------------------------------------------------------------------------------------
<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>

##  Frontend: Java Swing ☕
<a name="front"></a>
Como já mencionado, utilizamos o  Java Swing, que é uma biblioteca de componentes de interface gráfica (GUI) para Java. Utilizamos alguns componentes e fizemos alguns personalizados. Foi interessante ver a flexibilidade e o comportamento dos componentes Swing.

### Telas
Algumas telas desenvolvidas:

<p align="center">
  <a href="#">
    <img src="https://ibb.co/FmRVSQ8" />
  </a>
</p>


### Pastas

Por padrão, estamos usando a pasta `frontend` para armazenar e manipularmos as interfaces e implementações referentes ao frontend.




## 💻 Ajustes e melhorias
O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:
- [] : Adicionar camada de segurança
- [] : Buscar veículo por parte do nome
- [] : Paginação de clientes
- [] : Paginação de veículos
- [] : Paginação de alocação
- [] : Exportar arquivo
- [] : Histórico de locações

## 🤝 Colaboradores
<a name="contribua"></a>
<table align="center"><tr>
 <td align="center"><a href="https://github.com/fernandacostads" target="_blank"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/59060824?v=4" width="100px;" alt=""/>
    <br />
    <sub><b>Fernanda Costa</b></sub></a>

<br />
<a href="#" alt="LinkedIn">
  <img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white&link=https://linkedin.com/in/fernandacostads" /></a>
</td>
    <td align="center"><a href="https://github.com/ma-elissa" target="_blank"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/128258713?v=4" width="100px;" alt=""/>
    <br />
    <sub><b>Maria Elissa</b></sub></a>

<br />
<a href="#" alt="LinkedIn">
  <img src="https://img.shields.io/badge/-Linkedin-0e76a8?style=flat-square&logo=Linkedin&logoColor=white&link=https://linkedin.com/in/ma-elissa" /></a>
</td>
  </tr>
</table>


## 😄 Seja um dos contribuidores!
Quer fazer parte desse projeto? Para contribuir, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: git checkout -b <nome_branch>.
3. Faça suas alterações e confirme-as: git commit -m '<mensagem_commit>'
4. Envie para o branch original: git push origin <nome_do_projeto> / <local_>
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em como criar uma solicitação pull.
Clique [AQUI](https://opensource.guide/how-to-contribute/) e leia como contribuir.


## 📝 Licença
Esse projeto está sob licença. Veja o arquivo [LICENÇA](https://github.com/ma-elissa/LocateCar/LICENSE.md) para mais detalhes.


<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>
<hr>
<p align="center">Copyright © 2024 | LocateCar by Fernanda Costa e Maria Elissa
  <a href="#">
    <img src="" />
  </a>
</p>