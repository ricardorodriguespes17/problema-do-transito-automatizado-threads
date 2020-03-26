/* ***************************************************************
 * Autora: Ricardo Rodrigues Neto
 * Matricula: 201710560
 * Inicio: 13/10/2018
 * Ultima alteracao: 29/10/2018
 * Nome: Problema do transito automato
 * Funcao: Simulacao do problema do transito automato fazendo uso de
 *   semaforos em java
 ************************************************************** */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import controller.ControladorTela;

public class Principal extends Application{

	/* ***************************************************************
  * Metodo: main
  * Funcao: metodo inicial da aplicacao
  * Parametros: String[] args
  * Retorno: *sem retorno*
  *************************************************************** */
  public static void main(String[] args){
    launch(args);
  } 

  /* ***************************************************************
  * Metodo: start
  * Funcao: inicializa a tela
  * Parametros: palco principal da tela
  * Retorno: *sem retorno*
  *************************************************************** */
  @Override
  public void start(Stage palco) throws Exception{
  	//carrega o arquivo fxml
    Parent r = FXMLLoader.load(getClass().getResource("/view/Tela.fxml"));
    //muda a cena do palco
    palco.setScene(new Scene(r));
    //mostra o palco
    palco.show();
    //maximiza o palco
    palco.setMaximized(true);
  }
}