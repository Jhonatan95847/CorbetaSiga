package co.com.colcomercio.siga.utils;
public enum General {


    CONSTANT_ENV("Env"),
    PASS_BD("Pass"),
    TRAZABILIDAD_TRAMITE("Trazabilidad Trámite - "),
    INFORMACION_TRAMITE("Información de Trámite - "),
    PROGRAMADO("Programado"),
    PENDIENTE("Pendiente"),
    CELL_LCO_ENTRY(".//td[7]"),
    STATION_ONE(".//td[8]"),
    CELL_RECOVERY(".//td[14]"),
    QUALITY_AND_BEAUTY(".//td[15]"),
    RESULTADO(""),
    ARGUMENTS("arguments[0].value=arguments[1];"),
    CLASS("class"),
    ZEROS("00:00");


    String opcion;

    General(String msj) {
        this.opcion = msj;
    }

    public String getMsj() {
        return opcion;
    }

}
