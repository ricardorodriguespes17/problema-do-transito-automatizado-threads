/* ***************************************************************
 * Autora: Ricardo Rodrigues Neto
 * Matricula: 201710560
 * Inicio: 13/10/2018
 * Ultima alteracao: 29/10/2018
 * Nome: Problema do transito automato
 * Funcao: Simulacao do problema do transito automato fazendo uso de
 *   semaforos em java
 ************************************************************** */

package controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import model.Carro;

public class ControladorTela implements Initializable{
  //Spinner de velodidade para cada carro
  @FXML public Spinner<Integer> velocidade0, velocidade1, velocidade2, velocidade3, velocidade4;
  //ImageView para cada carro e ImageView para fundo da tela
  @FXML public ImageView imagemCarro0, imagemCarro1, imagemCarro2, imagemCarro3, imagemCarro4, fundo;
  //5 threads para cada carro
  public Carro carro0, carro1, carro2, carro3, carro4;
  //inteiro identificador usado como ids para os carros
  //inteiro estado para saber se tem trajeto sendo mostrado na tela ou nao
  private int identificador = 0, estado0 = 0, estado1 = 0, estado2 = 0, estado3 = 0, estado4 = 0;
  //30 semaforo para fazer o controle das regioes criticas
  public Semaphore s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15;
  public Semaphore s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28,s29, s30;
  
  public ControladorTela(){
    //inicializacao das variaveis da classe
    s1 = new Semaphore(1);
    s2 = new Semaphore(1);
    s3 = new Semaphore(1);
    s4 = new Semaphore(1);
    s5 = new Semaphore(1);
    s6 = new Semaphore(1);
    s7 = new Semaphore(1);
    s8 = new Semaphore(1);
    s9 = new Semaphore(1);
    s10 = new Semaphore(1);
    s11 = new Semaphore(1);
    s12 = new Semaphore(1);
    s13 = new Semaphore(1);
    s14 = new Semaphore(1);
    s15 = new Semaphore(1);
    s16 = new Semaphore(1);
    s17 = new Semaphore(1);
    s18 = new Semaphore(1);
    s19 = new Semaphore(1);
    s20 = new Semaphore(1);
    s21 = new Semaphore(1);
    s22 = new Semaphore(1);
    s23 = new Semaphore(1);
    s24 = new Semaphore(1);
    s25 = new Semaphore(1);
    s26 = new Semaphore(1);
    s27 = new Semaphore(1);
    s28 = new Semaphore(1);
    s29 = new Semaphore(1);
    s30 = new Semaphore(1);
    carro0 = new Carro();
    carro1 = new Carro();
    carro2 = new Carro();
    carro3 = new Carro();
    carro4 = new Carro();
    velocidade0 = new Spinner<>();
    velocidade1 = new Spinner<>();
    velocidade2 = new Spinner<>();
    velocidade3 = new Spinner<>();
    velocidade4 = new Spinner<>();
    imagemCarro0 = new ImageView();
    imagemCarro1 = new ImageView();
    imagemCarro2 = new ImageView();
    imagemCarro3 = new ImageView();
    imagemCarro4 = new ImageView();
    fundo = new ImageView();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb){
    //inicializando as thread
    inicializarCarro(carro0);
    inicializarCarro(carro1);
    inicializarCarro(carro2);
    inicializarCarro(carro3);
    inicializarCarro(carro4);
    try{
      //atualizar velocidade de acordo com os spinners
      atualizarVelocidade();
    }catch(Exception e){}
  }

  @FXML
  public void atualizarVelocidade() throws Exception{
    //atualiza velocidade dos carros de acordo com os spinners
    carro0.setVelocidade((int) velocidade0.getValue());
    carro1.setVelocidade((int) velocidade1.getValue());
    carro2.setVelocidade((int) velocidade2.getValue());
    carro3.setVelocidade((int) velocidade3.getValue());
    carro4.setVelocidade((int) velocidade4.getValue());
  }

  /* ***************************************************************
  * Metodo: mostrarFundoVermelho
  * Funcao: mostra trajeto do carro vermelho no fundo
  * Parametros: *sem parametros*
  * Retorno: *sem retorno*
  *************************************************************** */
  @FXML 
  public void mostrarFundoVermelho(){
    if(estado0 % 2 == 0){
      fundo.setImage(new Image("imagens/fundo_vermelho.png"));
    }else{
      fundo.setImage(new Image("imagens/fundo.png"));
    }
    estado0++;
    estado1 = 0;
    estado2 = 0;
    estado3 = 0;
    estado4 = 0;
  }

