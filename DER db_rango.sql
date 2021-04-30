CREATE TABLE `tb_postagem` (
	`id` INT(255) NOT NULL AUTO_INCREMENT,
	`dataHora` DATETIME NOT NULL,
	`post` varchar(255) NOT NULL,
	`imagem` varchar(255) NOT NULL,
	`usuario_id` INT(255) NOT NULL,
	`tema_id` INT(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descricao` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nomeCompleto` varchar NOT NULL,
	`email` varchar NOT NULL,
	`senha` varchar NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario`(`id`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk1` FOREIGN KEY (`tema_id`) REFERENCES `tb_tema`(`id`);

