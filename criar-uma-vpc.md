# Material de apoio

## POC - LOGS

- Clicar em sub redes
- Criar sub redes
- Vincular com uma VPC
- Informar nome da sub rede
- Informar zona de disponibilidade
- Informar IPv4 subnet CIDR block: 10.0.0.0/24
- Tags (opcional)
- Criar subredes ou adicionar mais subredes

### Links

- [Configurando o logback](https://helpdev.com.br/2020/02/24/java-configurando-o-log-slf4j-de-sua-aplicacao-para-o-logstash-elk/)
- [Configurando logback no spring boot](https://artefatox.com/configurando-logback-no-springboot/)
- []()

## POC

eseja associar ir em associação de subredes
-
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

