--select * from menu


insert into menu (id, nome) values (1, 'LOCALIDADE');
insert into menu (id, nome) values (2, 'USUARIOS');
insert into menu (id, nome) values (3, 'PESSOAS');
insert into menu (id, nome) values (4, 'EVENTOS');
insert into menu (id, nome) values (5, 'PRODUCAO');

--SELECT * FROM SUBMENU

insert into submenu values (1, 1, 'PAIS');
insert into submenu values (2, 1, 'ESTADO');
insert into submenu values (3, 1, 'CIDADE');
insert into submenu values (4, 1, 'DISTRITO');
insert into submenu values (5, 1, 'BAIRRO');
insert into submenu values (6, 1, 'FAIXA DE CEP');

insert into submenu values (7, 2, 'USUARIO');
insert into submenu values (8, 2, 'PERFIL DE ACESSO');
insert into submenu values (9, 2, 'ITEM DE ACESSO');

insert into submenu values (10, 3, 'PESSOA FISICA');
insert into submenu values (11, 3, 'PESSOA JURIDICA');

insert into submenu values (12, 4, 'PARTICIPANTE');
insert into submenu values (13, 4, 'EVENTOS');


insert into submenu values (14, 5, 'SOLICITAÇÃO');
insert into submenu values (15, 5, 'ORDEM DE PRODUÇÃO');


--select * from itemacesso

insert into itemacesso values (1, 'LISTA PAIS', 	1);
insert into itemacesso values (2, 'BUSCAR PAIS', 	1);
insert into itemacesso values (3, 'CADASTRAR PAIS', 	1);
insert into itemacesso values (4, 'EDITAR PAIS', 	1);
insert into itemacesso values (5, 'EXCLUIR PAIS', 	1);

insert into itemacesso values (6, 'LISTAR ESTADO', 	2);
insert into itemacesso values (7, 'BUSCAR ESTADO', 	2);
insert into itemacesso values (8, 'CADASTRAR ESTADO', 	2);
insert into itemacesso values (9, 'EDITAR ESTADO', 	2);
insert into itemacesso values (10, 'EXCLUIR ESTADO', 	2);

insert into itemacesso values (11, 'LISTAR CIDADE', 	3);
insert into itemacesso values (12, 'BUSCAR CIDADE', 	3);
insert into itemacesso values (13, 'CADASTRAR CIDADE', 	3);
insert into itemacesso values (14, 'EDITAR CIDADE', 	3);
insert into itemacesso values (15, 'EXCLUIR CIDADE', 	3);

insert into itemacesso values (16, 'LISTAR DISTRITO', 	4);
insert into itemacesso values (17, 'BUSCAR PAIS', 	4);
insert into itemacesso values (18, 'CADASTRAR DISTRITO',4);
insert into itemacesso values (19, 'EDITAR DISTRITO',   4);
insert into itemacesso values (20, 'EXCLUIR DISTRITO',  4);

insert into itemacesso values (21, 'LISTAR BAIRRO', 	5);
insert into itemacesso values (22, 'BUSCAR BAIRRO', 	5);
insert into itemacesso values (23, 'CADASTRAR BAIRRO',	5);
insert into itemacesso values (24, 'EDITAR BAIRRO',   	5);
insert into itemacesso values (25, 'EXCLUIR BAIRRO',  	5);

insert into itemacesso values (26, 'LISTAR FAIXA DE CEP',    6);
insert into itemacesso values (27, 'BUSCAR FAIXA DE CEP',    6);
insert into itemacesso values (28, 'CADASTRAR FAIXA DE CEP', 6);
insert into itemacesso values (29, 'EDITAR FAIXA DE CEP',    6);
insert into itemacesso values (30, 'EXCLUIR FAIXA DE CEP',   6);

