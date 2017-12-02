
CREATE TABLE IF NOT EXISTS `unidade` (
 `id` INTEGER UNIQUE,
 `codigo` INTEGER,
 `nome` TEXT,
 `sigla` TEXT,
 PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `status_anuncio` (
 `id` TEXT UNIQUE,
 `nome` TEXT,
 PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `historico_anuncio` (
 `id` INTEGER,
 `id_anuncio` INTEGER,
 `status_anuncio` TEXT,
 `data_alteracao` TEXT,
 `id_usuario` INTEGER,
 `justificativa` TEXT,
 PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `foto` (
 `id` INTEGER UNIQUE,
 `id_arquivo` INTEGER UNIQUE,
 `url_foto` TEXT,
 `id_anuncio` INTEGER,
 PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `etiqueta` (
 `id` INTEGER UNIQUE,
 `nome` TEXT,
 PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `categoria_anuncio` (
 `id` TEXT UNIQUE,
 `descricao` TEXT,
 PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `anuncio` (
 `texto_publciacao` TEXT,
 `id` INTEGER,
 `status_anuncio` INTEGER,
 `data_cadastro` TEXT,
 `data_publicacao` INTEGER,
 `id_bem` INTEGER,
 `id_unidade` INTEGER,
 `categoria_anuncio` INTEGER,
 `quantidade_dias_ativo` INTEGER,
 `data_sincronizacao` TEXT
);
CREATE TABLE IF NOT EXISTS `Usuario` (
 `id` INTEGER,
 `login` TEXT,
 `id_unidade` INTEGER,
 `email` TEXT,
 `url_foto` TEXT
);
CREATE TABLE IF NOT EXISTS `Interesse` (
 `id` INTEGER UNIQUE,
 `id_interessado` INTEGER UNIQUE,
 `data_interesse` TEXT,
 `id_anuncio` INTEGER,
 `data_aprovacao` TEXT,
 PRIMARY KEY(`id`)
);