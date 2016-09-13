package pl.java.scalatech.domain;

import lombok.Getter;

public enum InvoiceType {
    NO_SELECTED("invoice.type.noSelected"),BUSINESS("invoice.type.business") , CUSTOMER("invoice.type.customer");

    @Getter
    private String name;

    private InvoiceType(String name) {
        this.name = name;

    }
}
