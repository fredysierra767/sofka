Feature: Consultar mascotas por estado y verificar existencia

  Scenario: Buscar por estado y encontrar la mascota creada
  # Obtener el ID de la mascota creada
    * def petId = karate.get('petId')
    * print 'Buscando mascota con ID:', petId

  # Consultar todas las mascotas con estado "sold"
    Given url 'https://petstore.swagger.io/v2/pet/findByStatus?status=sold'
    When method get
    Then status 200
    * def lista = response

  # Buscar la mascota creada dentro del listado obtenido
    * def encontrada = karate.filter(lista, function(x){ return x.id == petId })[0]
    * print 'Mascota encontrada en estado sold:', encontrada

  # Validar que efectivamente esté en la lista
    * match encontrada.id == petId
