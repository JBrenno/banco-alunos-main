package com.ada.banco.doman.usecase;

import com.ada.banco.domain.gateway.ContaGateway;
import com.ada.banco.domain.model.Conta;
import com.ada.banco.domain.usecase.CriarNovaConta;
import com.ada.banco.dummy.testeDummy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;

public class CriarNovaContaTest {

    @Test
    public void deveLancarExptionCasoContaExista(){
        ContaGateway contaGateway = new testeDummy();
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);

        Conta conta= new Conta(12345L, 0002L, 1L, BigDecimal.valueOf(100), "Brenno", "123456789");


        Throwable throwable = Assertions.assertThrows(
                Exception.class,
                () -> criarNovaConta.execute(conta)
        );
        Assertions.assertEquals("Usuario já cadastrado", throwable.getMessage());
    }

    @Test
    public void deveCriarNovaConta() throws Exception {
        ContaGateway contaGateway = new testeDummy();
        CriarNovaConta criarNovaConta = new CriarNovaConta(contaGateway);

        Conta conta= new Conta(123L, 0002L, 1L, BigDecimal.valueOf(100), "Caio", "1234");

        Conta novaConta = criarNovaConta.execute(conta);

        Assertions.assertAll(
                () -> Assertions.assertEquals(123L, novaConta.getId()),
                () -> Assertions.assertEquals("Caio", novaConta.getTitular())
        );
    }

}
