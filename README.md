# Gestion des Factures - API

## Installation et Lancement du Projet

### Prérequis

Avant d'installer et d'exécuter ce projet, assurez-vous d'avoir les éléments suivants installés sur votre machine :

    - Java 17
    - Maven 3.x


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
mvn spring-boot:run
```

Accès à la Documentation de l'API
Une fois l'application lancée, la documentation de l'API sera disponible à l'adresse suivante : `http://localhost:8010/swagger-ui/index.html`

Swagger UI vous permettra de tester directement les différents endpoints de l'API.
