
## Pipeline
[![Java CI with Maven](https://github.com/MohamedAliSidibe/OSMBack/actions/workflows/maven.yml/badge.svg)](https://github.com/MohamedAliSidibe/OSMBack/actions/workflows/maven.yml)
# 🚀 Voyage et Partages

## 📍 Description du projet
Le projet **Voyage et Partages** a pour but de créer une carte interactive représentant un carnet de voyage. Il inclut des points d’intérêts (**musées, points de vue, hôtels...**), des photos et les trajets **piétons/voiture** entre ces points.

## 🗺️ Fonctionnalités principales
- Une carte affichant les **lieux visités** sous forme de **markers interactifs**.
- Affichage des **itinéraires piétons et voitures** entre les points d'intérêt.
- Gestion des **temps de transport** et du **temps passé sur place**.
- Possibilité d'afficher **plusieurs voyages** avec des détails spécifiques.
- **Navigation simplifiée** entre les jours d'un voyage.
- Utilisation d'une **API de géocodage** pour rechercher et afficher des lieux.

---

## 🏛️ Diagramme de classes
L'architecture du projet repose sur **trois entités principales** :

- **Voyage** : Représente un voyage complet. Il regroupe plusieurs journées, chacune contenant un itinéraire spécifique.
- **Jour** : Correspond à une journée d’un voyage, associée à un mode de transport et un itinéraire précis.
- **PointDetail** : Représente un point d'intérêt visité au cours d’une journée, incluant sa position géographique et des informations associées (horaires, description, photos...).

### 📌 Relations entre les classes :
- Un **Voyage** peut contenir plusieurs **Jours**.
- Un **Jour** appartient à un **Voyage** et contient plusieurs **Points de Détail**.
- Un **Point de Détail** est rattaché à un **Jour** unique.

Le diagramme ci-dessous illustre ces relations :

![Diagramme UML](/images/OSM.png)

---

## 📊 Explication des relations
- **Un voyage est composé de plusieurs jours**, ce qui permet de structurer un itinéraire en étapes.
- **Chaque jour comprend un mode de transport et un tracé géographique**, reliant différents lieux.
- **Un point de détail représente un lieu précis visité dans la journée**, avec des informations associées.

