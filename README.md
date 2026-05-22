NOUS Web

Aplicação web desenvolvida com Spring Boot para acompanhamento emocional e educacional de alunos, com foco em apoio analítico para educadores através de dashboards, check-ins emocionais e trilhas de desenvolvimento.

Deploy online:
https://nousjava.onrender.com

Repositório GitHub:
https://github.com/juliovilella88/NousJAVA

Tecnologias utilizadas
Java 21
Spring Boot
Spring MVC
Spring Security
Spring Data JPA
Thymeleaf
Oracle Database
Maven
HTML5
CSS3
Render
Funcionalidades
Área do aluno
Login autenticado
Dashboard personalizado
Registro de check-in emocional
Histórico de check-ins
Visualização de trilhas
Recomendações automáticas com base no humor informado
Área do educador
Dashboard analítico
Visualização de alunos
Identificação de alertas emocionais
Histórico emocional dos alunos
Acompanhamento do progresso das trilhas
Segurança
Autenticação com Spring Security
Controle de acesso por perfil:
ROLE_ALUNO
ROLE_EDUCADOR
Banco de dados

O projeto utiliza Oracle Database.

Configuração no arquivo:

src/main/resources/application.properties

Exemplo:

spring.datasource.username=SEU_RM
spring.datasource.password=SUA_SENHA
Execução local
Windows
mvnw.cmd spring-boot:run
Linux / Mac
./mvnw spring-boot:run

Aplicação disponível em:

http://localhost:8080
Usuários para teste
Aluno
E-mail: aluno@nous.com
Senha: 123456
Educador
E-mail: educador@nous.com
Senha: 123456
Estrutura do projeto
src/
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── security
 ├── config
 └── templates
Arquitetura

O projeto foi desenvolvido utilizando arquitetura em camadas:

Controller
Service
Repository
Model
DTO

Principais conceitos aplicados:

MVC
Injeção de Dependência
APIs REST
Validação de dados
Controle de autenticação e autorização

Integrantes
Julio César Dias Vilella
Gabriel Nakamura Ogata
Guilherme Costeira Braganholo 
