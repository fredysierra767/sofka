Feature: Crear una nueva mascota

  Scenario: Crear mascota y guardar el ID
  # 1. Cargar el JSON desde archivo
    * def basePet = read('classpath:data/mascota_nueva.json')

  # 2. Generar un ID aleatorio y asignarlo al objeto
    * def petId = Math.floor(Math.random() * 1000000)
    * basePet.id = petId
    * print 'Creando mascota con ID:', petId

  # 3. Enviar la solicitud con el cuerpo actualizado
    Given url 'https://petstore.swagger.io/v2/pet'
    And request basePet
    When method post
    Then status 200

  # 4. Guardar el ID para los otros pasos
    * karate.set('petId', petId)
    * print 'Mascota creada con ID:', petId
