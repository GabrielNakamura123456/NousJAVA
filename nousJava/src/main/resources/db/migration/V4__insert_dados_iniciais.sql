INSERT INTO tds_nous_trilha (ds_titulo, ds_descricao, ds_categoria)
VALUES ('Controle da Ansiedade', 'Tecnicas praticas para reduzir ansiedade e organizar a rotina.', 'Saude Mental');

INSERT INTO tds_nous_trilha (ds_titulo, ds_descricao, ds_categoria)
VALUES ('Gestao das Emocoes', 'Estrategias para reconhecer e lidar melhor com as emocoes.', 'Gestao Emocional');

INSERT INTO tds_nous_trilha (ds_titulo, ds_descricao, ds_categoria)
VALUES ('Foco Total', 'Metodos simples para melhorar a concentracao nos estudos.', 'Foco nos Estudos');

INSERT INTO tds_nous_trilha (ds_titulo, ds_descricao, ds_categoria)
VALUES ('Comunicacao Assertiva', 'Boas praticas para se expressar com clareza e confianca.', 'Comunicacao');

INSERT INTO tds_nous_trilha (ds_titulo, ds_descricao, ds_categoria)
VALUES ('Autoconfianca na Pratica', 'Atividades para fortalecer seguranca emocional e autonomia.', 'Autoconfianca');

INSERT INTO tds_nous_checkin_emocional (id_usuario, dt_checkin, nr_humor, ds_comentario)
VALUES ((SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'aluno@nous.com'), DATE '2026-04-04', 2, 'Estou me sentindo cansada com as atividades.');

INSERT INTO tds_nous_checkin_emocional (id_usuario, dt_checkin, nr_humor, ds_comentario)
VALUES ((SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'aluno@nous.com'), DATE '2026-04-05', 2, 'Ansiosa com as provas da semana.');

INSERT INTO tds_nous_checkin_emocional (id_usuario, dt_checkin, nr_humor, ds_comentario)
VALUES ((SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'aluno@nous.com'), DATE '2026-04-06', 1, 'Hoje foi um dia dificil para estudar.');

INSERT INTO tds_nous_checkin_emocional (id_usuario, dt_checkin, nr_humor, ds_comentario)
VALUES ((SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'aluno@nous.com'), DATE '2026-04-07', 4, 'Consegui organizar melhor meu tempo.');

INSERT INTO tds_nous_checkin_emocional (id_usuario, dt_checkin, nr_humor, ds_comentario)
VALUES ((SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'bruno@nous.com'), DATE '2026-04-06', 4, 'Dia produtivo e mais tranquilo.');

INSERT INTO tds_nous_checkin_emocional (id_usuario, dt_checkin, nr_humor, ds_comentario)
VALUES ((SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'carla@nous.com'), DATE '2026-04-06', 3, 'Consegui estudar, mas ainda estou preocupada.');

INSERT INTO tds_nous_progresso_trilha (id_usuario, id_trilha, st_trilha, dt_inicio, dt_conclusao)
VALUES (
    (SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'aluno@nous.com'),
    (SELECT id_trilha FROM tds_nous_trilha WHERE ds_titulo = 'Controle da Ansiedade'),
    'Iniciada',
    DATE '2026-04-01',
    NULL
);

INSERT INTO tds_nous_progresso_trilha (id_usuario, id_trilha, st_trilha, dt_inicio, dt_conclusao)
VALUES (
    (SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'aluno@nous.com'),
    (SELECT id_trilha FROM tds_nous_trilha WHERE ds_titulo = 'Foco Total'),
    'Concluida',
    DATE '2026-03-20',
    DATE '2026-03-30'
);

INSERT INTO tds_nous_progresso_trilha (id_usuario, id_trilha, st_trilha, dt_inicio, dt_conclusao)
VALUES (
    (SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'bruno@nous.com'),
    (SELECT id_trilha FROM tds_nous_trilha WHERE ds_titulo = 'Gestao das Emocoes'),
    'Iniciada',
    DATE '2026-04-03',
    NULL
);

INSERT INTO tds_nous_progresso_trilha (id_usuario, id_trilha, st_trilha, dt_inicio, dt_conclusao)
VALUES (
    (SELECT id_usuario FROM tds_nous_usuario WHERE ds_email = 'carla@nous.com'),
    (SELECT id_trilha FROM tds_nous_trilha WHERE ds_titulo = 'Autoconfianca na Pratica'),
    'Iniciada',
    DATE '2026-04-02',
    NULL
);
