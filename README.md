# Spring Boot - GraphQL - H2 

Getting Started with Spring Boot, GraphQL and H2

![GraphQL](https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/GraphQL_Logo.svg/200px-GraphQL_Logo.svg.png)
![Spring](https://img.icons8.com/color/200/000000/spring-logo.png)

## Usage

GraphQL endpoint is located at `http://localhost:8080/graphql` and can be changed in `application.properties` file.

The `player.graphqls` file is located in `resources/graphql` folder. The file is used to execute GraphQL.

#### Queries

`getAllPlayers` - Returns all players in the database<br>

#### Mutations

`addPlayer(playerDto: PlayerDto)` - Add new player<br>
`deletePlayer(id: ID)` - Delete a player by id<br>

#### Demo Usage
```
mutation{
  addPlayer(playerDto:{name:"Muhammet",surname:"Tiryaki",position:PG}){
    id, name, surname, position
  }
}
```
```
mutation{
  deletePlayer(id:1){
    id,name,surname,position
  }
}
```
```
query{
  getAllPlayers{
    id,name,surname,position
  }
}
```
