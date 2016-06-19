<?php
	
	class Cuentos extends Controller{
		protected $model;
		protected $view;
		
		function __construct($params){
			parent::__construct($params);
			$this->model=new mCuentos();
			$this->view= new vCuentos();
			
			//echo 'Hello controller!';
		}
		function home(){
			//Coder::codear($this->conf);
			
	}

	/**
	  * showcuentos() : Funcion para mostrar los cuentos que estan registrado para el usuario con la ID de la session
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

	function show_cuentos(){
			$id = $_SESSION['id_usuario'];
     		$result=$this->model->show_cuentos($id);
     		$this->ajax_set($result);
  		}

  	}
?>