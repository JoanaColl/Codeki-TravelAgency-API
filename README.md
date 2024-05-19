<!-- TÍTULO Y DESCRIPCIÓN -->
  <a name="ir-arriba"></a>
  # 🛄 Travel Agency
  Trabajo Práctico para el Bootcamp de Java, iniciativa que la **Agencia de Aprendizaje a lo largo de la vida** organiza junto a **IT Patagonia** y la academia educativa **Codeki**.

  <div align="center">
    <table>
      <tr>
        <td>
        Consigna: API REST CRUD sobre agencia de vuelos. Consulta a API externa (Dolar-API) y agregados algunos test unitarios, Swagger, relación de tablas y manejo de excepciones.
        </td>
        <td>
          <img src="https://github.com/joana-coll/Codeki-TravelAgency-API/blob/main/README%20RESOURCES/Proyecto.png" width="250px">
        </td>
      </tr>
    </table>
  </div>

<!-- ÍNDICE -->
  <a name="indice"></a>
  ## 📌 Índice
  <ol>
    <li><a href="#ir-arriba">Título y descripción del proyecto</a></li>
    <li><a href="#indice">Índice</a></li>
    <li><a href="#tecnologias">Tecnologías utilizadas</a></li>
    <li><a href="#instalacion">Instalación</a></li>
    <li><a href="#funcionalidad">Funcionalidad de la App</a>
      <ul>
        <li><a href="#createFlight">createFlight</a></li>
        <li><a href="#findAllFlights">findAllFlights</a></li>
        <li><a href="#findFlightById">findFlightById</a></li>
        <li><a href="#updateFlight">updateFlight</a></li>
        <li><a href="#deleteFlight">deleteFlight</a></li>
        <li><a href="#getFlightOffers">getFlightOffers</a></li>
        <li><a href="#findFlightByOrigin">findFlightByOrigin</a></li>
        <li><a href="#findFlightByOriginAndDestiny">findFlightByOriginAndDestiny</a></li>
        <li><a href="#createCompany">createCompany</a></li>
        <li><a href="#findAllCompanies">findAllCompanies</a></li>
        <li><a href="#findCompanyById">findCompanyById</a></li>
        <li><a href="#updateCompany">updateCompany</a></li>
        <li><a href="#deleteCompanyById">deleteCompanyById</a></li>
      </ul>
    </li>
    <li><a href="#desarrollado">Desarrollado por...</a>
    <li><a href="#contacto">Contacto</a>
    <li><a href="#agradecimiento">Agradecimiento</a>
  </ol>

<!-- TECNOLOGÍAS UTILIZADAS -->
  <a name="tecnologias"></a>
  ## ✅ Tecnologías utilizadas
  <p align="center">
    <a href="https://www.java.com/" target="_blank">
      <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white">
    </a>
    <a href="https://spring.io/" target="_blank">
      <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
      <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white">
    </a>
    <a href="https://github.com/" target="_blank">
      <img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white">
    </a>
    <a href="https://swagger.io/" target="_blank">
      <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white">
    </a>
   </p>
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

