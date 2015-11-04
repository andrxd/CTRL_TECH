create table "APP".USUARIO
    (
            EMAIL VARCHAR(100) not null primary key,
            SENHA VARCHAR(100),
            NOMECOMPLETO VARCHAR(100),
            RG VARCHAR(100),
            FILIAL VARCHAR(100),
            CARGO VARCHAR(100),
            TIPOUSUARIO VARCHAR(100),
            Ativo int

    );

CREATE TABLE TB_Produto (
    ID_Produto BIGINT NOT NULL GENERATED ALWAYS
    AS IDENTITY (START WITH 1, INCREMENT BY 1)
    CONSTRAINT PK_Produto PRIMARY KEY,

    NM_Produto VARCHAR(50) NOT NULL,
    Descricao VARCHAR(50),
    preco double NOT NULL,
    QTD_Atual int NOT NULL,
    QTD_Minima int NOT NULL,
    QTD_Maxima int NOT NULL,
    Plataforma VARCHAR(50) ,
    Genero VARCHAR(50),
    Garantia VARCHAR(50),
    FaixaEtaria VARCHAR(50),
    Armazenamento int,
    Flag int,
    TipoProduto VARCHAR(30)
);
