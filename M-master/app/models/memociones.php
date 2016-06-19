<?php

class mEmociones extends Model{

		function __construct(){
			parent::__construct();
			
		}
//funcion que carga las emociones con nombre y descripcion y su respectiva imagen
		function cargdiccionario(){
			try{
				
				  $query="SELECT emociones.nombre,emociones.descripcion,emociones.fuente FROM emociones";
				 $this->query($query);
				 $this->execute();
				 $row=$this->resultSet();
				 return $row;
			}
			catch(PDOException $e){
				echo "Error:".$e->getMessage();
			}
		}
}
?>