package com.yomna.miniprojetevenement.entities;


import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvenement;

    @NotBlank(message = "Le nom de l'événement est obligatoire")
    @Size(min = 2, max = 100, message = "Le nom doit contenir entre 2 et 100 caractères")
    private String nomEvenement;

    @NotBlank(message = "Le lieu est obligatoire")
    private String lieu;

    @NotNull(message = "La date est obligatoire")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEvenement;

    @NotBlank(message = "L'organisateur est obligatoire")
    private String organisateur;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String email;

    @ManyToOne(optional = true)
    private Genre genre;

    public Evenement() { super(); }

    public Evenement(String nomEvenement, String lieu, Date dateEvenement, String organisateur, String email) {
        this.nomEvenement = nomEvenement;
        this.lieu = lieu;
        this.dateEvenement = dateEvenement;
        this.organisateur = organisateur;
        this.email = email;
    }

    public Long getIdEvenement() { return idEvenement; }
    public void setIdEvenement(Long idEvenement) { this.idEvenement = idEvenement; }
    public String getNomEvenement() { return nomEvenement; }
    public void setNomEvenement(String nomEvenement) { this.nomEvenement = nomEvenement; }
    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }
    public Date getDateEvenement() { return dateEvenement; }
    public void setDateEvenement(Date dateEvenement) { this.dateEvenement = dateEvenement; }
    public String getOrganisateur() { return organisateur; }
    public void setOrganisateur(String organisateur) { this.organisateur = organisateur; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Evenement [idEvenement=" + idEvenement + ", nomEvenement=" + nomEvenement +
                ", lieu=" + lieu + ", dateEvenement=" + dateEvenement +
                ", organisateur=" + organisateur + ", email=" + email + "]";
    }
}