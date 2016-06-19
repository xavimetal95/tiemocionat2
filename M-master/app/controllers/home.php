<?php
	
	class Home extends Controller{
		protected $model;
		protected $view;
		
		function __construct($params){
			parent::__construct($params);
			$this -> model = new mHome();
			$this -> view = new vHome();
			
			//echo 'Hello controller!';
		}
		function home(){
		}

		/**
	  * login() : Acceso del usuario
	  *
	  * En caso de ser correcto se crearan los $_Session para el control del usuario en el framework
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

		function login(){
			if(!empty($_POST['email']) && !empty($_POST['password']))
			{//revisamos que input no este vacio
			
				$email = filter_input(INPUT_POST,'email',FILTER_SANITIZE_STRING);
				$password = filter_input(INPUT_POST,'password',FILTER_SANITIZE_STRING);
				$user = $this -> model -> login($email,$password);
				if($user == TRUE){//si lo que retorna la funcion es 1 o mayor no es false
					Session::set('user',$email);//seteamos session de usuario y rol
					Session::set('rol',$user);  
             		setcookie('user',Session::get('user'),0,APP_W);
             		if (isset($_POST['rememberme']) && $_POST['rememberme'] == '1') 
             		{
			            setcookie('username', $email, time()+60*60*24*365);
       				} else 
       				{
		            	setcookie('username', $email, false);
        			}
             		if($user == 2){//retorna usuario normal
         				$this -> ajax_set(array('redirect'=>APP_W.'home'));
         			}else{//retorna admin
         				$this -> ajax_set(array('redirect'=>APP_W.'admin'));
         			}
				}else{
             		return false;
				}
			}	
		}

		/**
	  * avatar() : Carga de la imagen de perfil
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

		function avatar(){
			$id = $_SESSION['id_usuario'];
			$list = $this -> model -> perfil($id);
			$this -> ajax_set($list);
		}


		/**
	  * top_jugadores() : Carga de los jugadores con mas puntos
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/


		function top_jugadores(){
			$list = $this -> model -> top_jugadores();
			$this -> ajax_set($list);
		}


		/**
	  * show_juegos() : Carga de los juegos que tiene disponibles el usuario
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

		function show_juegos(){
			$id = $_SESSION['id_usuario'];
			$list = $this -> model -> show_juegos($id);
			$this -> ajax_set($list);
		}

		/**
	  * logout() : Destruccion de la sesion del usuario
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

		function logout(){
			Session::set('islogged',FALSE);//ponemos seter de session a falso
			Session::set('user',FALSE);
			Session::destroy();//destruimos la sesion
			header('Location:'.APP_W);//redireccionamos 
		}

}