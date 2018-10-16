import java.sql.*;

public class Main {
    public static void main(String[] args) {

        CreateComicDB cc = new CreateComicDB();
        //outputDB();
        addContent();
        System.out.println("==========================");
        outputDB();
    }

    public static void addContent() {

        System.out.println("Inserting records into the table...");
        ComicBookDao comicDAO = new ComicBookDao();
        comicDAO.addContent(new ComicBook("Invincible Iron Man #1", 2000));
        comicDAO.addContent(new ComicBook("Amazing Fantasy #14", 1000));
        comicDAO.addContent(new ComicBook("Peter Porker the Spectacular Spider-Ham #2", 20  ));
        comicDAO.addContent(new ComicBook("Incredible Hulk #182", 3000));
        comicDAO.addContent(new ComicBook("Uncanny X-Men #268", 40.00));
        comicDAO.addContent(new ComicBook("Fantastic Four #50", 1200));
        comicDAO.addContent(new ComicBook("Werewolf By Night #32", 2850.75));

}

//move sql to comicbookdao
    public static void outputDB() {
        ComicBookDao comicDAO = new ComicBookDao();
        comicDAO.outputDB();
    }
}
