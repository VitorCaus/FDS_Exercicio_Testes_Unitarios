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
    public void testeFilaUmDIgito(){
        String assento = "F2A03";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }
    
    @Test
    public void testeAssentoUmDIgito(){
        String assento = "F32A3";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

    @Test
    public void testeFilaNula(){
        String assento = "F00A03";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

    @Test
    public void testeAssentoNulo(){
        String assento = "F50A00";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

    @Test
    public void testeFilaMaior60(){
        String assento = "F75A14";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

    @Test
    public void testeAssentoMaior20(){
        String assento = "F25A21";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(0, retorno);
    }

    @Test
    public void testeOcuparJaOcupado(){
        String assento = "F25A02";
        barca.ocupaLugarSemVerificacao(25, 2);
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(1, retorno);
    }

    @Test
    public void testePesoPrimeiros100(){
        for(int i = 1; i<=20; i++){//ocupando 80 assentos no inicio
            for(int j = 1; j <=4; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }

        String assento = "F40A19";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);
    }

    @Test
    public void testePesoPrimeiros200(){
        for(int i = 1; i<=20; i++){//ocupando 100 assentos no inicio
            for(int j = 1; j <=5; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }

        for(int i = 40; i<60; i++){//ocupando 80 assentos no fim
            for(int j = 1; j <=4; j++){
                barca.ocupaLugarSemVerificacao(i, j);
            }
        }

        String assento = "F30A10";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(2, retorno);
    }

    @Test
    public void testePesoJaDistribuido(){
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

        String assento = "F30A13";
        int retorno = barca.ocupaLugar(assento);
        Assertions.assertEquals(3, retorno);
    }
}
