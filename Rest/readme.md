REST availabe when server is run using mvn tomcat7:run

Available operations:
curl -i -X GET http://localhost:8080/pa165/rest/badges  //to get all badges
curl -i -X GET http://localhost:8080/pa165/rest/badges/1  //to get badge with id 1 
curl -i -X DELETE http://localhost:8080/pa165/rest/badges/2 //to delete badge with id 2

