# ConsumoGasolina_Automation

### Setup

- Necessário ter o **_Docker_** instalado localmente.
- Esteja com o serviço do **_Docker_** inicializado.
- A automação foi desenvolvida no **_IntelliJ_ Idea_** usando **_Selenium WebDriver Java_**, **_JUnit_** e **_Maven_**.

#### Instruções de Exceução

- Clone o repositório:
<pre>https://github.com/crisleyprestes/ConsumoGasolina_Automation.git</pre>
- Acesse o diretório do repositório.
- Decompacte o arquivo **_prova.zip_**.
- Pelo terminal ou CMD, acesse o diretório onde está o arquivo **_docker-compose.yml_** e execute o comando:
<pre>docker-compose up -d</pre>
- Aguarde os containers serem baixados, instalados e configurados.
- Após a inicialização dos containers ser finalizada, execute o comando abaixo para confirmar que os serviços estão funcionando corretamente:
<pre>docker ps</pre>
- Execute a automação usando o **_IntelliJ Idea_**.

#### Notas

- No arquivo **_docker-compose.yml_**, foi inserido os seguintes containers/comandos para inicializar o **_Selenium_**:
<pre>docker pull selenium/standalone-chrome</pre>
<pre>docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome</pre>
