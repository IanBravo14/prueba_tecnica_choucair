#language: es
Característica: Buscar vestido o t-shirt
  Como compradora
  Quiero poder buscar productos
  Para evitar tener que buscar el producto que deseo en toda la página

  Escenario: : Buscar vestido
    Dado que "Alicia" ingresa a la aplicacion
    Cuando introduza el vestido "Printed Dress" en el buscador
    Entonces debe ver los productos que tengan palabras identicas a la busqueda
