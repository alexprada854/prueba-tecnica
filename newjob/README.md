# Instalacion Aplicación Obtener Token y Dispositivos asociados  

### Descripcion General
Esta aplicacion fue creada como prueba tecnica de trabajo, fue hecha desde IDE eclipse con Maven, se uso la plantilla que ofrece la 
pagina de Spring Initializr [https://start.spring.io/], se hizo en dos proyectos, un Mock Service SOAP que publica por el puerto 8081 el metodo 
<login> que simula recibir unas claves de usuario, validarlas y devolver un token JWT valido para luego ser consumido en otro servcio, el cual 
esta pendiente de implementacion,  el segundo proyecto es el orquestador, que publica un servicio REST el cual recibe las credenciales, se las envia al primer servicio,
con el Token devuelto los persiste en una Base de datos en memoria (H2) y a su vez hace manejo de resiliencia para los patrones de ruptura de circuito y reintentos,
por ultimo se espcifico a traves del pom.xml, el uso de OpenApi3 (antiguo swangger) para generar la documentacion automatica, para este caso en [http://localhost:8082/swagger-ui/index.html]. Para este proyecto se cumplierón las siguientes especificaciones:

* [Manejo de dependencias con MAVEN](https://docs.spring.io/spring-boot/docs/3.0.9/maven-plugin/reference/html/)
* [Spring Boot 3](https://docs.spring.io/spring-boot/docs/3.0.9/api/org/springframework/boot/package-summary.html)
* [Java 17](https://docs.oracle.com/en/java/javase/17/docs/api/)
* [OpenApi 3, antinguo Swangger](https://swagger.io/specification/)
* [Resilience4J](https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/#configuring-resilience4j-circuit-breakers)
* [Implementación SOAP WSDL](http://localhost:8081/login/token.wsdl)  

### Instalación y despliegue
Los siguientes son los pasos para instalación:

* [Descargar los dos proyectos de GitHub](https://github.com/alexprada854/prueba-tecnica.git)
* 
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)

