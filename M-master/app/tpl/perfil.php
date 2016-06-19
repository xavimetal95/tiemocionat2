<div id="perfil-cont">
<div class="container-perfil">
  <nav id="menu_principal" class="nav_especial"><ul><a href="<?= APP_W.''; ?>"><li id="li1"><img src="/M-master/pub/images/juegos.png" />Juegos</li></a><a href="<?= APP_W.'cuentos'; ?>"><li id="li2"><img src="/M-master/pub/images/cuentos.png" />Cuentos</li></a><a href="<?= APP_W.'paint'; ?>"><li id="li3"><img src="/M-master/pub/images/dibuja.png" />Dibuja</li></a><a href="<?= APP_W.'emociones'; ?>"><li id="li4"><img src="/M-master/pub/images/diccionario.png" />Diccionario</li></a></ul></nav>
  <div id="bread"><p><a href="<?= APP_W.''; ?>">Home</a> > <a href="<?= APP_W.'perfil'; ?>">Perfil</a></p></div>

  <h2>Perfil de usuario</h2>
      <hr />
      
      <div id="img_perfil"></div>
      <form action="../M-master/perfil/cambiarimg" method="post" enctype="multipart/form-data" id="form_perfil"> <!-- class="camb-form" -->
      <input type="hidden" name="MAX_FILE_SIZE" value="50000000">
    <p><input name="perfil" type="file"  onChange="ver(form.file.value)" id="imagen_perfil_guardar"> </p>
    <input name="submit" type="submit" value="Guardar" id="imagen_perfil_guardar">  
</form><br> <span id="image"></span> 
      
  <table class="tg" id="tabla_perfil">

  </table>
   <div id="fr"> <hr /></div>
</div>
</div>