  /* ***************************************************************
  * Metodo: mostrarFundoAmarelo
  * Funcao: mostra trajeto do carro amarelo no fundo
  * Parametros: *sem parametros*
  * Retorno: *sem retorno*
  *************************************************************** */
  @FXML 
  public void mostrarFundoAmarelo(){
    if(estado1 % 2 == 0){
      fundo.setImage(new Image("imagens/fundo_amarelo.png"));
    }else{
      fundo.setImage(new Image("imagens/fundo.png"));
    }
    estado1++;
    estado0 = 0;
    estado2 = 0;
    estado3 = 0;
    estado4 = 0;
  }

  /* ***************************************************************
  * Metodo: mostrarFundoRosa
  * Funcao: mostra trajeto do carro rosa no fundo
  * Parametros: *sem parametros*
  * Retorno: *sem retorno*
  *************************************************************** */
  @FXML 
  public void mostrarFundoRosa(){
    if(estado2 % 2 == 0){
      fundo.setImage(new Image("imagens/fundo_rosa.png"));
    }else{
      fundo.setImage(new Image("imagens/fundo.png"));
    }
    estado2++;
    estado1 = 0;
    estado0 = 0;
    estado3 = 0;
    estado4 = 0;
  }

  /* ***************************************************************
  * Metodo: mostrarFundoAzul
  * Funcao: mostra trajeto do carro azul no fundo
  * Parametros: *sem parametros*
  * Retorno: *sem retorno*
  *************************************************************** */
  @FXML 
  public void mostrarFundoAzul(){
    if(estado3 % 2 == 0){
      fundo.setImage(new Image("imagens/fundo_azul.png"));
    }else{
      fundo.setImage(new Image("imagens/fundo.png"));
    }
    estado3++;
    estado1 = 0;
    estado2 = 0;
    estado0 = 0;
    estado4 = 0;
  }

  /* ***************************************************************
  * Metodo: mostrarFundoVerde
  * Funcao: mostra trajeto do carro verde no fundo
  * Parametros: *sem parametros*
  * Retorno: *sem retorno*
  *************************************************************** */
  @FXML 
  public void mostrarFundoVerde(){
    if(estado4 % 2 == 0){
      fundo.setImage(new Image("imagens/fundo_verde.png"));
    }else{
      fundo.setImage(new Image("imagens/fundo.png"));
    }
    estado4++;
    estado1 = 0;
    estado2 = 0;
    estado3 = 0;
    estado0 = 0;
  }

  /* ***************************************************************
  * Metodo: inicializarCarro
  * Funcao: inicializa a thread do carro
  * Parametros: a thread tipo Carro que sera inicializada
  * Retorno: *sem retorno*
  *************************************************************** */
  public void inicializarCarro(Carro c){
    //passa o controlador para a thread
    c.setControlador(this);
    //habilita o modo de encerramento da thread quando fecha a tela
    c.setDaemon(true);
    //muda o id
    c.setId(identificador);
    //escolhe imagem para
    switch(identificador){
      case 0:
        //carro vermelho
        c.setImageView(imagemCarro0);
        c.xInicial = 0;
        c.yInicial = 25;
        c.rotacaoInicial = 180;
        break;
      case 1:
        //carro amarelo
        c.setImageView(imagemCarro1);
        c.xInicial = 228;
        c.yInicial = 25;
        c.rotacaoInicial = 180;
        break;
      case 2:
        //carro rosa
        c.setImageView(imagemCarro2);
        c.xInicial = 228;
        c.yInicial = 257;
        c.rotacaoInicial = 180;
        break;
      case 3:
        //carro azul
        c.setImageView(imagemCarro3);
        c.xInicial = 0;
        c.yInicial = 370;
        c.rotacaoInicial = 180;
        break;
      case 4:
        //carro verde
        c.setImageView(imagemCarro4);
        c.xInicial = 535;
        c.yInicial = -14;
        c.rotacaoInicial = -90;
        break;
      default:
        System.out.println("Algo de errado nao esta certo");
        break;
    }
    //inicia o carro
    c.start();
    //identificador aumenta para o proximo carro
    identificador++;
  }
}