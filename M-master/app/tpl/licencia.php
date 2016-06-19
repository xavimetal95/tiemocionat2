<div id="licencia-cont">
<div class="container-licencia">

<?php 
                if(isset($_SESSION['user']) == FALSE){
    echo '<div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>COMPRA YA TU LICENCIA PARA EMPEZAR A DISFRUTAR!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>
                </div></a></div> <nav id="menu_principal"><ul><a href="'.APP_W.'licencia"><li id="li1" class="sin_licencia"><img src="/M-master/pub/images/juegos.png" />Juegos</li></a><a href="'.APP_W.'licencia"><li id="li2" class="sin_licencia"><img src="/M-master/pub/images/cuentos.png" />Cuentos</li></a><a href="'.APP_W.'licencia"><li id="li3" class="sin_licencia"><img src="/M-master/pub/images/dibuja.png" />Dibuja</li></a><a href="'.APP_W.'licencia"><li id="li4" class="sin_licencia"><img src="/M-master/pub/images/diccionario.png" />Diccionario</li></a></ul></nav>';
}else
{
    echo '<div id="slider">
            <img id="slide-image" src="/M-master/pub/images/215245_5.jpg" />
        <div id="container-buttons">
            <div class="button-slider" id="button1"></div><div class="button-slider" id="button2"></div><div class="button-slider" id="button3"></div>
        </div>
    </div> <nav id="menu_principal"><ul><a href="'.APP_W.'"><li id="li1"><img src="/M-master/pub/images/juegos.png" />Juegos</li></a><a href="'.APP_W.'cuentos"><li id="li2"><img src="/M-master/pub/images/cuentos.png" />Cuentos</li></a><a href="'.APP_W.'paint"><li id="li3"><img src="/M-master/pub/images/dibuja.png" />Dibuja</li></a><a href="'.APP_W.'emociones"><li id="li4"><img src="/M-master/pub/images/diccionario.png" />Diccionario</li></a></ul></nav>';
}
    ?>

<?php
	if(isset($_SESSION['user']) == FALSE){
	echo '<div id="compra">
	<ul>
	<li>Introducir datos</li>
	<li>Metodo de pago</li>
	<li>Confirmar</li>
	</ul>
	</div>

	<form class="licencia-form" method="POST">
		<table>
	    <tr><td><label>Nombre:</label></td><td><input class="input-style" type="text" name="name"></td></tr>
		<tr><td><label>Direccion:</label></td><td><input class="input-style" type="text" name="address"></td></tr>
		<tr><td><label>CP:</label></td><td><input class="input-style" type="text" name="cp"></td></tr>
		<tr><td><label>CIF:</label></td><td><input class="input-style" type="text" name="cif"></td></tr>
		<tr><td><label>Ciudad:</label></td><td><input class="input-style" type="text" name="city"></td></tr>
		<tr><td><label>Telefono:</label></td><td><input class="input-style" type="text" name="phone"></td></tr>
		<tr><td><label>CC:</label></td><td><input class="input-style" type="text" name="cc"></td></tr>
		<tr><td><label>Num. Licencias</label></td><td><select name="licencia">
			<option value="10">10</option>
			<option value="50">50</option>
			<option value="100">100</option>
			<option value="500">500</option>
		</select></td></tr>
		<tr><td colspan="2" style="text-align:end;"><input type="submit" value="Enviar" id="enviar_licencia"></input></td></tr>
	    </table>
	</form>

	<div class="line"></div>';
}else{
	echo '<div id="carga-licencias"><applet code="../M-master/tic/build/classes/Applet/AppletDiagonal.class" width=640 height=480></applet></div>';
}

?>

</div>
</div>