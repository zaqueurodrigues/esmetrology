INSERT INTO tb_department (name) VALUES ('Metrology lab');
INSERT INTO tb_department (name) VALUES ('Storeroom stove');

INSERT INTO tb_user (name, enrollment, email, password, department_id) VALUES ('Zaqueu Rodrigues', '588941826', 'zaqueu.pereira@esmaltec.com.br', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 1);
INSERT INTO tb_user (name, enrollment, email, password, department_id) VALUES ('Pedro Gomes', '588949517', 'pedro.junior@esmaltec.com.br', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 1);
INSERT INTO tb_user (name, enrollment, email, password, department_id) VALUES ('Francisco Wedersen', '588919293', 'francisco.wedersen@esmaltec.com.br', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 2);

INSERT INTO tb_role (authority) VALUES ('ROLE_COMMON');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);

INSERT INTO tb_notification (text, moment, read, user_id) VALUES ('Manometro 52.34.00038 se vence em x dias', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', true, 1);
INSERT INTO tb_notification (text, moment, read, user_id) VALUES ('Paquímetro 52.01.00077 vencido', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', false, 1);

INSERT INTO tb_lab (name, address, accreditation_number) VALUES ('M&M Instrumentation', 'Av. Airton Senna, 13', 'RBC-52548871');

INSERT INTO tb_instrument (tag, serie, mark, description, type, range, frequency, last_calibration, status, note, department_id) VALUES ('52.34.00038', '12345', 'Wika', 'Manometro Digital Tex', 'Manometro', '0 a 16 bar', '12 meses', TIMESTAMP WITH TIME ZONE '2020-11-03T13:00:00Z', 1, 'Atualizado', 1); 
INSERT INTO tb_instrument (tag, serie, mark, description, type, range, frequency, last_calibration, status, note, department_id) VALUES ('52.01.30021', '6789', 'Record', 'Paquímetro Analógico', 'Paquímetro', '0 a 200 mm', '6 meses', TIMESTAMP WITH TIME ZONE '2020-11-03T13:00:00Z', 1, 'Reativado', 2); 


INSERT INTO tb_certificate (code, calibration_date, publish_date, instrument_id, lab_id) VALUES ('CC-0105/20', TIMESTAMP WITH TIME ZONE '2020-11-03T13:00:00Z', TIMESTAMP WITH TIME ZONE '2020-11-03T13:00:00Z', 1, 1);