<!-- INSTALACIÓN -->
  <a name="instalacion"></a>
  ## 🔧 Instalación
  Si deseas correr la aplicación en un entorno local debes tener en cuenta lo siguiente: 
  1. Clona el repositorio utilizando GIT o descargando el archivo ZIP:

      `git clone https://github.com/joana-coll/Codeki-TravelAgency-API.git`
  
  2. Modificá los datos de username y password en el `application-properties` para poder conectarte a MySQL.

  3. Importa el `SCRIPT SQL` que encontras en la carpeta raíz del proyecto.

  4. Crea la base de datos `Travelagency` y ejecuta la app.

  5. Para probar los endpoint es recomendable utilizar Postman
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
<!-- FUNCIONALIDAD DE LA APP -->
  <a name="funcionalidad"></a>
  ## ⚙️ Funcionalidad de la App
  La aplicación es un CRUD de vuelos. Cuenta con los siguientes endpoints:
  
  <dl>Flight</dl>
    <ul>
      <li>/travelagency/v1/flight/create</li>
      <li>/travelagency/v1/flight</li>
      <li>/travelagency/v1/flight/{flightId}</li>
      <li>/travelagency/v1/flight/update/{flightId}</li>
      <li>/travelagency/v1/flight/delete/{flightId}</li>
      <li>/travelagency/v1/flight/offers</li>
      <li>/travelagency/v1/flight/origin</li>
      <li>/travelagency/v1/flight/originAndDestiny</li>
    </ul>
  <dl>Company</dl>
    <ul>
      <li>/travelagency/v1/company/create</li>
      <li>/travelagency/v1/company</li>
      <li>/travelagency/v1/company/{companyId}</li>
      <li>/travelagency/v1/company/update/{companyId}</li>
      <li>/travelagency/v1/company/delete/{companyId}</li>
    </ul>
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

## Flight
### createFlight
  `/travelagency/v1/flight/create` agrega un vuelo mediante _RequestBody_ y la compañia áerea mediante _RequestParam_
  
```json
{
    "id": 5,
    "origin": "EZE",
    "destiny": "COR",
    "departureTime": "Fri 28 May 8:30h",
    "arrivingTime": "Fri 28 May 11:30h",
    "convertedPrice": 720432,
    "frequency": "Diary",
    "company": {
        "id": 1,
        "name": "Flybondi",
        "page": "flybondi.com",
        "banner": "Banner Flybondi"
    }
}
```
 <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

### findAllFlights
  `/travelagency/v1/flight` muestra todos los vuelos 

```json
[
    {
        "id": 4,
        "origin": "EZE",
        "destiny": "BRC",
        "departureTime": "Sun 18 Ago 05:25",
        "arrivingTime": "Sun 18 Ago 07:50",
        "convertedPrice": 15607823,
        "frequency": "Diary",
        "company": {
            "id": 3,
            "name": "Aerolineas Argentinas",
            "page": "aerolineasargentinas.com.ar",
            "banner": "Banner Aerolineas Argentinas"
        }
    },
    {
        "id": 5,
        "origin": "EZE",
        "destiny": "COR",
        "departureTime": "Fri 28 May 8:30h",
        "arrivingTime": "Fri 28 May 11:30h",
        "convertedPrice": 720432,
        "frequency": "Diary",
        "company": {
            "id": 1,
            "name": "Flybondi",
            "page": "flybondi.com",
            "banner": "Banner Flybondi"
        }
    }
]
```
 <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

### findFlightById
  `/travelagency/v1/flight/{flightId}` muestra un determinado vuelo por id mediante un _PathVarible_

  ```json
 {
        "id": 1,
        "origin": "AEP",
        "destiny": "COR",
        "departureTime": "Sun 18 Ago 20:54",
        "arrivingTime": "Sun 18 Ago 22:21",
        "convertedPrice": 452991,
        "frequency": "Diary",
        "company": {
            "id": 2,
            "name": "JetSMART",
            "page": "jetsmart.com",
            "banner": "Banner JetSMART"
        }
      }
```
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
### updateFlight
  `/travelagency/v1/flight/update/{flightId}` edita un vuelo mediante un _RequestBody_ enviando el id por _PathVariable_ y la compañia aerea por _RequestParam_ 

  ```json
 {
    "id": 1,
    "origin": "TUC",
    "destiny": "SJU",
    "departureTime": "Sun 12 May 11:30h",
    "arrivingTime": "Sun 12 May 11:30h",
    "convertedPrice": 452991,
    "frequency": "Diaria",
    "company": {
        "id": 3,
        "name": "Aerolineas Argentinas",
        "page": "aerolineasargentinas.com.ar",
        "banner": "Banner Aerolineas Argentinas"
    }
}
```
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
### deleteFlight
  `/travelagency/v1/flight/delete/{flightId}` borra un determinada vuelo por id mediante un _PathVariable_

 ```json
Flight deleted!
```
  <p align="right">(<a href="#ir-arriba">Ir arriba</a>)</p>

