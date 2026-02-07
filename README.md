# BarberFlow ✂️💈
Sistema completo de gestão para barbearias desenvolvido com **Java e Spring Boot**, utilizando **arquitetura de microsserviços**, **banco de dados Oracle** e **boas práticas adotadas no mercado**.  
O projeto foi pensado com uma visão profissional, escalável e orientada a domínio, servindo tanto como **portfólio técnico** quanto como base para um produto real.

## Funcionalidades
- Agendamento online
- Controle de barbeiros
- Venda de serviços e produtos
- Financeiro e comissões
- Notificações
- Painel administrativo

## Arquitetura
- **Java 17**
- **Spring Boot**
- **Oracle Database**
- **Flyway** para versionamento de banco
- **Clean Architecture**
- **DDD pragmático**
- **Facade Pattern** para comunicação entre módulos

## 🎯 Objetivo do Projeto

Criar uma plataforma backend moderna para gerenciamento de barbearias, cobrindo desde **agendamentos** até **controle financeiro**, **faturamento**, **notificações** e **administração do negócio**, aplicando conceitos como:

- Microsserviços
- Domain-Driven Design (DDD)
- Arquitetura orientada a eventos
- Comunicação síncrona e assíncrona
- Separação clara de responsabilidades
- Padrões utilizados em ambientes corporativos

### Microsserviços principais:

- **agendamento-service**  
  Gerencia horários, agenda dos barbeiros e disponibilidade.

- **usuario-service**  
  Gerencia clientes, barbeiros e administradores.

- **catalogo-service**  
  Serviços oferecidos pela barbearia e seus preços.

- **financeiro-service**  
  Vendas, faturamento, receitas, despesas e lucro.

- **notificacao-service**  
  Envio de notificações (e-mail, WhatsApp, etc).

- **auth-service**  
  Autenticação e autorização (JWT).

---

## 🔄 Comunicação entre Serviços

### Comunicação síncrona
Utilizada quando um serviço precisa de uma resposta imediata.

- **Feign Client**
- DTOs dedicados (nenhuma entidade JPA é exposta)
- Timeouts e isolamento de falhas

Exemplo:
- Agendamento consultando dados do cliente no `usuario-service`

---

### Comunicação assíncrona (eventos)

Utilizada para desacoplamento e escalabilidade.

- Eventos de domínio (ex: `AgendamentoCriadoEvent`)
- Outros serviços reagem sem dependência direta

Exemplo:
- Agendamento criado →
    - Notificação enviada
    - Receita prevista no financeiro
    - Agenda do barbeiro atualizada

A arquitetura já está preparada para evolução com **Kafka ou RabbitMQ**.

---

## Estrutura Multimodular
O projeto é um **monólito modular** preparado para evolução em microsserviços.  
Cada domínio é isolado em um módulo próprio, garantindo baixo acoplamento e alta coesão.

### Módulos principais
- **barbearia-api** → módulo pai (packaging `pom`), responsável por orquestrar os demais
- **barbearia-commons** → utilitários e classes compartilhadas
- **barbearia-dominio** → regras de negócio e entidades
- **barbearia-servicos-int** → núcleo da aplicação, contém a classe principal `BarbeariaApiApplication`
- **barbearia-servicos-int-admin** → funcionalidades administrativas
- **barbearia-servicos-int-api** → camada de integração e exposição de serviços
- **barbearia-servicos-int-cliente** → funcionalidades voltadas ao cliente


### Comunicação
- Os módulos se comunicam via **Facade** e **Feign Clients**, mantendo isolamento e flexibilidade para futura migração a microsserviços.

---

## 🗄️ Banco de Dados
- Oracle Database
- Cada microsserviço possui seu próprio schema
- Scripts DDL versionados com Flyway
- Modelagem focada em integridade, performance e clareza

---

## 🧩 Padrões e Boas Práticas Utilizadas
- Facade Pattern
- DTO Pattern
- Repository Pattern
- Event-Driven Architecture
- Clean Code
- SOLID
- Transaction Management
- Versionamento de API
- Separação de camadas

---

## 🔐 Segurança
- Autenticação via JWT
- Controle de acesso por perfil (**ADMIN**, **BARBEIRO**, **CLIENTE**)
- Serviços desacoplados da lógica de autenticação

---

## 🚀 Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- Spring Cloud OpenFeign
- Oracle Database
- Maven
- Docker (em evolução)
- Event-driven architecture
- Swagger

---

## 📈 Evoluções Planejadas
- Kafka para eventos assíncronos
- Resilience4j (Circuit Breaker)
- Observabilidade (Prometheus + Grafana)
- Testes automatizados com Testcontainers
- Docker Compose completo
- CI/CD

---


## Como rodar
1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/barberflow.git
   cd barberflow/barbearia-servicos-int
2. Suba os serviços com Docker:
   ```bash
   docker-compose up
   

3. Clone o repositório:
   ```bash
   mvn sping-boot:run

A aplicação estará disponível em:
- 
- http://localhost:8080 (API principal)
- http://localhost:8080/actuator (endpoints de monitoramento)

