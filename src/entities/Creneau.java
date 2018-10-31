package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "creneaux")
public class Creneau implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCreneau")
    private Integer idCreneau;
    
    @NotNull(message = "This field is required")
    @Column(name = "date_creneau")
    @Temporal(TemporalType.DATE)
    private Date dateCreneau;

    @NotNull(message = "This field is required")
    @Column(name = "8_10")
    private boolean s1 = true;

    @NotNull(message = "This field is required")
    @Column(name = "11_13")
    private boolean s2 = true;

    @NotNull(message = "This field is required")
    @Column(name = "14_16")
    private boolean s3 = true;

    @NotNull(message = "This field is required")
    @Column(name = "17_19")
    private boolean s4 = true;

    @NotNull(message = "This field is required")
    @Column(name = "20_22")
    private boolean s5 = true;
    
    @ManyToOne
    @JoinColumn( name = "idPsycologue")
    private Psychologue psychologue;
    
    public Creneau() {}

    /**
     * @return the idCreneau
     */
    public Integer getIdCreneau() {
        return idCreneau;
    }

    /**
     * @param idCreneau the idCreneau to set
     */
    public void setIdCreneau(Integer idCreneau) {
        this.idCreneau = idCreneau;
    }

    /**
     * @return the dateCreneau
     */
    public Date getDateCreneau() {
        return dateCreneau;
    }

    /**
     * @param dateCreneau the dateCreneau to set
     */
    public void setDateCreneau(Date dateCreneau) {
        this.dateCreneau = dateCreneau;
    }

    /**
     * @return the s1
     */
    public boolean isS1() {
        return s1;
    }

    /**
     * @param s1 the s1 to set
     */
    public void setS1(boolean s1) {
        this.s1 = s1;
    }

    /**
     * @return the s2
     */
    public boolean isS2() {
        return s2;
    }

    /**
     * @param s2 the s2 to set
     */
    public void setS2(boolean s2) {
        this.s2 = s2;
    }

    /**
     * @return the s3
     */
    public boolean isS3() {
        return s3;
    }

    /**
     * @param s3 the s3 to set
     */
    public void setS3(boolean s3) {
        this.s3 = s3;
    }

    /**
     * @return the s4
     */
    public boolean isS4() {
        return s4;
    }

    /**
     * @param s4 the s4 to set
     */
    public void setS4(boolean s4) {
        this.s4 = s4;
    }

    /**
     * @return the s5
     */
    public boolean isS5() {
        return s5;
    }

    /**
     * @param s5 the s5 to set
     */
    public void setS5(boolean s5) {
        this.s5 = s5;
    }

    /**
     * @return the psychologue
     */
    public Psychologue getPsychologue() {
        return psychologue;
    }

    /**
     * @param psychologue the psychologue to set
     */
    public void setPsychologue(Psychologue psychologue) {
        this.psychologue = psychologue;
    }
    
    
}
