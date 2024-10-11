# Gestion des Factures - API

## Installation et Lancement du Projet

### Prérequis

Avant d'installer et d'exécuter ce projet, assurez-vous d'avoir les éléments suivants installés sur votre machine :

    - Java 17
    - Maven 3.x


### Modèle de données relationnel

![image](https://github.com/user-attachments/assets/327846cd-b9ea-47d7-91b5-16899101d9ff)



### Configurez les informations de connexion MySQL dans le fichier application.properties :

Ouvrez le fichier `src/main/resources/application.properties` et configurez les paramètres de votre base de données :

```
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_facture_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

Installez les dépendances du projet et compilez-le avec Maven :

```
mvn clean install
```

Lancez l'application Spring Boot :

```
mvn compile
```

Accès à la Documentation de l'API
Une fois l'application lancée, la documentation de l'API sera disponible à l'adresse suivante : `http://localhost:8010/swagger-ui/index.html`

Swagger UI vous permettra de tester directement les différents endpoints de l'API.

### Tester l'API de création de facture
Vous pouvez tester la création d'une facture en utilisant Postman en envoyant une requête POST à l'URL suivante :
```
POST : http://localhost:8010/api/factures
```
Exemple de corps de requête (JSON) :
```
{
    "refFacture": "F0001-011",
    "dateFacturation": "2024-10-17",
    "dateEcheance": "2024-11-17",
    "totalHt": 0,
    "totalTtc": 0,
    "conditionsReglement": "30 jours",
    "produits": [
        {
            "codeProduit": "PROD001",
            "designation": "Produit AA",
            "prixUnitaireHt": 70000,
            "tauxTva": 20,
            "quantite": 1
        },
        {
            "codeProduit": "PROD002",
            "designation": "Produit BB",
            "prixUnitaireHt": 1500,
            "tauxTva": 5.5,
            "quantite": 2
        },
        {
            "codeProduit": "PROD003",
            "designation": "Produit CC",
            "prixUnitaireHt": 4000,
            "tauxTva": 7,
            "quantite": 2
        },
        {
            "codeProduit": "PROD004",
            "designation": "Produit DD",
            "prixUnitaireHt": 3000,
            "tauxTva": 20,
            "quantite": 1
        }
    ]
}
```

