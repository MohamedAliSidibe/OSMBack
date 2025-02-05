package org.sid;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.sid.entities.Jour;
import org.sid.entities.PointDetail;
import org.sid.entities.Voyage;
import org.sid.repository.VoyageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VoyagesEtPartagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoyagesEtPartagesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(VoyageRepository voyageRepository) {
		return args -> {
			GeometryFactory geometryFactory = new GeometryFactory();

			// 1️⃣ Création du premier voyage "Paris Classique"
			Voyage voyage1 = new Voyage();
			voyage1.setId("voyage1");
			voyage1.setName("Paris Classique");

			// 📌 Ajout des 3 jours avec une fonction générique
			List<Jour> jours = new ArrayList<>();
			jours.add(createJour(1, "walking", List.of(
					createPoint("Tour Eiffel", 2.2945, 48.8584, "tour eiffel", "09:00", "10:30", "Un des monuments les plus célèbres au monde. Situé à Paris, la Tour Eiffel est une prouesse architecturale."),
					createPoint("Musée du Louvre", 2.3364, 48.8606, "louvre museum", "11:00", "12:30", "Le musée du Louvre est le plus grand musée d'art au monde. Il abrite la célèbre Joconde."),
					createPoint("Pont Alexandre III", 2.3131, 48.8656, "pont alexandre iii", "13:00", "14:30", "Un pont élégant et orné reliant les Invalides et le Grand Palais."),
					createPoint("Place de la Concorde", 2.321, 48.8655, "place de la concorde", "15:00", "16:00", "Une des plus grandes places de Paris, riche en histoire."),
					createPoint("Jardin des Tuileries", 2.3266, 48.8636, "jardin des tuileries", "16:30", "17:30", "Un jardin classique entre le Louvre et la Place de la Concorde."),
					createPoint("Opéra Garnier", 2.3318, 48.8706, "opera garnier", "18:00", "19:00", "Un magnifique opéra au cœur de Paris avec une architecture grandiose."),
					createPoint("Les Invalides", 2.3124, 48.8566, "les invalides", "19:30", "20:30", "Un complexe historique avec le tombeau de Napoléon et des musées militaires.")
			), geometryFactory));

			jours.add(createJour(2, "driving", List.of(
					createPoint("Cathédrale Notre-Dame", 2.3499, 48.8529, "notre dame cathedral", "09:00", "10:30", "Cette cathédrale gothique est un chef-d'œuvre d'architecture et un symbole emblématique de Paris."),
					createPoint("Basilique du Sacré-Cœur", 2.3431, 48.8867, "sacre coeur", "11:00", "12:30", "Située au sommet de la butte Montmartre, cette basilique offre une vue panoramique spectaculaire de Paris."),
					createPoint("Parc des Buttes-Chaumont", 2.3824, 48.8809, "buttes chaumont", "13:00", "14:30", "Un parc pittoresque avec des collines, des grottes et des cascades."),
					createPoint("Musée Picasso", 2.3626, 48.8593, "picasso museum", "15:00", "16:30", "Un musée dédié à l'œuvre de Pablo Picasso."),
					createPoint("Place des Vosges", 2.3669, 48.8555, "place des vosges", "17:00", "18:00", "Un charmant square historique dans le quartier du Marais."),
					createPoint("Centre Pompidou", 2.3522, 48.8606, "pompidou center", "18:30", "19:30", "Un centre culturel célèbre pour son architecture audacieuse et ses expositions d'art contemporain."),
					createPoint("Jardin du Luxembourg", 2.3372, 48.8462, "jardin du luxembourg", "20:00", "21:00", "Un magnifique jardin au cœur de Paris, idéal pour une promenade ou un moment de détente.")
			), geometryFactory));

			jours.add(createJour(3, "walking", List.of(
					createPoint("Panthéon", 2.346, 48.8462, "pantheon paris", "09:00", "10:30", "Un mausolée monumental abritant les tombes des grandes figures de l'histoire française."),
					createPoint("Parc Monceau", 2.308, 48.879, "parc monceau", "11:00", "12:30", "Un charmant parc avec une ambiance romantique et des structures historiques."),
					createPoint("Musée d'Orsay", 2.325, 48.8599, "orsay museum", "13:00", "14:30", "Un musée renommé pour ses collections d'art impressionniste et post-impressionniste."),
					createPoint("Les Invalides", 2.3124, 48.8566, null, "15:00", "16:30", "Un complexe historique avec le tombeau de Napoléon et des musées militaires."),
					createPoint("Grand Palais", 2.3125, 48.8662, "grand palais", "17:00", "18:30", "Un site emblématique pour les expositions d'art et les événements culturels."),
					createPoint("Petit Palais", 2.3132, 48.8663, "petit palais", "19:00", "20:00", "Un musée d'art offrant une collection fascinante et une magnifique architecture."),
					createPoint("Place Vendôme", 2.3283, 48.867, "place vendome", "20:30", "21:30", "Une place célèbre pour ses boutiques de luxe et son architecture imposante.")
			), geometryFactory));

			voyage1.setJours(jours);
			voyageRepository.save(voyage1);
		};
	}

	private PointDetail createPoint(String name, double lon, double lat, String photoQuery, String arrivalTime, String departureTime, String description) {
		return new PointDetail(null, name, new GeometryFactory().createPoint(new Coordinate(lon, lat)), photoQuery, arrivalTime, departureTime, description);
	}

	private Jour createJour(int day, String mode, List<PointDetail> points, GeometryFactory geometryFactory) {
		LineString path = geometryFactory.createLineString(points.stream()
				.map(p -> new Coordinate(p.getCoordinates().getX(), p.getCoordinates().getY()))
				.toArray(Coordinate[]::new));

		return new Jour(null, day, points, mode, path);
	}
}
