## Criar uma VPC

- Escolher o serviço VPC
- Escolher a região
- Criar VPC
- Somente VPC
- Tag de nome(opcional)
- Bloco CIDR IPv4 escolher manual e inserir 10.0.0.0/16
- Locação padrão
- Tag
- Criar VPC

## Criar sub redes

- Clicar em sub redes
- Criar sub redes
- Vincular com uma VPC
- Informar nome da sub rede
- Informar zona de disponibilidade
- Informar IPv4 subnet CIDR block: 10.0.0.0/24
- Tags (opcional)
- Criar subredes ou adicionar mais subredes

## Criar instância ec2

- Ir em EC2
- Clicar em execurar intância
- Informar nome
- Escolher AMI
- Escolher tipo de instância
- Criar ou selecionar par de chaves
- Em configurações de rede escolher a vpc
- Selecionar a subnet pública
- Habilitar: Atribuir IP público automaticamente
- Crear grupo de segurança
- Remover a regra e adicionar regra para o grupo de segurança
- Em Detalhes Avançados adicionar Dados do Usuário (Script para quando rodar a instância pela primeira vez se executado - pode ser instalação de um programa como o jdk por exemplo)

## Rede pública e Internet Gateway

### Criar Internet Gateway

- Em VPC entrar em Gateways de internet
- Criar internet Gateway
- Informar o nome e criar
- - Escolher ações
- Associar o internet gateway a VPC
- Informar a VPC

### Criar Tabelas de Rotas

- Em VPC ir em tabelas de rotas
- Criar tabela de rotas
- Informar o nome
- Escolher a VPC
- Informar tags

### Associar Tabela de Rotas a Subnet pública

- Na Tabela de Rotas que deseja associar ir em associação de subredes
- Editar associação de sub redes
- Escolher a sub rede pública e salvar a associação

### Informar a rota

- Na tabela de rotas que deseja informar a rota ir em Rotas
- Editar rotas
- Adicionar rotas
- Informar destino (0.0.0.0/0)
- Informar alvo Internet Gateway
- Escolher o internet gateway
- Salvar alterações


## Rede privada e Nat Gateway Gateway

### Criar Nat Gateway

- Em VPC entrar em Nat Gateway
- Criar gateway Nat
- Informar o nome
- Escolher subnet pública
- Ir em alocar ip elástico
- Criar Nat gateway

### Criar Tabelas de Rotas

- Em VPC ir em tabelas de rotas
- Criar tabela de rotas
- Informar o nome
- Escolher a VPC
- Tags
- Criar tabela de rotas

### Associar Tabela de Rotas a Subnet privada

- Na Tabela de Rotas que deseja associar ir em associação de subredes
- Editar associação de sub redes
- Escolher a sub rede privada e salvar a associação

### Informar a rota

- Na tabela de rotas que deseja informar a rota ir em Rotas
- Editar rotas
- Adicionar rotas
- Informar destino (0.0.0.0/0)
- Informar alvo Nat Gateway
- Escolher o nat gateway
- Salvar alterações

