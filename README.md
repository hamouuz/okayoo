# Gestion des Factures - README

#Introduction
Ce projet est une API de gestion des factures développée en Spring Boot. Elle permet la création, la mise à jour, la suppression et la récupération de factures, produits, et clients avec des relations gérées via des entités JPA. L'API est documentée avec Swagger UI pour faciliter les tests et les intégrations.

Prérequis
Avant d'installer et d'exécuter le projet, assurez-vous d'avoir les éléments suivants :

Java 17
Maven 3.x
MySQL 8.x
Git pour cloner le dépôt
Un outil comme Postman ou Swagger UI pour tester les endpoints
Installation
Clonez le dépôt GitHub :

bash
Copier le code
git clone https://github.com/hamouuz/okayo.git
cd okayo
Configurez la base de données MySQL. Créez une base de données appelée gestion_facture_db :

sql
Copier le code
CREATE DATABASE gestion_facture_db;
Ouvrez le fichier application.properties ou application.yml et configurez vos identifiants MySQL :

properties
Copier le code
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_facture_db
spring.datasource.username=your_username
spring.datasource.password=your_password
Installez les dépendances et compilez le projet avec Maven :

bash
Copier le code
mvn clean install
Exécutez l'application Spring Boot :

bash
Copier le code
mvn spring-boot:run
Accédez à l'interface Swagger UI pour tester les endpoints :

Swagger UI

Configuration Flyway
Le projet utilise Flyway pour gérer les migrations de la base de données. Les scripts de migration se trouvent dans le répertoire /src/main/resources/db/migration.

Chaque nouvelle version de la base de données doit être gérée via un script Flyway. Vous pouvez ajouter un script SQL dans ce répertoire pour chaque nouvelle migration de la base de données.

Endpoints de l'API
L'API expose plusieurs endpoints pour la gestion des clients, produits, factures, et TVA. Voici un résumé des principaux endpoints disponibles :

Facture Controller
GET /api/factures/{id} : Récupérer une facture par ID
POST /api/factures : Créer une nouvelle facture
PUT /api/factures/{id} : Mettre à jour une facture existante
DELETE /api/factures/{id} : Supprimer une facture
Client Controller
GET /api/clients/{id} : Récupérer un client par ID
POST /api/clients : Créer un nouveau client
PUT /api/clients/{id} : Mettre à jour un client existant
DELETE /api/clients/{id} : Supprimer un client
Produit Controller
GET /api/produits/{id} : Récupérer un produit par ID
POST /api/produits : Créer un nouveau produit
PUT /api/produits/{id} : Mettre à jour un produit existant
DELETE /api/produits/{id} : Supprimer un produit
TVA Controller
GET /api/tva/{id} : Récupérer une TVA par ID
POST /api/tva : Ajouter une nouvelle TVA
PUT /api/tva/{id} : Mettre à jour une TVA existante
DELETE /api/tva/{id} : Supprimer une TVA
Modèles de données (Entités)
Le projet contient plusieurs entités pour gérer les factures, clients, produits, et TVA.

Client
id
code_client
nom
adresse
telephone
created_at
Facture
id
ref_facture
date_facturation
date_echeance
total_ht
total_ttc
conditions_reglement
client_id
Produit
id
code_produit
designation
prix_unitaire_ht
taux_tva
quantite
TVA
id
taux_tva
Authentification
L'API n'est pas actuellement sécurisée par un mécanisme d'authentification. Vous pouvez ajouter un mécanisme de sécurité avec JWT ou OAuth2 selon vos besoins futurs.

Exemples de requêtes cURL
Voici quelques exemples de requêtes pour tester l'API avec cURL :

Créer une facture :

bash
Copier le code
curl -X POST "http://localhost:8010/api/factures" -H "Content-Type: application/json" -d '{
    "refFacture": "F2024-003",
    "dateFacturation": "2024-10-10",
    "dateEcheance": "2024-11-10",
    "totalHt": 1000,
    "totalTtc": 1200,
    "conditionsReglement": "30 jours",
    "client": {
        "id": 1
    },
    "produits": [
        {
            "id": 1,
            "quantite": 2
        },
        {
            "id": 2,
            "quantite": 1
        }
    ]
}'
Récupérer une facture :

bash
Copier le code
curl -X GET "http://localhost:8010/api/factures/1"
Test et Debugging
Utilisez l'interface Swagger pour effectuer des tests interactifs. Vous pouvez aussi utiliser Postman pour envoyer des requêtes et vérifier les réponses de l'API.

Licence
Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.

