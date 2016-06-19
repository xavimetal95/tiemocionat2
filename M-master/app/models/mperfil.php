<?php

class mPerfil extends Model{

		function __construct(){
			parent::__construct();
		}

		function select_user($id){
		    try{
				$sql = "SELECT * FROM usuarios WHERE id_usuario=:id"; 
				$this -> query($sql);
			    $this -> bind(":id",$id);
			    $this -> execute();
			     if($this -> rowCount() >= 1){
			           return $this -> resultSet();//lo pasamos como array al controller
			     }else {
			         	return FALSE;
			     }
		    }catch(PDOException $e){
		       echo "Error:".$e->getMessage();
		   }
		}

		function cambiarimg($fuente){
			try{
				 $id = $_SESSION['id_usuario'];
				 $query="INSERT INTO multimedia(fuente,nombre) VALUES(:fuente,:nombre)";
				 $this->query($query);
				 $this->bind(':fuente',$fuente);
				 $this->bind(':nombre',$id);
				 $this->execute();
				 $lastId = $this->db->lastInsertId();
				 $query="UPDATE detalle_imagen_usuario SET multimedia_idmultimedia = :idmult where usuarios_idusuarios = :iduser and foto_perfil=1;";
				 $this->query($query);
				 $this->bind(':idmult',$lastId);
				 $this->bind(':iduser',$id);
				 $this->execute();
				 $this->query($query);	 
			}
			catch(PDOException $e){
				echo "Error:".$e->getMessage();
			}
		}

	}
?>	