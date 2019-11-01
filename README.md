# Projeto Gerando Gênios - No Limits da Zup
## No que consiste esse repositório?
Este repositório, em específico, serve para adicionar os códigos dos desafios propostos pela Zup no seu programa Gerando Gênios (POD No Limits). De maneira geral, vamos terá apenas o branch mastes (eu acho) com as suas respectivas pastas na qual, dentro delas, se encontra o código fonte e o executável (.jar) da aplicação.
## Lista  de desafios (concluídos):
 - Criar um programa que, de maneira recursiva, apresente as subpastas e arquivos de uma determinada pasta. É necessário utilizar o Maven como gerenciador de dependências.
   1. Entre na pasta "ListarDiretorios";
   2. Entre na subpasta "target";
   3. Faça o download do arquivo "ListarDiretorios-1.0.jar";
   4. Na pasta de destino do arquivo, escreva ou copie e execute (no terminal) o seguinte comando **java -jar ListarDiretorios-1.0.jar**
 - Criar um programa que apresente os primeiros tópicos do Reddit (/r/programming) em ordem alfabética
   1. Entre na pasta "ListarReddit";
   2. Entre na subpasta "target";
   3. Faça o download do arquivo "ListarReddit-1.0.jar" e da pasta "lib";
   4. Na pasta de destino do arquivo, escreva o copie e execute (no terminal) o seguinte comando **java -jar ListarReddit-1.0.jar**. **IMPORTANTE: A PASTA 'lib' e o arquivo executável devem estar dentro do mesmo diretório.**
 - Criar um programa que faça requisições de métodos diferentes (post, delete e autenticação) e mostre na tela o resultado.
   1. Entre na pasta "RequisicaoHTTP";
   2. Entre na subpasta "target";
   3. Faça o download do arquivo "RequisicaoHTTP-1.0.jar";
   4. Na pasta de destino do arquivo, escreva ou copie e execute (no terminal) o seguinte comando **java -jar RequisicaoHTTP-1.0.jar**
 - Criar um programa, usando Spring Boot que, dentro de um arquivo de texto, insira, capture, liste e delete o texto de uma chave seguido por um registro. Exemplo: 
         matheus:filho
         joana:irmã
         pedro:pai
         carla:mãe
   1. Entre na pasta "RegistroChave";
   2. Entre na subpasta "target";
   3. Faça o download do arquivo "registrochave-0.0.1.jar";
   4. Na pasta de destino do arquivo, escreva ou copie e execute (no terminal) um dos seguintes comandos 
     - **java -jar registrochave-0.0.1.jar set [chave]:[registro]** > cria um novo arquivo ou escreve no mesmo arquivo a chave e o registro inseridos.
     - **java -jar registrochave-0.0.1.jar get [chave]** >  retorna o valor da chave inserida;
     - **java -jar registrochave-0.0.1.jar delete [chave]** > deleta a chave e o registro especificado;
     - **java -jar registrochave-0.0.1.jar list** > lista todas as chaves e seus registros
