<?php

class mGame extends Model{

		function __construct(){
			parent::__construct();
			
		}
//funcion para cargar la fuente de las imagenes el nombre y el id para poder realizar la funcion rangoup y crear la relacion el nivel
		function selectgame($juego,$nivel){
    try{
     $query="SELECT multimedia.fuente, multimedia.nombre, niveles.idniveles 
     FROM multimedia 
     inner join detalle_multimedia_juego ON multimedia.idmultimedia=detalle_multimedia_juego.multimedia_idmultimedia 
     inner join niveles ON detalle_multimedia_juego.niveles_idniveles=niveles.idniveles 
     inner join juegos ON juegos.idjuegos=niveles.juegos_idjuegos
     where juegos.nombre=:juego AND nivel=:nivel  AND multimedia.nombre != 'juego'";
     $this->query($query);
     $this->bind(':juego',$juego);
     $this->bind(':nivel',$nivel);
     $this->execute();
     $row=$this->resultSet();
     return $row;
	}catch(PDOException $e){
       echo "Error:".$e->getMessage();
   }
  }
//funcion que comprueba si ya se habia pasado el nivel, en caso contrario le suma los puntos y crea la relacion para poder saber si lo ha completado
function rangoup($juego,$nivel){
try{ 
            $id = $_SESSION['id_usuario'];
            $query='SELECT * FROM detalle_niveles INNER JOIN niveles ON detalle_niveles.niveles_idniveles=niveles.idniveles INNER JOIN juegos ON niveles.juegos_idjuegos=juegos.idjuegos where usuarios_idusuarios=:iduser and niveles_idniveles=:nivel+1  and juegos.nombre=:juego;';
            $this->query($query);
            $this->bind(':iduser',$id);
            $this->bind(':juego',$juego);
            $this->bind(':nivel',$nivel);
            $this->execute();
            $row=$this->resultSet();
            if(empty($row)){
            $query='UPDATE usuarios SET puntos = puntos + 50 where id_usuario = :iduser;';
            $this->query($query);
            $this->bind(':iduser',$id);
            $this->execute();
            $query2='INSERT INTO detalle_niveles (niveles_idniveles, usuarios_idusuarios) VALUES (:idgame+1, :idusernivel);';
            $this->query($query2);
            $this->bind(':idgame',$nivel);
            $this->bind(':idusernivel',$id);
			$this->execute();
            }
           return TRUE;
    }catch(PDOException $e){
       echo "Error:".$e->getMessage();
}
}

}

		?>