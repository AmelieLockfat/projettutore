package easyLabus.projet.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Enseignement {
    @Id
    @Column(name = "codeens")
    private String codeens;
    @Basic
    @Column(name = "nomens", nullable = false)
    private String nomens;
    @Basic
    @Column(name = "heurecm", nullable = false)
    private Double heurecm = 0.0;
    @Basic
    @Column(name = "heuretd", nullable = false)
    private Double heuretd = 0.0;
    @Basic
    @Column(name = "heuretp", nullable = false)
    private Double heuretp = 0.0;
    @Basic
    @Column(name = "heuretotalencadree", nullable = false)
    private Double heuretotalencadree = 0.0;
    
    @ManyToMany(mappedBy = "enseignements")
    private List<Personneinterne> personnesinternes = new ArrayList<Personneinterne>();

    @Basic
    @Column(name = "codeue", insertable = false,updatable = false, nullable = false)
    private String codeue;

    @ManyToOne
    @JoinColumn (name ="codeue", referencedColumnName = "codeue",nullable = false)
    private Ue ue;

    @Basic
    @Column(name = "heuretravailperso", nullable = true)
    private Double heuretravailperso;
    @Basic
    @Column(name = "coefficient", nullable = true)
    private Double coefficient;
    @Basic
    @Column(name = "modalitesevaluation", nullable = true)
    private String modalitesevaluation;
    @Basic
    @Column(name = "prerequis", nullable = true)
    private String prerequis;
    @Basic
    @Column(name = "planducours", nullable = true)
    private String planducours;

    @Basic
    @Column(name="contenu",nullable = true)
    private String contenu;

    public Enseignement (String codeens, String nomens, String codeue){
        this.codeens = codeens;
        this.nomens = nomens;
        this.codeue=codeue;
    }
    
    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp){
        this.codeens = codeens;
        this.nomens = nomens;
        this.heurecm = heurecm;
        this.heuretd = heuretd;
        this.heuretp = heuretp;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
        this.codeue=codeue;
    }

    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp, String contenu){
        this(codeens, nomens, codeue, heurecm, heuretd, heuretp);
        this.contenu = contenu;
    }

    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso){
        this(codeens, nomens, codeue, heurecm, heuretd, heuretp, contenu);
        this.heuretravailperso = heuretravailperso;
    }

    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient){
        this(codeens, nomens, codeue, heurecm, heuretd, heuretp, contenu, heuretravailperso);
        this.coefficient = coefficient;
    }

    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation){
        this(codeens, nomens, codeue, heurecm, heuretd, heuretp, contenu, heuretravailperso, coefficient);
        this.modalitesevaluation = modalitesevaluation;
    }

    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis){
        this(codeens, nomens, codeue, heurecm, heuretd, heuretp, contenu, heuretravailperso, coefficient, modalitesevaluation);
        this.prerequis = prerequis;
    }

    public Enseignement (String codeens, String nomens, String codeue, Double heurecm, Double heuretd, Double heuretp, String contenu, Double heuretravailperso, Double coefficient, String modalitesevaluation, String prerequis, String planducours){
        this(codeens, nomens, codeue, heurecm, heuretd, heuretp, contenu, heuretravailperso, coefficient, modalitesevaluation, prerequis);
        this.planducours = planducours;
    }

    public Enseignement() {

    }

    public String getCodeens() {
        return codeens;
    }

    public String getNomens() {
        return nomens;
    }

    public void setNomens(String nomens) {
        this.nomens = nomens;
    }

    public String getCodeue(){
        return codeue;
    }

    public Ue getUe() {
        return ue;
    }

    public void setCodeue(String codeue) {
        this.codeue = codeue;
    }

    public Double getHeurecm() {
        return heurecm;
    }

    public void setHeurecm(Double heurecm) {
        this.heurecm = heurecm;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
    }

    public Double getHeuretd() {
        return heuretd;
    }

    public void setHeuretd(Double heuretd) {
        this.heuretd = heuretd;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
    }

    public Double getHeuretp() {
        return heuretp;
    }

    public void setHeuretp(Double heuretp) {
        this.heuretp = heuretp;
        this.heuretotalencadree = heurecm + heuretd + heuretp;
    }

    public Double getHeuretotalencadree() {
        return heuretotalencadree;
    }
    
    public Double getHeuretravailperso() {
        return heuretravailperso;
    }

    public void setHeuretravailperso(Double heuretravailperso) {
        this.heuretravailperso = heuretravailperso;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getModalitesevaluation() {
        return modalitesevaluation;
    }

    public void setModalitesevaluation(String modalitesevaluation) {
        this.modalitesevaluation = modalitesevaluation;
    }

    public String getPrerequis() {
        return prerequis;
    }

    public void setPrerequis(String prerequis) {
        this.prerequis = prerequis;
    }

    public String getPlanducours() {
        return planducours;
    }

    public void setPlanducours(String planducours) {
        this.planducours = planducours;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public List<Personneinterne> getPersonnesinternes() {
        return personnesinternes;
    }

    public boolean equals(Enseignement enseignement) {
        return this.codeens.equals(enseignement.getCodeens());
    }
}
