#language: es

Característica: Agregar productos al carrito de compra
  Como compradora
  Quiero agregar productos al carrito
  Para tener una idea de el valor total a pagar

  Esquema del escenario: Agregar varios productos al carro
    Dado que "Alicia" ingresa a la aplicacion
    Cuando se agreguen varios productos al carrito
      | <correo> | <password> | <seccion_vestido> | <seccion_t_shirt> | <nom_vestido> | <nom_t_shirt> |
    Entonces debe observar los siguientes campos
      | <nom_vestido> | <nom_t_shirt> | <precio_vestido> | <precio_t_shirt> | <total_precio_sin_envio> |
    Ejemplos:
      | correo                 | password      | seccion_vestido | seccion_t_shirt | nom_vestido           | nom_t_shirt                 | precio_vestido | precio_t_shirt | total_precio_sin_envio |
      | aliciamanuel@gmail.com | TensaZangetsu | Dresses         | T-shirts        | Printed Chiffon Dress | Faded Short Sleeve T-shirts | $16.40         | $16.51         | $32.91                 |