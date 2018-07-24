# O Desafio
Atender as requisições de uma aplicação com alto índice de acesso (transações/requisições).
Utilizando-se do Java 8 e do Spring boot, o pequeno projeto a ser apresentado utilizou também:  
* JPA/ H2/ DevTools/ Eureka/ Actuator/ Zuul.

## O projeto foi divido em três aplicações:
* **Gateway** – o componente que fica exposto ao cliente, além do gerenciamento de distribuições das requisições feitas para app principal.
* **Discovery-Service** – utilizado como gerenciador de histórico/ load balance, consegue gravar as requisições feitas, além dos status das aplicações ligadas a ele, isso traz uma melhor visualização, controle e performance ao projeto.
* **Login-Service** – responsável por realizar o controle de acesso e da parte de banco de dados da aplicação, toda a parte gerenciamento de classes que se conectam a partir do repositor, e das funções desejadas pelo cliente.


### Abaixo um diagrama de como a solução do problema foi desenhada:
<img width="880" alt="Diagram services" src="https://github.com/mmsalmeida/job-backend-developer/blob/master/InteliPostLogin.png">


Para utilização e validação do projeto é necessário: 
 * **Primeiro passo**: baixe a versão e o utilize através do eclipse; 
 * **Segundo passo**: deve ser inicializado o  discovery-service(Eureka), que passará a "enxergar" as aplicações que virão a seguir. 
 
 <img width="500" alt="Diagram services" src="https://github.com/mmsalmeida/job-backend-developer/blob/master/Eureka1.png">
 
 * **Terceiro passo**: iniciar as demais aplicações que depois que estiverem funcionando será mostrado no discovery-service.
 
 <img width="500" alt="Diagram services" src="https://github.com/mmsalmeida/job-backend-developer/blob/master/Eureka2.png">	

**Banco de dados**: configurado junto ao login-service, depois que a aplicação estiver no ar podemos entrar no console e verificar a existência da tabela de usuário que contém as informações de id/email/login/nome/senha
 
<img width="500" alt="Diagram services" src="https://github.com/mmsalmeida/job-backend-developer/blob/master/h2database.png">

**Teste unitário**: para realização do teste inicial da aplicação foi realizada uma codificação onde as requisições são feitas pela API do google Restlet Cliente via post
apontando para o serviço de login-service passando o login e senha como parâmetros e devolvendo uma tratativa se o login é valido ou não.

<img width="500" alt="Diagram services" src="https://github.com/mmsalmeida/job-backend-developer/blob/master/restletok.png">

<img width="500" alt="Diagram services" src="https://github.com/mmsalmeida/job-backend-developer/blob/master/restletnok.png">


# **Considerações finais**

Todas as regras de negocio de dados estão na camada service.

A parte de teste massivo condiz ao utilizarmos do programa construido afim de escaloná-lo de acordo 
com suas requisições e se necessário realizar a distribuição para novas máquinas,utilizando o discovery como ponto de gerenciamento de dados.

O discovery e o gateway possibilitam que a aplicação possa ser distribuída de forma horizontal tornando
transparente sua requisição para o usuário.	


Oportunidades de melhoria:
- Para conhecimento, não foi possível utilizar de toda a plataforma do gateway(Zuul) e fica como uma questão a ser melhorada.
- Utilização de ferramentas onde é possível aplicar mais testes de "stress" e tempos de reposta do serviço também podem ser adicionadas.
- Por se tratar de uma aplicação simples para back-end não foi dada ênfase em sua parte de amostragem já que o intuito era apenas mostrar sua funcionalidade(back-end).
- Aplicação pronta para ser utilizada juntamente com containers e docker.
 
