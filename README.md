#Ambiente de desenvolvimento

Pré-requisitos
- JDK11
- Maven
- Git
- Docker
- Plugin Lombok

#Comandos via Docker
(Execultar na pasta docker contida dentro do projeto)

```
$ docker-compose up 
```


#Comandos via Maven

#Build

```
$ mvn clean install -U 
```

#Execução

```
$ mvn spring-boot:run 
```

na pasta `./testCompassoUol/src/main/java/com/compassoUol/testCompassoUol/TestCompassoUolApplication.java`

#Acesso Swagger

Para acessar a interface gráfica do Swagger acesse o endereço: 

`http://localhost:9999/swagger-ui.html`
