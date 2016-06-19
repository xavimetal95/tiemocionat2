<?php
	
	class Perfil extends Controller{
		protected $model;
		protected $view;
		
		function __construct($params){
			parent::__construct($params);
			$this->model=new mPerfil();
			$this->view= new vPerfil();
			
			//echo 'Hello controller!';
		}
		function home(){
			//Coder::codear($this->conf);
		}

		/**
	  * select_user() : Cargamos datos del usuario para que se muestre en vista Perfil
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

		function select_user(){
			$id = $_SESSION['id_usuario'];
			$list = $this -> model -> select_user($id);
			$this -> ajax_set($list);
		}

		/**
	  * cambiarimg() : Proceso de cambio de imagen de perfil del usuario 
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

		function cambiarimg(){
			$dir="../M-master/pub/images/";
			$fichero=$dir . basename($_FILES['perfil']['name']);
			if(($_FILES['perfil']['name']==null) || ($_FILES['perfil']['name']==""))
				{
				}
				else
				{
					if (move_uploaded_file($_FILES['perfil']['tmp_name'], $fichero)) {//con move_uploaded_file subiremos el archivo a la carpeta del servidor
						$this -> model ->cambiarimg($fichero);

					} else {
					}

				}
				//$this -> ajax_set(array('redirect'=>APP_W.'home'));
		}

	}
?>