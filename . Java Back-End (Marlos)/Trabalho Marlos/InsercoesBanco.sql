CREATE DATABASE taskcontrol

INSERT INTO user (email, name) VALUES
("matheusleite@gmail.com", "Matheus"),
("brunoramon@gmail.com", "Bruno"),
("marlos@gmail.com", "Marlos"),
("miguel@gmail.com", "Miguel"),
("adriel@gmail.com", "Adriel");

INSERT INTO task (description, scheduling_date, status, title, user_id) VALUES
("Aula de Python e MongoDB", "2025-10-01", 1,"Aula de Programação" ,1),
("Aula de Ritmo, GBO e Cronometragem", "2025-09-30", 1,"Aula de Cronoanálise" ,1),
("Aula de Fintas e Jabs", "2025-10-03", 4,"Aula de Boxe" ,2),
("Aula de como fazer uma mesa", "2025-10-04", 2,"Aula de Marcenaria" ,3),
("Aula de PROCV, PROCX e PROCH", "2025-10-05", 3,"Aula de Excel" ,4),
("Aula de Yoga na Academia AD3", "2025-10-06", 2,"Aula de Yoga" ,5),
("Aula de Pilates na Academia UFIT", "2025-10-07", 4,"Aula de Pilates" ,5);




