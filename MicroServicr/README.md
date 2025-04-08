# Gestion des Stocks avec Gateway et Services Dockerisés

Ce projet met en place une application pour gérer les stocks, en utilisant une architecture microservices avec une passerelle (Gateway) et plusieurs services Dockerisés. Les services communiquent entre eux via Eureka pour la découverte de services.

## Structure du Projet

Le projet est composé de plusieurs services qui interagissent entre eux :

1. **Eureka Server** (Service de découverte) : Utilisé pour l'enregistrement et la découverte des services.
2. **Gateway Service** : Passerelle qui redirige les requêtes vers les services appropriés.
3. **Stock Service** : Service principal pour gérer les opérations liées aux stocks.
4. **Base de Données MySQL** : Contient les informations relatives aux stocks.
5. **Keycloak** : Utilisé pour la gestion de l'authentification et de la sécurité.

## Fonctionnalités Principales

### 1. **Gestion des Stocks (Stock Service)**
   - Permet de gérer les informations des stocks, telles que l'ajout, la modification, et la suppression des produits.
   - Les services exposent des API REST via `http://localhost:8085/api/stocks/**` pour interagir avec les données de stock.

### 2. **Passerelle Gateway**
   - La passerelle redirige les requêtes vers le service `stock-service` lorsque les chemins `/api/stocks/**` sont demandés via `http://localhost:8093/api/stocks/**`.
   - La passerelle est configurée pour acheminer les requêtes en fonction de la configuration des routes dans `application.properties` :

     ```properties
     spring.cloud.gateway.routes[0].id=GESTIONSTOCK
     spring.cloud.gateway.routes[0].predicates=Path=/api/stocks/**
     spring.cloud.gateway.routes[0].uri=http://stock-service:8089
     ```

### 3. **Eureka Server (Discovery Service)**
   - Eureka est utilisé pour l'enregistrement des services et leur découverte.
   - Les services s'enregistrent auprès de Eureka pour être découverts par d'autres services dans le réseau.

### 4. **Base de Données MySQL**
   - La base de données stocke les informations sur les stocks et permet de les manipuler à travers le service `stock-service`.
   - La base de données utilise le nom de service `mysql-db` pour la connexion.

### 5. **Authentification avec Keycloak**
   - Keycloak est intégré pour la gestion de l'authentification et la sécurité des services.
   - Il expose une interface de gestion à `http://localhost:8180`.

## Prérequis

Avant de démarrer les services, vous devez avoir Docker et Docker Compose installés sur votre machine.

- **Docker** : [Installer Docker](https://www.docker.com/get-started)
- **Docker Compose** : [Installer Docker Compose](https://docs.docker.com/compose/install/)

## Configuration

1. **Eureka Server** : Le serveur Eureka est configuré dans le service `discovery-service` et écoute sur le port `8761` :

   ```yaml
   ports:
     - "8761:8761"
2. **Gateway Service : La passerelle Gateway écoute sur le port 8093 et redirige les requêtes vers le service stock-service :
ports:
  - "8093:8093"

3. **Stock Service : Le service stock-service écoute sur le port 8089 à l'intérieur du conteneur, mais il est exposé sur 8085 sur votre machine locale.
ports:
  - "8085:8089"

4. **MySQL Database : Le service mysql-db utilise le port 3306 pour la connexion à la base de données.
ports:
  - "3306:3306"

5. **Keycloak : Keycloak est configuré pour démarrer sur le port 8180 pour la gestion de l'authentification.
ports:
  - "8180:8180"

## Démarrage du Projet
  Étape 1 : Construire et démarrer les services avec Docker Compose
  Dans le répertoire du projet, exécutez la commande suivante pour démarrer tous les services définis dans le fichier docker-compose.yml :
  docker-compose up --build
  ==> Cela va construire et démarrer tous les services, y compris la base de données, Eureka, le Gateway, le stock-service, et Keycloak.

## Étape 2 : Accéder aux Services
        ##Eureka Server : Accédez à Eureka à l'adresse http://localhost:8761 pour voir les services enregistrés.

        Gateway Service : Accédez à l'API via la passerelle sur http://localhost:8093/api/stocks/getAllStocks pour récupérer les informations sur les stocks.

        Keycloak : Accédez à Keycloak pour la gestion de l'authentification à l'adresse http://localhost:8180.
## Étape 3 : Tester les API
        Utilisez un outil comme Postman ou curl pour tester les API exposées par le stock-service via la passerelle Gateway.
        Exemple de requête avec curl :
        curl(GET sur Postman) http://localhost:8093/api/stocks/getAllStocks

## Étape 4 : Vérification dans Eureka
   Vous pouvez accéder à l'interface Eureka à http://localhost:8761 pour vérifier que les services sont correctement enregistrés et visibles dans la liste des services.

## **Conclusion:** 
Ce projet permet de gérer les stocks à l'aide d'une architecture basée sur des microservices avec une passerelle de gestion des requêtes. La découverte des services est gérée par Eureka, et la sécurité est assurée par Keycloak.

