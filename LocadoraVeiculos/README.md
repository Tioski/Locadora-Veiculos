# Locadora de Veículos

Um sistema completo de gerenciamento de locação de veículos desenvolvido em Java. A aplicação oferece uma interface de menu interativa para gerenciar clientes, veículos e locações.

## 📋 Descrição

O projeto implementa um sistema de locadora de veículos com funcionalidades para:
- **Cadastro de Clientes**: Registrar e gerenciar informações de clientes
- **Cadastro de Veículos**: Adicionar diferentes tipos de veículos (Carros, Motos, Caminhonetes)
- **Sistema de Aluguel**: Alugar veículos para clientes
- **Sistema de Devolução**: Registrar devoluções com quilometragem
- **Histórico de Locações**: Visualizar todas as locações registradas

## 🏗️ Estrutura do Projeto

```
LocadoraVeiculos/
├── src/
│   ├── Locadora.java          # Classe principal com menu interativo
│   ├── Cliente.java            # Entidade de Cliente
│   ├── Veiculo.java            # Classe abstrata base para veículos
│   ├── Carro.java              # Implementação de Carro
│   ├── Moto.java               # Implementação de Moto
│   ├── Caminhonete.java        # Implementação de Caminhonete
│   └── Locacao.java            # Entidade de Locação
├── lib/                        # Dependências externas
└── README.md                   # Este arquivo
```

## 🚀 Como Usar

### Compilar o Projeto

```bash
javac -d bin src/*.java
```

### Executar a Aplicação

```bash
java -cp bin Locadora
```

### Menu Principal

Após executar, você terá acesso às seguintes opções:

1. **Cadastrar Cliente** - Registrar um novo cliente
2. **Cadastrar Veículo** - Adicionar um novo veículo à frota
3. **Listar Clientes** - Visualizar todos os clientes cadastrados
4. **Listar Veículos** - Visualizar todos os veículos disponíveis
5. **Alugar Veículo** - Registrar um aluguel
6. **Devolver Veículo** - Processar devolução de veículo
7. **Listar Locações** - Ver histórico de locações
8. **Sair** - Encerrar a aplicação

## 🛠️ Classes Principais

### Veiculo (Abstrata)
Classe base para todos os tipos de veículos com atributos como:
- Marca, modelo, placa
- Ano de fabricação
- Quilometragem
- Status de disponibilidade

### Cliente
Armazena informações do cliente:
- Nome e CPF
- Telefone e email
- Histórico de locações

### Locacao
Gerencia cada locação com:
- Cliente e veículo alugado
- Data de locação e devolução
- Status da locação (ativa/encerrada)
- Quilometragem rodada

### Tipos de Veículos
- **Carro** - Veículo de passeio
- **Moto** - Veículo de duas rodas
- **Caminhonete** - Veículo de carga

## 💾 Estrutura de Pastas

- `src/` - Código-fonte Java
- `lib/` - Dependências externas (se houver)
- `bin/` - Arquivos compilados (gerado automaticamente)

## 📝 Requisitos

- Java 8 ou superior
- Compilador Java (javac)

## 🎯 Próximas Melhorias

- Implementar persistência de dados (banco de dados)
- Adicionar sistema de cobranças
- Interface gráfica (GUI)
- Relatórios de rentabilidade


