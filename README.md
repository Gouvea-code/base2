# 📁 Projeto de Testes Automatizados para MantisBT
Este projeto tem como objetivo automatizar testes para o sistema MantisBT, uma ferramenta de gerenciamento de bugs, utilizando Selenium WebDriver, Cucumber e TestNG.</br>

Finalidade
O principal objetivo deste projeto é garantir a qualidade do MantisBT, verificando se suas funcionalidades estão funcionando corretamente e de acordo com os requisitos. Os testes automatizados ajudam a identificar problemas mais rapidamente, reduzir o tempo de execução dos testes e aumentar a confiabilidade do sistema.

# 📁 Requisitos
Java JDK: Versão 11 ou superior.</br>
Maven: Para gerenciar as dependências do projeto.</br>
Selenium WebDriver: Para automatizar as interações com o navegador.</br>
ChromeDriver: Driver do Selenium para o navegador Chrome.</br>
TestNG: Para executar os testes e gerar relatórios.</br>
Allure: Para gerar relatórios mais detalhados e visuais dos testes.</br>


# 🛠️ Configuração do Projeto
Clonar o repositório: Clone este repositório para a sua máquina local.

Instalar as dependências: Execute o comando **mvn clean install** na raiz do projeto para baixar e instalar as dependências do projeto.

# Executando os Testes

Para executar os testes, utilize o comando **mvn test**. Os resultados dos testes serão exibidos no console e um relatório será gerado na pasta target/surefire-reports.

Para gerar o relatório do Allure, execute o comando **mvn allure:serve**. O relatório será aberto automaticamente em seu navegador.
