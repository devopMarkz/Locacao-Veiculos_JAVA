# Sistema de Reserva de Veículos

Este é um sistema de reserva de veículos desenvolvido em Java. O sistema permite que clientes efetuem reservas de veículos em uma locadora, além de realizar o cadastro de clientes e gerenciar a disponibilidade dos veículos. Ele também trata de situações de validação, como a verificação de disponibilidade dos veículos e a checagem de CPFs ou CNPJs já cadastrados.

## Funcionalidades

- **Cadastro de Clientes:** O sistema permite cadastrar clientes do tipo Pessoa Física e Pessoa Jurídica. Ele valida CPF e CNPJ para evitar duplicidade de cadastros.
  
- **Reserva de Veículos:** Os clientes podem reservar veículos disponíveis, especificando o período de uso. O sistema verifica a disponibilidade do veículo e atualiza o status conforme as reservas.

- **Listagem de Veículos Disponíveis:** O sistema oferece a opção de listar todos os veículos que estão disponíveis para reserva.

- **Tratamento de Exceções:** O sistema trata exceções como:
  - `VeiculoIndisponivelException`: Quando o veículo não está disponível para reserva.
  - `CpfCadastradoException`: Quando um CPF já está cadastrado no sistema.
  - `CnpjCadastradoException`: Quando um CNPJ já está cadastrado no sistema.

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

src/  
├── model/  
│   ├── entities/  
│   │   ├── Cliente.java  
│   │   ├── PessoaFisica.java  
│   │   ├── PessoaJuridica.java  
│   │   ├── Veiculo.java  
│   │   ├── Carro.java  
│   │   ├── Reserva.java  
│   │   ├── Locadora.java  
│   ├── enums/  
│   │   ├── CategoriaVeiculo.java  
│   │   ├── StatusReserva.java  
│   │   ├── TipoCambio.java  
│   ├── exceptions/  
│   │   ├── CpfCadastradoException.java  
│   │   ├── CnpjCadastradoException.java  
│   │   ├── VeiculoIndisponivelException.java  


- `Cliente.java`: Classe base para clientes.
- `PessoaFisica.java` e `PessoaJuridica.java`: Classes que estendem `Cliente` para representar clientes de diferentes naturezas (física ou jurídica).
- `Veiculo.java` e `Carro.java`: Classes responsáveis por armazenar os dados dos veículos.
- `Reserva.java`: Classe que representa uma reserva de veículo.
- `Locadora.java`: Classe principal do sistema, onde são gerenciados clientes, veículos e reservas.
- `exceptions/`: Contém as exceções customizadas do sistema.

## Requisitos

- Java 8 ou superior
- Biblioteca `java.time.LocalDate` para manipulação de datas

## Funcionalidades Principais


### 1. Cadastro de Clientes
- Adicione clientes à locadora.
- Verifique se o CPF ou CNPJ do cliente já está cadastrado para evitar duplicatas.
- Suporte para Pessoa Física e Pessoa Jurídica.

### 2. Cadastro de Veículos
- Adicione veículos à locadora.
- Os veículos possuem características como placa, modelo, marca, ano, categoria e tipo de câmbio.

### 3. Reserva de Veículos
- Realize reservas de veículos disponíveis.
- O sistema verifica se o veículo está disponível antes de confirmar a reserva.
- Atualiza o status do veículo para "indisponível" após a reserva.

### 4. Listagem de Veículos Disponíveis
- Liste todos os veículos disponíveis para reserva.

### 5. Listagem de Reservas
- Exiba todas as reservas efetuadas.

### 6. Exceções e Validações
- Exceções são lançadas para condições como veículo indisponível e CPF/CNPJ já cadastrado.


## Exceções Tratadas

O projeto inclui tratamento de exceções para garantir a robustez e a integridade dos dados. As seguintes exceções são tratadas:

### 1. `VeiculoIndisponivelException`
- **Descrição:** Lançada quando um veículo solicitado para reserva não está disponível.
- **Uso:** Garantir que apenas veículos disponíveis possam ser reservados.

### 2. `CpfCadastradoException`
- **Descrição:** Lançada quando um CPF já cadastrado é tentado novamente para um novo cliente.
- **Uso:** Evitar a duplicação de CPFs para pessoas físicas.

### 3. `CnpjCadastradoException`
- **Descrição:** Lançada quando um CNPJ já cadastrado é tentado novamente para um novo cliente.
- **Uso:** Evitar a duplicação de CNPJs para pessoas jurídicas.

Essas exceções são utilizadas para validar a disponibilidade de veículos e a unicidade dos dados dos clientes, proporcionando um fluxo de trabalho mais seguro e confiável.
