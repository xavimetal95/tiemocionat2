<?php

class mPaint extends Model{

		function __construct(){
			parent::__construct();
		}

		function guardar($paint){
			//Cogemos el nombre de usuario con una session donde guardamos el id
			$id = $_SESSION['id_usuario'];
			$query="SELECT nombre FROM usuarios WHERE id_usuario=:iduser";
		    $this->query($query);
		    $this->bind(':iduser',$id);
		    $this->execute();
		    $row = $this -> resultSet();
		    $name= $row[0]['nombre'];
		    //lo guardamos en una variable
		    $datenow = new DateTime();
			$fecha = $datenow->format('Y-m-d');
			//cogemos la fecha y la concatenamos con el nombre para que no se sobrescriba cada vez que guardamos
			$nombrear=$fecha." ".$name;
			$img = $paint;
			/*en la cadena que nos da el canvasURL quitamos el inicio de la cadena que es informacion que sobra 
		    y remplazamos los espacios con + y decodificamos el base64 para posteriormente crear una imagen de una string*/
			$img = str_replace('data:image/jpeg;base64,', '', $img);
			$img = str_replace(' ', '+', $img);
			$fileData = base64_decode($img);
			$im = imagecreatefromstring($fileData);  //convertir a imagen
			if ($im !== false) {
			    imagejpeg($im, '../M-master/pub/images/dibujo/'.$nombrear.'.jpg'); //guardar a disco      '../M-master/pub/images/dibujo/'+    
			    imagedestroy($im); //liberar memoria
			    //imagejpeg($im, 'textosimple.jpg'+$name+$fecha+'.jpg');
			}
			try{ 
					//insertamos la fuente de la imagen en la base de datos y creamos la relacion con el usuario
					$imagen = '/M-master/pub/images/dibujo/'.$name.'.jpg';
					$query2='INSERT INTO multimedia (fuente,nombre) VALUES (:imagen, "test");';
		            $this->query($query2);
		            $this->bind(':imagen',$imagen);
					$this->execute();
					$lastId = $this->lastInsertId();
					$query3='INSERT INTO detalle_imagen_usuario (usuarios_idusuarios,multimedia_idmultimedia) VALUES (:iduser, :idmagen);';
		            $this->query($query3);
		            $this->bind(':iduser',$id);
		            $this->bind(':idmagen',$lastId);
					$this->execute();
				return TRUE;
		    }catch(PDOException $e){
		       echo "Error:".$e->getMessage();
			}
		}
	}
?>	