<div id="home-cont">
<div class="container-home">
    <?php 
                if(isset($_SESSION['user']) == FALSE){
    echo '<div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>COMPRA YA TU LICENCIA PARA EMPEZAR A DISFRUTAR!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>
                </div></a></div> <nav id="menu_principal"><ul><a href="'.APP_W.'"><li id="li1" class="sin_licencia"><img src="/M-master/pub/images/juegos.png" />Juegos</li></a><a href="'.APP_W.'"><li id="li2" class="sin_licencia"><img src="/M-master/pub/images/cuentos.png" />Cuentos</li></a><a href="'.APP_W.'"><li id="li3" class="sin_licencia"><img src="/M-master/pub/images/dibuja.png" />Dibuja</li></a><a href="'.APP_W.'"><li id="li4" class="sin_licencia"><img src="/M-master/pub/images/diccionario.png" />Diccionario</li></a></ul></nav>';
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

   

    <div id="ultimos-juegos">
        <div class="title">
            <img class="log-section" src="/M-master/pub/images/ultimos.png" /><h1>Últimos juegos</h1>
        </div>
        <div class="juegos">
            <?php 
                if(isset($_SESSION['user']) == FALSE){
                    echo '<div class="item-juego" id="sin_licencia"><img class="imagen-juego" src="/M-master/pub/images/memory.jpg" /><div class="text-game"><span>Memory</span></div></div>
                    <div class="item-juego" id="sin_licencia2"><img class="imagen-juego" src="/M-master/pub/images/relaciona.jpg" /><div class="text-game"><span>Relaciona</span></div></div>
                    <div class="item-juego" id="sin_licencia3"><img class="imagen-juego" src="/M-master/pub/images/comosiento.jpg" /><div class="text-game"><span>Como me siento</span></div></div>
                    <div class="item-juego" id="sin_licencia4"><img class="imagen-juego" src="/M-master/pub/images/puzzle_rabbit.jpg" /><div class="text-game"><span>Puzzle</span></div></div>
                    <div class="item-juego" id="sin_licencia5"><img class="imagen-juego" src="/M-master/pub/images/simpson.jpg" /><div class="text-game"><span>Simpson Atrapado</span></div></div>
                    <div class="item-juego" id="sin_licencia6"><img class="imagen-juego" src="/M-master/pub/images/bob.jpg" /><div class="text-game"><span>Bob el correcaminos</span></div></div>';
                }
            ?>
            <!--<div class="item-juego"><img src="/M-master/pub/images/215341_3.jpg" /><span>Memory</span></div>
            <div class="item-juego"><img src="/M-master/pub/images/215341_3.jpg" /><span>Memory</span></div>
            <div class="item-juego"><img src="/M-master/pub/images/215341_3.jpg" /><span>Memory</span></div>-->
        </div>
    </div>
    <?php 
            if(isset($_SESSION['user']) == TRUE){
                echo '<div id="top-jugados">
                        <div class="title">
                            <img class="log-section" src="/M-master/pub/images/trofeo.png" /><h1>Top jugadores</h1>
                        </div>
                        <div class="top-jugadores"></div>
                    </div>
                    <div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>AMPLIA AQUÍ TU LICENCIA!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>';
            }else{
                echo '<div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>COMPRA YA TU LICENCIA PARA EMPEZAR A DISFRUTAR!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>
                </div></a></div>';
            }
    ?>
</div>
</div>