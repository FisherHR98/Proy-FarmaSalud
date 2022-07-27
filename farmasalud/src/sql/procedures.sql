DELIMITER @@
CREATE PROCEDURE bdtienda.SP_ADIFACT(FV DATE, IGV CHAR(1), CODV CHAR(5), 
CODC CHAR(5), EST INT, TP CHAR(10))
BEGIN
DECLARE CUENTA INT;
DECLARE NROF CHAR(5);

DECLARE CUENTAG INT;
DECLARE GUIA CHAR(10);

SELECT COALESCE(MAX(NUM_FAC),0)+1 INTO CUENTA FROM FACTURAC;
SET NROF=LPAD(CUENTA,5, '0');

SELECT RIGHT(COALESCE(MAX(GUIA_REMI),0),7)+1 INTO CUENTAG FROM FACTURAC;
SET GUIA=CONCAT("GR-",LPAD(CUENTAG,7, '0'));

INSERT INTO facturac(num_fac, fecha_fac, igv_rec, cod_ven, estado,cod_cli, tipo, guia_remi) VALUES (NROF, FV, IGV,CODV,EST,CODC,TP,GUIA);

END @@
DELIMITER;


--recibo
DELIMITER @@
CREATE PROCEDURE bdtienda.SP_ADIREC(FV DATE, IGV CHAR(1), CODV CHAR(5), 
CODC CHAR(5), EST INT, TP CHAR(10))
BEGIN
DECLARE CUENTA INT;
DECLARE NROF CHAR(5);

SELECT COALESCE(MAX(NUM_FAC),0)+1 INTO CUENTA FROM FACTURAC;
SET NROF=LPAD(CUENTA,5, '0');


INSERT INTO facturac(num_fac, fecha_fac, igv_rec, cod_ven, estado,cod_cli, tipo, guia_remi)
VALUES (NROF, FV, IGV,CODV,EST,CODC,TP,null);
END @@
DELIMITER;


--graba detalle
DELIMITER @@
CREATE PROCEDURE bdtienda.SP_ADIDETA(NFAC CHAR(5), CODP CHAR(5), 
CANT INT, EST INT)
BEGIN
INSERT INTO DETALLE_RECIBO(num_fac, cod_pro, cant_pro, estado)
VALUES(NFAC, CODP, CANT, EST);
END @@
DELIMITER;

--ventas por empleado año
DELIMITER @@
CREATE PROCEDURE bdtienda.SP_RegistroVentas(AN INT)
BEGIN
Select year(fecha_fac), e.cod_ven, nom_ven,SUM(d.cant_pro*p.precio) ventas
from empleado e join facturac f on(e.cod_ven=f.cod_ven) 
join detalle_recibo d on (d.num_fac=f.num_fac) 
join producto p on(p.cod_pro=d.cod_pro)
where YEAR(fecha_fac)=AN
GROUP by e.cod_ven;
END @@
DELIMITER;