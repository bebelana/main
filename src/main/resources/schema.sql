CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE resultado (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    parametros VARCHAR(255) NOT NULL,
    resultado INT NOT NULL,
    usuario_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
