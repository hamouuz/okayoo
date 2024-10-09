-- Création de la table Client
CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code_client VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    adresse TEXT,
    telephone VARCHAR(20),
    created_at DATE NOT NULL
) ENGINE=InnoDB;

-- Création de la table TVA
CREATE TABLE IF NOT EXISTS tva (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    taux_tva DECIMAL(5, 2) NOT NULL,
    date DATE NOT NULL
) ENGINE=InnoDB;

-- Création de la table Produit
CREATE TABLE IF NOT EXISTS produit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code_produit VARCHAR(50) NOT NULL,
    designation VARCHAR(255) NOT NULL,
    taux_tva DECIMAL(5, 2) NOT NULL,
    prix_unitaire_ht DECIMAL(10, 2) NOT NULL,
    tva_id BIGINT,
    CONSTRAINT fk_tva FOREIGN KEY (tva_id) REFERENCES tva(id)
) ENGINE=InnoDB;

-- Création de la table Facture
CREATE TABLE IF NOT EXISTS facture (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ref_facture VARCHAR(255) NOT NULL,
    date_facturation DATE NOT NULL,
    date_echeance DATE NOT NULL,
    total_ht DECIMAL(10, 2) NOT NULL,
    total_ttc DECIMAL(10, 2) NOT NULL,
    conditions_reglement VARCHAR(255),
    client_id BIGINT,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id)
) ENGINE=InnoDB;
