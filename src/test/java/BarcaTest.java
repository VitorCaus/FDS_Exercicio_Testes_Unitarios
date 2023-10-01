import org.junit.jupiter.api.Assertions; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

import com.ex_teste_unitario.Barca; 

public class BarcaTest {
    private Barca barca = null;

    @BeforeEach
    void setUp(){
        barca = new Barca();
    }

    @Test 
    public void testePartValido100Primeiros(){
        String assento = "F14A07";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);
    }


    @Test 
    public void testePartBlockPeso100Primeiros(){
        String assento = "F44A15";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);
    }


    @Test 
    public void testePartValido100Proximos(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F50A03";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);
    }


    @Test 
    public void testePartBlockPeso100Proximos(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=4; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F30A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);
    }


    @Test 
    public void testePartValidoPesoEquilibrado(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        for(int i = 40; i<60; i++){//ocupando 100 assentos no fim
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F29A13";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);
    }

    @Test 
    public void testePartLugarJaOcupado(){
        
        String assento = "F10A10 ";
        barca.ocupaLugarSemVerificacao(10, 10);
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(1, retorno);
    }


    @Test 
    public void testePartFilaNula(){
        String assento = "F00A11 ";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }


    @Test 
    public void testePartAssentoNulo(){
        String assento = "F19A00 ";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }


    @Test 
    public void testePartFila1Digito(){
        String assento = "F3A05 ";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }


    @Test 
    public void testePartAssento1Digito(){
        String assento = "F12A9 ";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }


    @Test 
    public void testePartFilaAcimaLimite(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F80A10 ";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }


    @Test 
    public void testePartAssentoAcimaLimite(){
        String assento = "F16A31 ";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

/*
 * 
 *  TESTES VALOR LIMITE
 * 
 */
    @Test
    public void testeVLFilaNula(){
        String assento = "F00A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

    @Test
    public void testeVLFilaValida(){
        String assento = "F01A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);

    }

    @Test
    public void testeVLAssentoOcupado(){
        String assento = "F10A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(1, retorno);

    }

    @Test
    public void testeVLFilaNegativa(){
        String assento = "F-5A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }

    @Test
    public void testeVLFilaValidaLimite20(){
        String assento = "F20A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);

    }

    @Test
    public void testeVLBlockPeso100PrimeirosOffP(){
        for(int i = 1; i<=20; i++){//ocupando 80 assentos no inicio
            for(int j = 1; j <=4; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F21A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);

    }

    @Test
    public void testeVLBlockPeso100PrimeirosOutP(){
        for(int i = 1; i<=20; i++){//ocupando 80 assentos no inicio
            for(int j = 1; j <=4; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F30A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);

    }

    @Test
    public void testeVLValido200Primeiros(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F60A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);

    }

    @Test
    public void testeVLFilaAcima60OffP(){
        String assento = "F61A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }


    @Test
    public void testeVLFilaAcima60OutP(){
        String assento = "F70A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }

    @Test
    public void testeVLAssentoNulo(){
        String assento = "F08A00";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }

    @Test
    public void testeVLBlockPeso200Primeiros(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F09A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);

    }


    @Test
    public void testeVLAssentoNegativo(){
        String assento = "F14A-1";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }

    @Test
    public void testeVLOcupadoDemaisPass(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }

        for(int i = 40; i<60; i++){//ocupando 100 assentos no fim
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        barca.ocupaLugarSemVerificacao(45, 20);

        String assento = "F45A20";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(1, retorno);

    }

    @Test
    public void testeVLAssentoAcima20OffP(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F50A21";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }

    @Test
    public void testeVLAssentoAcima20OutP(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }
        String assento = "F55A25";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);

    }
    
}
