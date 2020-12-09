package Session;

public class Session {
    public static int id;
    public static String nom;
    public static String premon;
    public static String typeUser;

    public Session(int id, String nom, String prenom, String typeUser)
    {
        this.id = id;
        this.nom = nom;
        this.premon = prenom;
        this.typeUser = typeUser;
    }

}
