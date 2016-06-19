<?php
	/**
	 *  vHome
	 *  Prepares and loads the corresponding Template
	 *  @author Toni
	 * 
	 * */
	class vCuentos extends View{

		function __construct(){
			parent::__construct();
			$this->tpl=Template::load('cuentos',$this->view_data);
		}

	}