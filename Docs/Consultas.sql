SELECT * FROM OFERTA ORDER BY VECES DESC;
SELECT b.ID_OPERADOR AS operador, SUM(a.COSTO_TOTAL) As suma FROM CONTRATO a JOIN OPERADORCONTRATO b ON a.ID = b.ID_CONTRATO WHERE a.FECHA_FINAL BETWEEN '20/03/18' AND '21/03/18' GROUP BY ID_OPERADOR;