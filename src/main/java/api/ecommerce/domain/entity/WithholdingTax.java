package api.ecommerce.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class WithholdingTax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // IRT, II, IS, IVA, IP, IAC, OU, IRPC, IRPS...
    private Double tax; // 6.5
    private String description;
    private BigDecimal amount;
    @ManyToOne
    private Invoice invoice;
}

// IRT - Imposto Sobre os Rendimentos do Trabalho;

// II - Imposto Industrial;

// IS - Imposto de Selo;

// IVA - Imposto s/ o Valor Acrescentado;

// IP - Imposto Predial;

// IAC - Imposto sobre Aplicação de Capitais;

// OU - Outros;

// IRPC - Imposto s/ rendimento de pessoas colectivas (impostos futuros);

// IRPS - Imposto s/ rendimento de pessoas singulares (impostos futuros).