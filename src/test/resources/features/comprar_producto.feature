#language: es

Característica: Comprar producto en la tienda virtual
  Como comprodadora
  Quiero hacer el proceso de compra en linea
  Para no tener que comprar en la tienda física

  Esquema del escenario: Comprar producto
    Dado que "Alicia" ingresa a la aplicacion
    Cuando haga todo el proceso de compra de manera virtual
      | <correo> | <password> | <seccion> | <nombre_producto> | <medio_de_pago> |
    Entonces debe observar la orden de compra completada junto con el precio total a pagar
      | <mensaje_orden_compra> | <medio_de_pago> |
    Ejemplos:
      | correo                 | password      | seccion  | nombre_producto             | medio_de_pago          | mensaje_orden_compra                |
      | aliciamanuel@gmail.com | TensaZangetsu | Dresses  | Printed Chiffon Dress       | Cheque                 | Your order on My Store is complete. |
      | aliciamanuel@gmail.com | TensaZangetsu | T-shirts | Faded Short Sleeve T-shirts | Transferencia Bancaria | Your order on My Store is complete. |