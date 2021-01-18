#language: es

Característica: Registrar cliente en la aplicacion web
  Como cliente
  Quiero poder registrarme en la pagina
  Para tener acceso a todas las opciones que me ofrece la pagina

  Esquema del escenario: Registrar cliente sin escribir numero telefonico
    Dado que "Ian" ingresa a la aplicacion
    Cuando en el registro introduzca los siguientes datos a excepcion del numero de telefono
      | <nombre> | <apellido> | <correo> | <pass> | <fecha_nac> | <dir> | <ciudad> | <estado> | <cod_postal> | <pais> | <dir_ref> |
    Entonces le debe salir el mensaje de error "You must register at least one phone number."
    Ejemplos:
      | nombre | apellido | correo            | pass          | fecha_nac    | dir                  | ciudad   | estado | cod_postal | pais          | dir_ref              |
      | Ian    | Bravo    | hola100@gmail.com | TensaZangetsu | 14;June;1993 | Avenida Siempre Viva | Medellin | Kansas | 12345      | United States | Avenida Siempre Viva |

  Esquema del escenario: Registrar cliente solo llenando el nombre y apellido
    Dado que "Ian" ingresa a la aplicacion
    Cuando en el registro solo ingresa los dos primero campos obligatorios
      | <nombre> | <apellido> | <correo> |
    Entonces le debe mostrar la siguiente lista de campos obligatorios faltantes
      | <campos_faltantes> |
    Ejemplos:
      | nombre | apellido | correo            | campos_faltantes                                                                                                                                                                                                                       |
      | Ian    | Bravo    | hola100@gmail.com | You must register at least one phone number.;passwd is required.;address1 is required.;city is required.;The Zip/Postal code you've entered is invalid. It must follow this format: 00000;This country requires you to choose a State. |

  Esquema del escenario: Registrar cliente llenando los campos obligatorios
    Dado que "Ian" ingresa a la aplicacion
    Cuando en el registro solo ingrese los campos obligatorios
      | <nombre> | <apellido> | <correo> | <pass> | <dir> | <ciudad> | <estado> | <cod_postal> | <pais> | <cel> | <dir_ref> |
    Entonces se debe ver un mensaje de bienvenida a su cuenta
      | <mensaje_bienvenida> | <nombre_usuario> |
    Ejemplos:
      | nombre | apellido | correo            | pass          | dir                  | ciudad   | estado  | cod_postal | pais          | cel        | dir_ref              | mensaje_bienvenida                                                                        | nombre_usuario |
      | Ian    | Bravo    | hola300@gmail.com | TensaZangetsu | Avenida Siempre Viva | Medellin | Indiana | 12345      | United States | 3124567890 | Avenida Siempre Viva | Welcome to your account. Here you can manage all of your personal information and orders. | Ian Bravo      |

  Esquema del escenario: Registrar cliente llenando todos los campos
    Dado que "Ian" ingresa a la aplicacion
    Cuando en el registro ingresa todos los campos
      | <nombre> | <apellido> | <correo> | <pass> | <fecha_nac> | <compania> | <dir> | <dir_2> | <ciudad> | <estado> | <cod_postal> | <pais> | <info_adic> | <tel> | <cel> | <dir_ref> |
    Entonces se debe ver un mensaje de bienvenida a su cuenta
      | <mensaje_bienvenida> | <nombre_usuario> |
    Ejemplos:
      | nombre | apellido | correo           | pass          | fecha_nac       | compania | dir                 | dir_2                     | ciudad   | estado  | cod_postal | pais          | info_adic          | tel     | cel        | dir_ref              | mensaje_bienvenida                                                                        | nombre_usuario |
      | Ian    | Bravo    | hola400@gmail.com | TensaZangetsu | 12;January;1992 | Choucair | Avenida SiempreViva | Avenida Siempre Viva 1234 | Medellin | Florida | 12345      | United States | Esto es una prueba | 5120897 | 3219863456 | Avenida Siempre Viva | Welcome to your account. Here you can manage all of your personal information and orders. | Ian Bravo      |