# 💈 Gerenciador de Salão

Projeto de um sistema desktop para gerenciamento de um salão de beleza, desenvolvido em Java com JavaFX e Maven. A aplicação permite o gerenciamento de clientes, agendamentos e serviços, utilizando o padrão MVC e conexão com banco de dados MySQL.

⚠️ **Projeto em Desenvolvimento** ⚠️

## ✨ Funcionalidades Principais

* **Gestão de Clientes:**
    * Cadastro, edição, exclusão e listagem de clientes.
    * Formulário com validação de campos (Nome, CPF, Telefone).
* **Gestão de Atendimentos:**
    * Listagem de atendimentos agendados, exibindo código, nome do cliente, data/hora e observações.
    * Funcionalidade para adicionar novos atendimentos (abrindo uma tela de cadastro).
    * Exclusão de atendimentos existentes com diálogo de confirmação.
* **Tela Principal:**
    * Menu de navegação para as seções "Gerenciar Atendimentos" e "Gerenciar Clientes".
    * Exibição da hora atual em tempo real.
* **Estrutura Interna:**
    * Base para gerenciamento de `Funcionarios` e `Servicos`.
    * Tela de Login (estrutura FXML criada).

## 📸 Screenshots

*(Adicione aqui screenshots da aplicação para demonstrar o visual)*

| Tela Principal | Tela de Clientes |
| :---: | :---: |
| *(Imagem da tela1.fxml)* | *(Imagem da TelaConsultaClientes.fxml)* |
| ![Tela Clientes - DADOS FICCIONAIS](<img width="781" height="711" alt="clientes" src="https://github.com/user-attachments/assets/b7c60101-b9da-41d6-8a5e-f4babb243bd2" />
) |

| Tela de Atendimentos |
| :---: |
| *(Imagem da TelaConsultaAtendimentos.fxml)* |
| ![Tela Atendimentos](<img width="847" height="777" alt="atendimentos" src="https://github.com/user-attachments/assets/c464c4ef-e2cd-4b03-810d-323411324391" />
) |

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 11
* **Interface Gráfica:** JavaFX 21 (com FXML)
* **Componentes UI:** JFoenix 9.0.10
* **Banco de Dados:** MySQL (via `mysql-connector-j`)
* **Gerenciador de Dependências:** Maven

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura baseada no padrão **Model-View-Controller (MVC)**, complementada pelos padrões **Data Access Object (DAO)** e **Service Layer**.

* **`com.cadm.gerenciadorsalao` (Controller/View):** Contém a classe `App` e as classes controladoras (`Tela1Controller`, `TelaClientesController`, etc.) que gerenciam a interação do usuário com os arquivos FXML.
* **`model.classes` (Model):** Classes de entidade (POJOs) como `Pessoas`, `Clientes`, `Atendimentos`, etc.
* **`model.dao` (DAO):** Classes responsáveis pela comunicação direta com o banco de dados (`PessoasDao`, `AtendimentosDao`, etc.).
* **`model.services` (Service):** Camada de serviço que contém as regras de negócio (`PessoasServices`, `AtendimentosServices`, etc.).
* **`model.db`:** Classe utilitária para gerenciamento da conexão com o banco de dados (`DB.java`).

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e executar a aplicação em seu ambiente local.

### 1. Pré-requisitos

* JDK 11 ou superior (configurado nas variáveis de ambiente).
* Apache Maven.
* Um servidor MySQL (como XAMPP, WAMP, MySQL Workbench ou Docker) em execução.

### 2. Configuração do Banco de Dados

1.  Inicie seu servidor MySQL.
2.  Crie um novo banco de dados (schema) com o nome `gerenciador`.
3.  Assegure que as credenciais de acesso estejam corretas. O projeto está configurado por padrão para:
    * **Usuário:** `root`
    * **Senha:** `""` (vazia)
    * **URL:** `jdbc:mysql://localhost:3306/gerenciador`
4.  Caso suas credenciais sejam diferentes, altere-as no arquivo `src/main/java/model/db/DB.java`.
5.  **Importante:** Você precisará criar as tabelas (`Pessoas`, `Servicos`, `Atendimentos`, `AtendimentosServicos`, etc.) manualmente. O script SQL de criação não está incluído neste repositório.

### 3. Instalação e Execução

1.  Clone este repositório:
    ```bash
    git clone [https://github.com/pablotheves/GerenciadorSalao.git](https://github.com/pablotheves/GerenciadorSalao.git)
    cd GerenciadorSalao
    ```

2.  Instale as dependências do projeto usando o Maven:
    ```bash
    mvn install
    ```

3.  Execute a aplicação usando o plugin do Maven para JavaFX:
    ```bash
    mvn clean javafx:run
    ```
    *(Este comando é baseado na configuração do arquivo `nbactions.xml`)*

4.  Alternativamente, você pode abrir o projeto em sua IDE (NetBeans, IntelliJ, Eclipse) e executar a classe principal `com.cadm.gerenciadorsalao.App`.

## 👨‍💻 Autor

* **Pablo Theves** - [pablotheves](https://github.com/pablotheves)
