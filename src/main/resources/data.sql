INSERT INTO dispositivos (referencia, modelo, tipo_dispositivo) VALUES ('Sw' , 'Xiami01', 'celular');
INSERT INTO dispositivos (referencia, modelo, tipo_dispositivo) VALUES ('Sd' , 'Xiami02', 'router');
INSERT INTO dispositivos (referencia, modelo, tipo_dispositivo) VALUES ('Sm' , 'Xiami03', 'torre');

INSERT INTO clientes (cliente) VALUES ('cliente1');
INSERT INTO clientes (cliente) VALUES ('cliente2');
INSERT INTO clientes (cliente) VALUES ('cliente3');
INSERT INTO clientes (cliente) VALUES ('cliente4');

INSERT INTO operadores (operador, banda) VALUES ('Movistar','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Claro','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Tigo','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Flash','5.0');
INSERT INTO operadores (operador, banda) VALUES ('Virgin','5.0');

INSERT INTO operadores (operador, banda) VALUES ('Movistar 2','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Claro 2','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Tigo 2','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Flash 2','5.0');
INSERT INTO operadores (operador, banda) VALUES ('Virgin 2','5.0');

INSERT INTO operadores (operador, banda) VALUES ('Movistar 3','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Claro 3','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Tigo 3','2.4');
INSERT INTO operadores (operador, banda) VALUES ('Flash 3','5.0');
INSERT INTO operadores (operador, banda) VALUES ('Virgin 3','5.0');

INSERT INTO simcards (id_operador ,numero , estado) VALUES (1, '123', 'activo');
INSERT INTO simcards (id_operador ,numero , estado) VALUES (1, '456', 'Inactivo');
INSERT INTO simcards (id_operador ,numero , estado) VALUES (2, '678', 'activo');
INSERT INTO simcards (id_operador ,numero , estado) VALUES (2, '915', 'activo');
INSERT INTO simcards (id_operador ,numero , estado) VALUES (2, '000', 'activo');


INSERT INTO planes (plan, total_minutos, total_datos) VALUES ('Minutos Ilimitados', 100, 0);
INSERT INTO planes (plan, total_minutos, total_datos) VALUES ('Paquete 100 Min', 100, 0);
INSERT INTO planes (plan, total_minutos, total_datos) VALUES ('Paquete 100 Gb', 0, 100);
INSERT INTO planes (plan, total_minutos, total_datos) VALUES ('Paquete 100/100 Min/Gb', 100, 100);


INSERT INTO dispositivos_simcards (id_plan , id_simcard, id_dispositivo,fecha_inicio, fecha_fin, latitud, longitud, min_consumidos,gb_consumidos ) VALUES (1,1,1,NOW(),NOW(), 153, 125,50 , 0);
INSERT INTO dispositivos_simcards (id_plan , id_simcard, id_dispositivo,fecha_inicio, fecha_fin, latitud, longitud, min_consumidos,gb_consumidos ) VALUES (1,2,1,NOW(),NOW(), 153, 125,50 , 0);
INSERT INTO dispositivos_simcards (id_plan , id_simcard, id_dispositivo,fecha_inicio, fecha_fin, latitud, longitud, min_consumidos,gb_consumidos ) VALUES (1,3,1,NOW(),NOW(), 153, 125,50 , 0);
INSERT INTO dispositivos_simcards (id_plan , id_simcard, id_dispositivo,fecha_inicio, fecha_fin, latitud, longitud, min_consumidos,gb_consumidos ) VALUES (1,2,2,NOW(),NOW(), 153, 125,0 , 50);


