public class Employee extends Personne {

    int id_emp;

    public Employee(String nom,String prenom, int id){
        super(nom,prenom);
        this.id_emp = id;

    }
}