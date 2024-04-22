# Projeto Api Previsao do Tempo ☁️☔☀️

Projeto consiste em uma api que irá consultar a situaçao atual do tempo de acordo com o código postar informado.<br>
Ao fazer a request a api retorna os dados como: Temperatura, Cidade, Umidade Relativa, Velocidade do vento e Data.<br>

### Documentação Api Base:
Site https://www.weatherbit.io<br>
Documentação Api WeatherBit https://www.weatherbit.io/api/weather-current<br>
<br>
### Documentação Api Local:<br>
 -Para efetuar a consulta deve-se seguir o seguinte formato:<br>
   ***{*** <br>
     ***"localidade":"00000000"*** <br>
   ***}*** <br>
   <br>
  <code>Onde "00000000" refere-se ao código posta.</code><br>
<br>
-Para consulta local, onde ficam armazenadas as informações coletadas durante as consultas<br> 
 basta acessar: **localhost:8091/consulta**  <br>
<br>
  <code>Atenção:</code> Ao rodar a Api verifique se a porta configurada não está em uso, para alterar acessa em seu diretório o arquivo *aplication.properties* <br> 
  e altere o server.port para uma porta a sua escolha.

-A rota **localhost:8091/ajuda** está configurada para retornar uma mensagem padrão com nome do Aluno e nome do Projeto.<br>
<br>
***Toda responsabilidade dos dados e disponibilidade da api são de responsabilidade da Weatherbit.io*** 
