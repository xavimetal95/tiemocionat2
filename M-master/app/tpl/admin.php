<div class="admin">
<?php
	if(isset($_SESSION['rol']) == TRUE && $_SESSION['rol'] == 1){
		echo '<div id="edicion-admin">
				EDICION DE USUARIOS
			</div>

		<form class="form-admin" method="POST">

			<input type="button" id="form-insert" value="Nuevo" />
			<input type="button" id="form-update" value="Editar" />
			<input type="submit" id="form-delete" value="Eliminar" />

			<div></div>

			<table class="form-user" border="0">
				<tr style="background-color:rgba(32,32,32,0.8);color:rgba(244,244,244,1);"><td>ID</td><td>Email</td><td>Nombre</td><td>Poblacion</td><td>Rol</td><td></td></tr>
			</table>
		</form>
		<div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>AMPLIA AQUÍ TU LICENCIA!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>
		';
	}else{
		echo 'SIN PERMISO DE ADMINISTRADOR';
	}
?>
</div>