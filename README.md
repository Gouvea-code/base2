# 📁 Projeto de Testes Automatizados para MantisBT
Este projeto tem como objetivo automatizar testes para o sistema MantisBT, uma ferramenta de gerenciamento de bugs, utilizando Selenium WebDriver, Cucumber e TestNG.</br>

Finalidade
O principal objetivo deste projeto é garantir a qualidade do MantisBT, verificando se suas funcionalidades estão funcionando corretamente e de acordo com os requisitos. Os testes automatizados ajudam a identificar problemas mais rapidamente, reduzir o tempo de execução dos testes e aumentar a confiabilidade do sistema.

# 📁 Requisitos
Java JDK: Versão 11 ou superior.</br>
Maven: Para gerenciar as dependências do projeto.</br>
Selenium WebDriver: Para automatizar as interações com o navegador.</br>
ChromeDriver: Driver do Selenium para o navegador Chrome.</br>


# 🛠️ Configuração do Projeto
Clonar o repositório: Clone este repositório para a sua máquina local.

Instalar as dependências: Execute o comando mvn clean install na raiz do projeto para baixar e instalar as dependências do projeto.

Configurar o ChromeDriver:

Baixe o ChromeDriver da página oficial: https://chromedriver.chromium.org/downloads </br>
Descompacte o arquivo e coloque o executável chromedriver.exe em um diretório de sua preferência.</br>
Atualize o caminho para o ChromeDriver no arquivo WebDriverFactory.java:
Java
System.setProperty("webdriver.chrome.driver", "caminho/para/seu/chromedriver.exe");

Executar os testes:

Usando o Maven: Execute o comando mvn clean test na raiz do projeto.
