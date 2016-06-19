<div id="game-cont">
<div class="container-home">

<nav id="menu_principal" class="nav_especial"><ul><a href="<?= APP_W.''; ?>"><li id="li1"><img src="/M-master/pub/images/juegos.png" />Juegos</li></a><a href="<?= APP_W.'cuentos'; ?>"><li id="li2"><img src="/M-master/pub/images/cuentos.png" />Cuentos</li></a><a href="<?= APP_W.'paint'; ?>"><li id="li3"><img src="/M-master/pub/images/dibuja.png" />Dibuja</li></a><a href="<?= APP_W.'emociones'; ?>"><li id="li4"><img src="/M-master/pub/images/diccionario.png" />Diccionario</li></a></ul></nav>
<div id="bread"><p><a href="<?= APP_W.''; ?>">Home</a> > <a href="<?= APP_W.'paint'; ?>">Dibuja</a></p></div>
<?php 
            if(isset($_SESSION['user']) == TRUE){
echo '<div class="jpaint">
	<canvas id="can" width="1142" height="600" ></canvas><!-- 1142 -->
	<div id="clr">
		<div style="background-color:black;"></div>
		<div style="background-color:red;"></div>
		<div style="background-color:green;"></div>
		<div style="background-color:orange;"></div>
		<div style="background-color:#FFFF00;"></div>
		<div style="background-color:#F43059;"></div>
		<div style="background-color:#ff00ff;"></div>
		<div style="background-color:#9ecc3b;"></div>
		<div style="background-color:#fbd;"></div>
		<div style="background-color:#fff460;"></div>
		<div style="background-color:#F43059;"></div>
		<div style="background-color:#82B82C;"></div>
		<div style="background-color:#0099FF;"></div>
		<div style="background-color:#ff00ff;"></div>
		<div style="background-color:rgb(128,0,255);"></div>
		<div style="background-color:rgb(255,128,0);"></div>
		<div style="background-color:rgb(153,254,0);"></div>
		<div style="background-color:rgb(18,0,255);"></div>
		<div style="background-color:rgb(255,28,0);"></div>
		<div style="background-color:rgb(13,54,0);"></div>
	</div>
	<div id="controles">
		<a class="control-paint" id="limpiar"><img src="../M-master/pub/images/paint/hoja_doblada.png" /></a>
		<a class="control-paint" id="pincel"><img src="../M-master/pub/images/paint/apple-icon-60x60.png" /></a>
		<a class="control-paint" id="borrador"><img src="../M-master/pub/images/paint/Goma-Borrar-Kawaii-86342.png" /></a>
		<a class="control-paint" id="guardar"><img src="../M-master/pub/images/guardar.png" /></a>
		<a id="circulo" href="#"><div id="circle"></div></a>
		<a id="cuadrado" href="#"><div id="cuadrado"></div></a>
		<a id="rectangulo" href="#"><div id="rectangulo"></div></a>
	</div>
	<img id="test" src="">
</div>';
}else{
	echo '<div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>COMPRA YA TU LICENCIA PARA EMPEZAR A DISFRUTAR!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>
                </div></a></div>';
}
?>


</div>
</div>