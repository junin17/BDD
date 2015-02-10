/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step;

import com.mycompany.caixaeletronico.Cliente;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

/**
 *
 * @author Junin
 */
public class SaqueDeClienteComumComSaldoNegativo extends Steps {

    private Cliente cliente;

    private boolean saqueEfetuado = false;

    private Exception exception;

    public SaqueDeClienteComumComSaldoNegativo() {
    }

    @Given("um cliente comum com saldo atual de $saldoAtual reais")
    public void popularCliente(Double saldoAtual) {
        cliente = new Cliente();
        cliente.setSaldoAtual(saldoAtual);
        cliente.clienteComum();
    }

    @When("solicitar um saque de $valorDoSaque reais")
    public void sacar(Double valorDoSaque) {
        try {
            cliente.sacar(valorDoSaque);
        } catch (Exception ex) {
            this.exception = ex;
        }
    }

    @Then("não deve efetuar o saque e retornar a mensagem $msg")
    public void verificaOSaldo(String msg) {
        assertFalse(saqueEfetuado);
        assertEquals(msg, exception.getMessage());
    }

}
