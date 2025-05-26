Feature: Actualizar mascota

  Scenario: Consultar, actualizar y verificar cambio
  # Obtener el ID guardado previamente
    * def petId = karate.get('petId')
    * print 'Consultando antes de actualizar, ID:', petId

  # Consultar la mascota actual para obtener sus datos
    Given url 'https://petstore.swagger.io/v2/pet/' + petId
    When method get
    Then status 200
    * def petActual = response
    * print 'Mascota actual:', petActual

  # Modificar algunos campos de la mascota
    * petActual.name = 'firulais-actualizado'
    * petActual.status = 'sold'

  # Enviar la actualización usando método PUT
    Given url 'https://petstore.swagger.io/v2/pet'
    And request petActual
    When method put
    Then status 200

  # Imprimir la respuesta luego de la actualización
    * print 'Mascota actualizada:', response
