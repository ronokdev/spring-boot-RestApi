#### Reference URL
* https://www.notion.so/ronok/Spring-Boot-3dde1c4b0417463faeac997e3b04d166
-------------------------------------------------
#### Health & Metrics 🌟
##### commit name 
- feat(actuator): exposing all the endpoints of Actuator
- feat(actuator): added management.endpoint.health.show-details to always in order to see more info on actuator Page
    

#### Actuator URL 🌟
* http://localhost:8080/springbootapi/actuator
--------------------------------------------------

#### CRUD 🌟
##### Controller name
- ProductRestController

##### Method names
- getProducts
- createProduct
- updateProduct
- deleteProduct
------------------------------------------------- 

#### Database Caching  🌟 
- Caching added only on the *getProduct* on *ProductRestController*
##### commit name 
- feat(application): caching add
- feat(application-caching): application caching added and working fine




-------------------------------------------------
#### Swagger REST Documentation Quickstart 🌟
##### commit name
- feat(swagger): swager Configuration file add.
- feat(application-swagger): @ApiOperation annotaion use for one of the endpoints.
##### Swagger UI URL 
- http://localhost:8080/springbootapi/v2/api-docs
- http://localhost:8080/springbootapi/swagger-ui.html
-------------------------------------------------
    
#### Spring Batch 🌟
##### FILE Path
- batch/batchConfig.java
   
##### <B>Batching Steps</B>
- Reader
- Processor
- Writer
- Step
- Job
##### commit name
- feat(CSV to DB update) : spring batching used
-------------------------------------------------

####Unit Testing using MockMvc 🌟 
##### FILE Path
- test/ProductRestControllerMvcTest.java

##### Unit test written for all the below Methods
- getProducts
- createProduct
- updateProduct
- deleteProduct
##### commit name 
- feat(application-test): Unit testing with MockMvc
- feat(Application-test): create product test with MockMvc
- feat(application-test): Update & delete product test with MockMvc
-------------------------------------------------

#### EndPoint Validation with Validation-API 🌟
- Only Done for createProduct Endpoint    
##### commit name 
- feat(application-validation):Spring boot started validated add to POM.XML
- feat(Application-validaton): Validation added on the Product Create Endpont  
-------------------------------------------------
 
           