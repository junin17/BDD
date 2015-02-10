
import org.jbehave.scenario.Scenario;
import step.SaqueDeClienteComumComSaldoNegativo;

public class CaixaEletronicoTest extends Scenario {
    //Construtor

    public CaixaEletronicoTest() {
    //Cria Steps que irão executaros cenários do arquivo texto.
        //addSteps(new SaqueDeClienteEspecialComSaldoNegativo());
        addSteps(new SaqueDeClienteComumComSaldoNegativo());
    }
}
