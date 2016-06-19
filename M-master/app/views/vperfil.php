<?php
	/**
	 *  vHome
	 *  Prepares and loads the corresponding Template
	 *  @author Toni
	 * 
	 * */
	class vPerfil extends View{

		function __construct(){
			parent::__construct();
			
			$this->tpl=Template::load('perfil',$this->view_data);
			
		}

	}