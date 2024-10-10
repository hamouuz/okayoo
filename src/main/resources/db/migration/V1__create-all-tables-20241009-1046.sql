-- Création de la table Client
CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code_client VARCHAR(50) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    adresse TEXT,
    telephone VARCHAR(20),
    created_at DATE NOT NULL
);

-- Création de la table TVA
CREATE TABLE IF NOT EXISTS tva (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    taux_tva DECIMAL(5, 2) NOT NULL,
    date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS `gestion_facture_db`.`facture` (
    `id` int NOT NULL AUTO_INCREMENT,
    `ref_facture` VARCHAR(255) NOT NULL,
    `date_facturation` DATE DEFAULT NULL,
    `date_echeance` DATE DEFAULT NULL,
    `total_ht` DECIMAL(10, 2) NOT NULL,
    `total_ttc` DECIMAL(10, 2) NOT NULL,
    `conditions_reglement` VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `gestion_facture_db`.`produit` (
    `id` int NOT NULL AUTO_INCREMENT,
    `code_produit` VARCHAR(50) NOT NULL,
    `designation` VARCHAR(255) NOT NULL,
    `taux_tva` DECIMAL(5, 2) NOT NULL,
    `prix_unitaire_ht` DECIMAL(10, 2) NOT NULL,
    `id_facture` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKng7ng01d355hkogsl5aeqad4i` (`id_facture`),
    CONSTRAINT `FKng7ng01d355hkogsl5aeqad4i` FOREIGN KEY (`id_facture`) REFERENCES `facture` (`id`)
);