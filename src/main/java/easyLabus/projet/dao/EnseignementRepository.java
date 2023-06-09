package easyLabus.projet.dao;

import easyLabus.projet.entity.Enseignement;
import easyLabus.projet.dto.EnseignementSimple;
import easyLabus.projet.dto.FausseFicheENSSimple;
import easyLabus.projet.dto.IntervenantENSSimple;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnseignementRepository extends JpaRepository<Enseignement, String> {
    @Query( "SELECT ens.codeens as codeens, ens.nomens as nomens, ens.heurecm as heurecm, ens.heuretd as heuretd, ens.heuretp as heuretp, ens.heuretotalencadree as heuretotalencadree, ens.heuretravailperso as heuretravailperso, ens.coefficient as coefficient, ens.modalitesevaluation as modalitesevaluation, ens.prerequis as prerequis, ens.planducours as planducours, ens.contenu as contenu "
          +"FROM Enseignement ens "
          +"WHERE ens.ue.codeue = :codue ")
    public List<EnseignementSimple> getByUe(String codue);

    @Query(
           "SELECT ens.codeens as codeens, ens.nomens as nomens, ens.heurecm as heurecm, ens.heuretd as heuretd, ens.heuretp as heuretp, ens.heuretotalencadree as heuretotalencadree, ens.heuretravailperso as heuretravailperso, ens.coefficient as coefficient, ens.modalitesevaluation as modalitesevaluation, ens.prerequis as prerequis, ens.planducours as planducours, ens.ue.codeue as codeue, ens.ue.intituleue as intituleue, ens.ue.semestre.numsemestre as numsemestre "
          +"FROM Enseignement ens "
          +"WHERE ens.codeens = :code ")
    public FausseFicheENSSimple getFicheActu(String code);

    // NE MARCHE PEUT ETRE PAS //
    @Query(nativeQuery = true, value =
           "SELECT pers.prenompers as prenompers, pers.nompers as nompers, pers.numtel as numtel, pers.identifiant as identifiant, pers.email as email, pers.coordprivee as coordprivee "
          +"FROM enseigner er INNER JOIN Personneinterne pers ON er.identifiant = pers.identifiant "+
                   "INNER JOIN Enseignement ens ON er.codeens=ens.codeens "
          +"WHERE ens.codeens = :code ")
    public List<IntervenantENSSimple> getIntervenants(String code);
}
