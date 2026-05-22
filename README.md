Nous

Aplicação web desenvolvida com Spring Boot para a Sprint 3 do projeto NOUS, com foco em acompanhamento emocional de alunos e apoio analítico para educadores.

Tecnologias
Java 21
Spring Boot
Spring MVC
Thymeleaf
Spring Security
Spring Data JPA
Oracle Database
Configuração

Configure o acesso ao banco Oracle no arquivo:

src/main/resources/application.properties

Preencha com seu RM e senha:

spring.datasource.username=SEU_RM
spring.datasource.password=SUA_SENHA
Execução

Linux/Mac:

./mvnw spring-boot:run

Windows:

mvnw.cmd spring-boot:run

A aplicação estará disponível em:

http://localhost:8080
Funcionalidades
Autenticação com Spring Security
Controle de acesso por perfil (aluno e educador)
Dashboard do aluno
Registro de check-in emocional
Histórico de check-ins
Visualização de trilhas
Dashboard do educador
