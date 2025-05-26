Feature: Flujo completo de pruebas de mascota

  Scenario: Crear, consultar, actualizar y verificar por estado
  # Llamar al feature que crea la mascota y guarda su ID
    * call read('classpath:mascotas/1_crear_mascota.feature')

  # Llamar al feature que consulta por ID la mascota creada
    * call read('classpath:mascotas/2_consultar_por_id.feature')

  # Llamar al feature que actualiza los datos de la mascota
    * call read('classpath:mascotas/3_actualizar_mascota.feature')

  # Llamar al feature que busca por estado y valida que la mascota esté presente
    * call read('classpath:mascotas/4_consultar_por_status.feature')
