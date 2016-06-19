<?php
	
	class Licencia extends Controller{
		protected $model;
		protected $view;
		
		function __construct($params){
			parent::__construct($params);
			$this->model=new mLicencia();
			$this->view= new vLicencia();
			
			//echo 'Hello controller!';
		}
		function home(){
			//Coder::codear($this->conf);
			
	}

	/**
	  * upgradeli() : Proceso de compra de licencia
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/
	function upgradeli(){
		$licencia=$_POST['licencia'];
		$nombre=$_POST['name'];
		$cif=$_POST['cif'];
		$address=$_POST['address'];
		$cp=$_POST['cp'];
		$cc=$_POST['cc'];
		$phone=$_POST['phone'];
		$ciudad=$_POST['city'];
		$result=$this->model->upgradeli($licencia,$nombre,$cif,$address,$cp,$cc,$phone,$ciudad);
     	$this -> ajax_set(array('redirect'=>APP_W.'home'));
	}

  	}
?>