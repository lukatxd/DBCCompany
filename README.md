# DBCCompany

Olá!
Neste repositório está o programa feito para o desafio da DBCCompany.

<h2>Instruções de instalação</h2>

<b>Banco de dados</b>

Será necessário usar o banco H2 em modo servidor. Para isso, efetue o download desta versão em específico, para facilitar a criação automática do banco:
https://storage.googleapis.com/google-code-archive-downloads/v2/code.google.com/h2database/h2-2014-01-18.zip
Extraia e execute o arquivo batch /bin/h2.bat
Feito isso, o servidor já está executando na porta padrão 8082.

O app VotingCentral criará a tabela quando estiver subindo, e a criação de tabelas fica a cargo do Flyway, que também criará quando a aplicação estiver subindo.

<b>Maven</b>

Para fazer o download das dependencias do projeto, é necessário ter o Maven instalado.
https://maven.apache.org/download.cgi
É necessário também definir a variável de ambiente M2_HOME e adicionar ao Path.

<b>VotingCentral</b>

Clone o repositório para um diretório de sua escolha. Navegue até o diretório da aplicação VotingCentral e abra uma janela de linha de comando ali.
Execute o comando:
mvn org.springframework.boot:spring-boot-maven-plugin:run
Isso irá baixar todas as dependências necessárias e o servidor Tomcat, e também irá subir a aplicação na porta padrão 8080.
