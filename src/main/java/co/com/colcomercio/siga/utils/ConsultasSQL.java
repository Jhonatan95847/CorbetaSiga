package co.com.colcomercio.siga.utils;

public class ConsultasSQL {
    public static final String CHASIS_ENTREGADO_CORAUTOS = "SELECT VehiculoSerieChasis, vehiculoplaca, ReferenciaUnicaId, VehiculoPSEAN, EstadoNombre, EjecucionProcesoFechaBloqueo, EjecucionProceso.EjecucionProcesoId, ReferenciaNombre, ReferenciaCodigoInt, MarcaNombre, VehiculoSerieMotor FROM Vehiculo.Vehiculo\n" +
            "      INNER JOIN Vehiculo.VehiculoPS\n" +
            "      ON Vehiculo.VehiculoPSId=VehiculoPS.VehiculoPSId\n" +
            "      INNER JOIN Vehiculo.Referencia\n" +
            "      ON VehiculoPS.ReferenciaId=Referencia.ReferenciaId\n" +
            "      INNER JOIN Vehiculo.Marca\n" +
            "      ON Referencia.MarcaId=Marca.MarcaId\n" +
            "      INNER JOIN Procesos.EjecucionProceso\n" +
            "      ON Vehiculo.EjecucionProcesoId=EjecucionProceso.EjecucionProcesoId\n" +
            "      INNER JOIN Procesos.Estado_Proceso\n" +
            "      ON EjecucionProceso.Estado_ProcesoId=Estado_Proceso.Estado_ProcesoId\n" +
            "      INNER JOIN Procesos.Estado\n" +
            "     ON Estado.EstadoId= Estado_Proceso.EstadoId\n" +
            "where marca.UnidadNegocioId=2 and EstadoNombre IN ('entregado')  AND Referencia.ReferenciaNombre like '%BJ2037%' --(Corautos) \n" +
            "  order by EjecucionProcesoFechaBloqueo";
    public static final String CHASIS_ENTREGADO_AKT = "SELECT TOP 1 VehiculoSerieChasis, ReferenciaUnicaId, VehiculoPSEAN, EstadoNombre, EjecucionProcesoFechaBloqueo, EjecucionProceso.EjecucionProcesoId, ReferenciaNombre, ReferenciaCodigoInt, MarcaNombre, VehiculoSerieMotor FROM Vehiculo.Vehiculo\n" +
            "      INNER JOIN Vehiculo.VehiculoPS\n" +
            "      ON Vehiculo.VehiculoPSId=VehiculoPS.VehiculoPSId\n" +
            "      INNER JOIN Vehiculo.Referencia\n" +
            "      ON VehiculoPS.ReferenciaId=Referencia.ReferenciaId\n" +
            "      INNER JOIN Vehiculo.Marca\n" +
            "      ON Referencia.MarcaId=Marca.MarcaId\n" +
            "      INNER JOIN Procesos.EjecucionProceso\n" +
            "      ON Vehiculo.EjecucionProcesoId=EjecucionProceso.EjecucionProcesoId\n" +
            "      INNER JOIN Procesos.Estado_Proceso\n" +
            "      ON EjecucionProceso.Estado_ProcesoId=Estado_Proceso.Estado_ProcesoId\n" +
            "      INNER JOIN Procesos.Estado\n" +
            "     ON Estado.EstadoId= Estado_Proceso.EstadoId\n" +
            "where marca.UnidadNegocioId=1 and EstadoNombre IN ('entregado')  AND Referencia.ReferenciaNombre like '%TTR%' --Akt \n" +
            "  order by EjecucionProcesoFechaBloqueo asc";
}
