#language: es
@all
Característica: Generar OT



    ####################################### Nueva Implementacion ############################################
  #******************************************************CREAR ORDEN DE TRABAJO HASTA VALIDAR*********************************************
@corautosAdmPrecios
  Escenario: Compra con T Alkosto
  Narrativa: El cliente registrado en Alkosto
    Dado que el usuario inicia sesion como "recepcionista" para "CORAUTOS"
    Y en el menu selecciona "Vehículos" y el submenu "Vehículo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Registrar Recepción"
    Y diligencia el formulario de Registrar Recepcion en taller "fofat" con cambio de propietario
    Y llena el formulario de Registar orden de trabajo
    Entonces Genera el numero de la otden de trabajo


    Dado que el usuario inicia sesion como "jefe_taller" para "CORAUTOS"
    Y en el menu selecciona "Taller" y el submenu "Orden de Trabajo"
    Cuando el usuario busca la OT para el caso y selecciona la accion "Asignar OT a Celda"
    Y diligencia el formulario de asignar solicitud para taller "fofat"
    Entonces la orden de trabajo pasa a estado En ejecucion

    Dado que el usuario inicia sesion como "tecnico_taller" para "CORAUTOS"
    Y en el menu selecciona "Taller" y el submenu "Ejecución Orden Trabajo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Procesar Ejecución"
    Y ejecuto la accion "Crear Novedad TP"
    Y diligencio el formulario agregando los detalles y creo la novedad TP para "fofat"
    Entonces se crea la novedad TP

    #Dado que el usuario inicia en siga sesion como "validador" Corautos
    #Y en el menu selecciona "Novedad" y el submenu "Novedad TP"
    #Cuando el usuario busca el chasis para el caso y selecciona la accion "Ejecutar Acción"
    #Y edita y vlaida la novedad TP
    #Entonces la novedad TP queda en estado validada

  @corautosNoAdmPrecios
  Escenario: Compra con T Alkosto
  Narrativa: El cliente registrado en Alkosto
    Dado que el usuario inicia sesion como "recepcionista" para "CORAUTOS"
    Y en el menu selecciona "Vehículos" y el submenu "Vehículo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Registrar Recepción"
    Y diligencia el formulario de Registrar Recepcion con cambio de propietario para "vwmed"
    Y llena el formulario de Registar orden de trabajo
    Entonces Genera el numero de la otden de trabajo


    Dado que el usuario inicia sesion como "jefe_taller" para "CORAUTOS"
    Y en el menu selecciona "Taller" y el submenu "Orden de Trabajo"
    Cuando el usuario busca la OT para el caso y selecciona la accion "Asignar OT a Celda"
    Y diligencia el formulario de asignar solicitud para "vwmed"
    Entonces la orden de trabajo pasa a estado En ejecucion

    Dado que el usuario inicia sesion como "tecnico_taller" para "CORAUTOS"
    Y en el menu selecciona "Taller" y el submenu "Ejecución Orden Trabajo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Procesar Ejecución"
    Y ejecuto la accion "Crear Novedad TP"
    Y diligencio el formulario agregando los detalles y creo la novedad TP para "vwmed"
    Entonces se crea la novedad TP

    #Dado que el usuario inicia en siga sesion como "validador" Corautos
    #Y en el menu selecciona "Novedad" y el submenu "Novedad TP"
    #Cuando el usuario busca el chasis para el caso y selecciona la accion "Ejecutar Acción"
    #Y edita y vlaida la novedad TP
    #Entonces la novedad TP queda en estado validada

  @akt
  Escenario: Compra con T Alkosto
  Narrativa: El cliente registrado en Alkosto
    Dado que el usuario inicia sesion como "recepcionista" para "AKT"
    Y en el menu selecciona "Vehículos" y el submenu "Vehículo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Registrar Recepción"
    Y diligencia el formulario de Registrar Recepcion akt con cambio de propietario
    Y llena el formulario de Registar orden de trabajo
    Entonces Genera el numero de la otden de trabajo

    Dado que el usuario inicia sesion como "jefe_taller" para "AKT"
    Y en el menu selecciona "Taller" y el submenu "Orden de Trabajo"
    Cuando el usuario busca la OT para el caso y selecciona la accion "Asignar OT a Celda"
    Y diligencia el formulario de asignar solicitud para "akt_administra_precios"
    Entonces la orden de trabajo pasa a estado En ejecucion

    Dado que el usuario inicia sesion como "tecnico_taller" para "AKT"
    Y en el menu selecciona "Taller" y el submenu "Ejecución Orden Trabajo"
    Cuando el usuario busca el chasis para el caso y selecciona la accion "Procesar Ejecución"
    Y ejecuto la accion "Crear Novedad TP"
    Y diligencio el formulario agregando los detalles y creo la novedad TP para "akt_administra_precios"
    Entonces se crea la novedad TP

    #Dado que el usuario inicia en siga sesion como "validador" Corautos
    #Y en el menu selecciona "Novedad" y el submenu "Novedad TP"
    #Cuando el usuario busca el chasis para el caso y selecciona la accion "Ejecutar Acción"
    #Y edita y vlaida la novedad TP
    #Entonces la novedad TP queda en estado validada
