# cathayBankTest2022
Currency project for Cathay Bank Testing

## Environment
Database : H2

Framework : Spring Boot 2.7.0

Java version : 8

Maven

## API List
### API_01 : call coinDesk API to get coindesk data
URI : GET api/v1/coinDesk/CurrentPrice
![img.png](src/main/resources/static/API01_result.png)
### API_02 : call coinDesk API and regroup the return data
URI : GET api/v1/coinDesk/CurrentPrice/new
![img.png](src/main/resources/static/API02_result.png)
### API_03 : API for query CURRENCY dataTable
URL :

findAll : GET api/v1/currency
![img.png](src/main/resources/static/API_03_findAll_result.png)
findByCode : GET api/v1/currency/**{code}**
![img_1.png](src/main/resources/static/API_03_findByCode.png)

### API_04 : API for create currency date into CURRENCY dataTable
URL : POST api/v1/currency

RequestBody: {name, code, description (optional)}
![img.png](src/main/resources/static/API_04_result.png)
### API_05 : API for update currency dataTable
URL : PUT api/v1/currency/**{code}**

RequestBody: {name (optional), code (optional), description (optional)}
![img_2.png](src/main/resources/static/API_05_result.png)
### API_06 : API for delete currency dataTable
URL : DELETE api/v1/currency/**{code}**
![img_1.png](src/main/resources/static/API_06_result.png)
Searching after deleted
![img_1.png](src/main/resources/static/API_06_result_search.png)
## Unit Testing Result
![img.png](src/main/resources/static/unitTestResult.png)