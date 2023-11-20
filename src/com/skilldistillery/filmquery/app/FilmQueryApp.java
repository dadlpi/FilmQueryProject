package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();  //this calls findFilmById
//		app.secondMethod(); //this calls findActorById
//		app.thirdMethod(); //this calls findActorsByFilmId
//		app.fourthMethod(); //this was a conceptual design
		app.launch();
	}

	private void searchFilmByFilmId(int filmId) {
		Film film = null;
		try {
			film = db.findFilmById(filmId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (film != null) {
			System.out.println("**************FILM FOUND: ******************");
			System.out.println("*****FILM NAME: " + film.getTitle());
			System.out.println("*****FILM YEAR: " + film.getReleaseYear());
			System.out.println("*****FILM RATING: " + film.getRating());
			System.out.println("*****FILM DESCRIPTION: " + film.getDescriptionOffilm());
			System.out.println("*****FILM LANGUAGE: " + film.getLanguage());
			List<Actor> cast = film.getCast();
//				System.out.println("*****CAST: " + (ArrayList<Actor>)film.getCast() );
			System.out.println("*****CAST: ");
			int actorPositionNumber = 1;
			for (Actor individualActor : cast) {
				System.out.println("\t" + actorPositionNumber + ") Actor: " + individualActor.getFirstName() + " "
						+ individualActor.getLastName() + " DB_ID #:" + individualActor.getId());
				actorPositionNumber++;
			}
			System.out.println("************ END OF FILM INFO **************");
		} else {
			System.out.println("film was not found, please search again by another ID or search method ");
		}
	}

	private void searchFilmByFilmSearchString(String searchString) {
		List<Film> films = new ArrayList<Film>();
		try {
			films = db.findFilmByString(searchString);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (films.isEmpty()) {
			System.out.println("film was not found, please search again by another search string or method ");
		} else {
			for (Film film : films) {
				System.out.println("**************FILM FOUND: ******************");
				System.out.println("*****FILM NAME: " + film.getTitle());
				System.out.println("*****FILM YEAR: " + film.getReleaseYear());
				System.out.println("*****FILM RATING: " + film.getRating());
				System.out.println("*****FILM DESCRIPTION: " + film.getDescriptionOffilm());
				System.out.println("*****FILM LANGUAGE: " + film.getLanguage());
				List<Actor> cast = film.getCast();
//				System.out.println("*****CAST: " + (ArrayList<Actor>)film.getCast() );
				System.out.println("*****CAST: ");
				int actorPositionNumber = 1;
				for (Actor individualActor : cast) {
					System.out.println("\t" + actorPositionNumber + ") Actor: " + individualActor.getFirstName() + " "
							+ individualActor.getLastName() + " DB_ID #:" + individualActor.getId());
					actorPositionNumber++;
				}
				System.out.println("************ END OF FILM INFO **************");
				System.out.println();
			}
		}
	}

//	LAB BLOCK
//	private void test(int filmId) {
//		Film film = null;
//		try {
//			film = db.findFilmById(filmId);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if (film != null) {
//			System.out.println(film.getTitle() + " " + film.getCast()+ " film is not null");
//		} else {
//			System.out.println("film is null ");
//		}
//	}
////
//	private void secondMethod() {
//		Actor actor = null;
//		
//		try {
//			actor = db.findActorById(2);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if (actor != null) {
//			System.out.println(actor.getId() + " " + actor.getFirstName() + " "+ actor.getLastName() + " actor is not null");
//		} else {
//			System.out.println("actor is null ");
//		}
//		
//	}
//	
//	
//	private void thirdMethod() {
//		List<Actor> manyActorsList = new ArrayList<Actor>();
//		try {
//			manyActorsList = db.findActorsByFilmId(2);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		int actorCount = 1;
//		for (Actor actor : manyActorsList) {
//			System.out.println(actorCount + ") DB_id=" + actor.getId() + ", firstName= " + actor.getFirstName() + ", lastName= " + actor.getLastName());
//			actorCount++;
//		}
//		
//	}
//	
//	private void fourthMethod() {
////		try {
////			manyActorsList = db.findActorsByFilmId(2);
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		int actorCount = 1;
////		for (Actor actor : manyActorsList) {
////			System.out.println(actorCount + ") DB_id=" + actor.getId() + ", firstName= " + actor.getFirstName() + ", lastName= " + actor.getLastName());
////			actorCount++;
////		}
//		
//	}
// END LAB BLOCK

	private void launch() {
		System.out.println("** Hello Welcome to the command line Movie search tool ********");
		System.out.println("** You can query the sdvid database to search for movie data **");
		System.out.println("***************************************************************");
		returnMainMenuOptions();
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		while (true) {
			int userInput = input.nextInt();
			if (userInput == 1) {
				System.out.println("Please select a FILM ID now to search for your desired film, which is numeric: ");
				int furtherUserInput = input.nextInt();
				searchFilmByFilmId(furtherUserInput);
				input.nextLine();
			} else if (userInput == 2) {
				System.out.println("Please enter a search string for the movie you are searching for:");
				String stringUserInput = input.next();
				searchFilmByFilmSearchString(stringUserInput);
				input.nextLine();
			} else if (userInput == 3) {
				System.out.println("thanks for using our Movie Search Tool, goodbye");
				break;
			} else {
				System.out.println("please make a valid selection");
			}

			returnMainMenuOptions();
		}

	}

	private void returnMainMenuOptions() {
		System.out.println();
		System.out.println("Enter the following Options:");
		System.out.println("1) Look up film by an ID number");
		System.out.println("2) Look up a film by a search keyword");
		System.out.println("3) Exit the Movie Search application");
	}
}
