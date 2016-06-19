<div id="home-cont">
<div class="container-home">
    <div id="slider">
            <img id="slide-image" src="/M-master/pub/images/215245_5.jpg" />
        <div id="container-buttons">
            <div class="button-slider" id="button1"></div><div class="button-slider" id="button2"></div><div class="button-slider" id="button3"></div>
        </div>
    </div>

    <nav id="menu_principal"><ul><a href="<?= APP_W.''; ?>"><li id="li1"><img src="/M-master/pub/images/juegos.png" />Juegos</li></a><a href="<?= APP_W.'cuentos'; ?>"><li id="li2"><img src="/M-master/pub/images/cuentos.png" />Cuentos</li></a><a href="<?= APP_W.'paint'; ?>"><li id="li3"><img src="/M-master/pub/images/dibuja.png" />Dibuja</li></a><a href="<?= APP_W.'emociones'; ?>"><li id="li4"><img src="/M-master/pub/images/diccionario.png" />Diccionario</li></a></ul></nav>

    <div id="bread"><p><a href="<?= APP_W.''; ?>">Home</a> > <a href="<?= APP_W.'cuentos'; ?>">Cuentos</a></p></div>
    <div id="ultimos-juegos">
        <div class="title">
            <img class="log-section" src="/M-master/pub/images/ultimos.png" /><h1>Últimos cuentos</h1>
        </div>
        <div class="cuentos">
            <?php 
                if(isset($_SESSION['user']) == FALSE){
                    echo '<div class="item-juego"><img class="imagen-juego" src="/M-master/pub/images/berta.png" /><div class="text-game"><span>Berta se va de colonias</span></div></div>';
                }
            ?>
        </div>
    </div>
    <?php 
            if(isset($_SESSION['user']) == TRUE){
                echo '<div id="top-jugados">
                        <div class="title">
                            <img class="log-section" src="/M-master/pub/images/trofeo.png" /><h1>Top jugadores</h1>
                        </div>
                        <div class="top-jugadores" id="best_players"></div>
                    </div>';
            }else{
                echo '<div id="link-licencia"><a href="/M-master/licencia"><div id="licencias">
                    <img src="/M-master/pub/images/licencias.jpg" /><div><span>TICEMOCIONAT APP</span></br><span>COMPRA YA TU LICENCIA PARA EMPEZAR A DISFRUTAR!</span></br><span>*A partir de 20 euros + IVA el grupo de licencias</span></div>
                </div></a></div>';
            }
    ?>
</div>
</div>