package com.senai.demo.entities;

public enum Status {
    ABERTO(1),
    PENDENTE(2),
    CONCLUIDO(2),
    CANCELADO(2);

    private Integer status;

    Status(Integer status){
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public static Status fromStatus(Integer status){
        for(Status s : values()){
            if (s.getStatus() == status) return s;
        }
        throw new IllegalArgumentException("Código de status inválido: " + status);
    }
}
