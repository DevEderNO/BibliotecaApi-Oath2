-- users SENHA admin
INSERT INTO usuario (id, nome, email, senha) values (1, 'Administrador', 'admin@admin.com', '$2a$10$3y4RPg/.MZOCz9bsKoHtbOWmBlg4L43rLyU1ee/r0UeOg0Sa5SvzO');
INSERT INTO usuario (id, nome, email, senha) values (2, 'Usuario', 'usuario@usuario.com', '$2a$10$3y4RPg/.MZOCz9bsKoHtbOWmBlg4L43rLyU1ee/r0UeOg0Sa5SvzO');

-- roles
INSERT INTO permissao (id, descricao) values (1, 'ROLE_INCLUIR_LIVRO');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_ALTERAR_LIVRO');
INSERT INTO permissao (id, descricao) values (3, 'ROLE_EXCLUIR_LIVRO');
INSERT INTO permissao (id, descricao) values (4, 'ROLE_PESQUISAR_POR_ID_LIVRO');
INSERT INTO permissao (id, descricao) values (5, 'ROLE_LISTAR_LIVRO');

INSERT INTO permissao (id, descricao) values (6, 'ROLE_INCLUIR_GENERO');
INSERT INTO permissao (id, descricao) values (7, 'ROLE_ALTERAR_GENERO');
INSERT INTO permissao (id, descricao) values (8, 'ROLE_EXCLUIR_GENERO');
INSERT INTO permissao (id, descricao) values (9, 'ROLE_PESQUISAR_POR_ID_GENERO');
INSERT INTO permissao (id, descricao) values (10, 'ROLE_LISTAR_GENERO');

-- ADMIN
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,3);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,4);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,5);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,6);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,7);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,8);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,9);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1,10);

-- Usuario
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2,9);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (2,10);
