# 🧩 Eventos Acadêmicos — Sistema de Gestão de Atividades

Este projeto é um sistema acadêmico simplificado desenvolvido em **Java 21**, **Spring Boot**, **JPA/Hibernate** e banco em memória **H2**.  
Ele gerencia **atividades**, **participantes**, **blocos de horários** e **categorias**, demonstrando na prática o uso dos relacionamentos:

- **Many-to-One**
- **One-to-Many**
- **Many-to-Many**

---

## 🏛️ Modelo de Domínio

O sistema possui as seguintes entidades:

---

### 📌 Categoria
- **ID**
- **Descrição**
- Uma categoria possui **várias atividades**

**Relação:** `1 Categoria -> N Atividades`

---

### 📌 Atividade
- **ID**
- **Nome**
- **Descrição**
- **Preço**
- **Categoria (ManyToOne)**
- **Blocos (OneToMany)**
- **Participantes (ManyToMany)**

**Relações:**
- `1 Atividade -> N Blocos`
- `N Atividades <-> N Participantes` *(JoinTable)*

---

### 📌 Bloco
Bloco representa um intervalo de tempo de uma atividade.

- **ID**
- **Início**
- **Fim**
- **Atividade (ManyToOne)**

---

### 📌 Participante
- **ID**
- **Nome**
- **Email**
- **Atividades (ManyToMany)**

---

## 🔗 Estrutura do Banco & Relacionamentos

### Many-to-Many entre Atividade e Participante:

```java
@ManyToMany
@JoinTable(
    name = "tb_atividade_participante",
    joinColumns = @JoinColumn(name = "atividade_id"),
    inverseJoinColumns = @JoinColumn(name = "participante_id")
)
private Set<Participante> participantes = new HashSet<>();
Lado inverso:

java
Copiar código
@ManyToMany(mappedBy = "participantes")
private Set<Atividade> atividades = new HashSet<>();
🗄️ Script SQL (data.sql)
O projeto inicia com dados pré-carregados:

Categorias

Atividades

Blocos

Participantes

Relações Many-to-Many

Exemplo:

sql
Copiar código
INSERT INTO tb_categoria(descricao) VALUES ('Curso');
INSERT INTO tb_categoria(descricao) VALUES ('Oficina');

INSERT INTO tb_atividade(categoria_id, nome, descricao, preco)
VALUES (1, 'Curso de HTML', 'Aprenda HTML de forma prática', 80.0);
⚙️ Configurações (application.properties)
Banco H2 configurado para testes:

properties
Copiar código
spring.profiles.active=test
spring.jpa.open-in-view=false

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Acesse o H2 Console em:

👉 http://localhost:8080/h2-console

▶️ Como Rodar o Projeto
1. Clonar o repositório
bash
Copiar código
git clone https://github.com/SEU-USUARIO/seu-repo.git
2. Acessar o diretório
bash
Copiar código
cd seu-repo
3. Executar o projeto
bash
Copiar código
mvn spring-boot:run
4. Banco disponível na H2 Console
JDBC URL: jdbc:h2:mem:testdb

Usuário: sa

Senha: (vazio)

🧠 O que este projeto demonstra
✔ Uso correto de relacionamentos JPA
✔ Mapeamento Many-to-Many com JoinTable
✔ Carga inicial via data.sql
✔ Modelo de domínio organizado
✔ Ideal para estudos de Spring Boot + JPA + H2

🚀 Possíveis Melhorias Futuras
Criar Controllers REST

Implementar DTOs

Adicionar Swagger

Criar testes unitários
