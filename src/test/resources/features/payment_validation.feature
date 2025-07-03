Feature: Validación de pagos con tarjeta inválida

  @Demo
  Scenario Outline: Comprar con tarjeta rechazada
    Given Inicio la app de Mercado Libre
    When Busco el producto "<producto>"
    And Selecciono el primer resultado
    And Agrego el producto al carrito
    And Procedo al checkout como invitado
    And Completo dirección de envío
    And Selecciono pago con tarjeta de crédito
    And Ingreso datos de tarjeta inválida con estado "<estado>"
    Then Debo ver el mensaje de error "<mensaje>"

    Examples:
      | producto      | estado  | mensaje                          |
      | PlayStation 5 | OTHE    | Problema con tu pago             |
      | Xbox Series X | FUND    | Fondos insuficientes            |
      | Nintendo Swi  | SECU    | Código de seguridad inválido    |