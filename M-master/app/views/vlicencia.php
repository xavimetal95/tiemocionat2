<?php
	/**
	 *  vHome
	 *  Prepares and loads the corresponding Template
	 *  @author Toni
	 * 
	 * */
	class vLicencia extends View{

		function __construct(){
			parent::__construct();
			
			$this->tpl=Template::load('licencia',$this->view_data);
			
		}

	}