insert into itemacesso values (31, 'LISTAR USUARIO',    7);
insert into itemacesso values (32, 'BUSCAR USUARIO',    7);
insert into itemacesso values (33, 'CADASTRAR USUARIO', 7);
insert into itemacesso values (34, 'EDITAR USUARIO',    7);
insert into itemacesso values (35, 'EXCLUIR USUARIO',   7);

insert into itemacesso values (36, 'LISTAR PERFIL DE ACESSO',    8);
insert into itemacesso values (37, 'BUSCAR PERFIL DE ACESSO',    8);
insert into itemacesso values (38, 'CADASTRAR PERFIL DE ACESSO', 8);
insert into itemacesso values (39, 'EDITAR PERFIL DE ACESSO',    8);
insert into itemacesso values (40, 'EXCLUIR PERFIL DE ACESSO',   8);

insert into itemacesso values (41, 'LISTAR ITEM DE ACESSO',    9);
insert into itemacesso values (42, 'BUSCAR ITEM DE ACESSO',    9);
insert into itemacesso values (43, 'CADASTRAR ITEM DE ACESSO', 9);
insert into itemacesso values (44, 'EDITAR ITEM DE ACESSO',    9);
insert into itemacesso values (45, 'EXCLUIR ITEM DE ACESSO',   9);

insert into itemacesso values (46, 'LISTAR PESSOA FÍSICA',    10);
insert into itemacesso values (47, 'BUSCAR PESSOA FÍSICA',    10);
insert into itemacesso values (48, 'CADASTRAR PESSOA FÍSICA', 10);
insert into itemacesso values (49, 'EDITAR PESSOA FÍSICA',    10);
insert into itemacesso values (50, 'EXCLUIR PESSOA FÍSICA',   10);

insert into itemacesso values (51, 'LISTAR PESSOA JURÍDICA',    11);
insert into itemacesso values (52, 'BUSCAR PESSOA JURÍDICA',    11);
insert into itemacesso values (53, 'CADASTRAR PESSOA JURÍDICA', 11);
insert into itemacesso values (54, 'EDITAR PESSOA JURÍDICA',    11);
insert into itemacesso values (55, 'EXCLUIR PESSOA JURÍDICA',   11);

insert into itemacesso values (56, 'LISTAR PARTICIPANTE',    12);
insert into itemacesso values (57, 'BUSCAR PARTICIPANTE',    12);
insert into itemacesso values (58, 'CADASTRAR PARTICIPANTE', 12);
insert into itemacesso values (59, 'EDITAR PARTICIPANTE',    12);
insert into itemacesso values (60, 'EXCLUIR PARTICIPANTE',   12);

insert into itemacesso values (61, 'LISTAR EVENTO',    13);
insert into itemacesso values (62, 'BUSCAR EVENTO',    13);
insert into itemacesso values (63, 'CADASTRAR EVENTO', 13);
insert into itemacesso values (64, 'EDITAR EVENTO',    13);
insert into itemacesso values (65, 'EXCLUIR EVENTO',   13);

insert into itemacesso values (66, 'LISTAR SOLICITAÇÃO',    14);
insert into itemacesso values (67, 'BUSCAR SOLICITAÇÃO',    14);
insert into itemacesso values (68, 'CADASTRAR SOLICITAÇÃO', 14);
insert into itemacesso values (69, 'EDITAR SOLICITAÇÃO',    14);
insert into itemacesso values (70, 'EXCLUIR SOLICITAÇÃO',   14);

insert into itemacesso values (71, 'LISTAR ORDEM DE PRODUÇÃO',    15);
insert into itemacesso values (72, 'BUSCAR ORDEM DE PRODUÇÃO',    15);
insert into itemacesso values (73, 'CADASTRAR ORDEM DE PRODUÇÃO', 15);
insert into itemacesso values (74, 'EDITAR ORDEM DE PRODUÇÃO',    15);
insert into itemacesso values (75, 'EXCLUIR ORDEM DE PRODUÇÃO',   15);