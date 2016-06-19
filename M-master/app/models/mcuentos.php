<?php

class mCuentos extends Model{

		function __construct(){
			parent::__construct();
			
		}
	
	/**
	  * show_cuentos() : Recoge las imagenes, descripciones y nombres de todos los cuentos asignados al usuario
	  *
	  *
	  * @author TicEmocionat
	  * @package controllers
	  *
  	*/

	function show_cuentos($id){
		    try{
			     $query="SELECT multimedia.fuente, juegos.nombre, juegos.descripcion FROM juegos 
			     inner join niveles ON juegos.idjuegos=niveles.juegos_idjuegos 
			     inner join detalle_niveles ON niveles.idniveles=detalle_niveles.niveles_idniveles 
			     inner join usuarios ON detalle_niveles.usuarios_idusuarios=usuarios.id_usuario
                 inner join detalle_multimedia_juego ON niveles.idniveles=detalle_multimedia_juego.niveles_idniveles  
                 inner join multimedia ON detalle_multimedia_juego.multimedia_idmultimedia=multimedia.idmultimedia
                 inner join categoria ON juegos.categoria_idcategoria=categoria.idcategoria
                 where multimedia.nombre = 'juego' AND categoria.nombre='libro'";
			     $this -> query($query);
			     $this -> bind(":id",$id);
			     $this->execute();
		     	if($this -> rowCount() >= 1){
					return $this -> resultSet();//lo pasamos como array al controller
				}else {
					return FALSE;
				}
			}catch(PDOException $e){
		       echo "Error:".$e->getMessage();
		   }
	  	}
}
?>