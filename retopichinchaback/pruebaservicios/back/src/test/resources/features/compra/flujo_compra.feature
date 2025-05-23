# language: es
Característica: Flujo de compra en OpenCart

  @Flujo01
  Esquema del escenario: Compra como invitado
    Dado que el usuario abre la página de inicio
    Cuando agrega los productos "<producto1>" y "<producto2>" al carrito
    Y visualiza el carrito de compras
    Y completa el checkout como "invitado" con los datos correctos
    Entonces debería ver el mensaje "Your order has been placed!"

    Ejemplos:
      | producto1 | producto2       |
      | iMac      | HTC Touch HD    |
