/* ***************************************************************
 * Autora: Ricardo Rodrigues Neto
 * Matricula: 201710560
 * Inicio: 13/10/2018
 * Ultima alteracao: 29/10/2018
 * Nome: Problema do transito automato
 * Funcao: Simulacao do problema do transito automato fazendo uso de
 *   semaforos em java
 ************************************************************** */

package model;

import controller.ControladorTela;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Carro extends Thread{
  private ControladorTela c;
  private int id, velocidade;
  private ImageView imageView;
  public double posicaox, posicaoy, rotacao, xInicial, yInicial, rotacaoInicial;
  private int esquerda = 2, direita = 3, cima = 1, baixo = 0, y = 4, x = 5;

  public void run(){
    while(true){
      posicaoy = yInicial;
      posicaox = xInicial;
      rotacao = rotacaoInicial;
      try{
        percorreRua();
      }catch (Exception e) {}
    }
  }

  /* ***************************************************************
  * Metodo: percorreRua
  * Funcao: identifica o carro e chama a rota dele
  * Parametros: *sem parametros*
  * Retorno: *sem retorno*
  *************************************************************** */
  private void percorreRua() throws Exception{
    switch(id){
      case 0:
      //carro vermelho
        //parte 1
        percorreRua(35, baixo);
        percorreEsquina(baixo, baixo);
        percorreRua(35, baixo);
        c.s16.acquire();  //semaforo com o amarelo
        percorreEsquina(baixo, baixo);
        percorreRua(35, baixo);
        c.s7.acquire();  //semaforo com o azul
        percorreEsquina(baixo, direita);
        //parte 2
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        c.s16.release();
        percorreRua(35, direita);
        c.s3.acquire();  //semaforo com o rosa e azul
        percorreEsquina(direita, direita);
        c.s3.release();
        percorreRua(35, direita);
        c.s2.acquire();  //semaforo com verde e azul
        percorreEsquina(direita, direita);
        c.s2.release();
        percorreRua(35, direita);
        c.s19.acquire();  //semaforo com o amarelo
        percorreEsquina(direita, baixo);
        c.s7.release();
        //parte 3
        percorreRua(35, baixo);
        c.s17.acquire();  //semaforo com o amarelo
        percorreEsquina(baixo, esquerda);
        //parte 4
        percorreRua(35, esquerda);
        c.s11.acquire();  //semaforo com o verde
        percorreEsquina(esquerda, esquerda);  //semaforo com o verde
        c.s11.release();
        c.s19.release();
        percorreRua(35, esquerda);
        c.s9.acquire();  //semaforo com o rosa
        percorreEsquina(esquerda, esquerda);
        c.s9.release();
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        percorreRua(35, esquerda);
        c.s8.acquire();  //semaforo com o azul
        c.s17.release();
        percorreEsquina(esquerda, baixo);
        //parte 5
        percorreRua(35, baixo);
        percorreEsquina(baixo, direita);
        //parte 6
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        c.s10.acquire();  //semaforo com o rosa
        c.s18.acquire();  //semaforo com o amarelo
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        c.s12.acquire();  //semaforo com o verde
        percorreEsquina(direita, direita);
        c.s18.release();
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        percorreEsquina(direita, cima);
        //parte 7
        percorreRua(35, cima);
        percorreEsquina(cima, cima);
        percorreRua(35, cima);
        c.s19.acquire();  //semaforo com o amarelo
        percorreEsquina(cima, cima);
        c.s8.release();
        percorreRua(35, cima);
        percorreEsquina(cima, esquerda);
        //parte 8
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        c.s19.release();
        percorreRua(35, esquerda);
        c.s6.acquire();  //semaforo com o rosa
        percorreEsquina(esquerda, esquerda);
        c.s6.release();
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        c.s12.release();
        c.s10.release();
        percorreRua(35, esquerda);
        c.s15.acquire();
        c.s20.acquire();  //semaforo com o amarelo
        percorreEsquina(esquerda, cima);
        //parte 9
        percorreRua(35, cima);
        percorreEsquina(cima, direita);
        //parte 10
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        c.s20.release();
        percorreRua(35, direita);
        c.s15.release();  //semaforo com o amarelo
        c.s21.acquire();  //semaforo com o amarelo
        c.s13.acquire();  //semaforo com o verde
        percorreEsquina(direita, direita);
        c.s13.release();
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        c.s21.release();
        c.s14.acquire();  //semaforo com o verde
        percorreEsquina(direita, cima);
        //parte 11
        percorreRua(35, cima);
        percorreEsquina(cima, esquerda);
        //parte 12
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        percorreRua(35, esquerda);
        c.s22.acquire();
        percorreEsquina(esquerda, esquerda);
        c.s14.release();  //semaforo com o amarelo
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        c.s22.release();
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, baixo);
        break;
      case 1:
      //carro amarelo
        //parte 1
        percorreRua(35, baixo);
        c.s15.acquire();  //semaforo com o vermelho
        percorreEsquina(baixo, esquerda);
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, baixo);
        percorreRua(35, baixo);
        percorreEsquina(baixo, esquerda);
        percorreRua(35, esquerda);
        c.s15.release();
        c.s16.acquire();  //semaforo com o vermelho
        percorreEsquina(esquerda, baixo);
        percorreRua(35, baixo);
        //parte 2
        c.s28.acquire();  //semaforo com o azul
        percorreEsquina(baixo, direita);
        percorreRua(35, direita);
        percorreEsquina(direita, baixo);
        c.s16.release();
        c.s28.release();
        percorreRua(35, baixo);
        c.s17.acquire();  //semaforo com o vermelho
        percorreEsquina(baixo, direita);
        percorreRua(35, direita);
        c.s23.acquire();  //semaforo com o rosa
        percorreEsquina(direita, baixo);
        percorreRua(35, baixo);
        c.s18.acquire();  //semaforo com o vermelho
        c.s29.acquire();  //semaforo com o azul
        percorreEsquina(baixo, direita);
        c.s17.release();
        percorreRua(35, direita);
        //parte 3
        c.s25.acquire();  //semaforo com o verde
        percorreEsquina(direita, cima);
        c.s29.release();
        c.s18.release();
        c.s23.release();
        percorreRua(35, cima);
        c.s19.acquire();  //semaforo com o vermelho
        percorreEsquina(cima, direita);
        c.s25.release();
        percorreRua(35, direita);
        percorreEsquina(direita, cima);
        percorreRua(35, cima);
        c.s30.acquire();  //semaforo com o azul
        percorreEsquina(cima, direita);
        percorreRua(35, direita);
        c.s20.acquire();  //semaforo com o vermelho
        c.s24.acquire();  //semaforo com o rosa
        c.s26.acquire();  //semaforo com o verde
        percorreEsquina(direita, cima);
        c.s30.release();
        percorreRua(35, cima);
        //parte 4
        percorreEsquina(cima, esquerda);
        c.s26.release();
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, cima);
        c.s19.release();
        c.s24.release();
        c.s20.release();
        percorreRua(35, cima);
        c.s21.acquire();  //semaforo com o vermelho
        percorreEsquina(cima, esquerda);
        percorreRua(35, esquerda);
        c.s27.acquire();  //semaforo com o verde
        percorreEsquina(esquerda, cima);
        c.s21.release();
        percorreRua(35, cima);
        c.s22.acquire();  //semaforo com o vermelho
        percorreEsquina(cima, esquerda);
        c.s27.release();
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, baixo);
        c.s22.release();
        break;
      case 2:
      //carro rosa
        //parte 1
        percorreRua(35, baixo);
        c.s3.acquire();  //semaforo com o vermelho e azul
        percorreEsquina(baixo, baixo);
        c.s3.release();
        percorreRua(35, baixo);
        c.s23.acquire();  //semaforo com o amarelo
        c.s9.acquire();  //semaforo com o vermelho
        percorreEsquina(baixo, baixo);
        c.s9.release();
        percorreRua(30, baixo);
        c.s10.acquire();  //semaforo com o vermelho
        c.s4.acquire();  //semaforo com o azul
        percorreEsquina(baixo, direita);
        //parte 2
        percorreRua(35, direita);
        c.s5.acquire();  //semaforo com o verde
        percorreEsquina(direita, direita);
        c.s23.release();  //semaforo com o rosa
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        percorreEsquina(direita, cima);
        //parte 3
        percorreRua(30, cima);
        percorreEsquina(cima, cima);
        percorreRua(35, cima);
        c.s24.acquire();  //semaforo com o rosa
        percorreEsquina(cima, cima);
        percorreRua(35, cima);
        percorreEsquina(cima, esquerda);
        c.s5.release();
        c.s4.release();
        //parte 4
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        c.s24.release();
        percorreRua(35, esquerda);
        c.s6.acquire();  //semaforo com o vermelho
        percorreEsquina(esquerda, esquerda);
        c.s6.release();
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, baixo);
        c.s10.release();
        break;
      case 3:
      //carro azul
        //parte 1
        percorreRua(35, baixo);
        c.s8.acquire();  //semaforo com o vermelho
        percorreEsquina(baixo, baixo);
        percorreRua(35,baixo);
        percorreEsquina(baixo, direita);
        //parte 2
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        c.s4.acquire();  //semaforo com o rosa
        c.s29.acquire();  //semaforo com o amarelo
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        c.s1.acquire();  //semaforo com o verde
        percorreEsquina(direita, direita);
        c.s29.release();
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        percorreEsquina(direita, cima);
        //parte 3
        percorreRua(35, cima);
        percorreEsquina(cima, cima);
        percorreRua(35, cima);
        c.s30.acquire();  //semaforo com o amarelo
        c.s7.acquire();  //semaforo com o vermelho
        percorreEsquina(cima, esquerda);
        c.s1.release();
        c.s4.release();
        c.s8.release();
        //parte 4
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        c.s30.release();
        percorreRua(35, esquerda);
        c.s2.acquire();  //semaforo com o verde e vermelho
        percorreEsquina(esquerda, esquerda);
        c.s2.release();
        percorreRua(35, esquerda);
        c.s3.acquire();  //semaforo com o rosa e vermelho
        percorreEsquina(esquerda, esquerda);
        c.s3.release();
        percorreRua(35, esquerda);
        c.s28.acquire();  //semaforo com o amarelo
        percorreEsquina(esquerda, esquerda);
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, baixo);
        c.s28.release();
        c.s7.release();
        break;
      case 4:
      //carro verde
        //parte 4
        percorreRua(35, esquerda);
        percorreEsquina(esquerda, esquerda);
        percorreRua(35, esquerda);
        c.s27.acquire();  //semaforo com o amarelo
        percorreEsquina(esquerda, baixo);
        c.s14.release();
        //parte 1
        percorreRua(35, baixo);
        c.s13.acquire();  //semaforo com o vermelho
        percorreEsquina(baixo, baixo);
        c.s13.release();
        c.s27.release();
        percorreRua(35, baixo);
        c.s6.acquire();  //semaforo com o rosa e o vermelho
        percorreEsquina(baixo, baixo);
        c.s6.release();
        percorreRua(35, baixo);
        c.s2.acquire();  //semaforo com o azul e vermelho
        percorreEsquina(baixo, baixo);
        c.s2.release();
        percorreRua(35, baixo);
        c.s25.acquire();  //semaforo com o amarelo
        c.s11.acquire();  //semaforo com o vermelho
        percorreEsquina(baixo, baixo);
        c.s11.release();
        percorreRua(30, baixo);
        c.s12.acquire();  //semaforo com o vermelho
        c.s5.acquire();  //semaforo com o rosa
        c.s1.acquire();  //semaforo com o azul
        percorreEsquina(baixo, direita);
        c.s25.release();
        //parte 2
        percorreRua(35, direita);
        percorreEsquina(direita, direita);
        percorreRua(35, direita);
        percorreEsquina(direita, cima);
        //parte 3
        percorreRua(30, cima);
        percorreEsquina(cima, cima);
        percorreRua(35, cima);
        c.s26.acquire(); //semaforo com o amarelo
        percorreEsquina(cima, cima);
        c.s1.release();
        percorreRua(35, cima);
        percorreEsquina(cima, cima);
        c.s26.release();
        c.s5.release();
        percorreRua(35, cima);
        c.s14.acquire();  //semaforo com o vermelho
        percorreEsquina(cima, cima);
        percorreRua(35, cima);
        percorreEsquina(cima, esquerda);
        c.s12.release();
        break;
    }
  }

  /* ***************************************************************
  * Metodo: percorreRua
  * Funcao: faz a imagem do carro percorrer uma parte de rua
  * Parametros: numero de casas  e sentido que o carro andara
  * Retorno: *sem retorno*
  *************************************************************** */
  private void percorreRua(int numero, int sentido) throws Exception{
    for(int i = 0; i < numero; i++){
      switch(sentido){
        case 1:
          //cima
          rotacao = 0;
          posicaoy--;
          break;
        case 0:
          //baixo
          rotacao = 180;
          posicaoy++;
          break;
        case 2:
          //esquerda
          rotacao = -90;
          posicaox--;
          break;
        case 3:
          //direita
          rotacao = 90;
          posicaox++;
          break;
      }
      sleep(velocidade);
      Platform.runLater(() ->{
        imageView.setLayoutX(posicaox);
        imageView.setLayoutY(posicaoy);
        imageView.setRotate(rotacao);
      });
    }
  }

  /* ***************************************************************
  * Metodo: percorreEsquina
  * Funcao: faz a imagem do carro percorre uma esquina
  * Parametros: numero de casas  e sentido que o carro andara
  * Retorno: *sem retorno*
  *************************************************************** */
  private void percorreEsquina(int de, int para) throws Exception{
    if(de == para){
      percorreRua(80, de);
    }else{
      for(int i = 1; i <= 40; i++){
        if(de == baixo && para == esquerda){
          posicaox--;
          posicaoy += (42/40);
          rotacao += 2.25;
        }else if(de == baixo && para == direita){
          posicaox++;
          posicaoy += (42/40);
          rotacao += -2.25;
        }else if(de == cima && para == esquerda){
          posicaox--;
          posicaoy += -(42/40);
          rotacao += -2.25;
        }else if(de == cima && para == direita){
          posicaox++;
          posicaoy -= (42/40);
          rotacao += 2.25;
        }else if(de == esquerda && para == cima){
          posicaox--;
          posicaoy -= (42/40);
          rotacao += 2.25;
        }else if(de == esquerda && para == baixo){
          posicaox--;
          posicaoy += (42/40);
          rotacao += -2.25;
        }else if(de == direita && para == cima){
          posicaox++;
          posicaoy -= (42/40);
          rotacao += -2.25;
        }else if(de == direita && para == baixo){
          posicaox++;
          posicaoy += (42/40);
          rotacao += 2.25;
        }
        sleep(velocidade);
        Platform.runLater(() ->{
          imageView.setLayoutX(posicaox);
          imageView.setLayoutY(posicaoy);
          imageView.setRotate(rotacao);
        });
      }
    }
  }

  /* ***************************************************************
  * Metodo: setControlador
  * Funcao: muda o valor da variavel c
  * Parametros: ControladorTela
  * Retorno: *sem retorno*
  *************************************************************** */
  public void setControlador(ControladorTela c){
    this.c = c;
  }

  /* ***************************************************************
  * Metodo: setId
  * Funcao: muda o valor do id
  * Parametros: inteiro id
  * Retorno: *sem retorno*
  *************************************************************** */
  public void setId(int id){
    this.id = id;
  }

  /* ***************************************************************
  * Metodo: getid
  * Funcao: retorna o id
  * Parametros: *sem parametros*
  * Retorno: inteiro id
  *************************************************************** */
  public int getid(){
    return id;
  }

  /* ***************************************************************
  * Metodo: setImageView
  * Funcao: muda o valor da variavel imageview
  * Parametros: ImageView que sobrescrevera a atual
  * Retorno: *sem retorno*
  *************************************************************** */
  public void setImageView(ImageView imageView){
    this.imageView = imageView;
  }

  /* ***************************************************************
  * Metodo: getImageView
  * Funcao: retorna a variavel imageView
  * Parametros: *sem parametros*
  * Retorno: imageView
  *************************************************************** */
  public ImageView getImageView(){
    return imageView;
  }

  /* ***************************************************************
  * Metodo: setVelocidade
  * Funcao: faz o calculo de invercao de valor e suspende a thread
  *   se o valor for velocidade for 0
  * Parametros: inteiro velocidade
  * Retorno: *sem retorno*
  *************************************************************** */
  public void setVelocidade(int velocidade) throws Exception{
    if(velocidade == 0){
      suspend();
    }else{
      resume();
    }
    this.velocidade = 28 - (5 * velocidade);
  }

  /* ***************************************************************
  * Metodo: getVelocidade
  * Funcao: retorna a variavel velocidade
  * Parametros: *sem parametros*
  * Retorno: inteiro velocidade
  *************************************************************** */
  public int getVelocidade(){
    return velocidade;
  }
}