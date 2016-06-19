<?php
	
	class Game extends Controller{
		protected $model;
		protected $view;
		
		function __construct($params){
			parent::__construct($params);
			$this->model=new mGame();
			$this->view= new vGame();
			
			//echo 'Hello controller!';
		}
		function home(){
			//Coder::codear($this->conf);
	}

	 /**
	  * selectgame() : Selecciona un juego y su nivel
	  *
	  * Le pasaremos por el metodo POST el juego y el nivel indicados en app.js
	  * el cual se encarga de transmitirselo
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

	function selectgame(){
	 $juego=filter_input(INPUT_POST, 'game', FILTER_SANITIZE_STRING);
     $nivel=filter_input(INPUT_POST, 'level', FILTER_SANITIZE_STRING);
     $result=$this->model->selectgame($juego,$nivel);
     $this->ajax_set($result);
  }

  /**
	  * rangoup() : Sube el nivel de un juego y añade puntos
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

	function rangoup(){
	$juego=filter_input(INPUT_POST, 'game', FILTER_SANITIZE_STRING);
	$nivel=filter_input(INPUT_POST, 'level', FILTER_SANITIZE_STRING);
    $result=$this->model->rangoup($juego,$nivel);
    $this->ajax_set($result);
  }
}
	?>