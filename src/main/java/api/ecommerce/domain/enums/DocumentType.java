
package api.ecommerce.domain.enums;

import java.util.Arrays;

public enum DocumentType {

    FA, FT, FR, FG, GF,
    AC, AR, TV, RC, RG,
    RE, ND, NC, AF, RP,
    RA, CS, LD;

    public static boolean isValid(String value) {
        return Arrays.stream(values())
                .anyMatch(v -> v.name().equals(value));
    }
}
// FA - Factura de Adiantamento

// FT - Factura

// FR - Factura/Recibo

// FG - Factura Global

// GF - Factura Genérica

// AC - Aviso de Cobrança

// AR - Aviso de Cobrança/Recibo

// TV - Talão de Venda

// RC - Recibo Emitido

// RG - Recibo

// RE - Estorno ou Recibo de Estorno

// ND - Nota de Débito

// NC - Nota de Crédito

// AF - Factura/Recibo de Autofacturação

// RP - Prémio ou Recibo de Prémio

// RA - Resseguro Aceite

// CS - Imputação a Co-seguradoras

// LD - Imputação a Co-seguradora Líder