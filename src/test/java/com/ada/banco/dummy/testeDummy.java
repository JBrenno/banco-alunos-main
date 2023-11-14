package com.ada.banco.dummy;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;

import java.math.BigDecimal;

public class testeDummy implements ContaGateway {


    @Override
    public Conta buscarPorCpf(String cpf) {
        if(cpf.equals("123456789")){
            return new Conta (12345L, 0002L, 1L, BigDecimal.valueOf(100), "Brenno", "123456789");
        }
        return null;
    }

    @Override
    public Conta salvar(Conta conta) {
        return new Conta(123L, 0002L, 1L, BigDecimal.valueOf(100), "Caio", "1234");
    }

}
