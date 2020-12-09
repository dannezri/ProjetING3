public class ClientBusiness extends Personne {

    private String nomEntreprise;

    public ClientBusiness(String nom,String prenom,String nomEntreprise)
    {
        super(nom,prenom);
        this.nomEntreprise=nomEntreprise;
    }
}