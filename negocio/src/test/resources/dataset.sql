insert into cliente values("11111", "juan@gmail.com", "Juan", "123123", true, "ruta foto");
insert into cliente values("22222", "luis@gmail.com", "Luis",   "123123", true, "ruta foto");
insert into cliente values("33333", "andres@gmail.com", "Andres" , "123123", true, "ruta foto");
insert into cliente values("44444", "carlos@gmail.com", "Carlos", "123123", true, "ruta foto");
insert into cliente values("55555", "pedro@gmail.com", "Pedro",   "123123", true, "ruta foto");

insert into cliente_telefonos values("11111", "4353453");
insert into cliente_telefonos values("11111", "5464756");
insert into cliente_telefonos values("22222", "1235435");
insert into cliente_telefonos values("22222", "9789784");
insert into cliente_telefonos values("33333", "5672343");
insert into cliente_telefonos values("33333", "6456123");
insert into cliente_telefonos values("44444", "7876834");
insert into cliente_telefonos values("44444", "7876324");
insert into cliente_telefonos values("55555", "12345678");
insert into cliente_telefonos values("55555", "898952323");

insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Bogota");
insert into ciudad values (3, "Medellin");
insert into ciudad values (4, "Cali");
insert into ciudad values (5, "Barranquilla");

insert into administrador values("11111", "admin@gmail.com", "Admin", "123123", "admin");


insert into administrador_teatro values("1", "admin1@gmail.com", "Admin1",   "123123");
insert into administrador_teatro values("2", "admin2@gmail.com", "Admin2",   "123123");
insert into administrador_teatro values("3", "admin3@gmail.com", "Admin3",   "123123");
insert into administrador_teatro values("4", "admin4@gmail.com", "Admin4",   "123123");
insert into administrador_teatro values("5", "admin5@gmail.com", "Admin5",   "123123");

insert into teatro values (1, "Unicentro", "Teatro1", "213123", "1" , 1);
insert into teatro values (2, "Sao", "Teatro2", "213123", "1" , 1);
insert into teatro values (3, "Calima", "Teatro3", "213123", "1" , 1);
insert into teatro values (4, "Cra 20 #15-13", "Teatro3", "213123", "1" , 1);
insert into teatro values (5, "Calima", "Teatro3", "213123", "1" , 1);

insert into confiteria values (1, "urlImagen", "Palomitas 400 gramos", 45000);
insert into confiteria values (2, "urlImagen", "Palomitas 600 gramos", 65000);
insert into confiteria values (3, "urlImagen", "Palomitas 800 gramos", 85000);
insert into confiteria values (4, "urlImagen", "Gaseosa 350 ML", 85000);
insert into confiteria values (5, "urlImagen", "Gaseosa 450 ML", 85000);

insert into pelicula values (1, "activo", "Terror", "imagenPelicula", "Hallowen", "Maicol", "Pelicula de terror", "Hallowen.mp4");
insert into pelicula values (2, "activo", "Comedia", "imagenPelicula", "Ted", "Oso", "Oso Ted", "Ted.mp4");
insert into pelicula values (3, "activo", "Accion", "imagenPelicula", "Fast furios", "Carreras", "Carreras", "FastFurios.mp4");
insert into pelicula values (4, "activo", "Animada", "imagenPelicula", "Toy story", "Juguetes", "Juguetes", "ToyStory.mp4");
insert into pelicula values (5, "activo", "Accion", "imagenPelicula", "Avenger", "Marvel", "Super heroes", "Avenger.mp4");


insert into distribucion_sillas values (1, 10, "", 10, 100);
insert into distribucion_sillas values (2, 10, "", 10, 100);
insert into distribucion_sillas values (3, 10, "", 10, 100);
insert into distribucion_sillas values (4, 10, "", 10, 100);
insert into distribucion_sillas values (5, 10, "", 10, 100);
insert into distribucion_sillas values (6, 10, "", 10, 100);
insert into distribucion_sillas values (7, 10, "", 10, 100);
insert into distribucion_sillas values (8, 10, "", 10, 100);
insert into distribucion_sillas values (9, 10, "", 10, 100);
insert into distribucion_sillas values (10, 10, "", 10, 100);
insert into distribucion_sillas values (11, 10, "", 10, 100);
insert into distribucion_sillas values (12, 10, "", 10, 100);
insert into distribucion_sillas values (13, 10, "", 10, 100);
insert into distribucion_sillas values (14, 10, "", 10, 100);
insert into distribucion_sillas values (15, 10, "", 10, 100);


