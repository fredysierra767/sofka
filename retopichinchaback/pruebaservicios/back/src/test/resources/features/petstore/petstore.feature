# language: es
Característica: : Pruebas API de PetStore

  Antecedentes: :
  * url 'https://petstore.swagger.io/v2'

  Escenario: Añadir mascota
    Dado path 'pet'
    Y request { id: 1010, name: 'Max', status: 'available' }
    Cuando  method post
    Entonces  status 200

  Escenario: Consultar mascota por ID
    Dado path 'pet/1010'
    Cuando method get
    Entonces status 200
    Y match response.name == 'Max'

  Escenario: Actualizar mascota
    Dado path 'pet'
    Y request { id: 1010, name: 'MaxUpdated', status: 'sold' }
    Cuando method put
    Entonces status 200
    Y match response.status == 'sold'

  Escenario: Buscar mascota por estatus
    Dado path 'pet/findByStatus'
    Y param status = 'sold'
    Cuando method get
    Entonces status 200
    Y match each response[*].status contains 'sold'
