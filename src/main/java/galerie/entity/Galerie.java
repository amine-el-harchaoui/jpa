package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    // TODO : Mettre en oeuvre la relation oneToMany vers Exposition

    @OneToMany (mappedBy = "organisateur")
    List<Exposition> listeEvenements = new LinkedList<>();

    public float CA(int annee) {
        float ca = 0f;
        for (int i=0;i<listeEvenements.size();i++) {
            if (listeEvenements.get(i).getDebut().isAfter(LocalDate.of(annee,1,1)) && listeEvenements.get(i).getDebut().isBefore(LocalDate.of(annee,12,31))) {
                ca += listeEvenements.get(i).CA();
            }
        }
        return ca;
    }
}