insert into sala values (1, "Sala1", 1, 1);
insert into sala values (2, "Sala2", 2, 1);
insert into sala values (3, "Sala3", 3, 1);
insert into sala values (4, "Sala4", 4, 5);
insert into sala values (5, "Sala5", 5, 1);
insert into sala values (6, "Sala6", 6, 2);
insert into sala values (7, "Sala7", 7, 2);
insert into sala values (8, "Sala8", 8, 2);
insert into sala values (9, "Sala9", 9, 5);
insert into sala values (10, "Sala10", 10, 2);
insert into sala values (11, "Sala11", 1, 3);
insert into sala values (12, "Sala12", 2, 3);
insert into sala values (13, "Sala13", 3, 3);
insert into sala values (14, "Sala14", 4, 3);
insert into sala values (15, "Sala15", 5, 5);


insert into horario values (1, "LMXJVSD", "20:00");
insert into horario values (2, "LMSD", "21:00");
insert into horario values (3, "SD", "12:00");
insert into horario values (4, "LJVSD", "15:00");
insert into horario values (5, "LMXJVSD", "09:00");

insert into funcion values (1, 12000, 1, 1, 1);
insert into funcion values (2, 5500, 2, 2, 2);
insert into funcion values (3, 7000, 3, 3, 3);
insert into funcion values (4, 9000, 4, 4, 4);
insert into funcion values (5, 12000, 5, 5, 5);
insert into funcion values (6, 18000, 1, 1, 6);
insert into funcion values (7, 13000, 2, 2, 7);
insert into funcion values (8, 7000, 3, 3, 8);
insert into funcion values (9, 7400, 4, 4, 9);
insert into funcion values (10, 12000, 5, 5, 10);
insert into funcion values (11, 11000, 1, 1, 11);

insert into cupon values (1, "Cupon", 12, 1, "2022-12-17");
insert into cupon values (2, "Cupon", 22, 1, "2022-12-17");
insert into cupon values (3, "Cupon", 32, 1, "2022-12-17");
insert into cupon values (4, "Cupon", 2, 1, "2022-12-17");
insert into cupon values (5, "Cupon", 10, 1, "2022-12-17");
insert into cupon values (6, "Cupon", 50, 1, "2022-12-17");

insert into compra values (1, NOW(), "VISA", 50000, "22222", 1, 1);
insert into compra values (2, NOW(), "PSE", 50000, "22222", 2, 2);
insert into compra values (3, NOW(), "NEQUI", 50000, "33333", 3, 3);
insert into compra values (4, NOW(), "DAVIPLATA", 50000, "44444", 4, 4);
insert into compra values (5, NOW(), "MASTERCARD", 50000, "55555", 5, 5);
insert into compra values (6, NOW(), "VISA", 50000, "55555", 6, 6);

insert into confiteria_compra values (1, 20000, 2, 1, 1);
insert into confiteria_compra values (2, 50000, 2, 2, 2);
insert into confiteria_compra values (3, 60000, 2, 3, 3);
insert into confiteria_compra values (4, 70000, 2, 4, 4);
insert into confiteria_compra values (5, 80000, 2, 5, 5);
insert into confiteria_compra values (6, 90000, 2, 6, 1);

insert into entrada values (1, 1, 1, 12000, 1);
insert into entrada values (2, 2, 1, 22000, 2);
insert into entrada values (3, 3, 1, 32000, 3);
insert into entrada values (4, 4, 1, 42000, 4);
insert into entrada values (5, 5, 1, 52000, 5);
insert into entrada values (6, 6, 1, 62000, 6);



