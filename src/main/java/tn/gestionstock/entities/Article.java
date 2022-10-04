package tn.gestionstock.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name="article")
public class Article extends AbsrtactEntity{
private String codeArticle;
private String designation;
private BigDecimal prixUnitaireHt;
private BigDecimal tauxTva;
private BigDecimal prixUnitaireTtc;
private String photo;
private Integer idEntreprise;
@ManyToOne
@JoinColumn(name="idcategory")
private Category category;
}
