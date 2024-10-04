#language: es
@all
Característica: Generar OT



    ####################################### Nueva Implementacion ############################################

  #______________________________________________________EXITOSA______________________________________________
  #******************************************************HARDLOGIN*********************************************
@siga
  Escenario: Compra con T Alkosto
  Narrativa: El cliente registrado en Alkosto
    Dado que el usuario inicia sesion como "recepcionista"
    Y en el menu selecciona "Vehículos" y el submenu "Vehículo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Registrar Recepción"
    Y diligencia el formulario de Registrar Recepcion con cambio de propietario
    Y llena el formulario de Registar orden de trabajo
    Entonces Genera el numero de la otden de trabajo

    Dado que el usuario inicia sesion como "jefe_taller"
    Y en el menu selecciona "Taller" y el submenu "Orden de Trabajo"
    Cuando el usuario busca la OT para el caso y selecciona la accion "Asignar OT a Celda"
    Y diligencia el formulario de asignar solicitud
    Entonces la orden de trabajo pasa a estado En ejecucion

    Dado que el usuario inicia sesion como "tecnico_taller"
    Y en el menu selecciona "Taller" y el submenu "Ejecución Orden Trabajo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Procesar Ejecución"
    Y ejecuto la accion "crear novedad TP"
    #Y diligencio el formulario agregando los detalles y creo la novedad TP
    #Entonces se crea la novedad TP

    #Dado que el usuario inicia sesion como "validador"
    #Y en el menu selecciona "Novedad" y el submenu "Novedad TP"
    #Cuando el usuario busca el chasis para el caso y selecciona la accion "Ejecutar accion"
