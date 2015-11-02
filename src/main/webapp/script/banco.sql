create table "APP".USUARIO
    (
            EMAIL VARCHAR(100) not null primary key,
            SENHA VARCHAR(100),
            NOMECOMPLETO VARCHAR(100),
            RG VARCHAR(100),
            FILIAL VARCHAR(100),
            CARGO VARCHAR(100),
            TIPOUSUARIO VARCHAR(100)
    )