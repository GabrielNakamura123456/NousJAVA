# NOUS Web - DevOps Tools & Cloud Computing

## 📌 Descrição do Projeto

O NOUS Web é uma aplicação acadêmica desenvolvida para acompanhamento emocional e educacional de alunos, permitindo que estudantes realizem check-ins emocionais e que educadores acompanhem indicadores, histórico emocional e trilhas de desenvolvimento.

O projeto foi desenvolvido utilizando práticas de DevOps e Cloud Computing, incluindo integração contínua (CI), entrega contínua (CD), deploy automatizado em nuvem e persistência de dados em Oracle Database.

---

# 👨‍💻 Integrantes

| Nome | RM |
|------|------|
| Gabriel Nakamura Ogata | RM560671 |
| Julio Cesar Dias Vilella | RM560494 |
| Guilherme Costeira Braganholo | RM560628 |

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- Maven
- Oracle Database
- Azure DevOps
- Azure App Service
- GitHub
- Docker

---

# ☁️ Arquitetura DevOps / CI-CD

A aplicação utiliza uma pipeline CI/CD automatizada com Azure DevOps.

Fluxo da pipeline:

```text
GitHub
↓
Trigger automático
↓
Azure DevOps Pipeline

CI - Integração Contínua
↓
Java 21
↓
Maven Build
↓
Testes automatizados

CD - Entrega Contínua
↓
Deploy automático
↓
Azure App Service
↓
NOUS Web Online
↓
Persistência de dados
↓
Oracle Database
```

---

# 🖼️ Diagrama da Pipeline

![Pipeline CI/CD](./diagramasprintdevops.drawio.png)

---

# 🔄 Pipeline CI/CD

A pipeline foi configurada no Azure DevOps utilizando YAML.

Etapas executadas:

1. Trigger automático via GitHub
2. Configuração ambiente Java 21
3. Build Maven
4. Execução de testes automatizados
5. Deploy automático no Azure App Service

Arquivo da pipeline:

```text
azure-pipelines.yml
```

---

# 🌐 Aplicação Online

A aplicação foi publicada no Azure App Service:

```text
https://nous-java-rm560671-dne5g8gpamg7fkda.centralus-01.azurewebsites.net/
```

---

# 🗄️ Banco de Dados

O projeto utiliza Oracle Database em nuvem para persistência dos dados.

Foi demonstrada persistência real dos dados através da criação de check-ins emocionais armazenados no banco Oracle.

---

# 🔐 Usuários para Teste

## 👨‍🎓 Aluno

```text
E-mail: aluno@nous.com
Senha: 123456
```

## 👨‍🏫 Educador

```text
E-mail: educador@nous.com
Senha: 123456
```

---

# ▶️ Como Executar Localmente

## 1. Clonar repositório

```bash
git clone https://github.com/GabrielNakamura123456/NousJAVA.git
```

---

## 2. Entrar na pasta do projeto

```bash
cd NousJAVA
```

---

## 3. Configurar Oracle Database

Editar o arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=SEU_ORACLE_URL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

---

## 4. Executar aplicação

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / Mac

```bash
./mvnw spring-boot:run
```

---

# 📂 Estrutura do Projeto

```text
src/
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── security
 ├── config
 └── templates
```

---

# 📋 Azure DevOps

Durante o desenvolvimento foram utilizados:

- Azure Boards
- Azure Pipelines
- Work Items
- Pull Requests
- CI/CD
- Deploy automatizado

---

#  Pull Request

Foi realizado fluxo de Pull Request no GitHub para controle de versionamento e integração contínua do código.

---

#  Persistência dos Dados

A aplicação realiza persistência real no Oracle Database em nuvem.

Foi realizado teste de persistência através da criação de check-ins emocionais, comprovando armazenamento permanente dos dados após atualização da aplicação.

---

#  Demonstração

O vídeo da entrega demonstra:

- Azure Boards
- Pipeline CI/CD
- Build automatizado
- Deploy automático
- Aplicação online no Azure
- Persistência Oracle Database
- Funcionamento completo da solução

---

#  Repositório GitHub

```text
https://github.com/GabrielNakamura123456/NousJAVA
```

---

#  Status do Projeto

```text
✔ Pipeline CI/CD configurada
✔ Deploy automatizado no Azure
✔ Aplicação online funcionando
✔ Oracle Database configurado
✔ Persistência de dados funcionando
✔ Azure DevOps integrado
```
