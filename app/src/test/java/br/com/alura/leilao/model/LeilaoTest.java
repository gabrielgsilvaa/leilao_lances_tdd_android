package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario USUARIO_ALEX = new Usuario("Alex");

    /**
     *  Templates de métodos
     *  [Nome do Metodo]_[Estado de Teste]_[Resultado Esperado]     -   getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemCrescente_DevolveMaiorLance
     *  [deve]_[resultado esperado]_[estado de teste]               -   deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente
     *
     *  1. criar cenário de teste
     *  2. executar ação esperada
     *  3. testar resultado esperado
     */

    @Test
    public void deve_DevolverDescricao_QuandoRecebeDescricao() {

        String descricaoDevolvida = CONSOLE.getDescricao();

        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeApenasUmLance(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 500.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(500.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 300.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 100.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(300.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeApenasUmLance(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 500.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 300.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 100.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);

    }

    // Aplicando Test Driven Development - TDD
    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){

        CONSOLE.propoe(new Lance(USUARIO_ALEX, 200.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"), 300.0));
        CONSOLE.propoe(new Lance(USUARIO_ALEX, 400.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLancesDevolvidos();

        assertEquals(3, tresMaioresLancesDevolvidos.size());

        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }



}