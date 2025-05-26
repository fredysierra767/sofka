Feature: Consultar mascota por ID

  Scenario: Consultar por ID generado
  # Obtener el ID guardado previamente
    * def petId = karate.get('petId')
    * print 'Consultando mascota con ID:', petId

  # Enviar petición GET para consultar la mascota por su ID
    Given url 'https://petstore.swagger.io/v2/pet/' + petId
    When method get
    Then status 200

  # Imprimir la respuesta obtenida
    * print 'Respuesta de consulta:', response
