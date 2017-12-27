#########################################
############## ENGLISH ###############
#########################################


 Application developed for the Avenue Code test!

- The application was developed using: Spring Boot, Rest Services, JPA / Hibernate, Thymeleaf, Maven and h2database;
- And the tests of the application with: Cucumber / JUnit (Mocked classes);  

- If you want a Full build, execute the command 				 mvn clean install
- If you want to Run only the tests, execute the command		 mvn test

- To execute the project, you must follow one of the two existing paths:
* Load the project into an IDE (like Eclipse) and run its Main class (AvenueApplication) as a Java Application.

* Go in the path that are the the pom.xml and run the command     mvn spring-boot: run
* Open the browser and access the application through  		      http://localhost:8080

- The system consists of 4 main functions:
* 1 Image registration screen, where you must provide the Image Type;
* 1 query and image management screen, where the images can be filtered by the fields of the inclusion and additionally allows the exclusion and / or change of the same.
* 1 Product registration screen, where the Product Name (Required), the Product Parent and an Image associated with the product can be informed;
* 1 query and product management screen, where products can be filtered by the fields of inclusion and additionally allows the exclusion and / or modification of the same.


- Note: The system does not allow the exclusion of objects that have associations, such as excluding a parent product without excluding children before. Therefore, the buttons are disabled!



#########################################
############## PORTUGUESE ###############
#########################################


- Aplicação desenvolvida para o teste da Avenue Code

- A aplicação foi desenvolvida utilizando: Spring Boot, Rest Services, JPA/Hibernate, Thymeleaf, Maven e h2database;
- E os testes da aplicação foram feitos com: Cucumber / JUnit (Classes "Mocked");

- Se você quiser fazer um build completo, execute o comando 	   mvn clean install
- Se você quiser somente executar os testes, execute o comando     mvn test

- Para execução da mesma, deve-se seguir um dos dois caminhos: 
* Carregar o projeto em uma IDE(Como o Eclipse) e executar a sua classe Principal (AvenueApplication) como uma Java Application.  

* Ir no caminho que encontra-se o pom.xml e executar: 			   mvn spring-boot:run
* Abra o browser e acesse a aplicação pelo endereço 		       http://localhost:8080

- O sistema é composto por 4 telas principais:
* 1 tela de cadastro de Imagem, onde deve ser informado o Tipo de Imagem;
* 1 tela de consulta e gerenciamento de Imagem, onde as imagens podem ser filtradas pelos campos da inclusão e adicionalmente permite a exclusão e/ou alteração da mesma.
* 1 tela de cadastro de Produto, onde podem ser informados o Nome do Produto(Obrigatoriamente), O Pai do Produto e uma Imagem associada ao produto;
* 1 tela de consulta e gerenciamento de Produto, onde produtos podem ser filtrados pelos campos da inclusão e adicionalmente permite a exclusão e/ou alteração do mesmo.

- Obs.: O sistema não permite a exclusão de objetos que tenham associações, como por exemplo excluir um produto pai sem excluir os filhos antes. Portanto, os botões ficam desabilitados!
 