### getFlightOffers
  `/travelagency/v1/flight/offers` muestra ofertas de vuelo que hay disponibles
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
### findFlightByOrigin
  `/travelagency/v1/flight/origin` muestra los vuelos por su origen
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
### findFlightByOriginAndDestiny
  `/travelagency/v1/flight/originAndDestiny` muestra los vuelos por su origen y destino
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

## Company
### createCompany
  `/travelagency/v1/company/create` agrega una compañia aérea mediante _RequestBody_ 

   ```json
 {
    "id": 4,
    "name": "Air France",
    "page": "www.airfrance.com.ar",
    "banner": "Banner Air France"
}
```
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

### findAllCompanies
  `/travelagency/v1/company` muestra todas las compañías aéreas

   ```json
[
    {
        "id": 1,
        "name": "Flybondi",
        "page": "flybondi.com",
        "banner": "Banner Flybondi"
    },
    {
        "id": 2,
        "name": "JetSMART",
        "page": "jetsmart.com",
        "banner": "Banner JetSMART"
    },
    {
        "id": 3,
        "name": "Aerolineas Argentinas",
        "page": "aerolineasargentinas.com.ar",
        "banner": "Banner Aerolineas Argentinas"
    },
    {
        "id": 4,
        "name": "Air France",
        "page": "www.airfrance.com.ar",
        "banner": "Banner Air France"
    }
]
```
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

### findCompanyById
  `/travelagency/v1/company/{companyId}` muestra una determinada compañía aérea por id mediante un _PathVarible_

   ```json
{
    "id": 3,
    "name": "Aerolineas Argentinas",
    "page": "aerolineasargentinas.com.ar",
    "banner": "Banner Aerolineas Argentinas"
}
```
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

### updateCompany
  `/travelagency/v1/company/update/{companyId}` edita una compañía aérea mediante un _RequestBody_ enviando el id por _PathVariable_

   ```json
 {
    "id": 3,
    "name": "Aerolineas Argentinas",
    "page": "www.aerolineas.com.ar",
    "banner": "BANNER EDITED"
}
```
 
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

### deleteCompanyById
  `/travelagency/v1/company/delete/{companyId}` borra una determinada compañía aérea por id mediante un _PathVariable_

   ```json
Company deleted!
```
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
<!-- DESARROLLADO POR -->
  <a name="desarrollado"></a>
  ## 💁 Desarrollado por...
  * **Joana Coll** - [joanacoll](https://github.com/joanacoll)
  
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
  
<!-- CONTACTO -->
  <a name="contacto"></a>
  ## 📩 Contacto
  Si deseas contactarte conmigo:
  <a href="mailto:colljoana@gmail.com" target="_blank">
  <img src="https://img.shields.io/badge/colljoana-red?style=flat&logo=Gmail&logoColor=white&labelColor=red" alt="Gmail"></a>
  <a href="https://ar.linkedin.com/in/joanacoll" target="_blank"><img src="https://img.shields.io/badge/joanacoll-blue?style=flat&logo=Linkedin&logoColor=white&labelColor=blue" alt="Linkedin"></a>
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>

<!-- AGRADECIMIENTO -->
  <a name="agradecimiento"></a>
  ## ❤️ Agradecimiento
  Gracias por leer hasta aquí, espero que el proyecto te sea útil. No tiene Licencia pero podes usarlo como gustes mientras sigas fomentando el código libre y ayudando a otros pares. 
  
  ¡Que tengas un lindo día!
  
  Nana ✨
  <p align="right"><a href="#ir-arriba">:arrow_up:</a></p>
