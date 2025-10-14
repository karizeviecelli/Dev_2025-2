package com.Task_springboot.dtos;

public class MensagemDTO {

    private String msg;

    public MensagemDTO() {
    }

    public MensagemDTO(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
