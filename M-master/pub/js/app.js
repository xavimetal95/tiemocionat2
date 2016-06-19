$(document).ready(function(){
	console.log("ready!");

  var juego = "";//juego a seleccionar
  var nivel = "";//nivel a seleccionar

  //Pantalla negra que se usará para el login
	$("#black-screen").hide();

  //Emociones del diccionario
	$(".emocion div").hide();
  
  $(".emocion").on('click',function(){
    $(this).children("div").toggle("slow");
  });

  //Una vez hagamos clic encima del Login
  $("#login").on('click',function(){
    $("#black-screen").show();
  });
  
  //Dialog de Login que aparecera
  $("#dialog-login").dialog({
    open: function() {
      $(".close").remove();
      $("button").remove();
      $(".ui-widget-header").append("<div class='close'><img src='/M-master/pub/images/icon-close-128.png' /></div>");
      $(".close").on('click',function(){
      $("#dialog-login").dialog("close");
      $("#dialog-register").dialog("close");
      $("#black-screen").hide();
    });
    },
    autoOpen: false,
    draggable: false,
    height: "216",
      width: "406",
      resizable: false,
      show: {
        effect: "blind",
        duration: 400
      }
    });
 
    $("#login").on('click',function(){
      $("#dialog-login").dialog("open");
      
    });
  
  $(".ui-dialog-titlebar-close").on('click',function(){
      $("#dialog-login").dialog("close");
    $("#black-screen").hide();
    });
  
  $("#black-screen").on('click',function(){
      $("#dialog-login").dialog("close");
    $("#black-screen").hide();
    });
  
    
  //SLIDER
  var a = 1;
  
  //Sistema de botones del slider
  $(".button-slider").eq(a-1).css("background-color","rgba(34, 167, 240,1)");
  
  //Automatizacion del paso de las imagenes
  setInterval(function next(){
    $(".button-slider").css("background-color","rgba(204,204,204,0.6)");
    a++;
    $('#slide-image').fadeOut(250, function() {
      if(a == 1){
        $("#slide-image").attr("src","../M-master/pub/images/215245_5.jpg");
      }else if(a == 2){
        $("#slide-image").attr("src","../M-master/pub/images/214511_6.jpg");
      }else if(a == 3){
        $("#slide-image").attr("src","../M-master/pub/images/207942_7.jpg");
        a = 0;
      }
      $('#slide-image').fadeIn(250);
    });
    $(".button-slider").eq(a-1).css("background-color","rgba(34, 167, 240,1)");
  },7000);
  
  
  //Cuando el usuario clica encima de algún boton del slider
  $(".button-slider").on('click',function(){
    $(".button-slider").css("background-color","rgba(204,204,204,0.6)");
    $(".button-slider").removeClass("selected");
    $(this).addClass("selected");
      if($(this).attr('id') == "button1"){
        $('#slide-image').fadeOut(250, function() {
          $("#slide-image").attr("src","../M-master/pub/images/215245_5.jpg");
          $('#slide-image').fadeIn(250);
        });
        a = 1;  
      }else if($(this).attr('id') == "button2"){
        $('#slide-image').fadeOut(250, function() {
          $("#slide-image").attr("src","../M-master/pub/images/214511_6.jpg");
          $('#slide-image').fadeIn(250);
        }); 
        a = 2;
      }else if($(this).attr('id') == "button3"){
        $('#slide-image').fadeOut(250, function() {
          $("#slide-image").attr("src","../M-master/pub/images/207942_7.jpg");
          $('#slide-image').fadeIn(250);
        });
        a = 0;
      }
    $(".button-slider").eq(a-1).css("background-color","rgba(34, 167, 240,1)"); 
  });

  //Controles de guardar, borrar, dibujar del Paint
  $(".control-paint").on('click',function(){
      $(".control-paint").css('opacity','1');
      $(this).css('opacity','0.6');
  });

  //Lista de colores para el Paint
  $("#clr div").on('click',function(){
      $("#clr div").css('opacity','1');
      $(this).css('opacity','0.6');
  });

  //Carga de la imagen del perfil del usuario
	$(window).load(function() {
		var postData = $(this).serialize();
		     $.ajax({
		       url:"../M-master/home/avatar",
		       data:postData,
		       method:'post',
		       dataType:'json',
		       success:function(output){
		       		$("#user-account").append("<a href='/M-master/perfil'><img src='"+output[0]['fuente']+"' /></a>");
		       }
		});
	});

  //Carga mediante el Login al usuario de base de datos
	 $('.form-log').on('submit',function(){
	     console.log('click');
	     var postData = $(this).serialize();
	     var formURL = $(this).attr("action");
	     $.ajax({
	       url:formURL,
	       data:postData,
	       method:'post',
	       dataType:'json',
	       error: function(){
	          show_mesg('Error inicio de sesion');
	       },
	       success: function(output){
	          console.log(output);
	          window.location.href=output.redirect; 
	       }
	    });
	    return false;
 	 });


   //Dashboard de admin cuando requiere de borrar algun usuario
	 $("#form-delete").on('click',function(){
	 	  $('.form-admin').on('submit',function(){
			     var postData = $(this).serialize();
			     $.ajax({
			       url:"../M-master/admin/deleteuser",
			       data:postData,
			       method:'post',
			       dataType:'json',
			       success:function(output){
			          window.location.href=output.redirect; 
			       }
			    });
	 	 });
 	  });

   //Para saber en que posicion del Framework nos encontramos
	 var pathname = window.location.pathname;
	 aux_path = pathname.split('/');

   //En caso de estar en la posicion de Perfil cargamos otra imagen con un tamaño más grande
    if(aux_path[aux_path.length-1] == 'perfil'){
        var postData = $(this).serialize();
         $.ajax({
           url:"../M-master/home/avatar",
           data:postData,
           method:'post',
           dataType:'json',
           success:function(output){
              $("#img_perfil").append("<img src='"+output[0]['fuente']+"' />");
           }
        });


         //Seleccionamos datos de usuario que se mostraran en pantalla
         var postData = $(this).serialize();
         $.ajax({
           url:"../M-master/perfil/select_user",
           data:postData,
           method:'post',
           dataType:'json',
           success:function(output){
              $(".tg").append("<tr><th class='tg-8bhd'>Nombre:</th><th class='tg-baqh'>"+output[0]['nombre']+"</th></tr><tr><td class='tg-8bhd'>Apellidos:</td><td class='tg-baqh'>"+output[0]['apellidos']+"</td></tr><tr><td class='tg-8bhd'>Email:</td><td class='tg-baqh'>"+output[0]['email']+"</td></tr><tr><td class='tg-8bhd'>Puntos:</td><td class='tg-baqh'>"+output[0]['puntos']+"</td></tr><tr><td class='tg-8bhd'>Perfil de Usuario:</td><td class='tg-baqh'>Alumno</td></tr>");
            }
          });
    }

    //Cuando estemos en la vista cuentos se cargaran todos los cuentos que existan en la base de datos con sus respectivas imagenes
   if(aux_path[aux_path.length-1] == 'cuentos'){
      var postData = $(this).serialize();
         $.ajax({
           url:"../M-master/cuentos/show_cuentos",
           data:postData,
           method:'post',
           dataType:'json',
           success:function(output){
              for(i = 0; i < output.length; i++){
                $(".cuentos").append("<div class='item-juego' id='"+output[i]['nombre']+"'><a href='../M-master/game'><img class='imagen-juego' src='"+output[i]['fuente']+"' /></a><div class='text-game'><a href='../M-master/game'><span>"+output[i]['nombre']+"</span></br></a><span>"+output[i]['descripcion']+"</span></div></div>");
              }

              //Indicamos que cuando clique encima del cuento de Berta se cree una variable en localstorage que se encargara de pasarle a la vista Game el juego y el nivel que ha escodigo el usuario
              $("#Berta").on('click',function(){
                    mem=new Array;
                    juego = "Berta";
                    localStorage['juego'] = "Berta";
                    localStorage['nivel'] = "1";
                    nivel = "1";
              });
           }
        });
   }


   //Cuando estemos tanto en Home como en Cuentos habrá un top de jugadores con más puntos los cuales cargan de base de datos
   if(aux_path[aux_path.length-1] == 'home' || aux_path[aux_path.length-1] == '' || aux_path[aux_path.length-1] == 'cuentos'){
     var postData = $(this).serialize();
           $.ajax({
             url:"../M-master/home/top_jugadores",
             data:postData,
             method:'post',
             dataType:'json',
             success:function(output){
                for(i = 0; i < output.length; i++){
                  $(".top-jugadores").append("<div class='item-jugador' id='img_jugadores'><img class='imagen-jugador' src='"+output[i]['fuente']+"' /><div><span>"+(i+1)+'. '+output[i]['nombre']+"</span><span>Puntos "+output[i]['puntos']+"</span></div></div>");
                }
             }
          });
    }

    //En Home se cargan los juegos 
   if(aux_path[aux_path.length-1] == 'home' || aux_path[aux_path.length-1] == ''){
      var postData = $(this).serialize();
         $.ajax({
           url:"../M-master/home/show_juegos",
           data:postData,
           method:'post',
           dataType:'json',
           success:function(output){
              for(i = 0; i < output.length; i++){
                $(".juegos").append("<div class='item-juego' id='"+output[i]['nombre']+"'><a href='../M-master/game'><img class='imagen-juego' src='"+output[i]['fuente']+"' /></a><div class='text-game'><a href='../M-master/game'><span>"+output[i]['nombre']+"</span></br></a><span>"+output[i]['descripcion']+"</span></div></div>");
              }

              //Mismo proceso con los cuentos solo que ahora con los juegos
              $("#Memory").on('click',function(){
                    mem=new Array;
                    juego = "Memory";
                    localStorage['juego'] = "Memory";
                    localStorage['nivel'] = "1";
                    nivel = "1";
              });

              $("#relaciona").on('click',function(){
                    mem=new Array;
                    juego = "relaciona";
                    //metemos en localstorage el juego y el nivel para luego asignarlo a las variables juego y nivel
                    localStorage['juego'] = "relaciona";
                    localStorage['nivel'] = "1";
                    nivel = "1";
              });
           }
        });
   }

      $(".licencia-form").on('submit',function(){
          var postData = $(this).serialize();
         $.ajax({
           url:"../M-master/licencia/upgradeli",
           data:postData,
           method:'post',
           dataType:'json',
           success:function(output){
              window.location.href=output.redirect; 
           }
          });
         return false;
      });

   //Vista Admin la cual tendra distintas opciones ya sea crear usuario, eliminarlo, o cambiarlo
	 if(aux_path[aux_path.length-1] == 'admin'){
	     var postData = $(this).serialize();
	     $.ajax({
	       url:"../M-master/admin/listuser",
	       data:postData,
	       method:'post',
	       dataType:'json',
	       success:function(output){
	       	var tipo, poblacion;

	          for(i = 0; i < output.length; i++){
		          	if(output[i]['rol'] == 1){
		          		tipo = "Administrador";
		          	}else{
		          		tipo = "Usuario";
		          	}

		          	if(output[i]['poblacion'] == 1){
		          		poblacion = "Gava";
		          	}else if(output[i]['poblacion'] == 2){
		          		poblacion = "Viladecans";
		          	}else if(output[i]['poblacion'] == 3){
		          		poblacion = "Castelldefels";
                }

	          		$(".form-user").append("<tr><td>"+output[i]['id_usuario']+"</td><td>"+output[i]['email']+"</td><td>"+output[i]['nombre']+"</td><td>"+poblacion+"</td><td>"+tipo+"</td><td><input type='checkbox' name='usuario[]' value='"+output[i]['id_usuario']+"' /></td></tr>");
	      	  }
	      	  $(".form-user").append("<tr style='text-align:center;background-color:rgba(32,32,32,0.8);color:rgba(244,244,244,1);'><td style='text-align:end;' colspan='5'><input type='button' id='admin-todos' value='Seleccionar todos' /></td><td><input type='button' id='admin-quitar' value='Quitar todos' /></td></tr>");
		       	  
		       	  $("#admin-todos").on('click',function(){
						$('input[type=checkbox]').each(function(){ 
							this.checked = true; 
						});
				  });
				  $("#admin-quitar").on('click',function(){
						$('input[type=checkbox]').each(function(){ 
							this.checked = false; 
						});
				  });
	       }
	    });
	}

$("#form-insert").on('click',function(){
 	 $(".form-admin div label").remove();
 	 $(".form-admin div input").remove();
 	 $(".form-admin div select").remove();
 	 $(".form-admin div").append("<label>Email* </label><input type='text' name='newemail' /><label> Nombre* </label><input type='text' name='newnombre' /><label> Contraseña* </label><input type='text' name='newpassword' /><label> Poblacion* </label><select name='newpoblacion'><option value=''>Selecciona</option><option value='Gava'>Gava</option><option value='Viladecans'>Viladecans</option><option value='Castelldefels'>Castelldefels</option></select><label> Permisos* </label><select name='newrol'><option value=''>Selecciona</option><option value='administrador'>Administrador</option><option value='usuario'>Usuario</option></select><input type='submit' id='adduser' value='Añadir' /><input type='button' id='form-del' value='Cancelar' />");

	 $('.form-admin').on('submit',function(){
		     var postData = $(this).serialize();
		     $.ajax({
		       url:"../M-master/admin/newuser",
		       data:postData,
		       method:'post',
		       dataType:'json',
		       success:function(output){
		          window.location.href=output.redirect; 
		       }
		    });
 	 });

 	 $("#form-del").on('click',function(){
		$(".form-admin div label").remove();
 		$(".form-admin div input").remove();
 		$(".form-admin div select").remove();
	 });
});

$("#form-update").on('click',function(){
 	 $(".form-admin div label").remove();
 	 $(".form-admin div input").remove();
 	 $(".form-admin div select").remove();
 	 $(".form-admin div").append("<label>Email </label><input type='text' name='upemail' /><label> Nombre </label><input type='text' name='upnombre' /><label> Permisos </label><select name='uprol'><option value=''>Selecciona</option><option value='administrador'>Administrador</option><option value='usuario'>Usuario</option></select><input type='submit' id='update' value='Actualizar' /><input type='button' id='form-del' value='Cancelar' />");
 	 
 	 $('.form-admin').on('submit',function(){
		     var postData = $(this).serialize();
		     $.ajax({
		       url:"../M-master/admin/updateuser",
		       data:postData,
		       method:'post',
		       dataType:'json',
		       success:function(output){
		          window.location.href=output.redirect; 
		       }
		    });
 	 });

 	 $("#form-del").on('click',function(){
		$(".form-admin div label").remove();
 		$(".form-admin div input").remove();
 		$(".form-admin div select").remove();
	 });
});


//Funcion show_mesg encargada de enseñar al usuario cualquier mensaje de error o transicion
var show_mesg = function(str){
	$('body').append('<div class="message">' + str + '<div>');
	setTimeout(function(){
		$('.message').remove();
	},5000);
}


//------------------------------------------------------------------------------


//En la vista Game
if(aux_path[aux_path.length-1] == 'game'){
  //asignamos el juego y el nivel a traves de localstorage
  juego=localStorage['juego'];
  nivel=localStorage['nivel'];
    var mem=new Array;
    //Dependiendo de la variable se cargaran estos distintos juegos/cuentos en la misma vista
    if(juego=="Memory"){
    $.get('../M-master/game',
      { juego: 'memory' },
      function(datos) {
        cargmemory(juego,nivel,mem);
      });}
    if(juego=="relaciona"){
    $.get('../M-master/game',
      { juego: "relaciona" },
      function(datos) {
        cargrelaciona(juego,nivel,mem);
      });}
    if(juego=="Berta"){
    $.get('../M-master/game',
      { juego: "Berta" },
      function(datos) {
        carghistoria(juego,nivel,mem);
      });}
    $("#title-game").append(localStorage['juego']+"<span>Nivel "+localStorage['nivel']+"</span>");
}

//Vista Paint haremos la carga de la funcion paint
if(aux_path[aux_path.length-1] == 'paint'|| aux_path[aux_path.length-1] == 'paint#'){
  cargpaint();
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
}

//Vista emociones, nos encargaremos de llamar a la funcion del diccionario de emociones
if(aux_path[aux_path.length-1] == 'emociones'|| aux_path[aux_path.length-1] == 'emociones#'){
  cargardic();
}

//Funcion de carga del juego Memory
function cargmemory(juego,nivel,mem){
    $.ajax({
      url:'../M-master/game/selectgame',
      type:'POST',
      datatype:'json',
      data:{game: juego, level: nivel},
      success:function(respuesta){
      i=0;
      cont=0;
      band=-1;
      var numOccurences=0;
      var mem2 = new Array;
      var name = new Array;
      var comp = new Array;
      var ultinum;
      //meto la caja donde se producira el juego
      $("#container").append("<div id='memory-caja'></div>");
      var data = JSON.parse(respuesta);
      //una bandera para saber si el juego ha sido completado
      var comprobante=0;
      //meto unos numeros para controlar los divs
      var numeros = ["cero","uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"];
      idnivel=data[0].idniveles;
      for(j=0;j<data.length;j++){
        if(j==0){
        $("#memory-caja").append("<div id="+numeros[j]+"></div>");
        $("#memory-caja").append("<div id="+numeros[j+1]+"></div>");
        ultinum=j+2;
        }
        else{   
        $("#memory-caja").append("<div id="+numeros[ultinum]+"></div>");
        $("#memory-caja").append("<div id="+numeros[ultinum+1]+"></div>");
        ultinum=ultinum+2;
        }
        //voy rellenando los arrays con la fuente y con el nombre
        mem.push(data[j].fuente);
        name.push(data[j].nombre);
      }
      //hago un random por cada div que se ha creado y cojo el nombre y la ruta
      $( "#memory-caja div" ).each(function() {
    num=Math.floor((Math.random() * mem.length-1) + 1);
    ruta=mem[num];
    nombre=name[num];
    //aqui controlo para que no se me repita las imagenes mas de 2 veces en ese caso meto la imagen en cada div y lo voy metiendo en el array mem2 para poder controlarlo
    if(jQuery.inArray(ruta, mem2) !== -1){
      for(i=0;i<mem2.length;i++){
        if(mem2[i]===ruta){
          numOccurences++;
          }
        }
      if(numOccurences===2){
      while(numOccurences!==0){
        num=Math.floor((Math.random() * mem.length-1) + 1);
        ruta=mem[num];
        nombre=name[num];
        band=$.inArray(ruta,mem2);
        numOccurences=0;

        for(j=0;j<mem2.length;j++){
        if(mem2[j]===ruta){
          numOccurences++;
          }
        }
        if(numOccurences<2){
          numOccurences=0;
          mem2.push(ruta);
          var id = $(this).attr('id');
            $(this).append( "<img class='inc' id='img"+id+"' src='"+ruta+"' name='"+nombre+"'>" );
          }
        }
      }
      else{
      numOccurences=0;
      mem2.push(ruta);
      var id = $(this).attr('id');
        $(this).append( "<img class='inc' id='img"+id+"' src='"+mem[num]+"' name='"+nombre+"'>" );
      }
      
      }
      else{
      mem2.push(ruta);
      var id = $(this).attr('id');
        $(this).append( "<img class='inc' id='img"+id+"' src='"+mem[num]+"' name='"+nombre+"'>" );
      }
    
});
i=0;
//oculto las imagenes y cuando hace click que se muestre si es la primera que no haga nada pero si es la segunda comprueba si son la misma con el nombre de la imagen
  $(".cor").hide();
  $(".inc").hide();
  $("#memory-caja div").click(function(){
    cont = cont+1;
    var id = $(this).attr('id');
    if(cont==2){
      $("#img"+id).show("clip",1000);
      comp.push($("#img"+id).attr('name'));
      cad1=comp[0];
      cad2=comp[1];
      if(cad1===cad2){
      $("#img"+id).switchClass( "inc", "cor", 1000 );
      $("#"+idant).switchClass( "inc", "cor", 1000 );
      comprobante=comprobante+1;
        }
      else{
        $(".inc").hide("clip",1000);
          }
      cont=0;
      comp=[];
      }
      //si es el primero en un array meto el atributo nombre del primero que ha clickado
    else if(cont<2){
      idant="img"+id;
      comp.push($("#img"+id).attr('name'));
      $("#img"+id).show("clip",1000);
      }
      //aquí compruebo si ha terminado el juego en caso de que sea asi se le da un mensaje y se llama a la funcion rangoup que le suma puntos al niño en caso de haber finalizado el juego por primera vez
    if(comprobante==data.length){
      alert("correcto");
      $.ajax({
          url:'../M-master/game/rangoup',
          type:'POST',
          datatype:'json',
          data:{game: juego,level: idnivel},
          success:function(respuesta){
                            }
                          });

    }
    
    });
      },
      error:function(data){
        alert(JSON.stringify(data));
      }
      })
};

//Carga del juego relaciona
function cargrelaciona(juego,nivel,mem){
    $.ajax({
      url:'../M-master/game/selectgame',
      type:'POST',
      datatype:'json',
      data:{game: juego, level: nivel},
      success:function(respuesta){
      var data = JSON.parse(respuesta);
      var easy = 4;
      var win = easy;
      //creo varios arrays para poder hacer las imagenes aleatorias y no se repitan tanto imagenes como nombres
      var arrayo = Array();
      var arrayo2 = Array();
      var arraynombres = Array();
      var arraynombres2 = Array();
      var arrayo3 = Array();
      var arrayo4 = Array();
      var no = false;
     
      //creo las cajas de separacion, imagenes y nombres
       $("#container").append("<div id='relaciona-caja'></div>");
        $("#container").append("<div id='relaciona-caja2'></div>");
        $("#container").append("<div id='relaciona-caja3'></div>");
      for(j=0;j<data.length;j++){
      arrayo.push(data[j].fuente);
      arraynombres.push(data[j].nombre);
      }
    arrayo2.push(1);
    for(i = 0; i < easy; i++){
    do{
    var alea = Math.floor(Math.random()*7);
    no = false;
    for(j = 0; j < arrayo2.length; j++){
      if(alea == arrayo2[j])
      {
        no = true;
        break;
      }
    }
  }while(no == true);
  arrayo2.push(alea);
  //creo los divs de nombre y los meto en su caja y en los que estaran las imagenes
  var imagen = arrayo[alea];
  var nombre = arraynombres[alea];
    $('#relaciona-caja').append('<div id="'+i+'">'+nombre+'</div>');
    arrayo3.push('<div id="'+i+'"><img src="'+imagen+'" width="100%" /></div>');
}
//y lo meto en la caja que le toca
arrayo4.push(Math.floor(Math.random()*4));
$("#relaciona-caja3").append(arrayo3[arrayo4[0]]);
for(i = 0; i < arrayo3.length-1; i++){
  
  do{
    var alea = Math.floor(Math.random()*4);
    no = false;
    for(j = 0; j < arrayo4.length; j++){
      if(alea == arrayo4[j])
      {
        no = true;
        break;
      }
    }
  }while(no == true);
  arrayo4.push(alea);
  
  $("#relaciona-caja3").append(arrayo3[alea]);  
}

$("#relaciona-caja div").on('mouseover',function(){
  $(this).on('click',function(){
    $("#relaciona-caja div").css('background-color','white');
    $(this).css('background-color','#FCC');
  });
});

$("#relaciona-caja3 div").on('mouseover',function(){
  $(this).on('click',function(){
    $("#relaciona-caja div").css('background-color','white');
  });
});

$("#relaciona-caja2").on('mouseover',function(){
  $(this).on('click',function(){
    $("#relaciona-caja div").css('background-color','white');
  });
});

var temp;
//meto la id en una variable para poder comprobar luego si es correcto
$("#relaciona-caja div").on('click',function(){
  temp = $(this).attr("id");
});

$("#relaciona-caja3 div").on('click',function(){
  //si la variable tem es igual que el id es que ha acertado ya que comparten id
  if(temp == $(this).attr("id")){
    $("#relaciona-caja #"+temp).css('-webkit-filter','opacity(0%)');
    $("#relaciona-caja #"+temp).css('filter','opacity(0%)');
    $(this).css('-webkit-filter','opacity(0%)');
    $(this).css('filter','opacity(0%)');
    win=win-1;
    if(win==0)
    {
      alert("MOLT BE ETS UN CAMPIÓ"); 
      //voy restando a win hasta que sepa si es 0 entonces significa que ha ganado el juego y entonces llamo a la funcion rango up
      $.ajax({
         url:'../M-master/game/rangoup',
         type:'POST',
         datatype:'json',
         data:{game: juego,level: idnivel},
         success:function(respuesta){ 
          }
               });
    }
  }
});
      },
      error:function(data){
        alert(JSON.stringify(data));
      }
      });
};


//Carga de la historia/cuento
function carghistoria(juego,nivel,mem){
    $.ajax({
      url:'../M-master/game/selectgame',
      type:'POST',
      datatype:'json',
      data:{game: juego, level: nivel},
      success:function(respuesta){
      var data = JSON.parse(respuesta);
      tam_width = window.innerWidth - 20;
    tam_height = window.innerHeight - 20;
    idnivel=data[0].idniveles;
    //Control de escenas
    var scene = 1;//ini con la primera escena

    var lost, next, fin; //timers
    var ini_video;//videos
    var f_accion, next; //flags

    call_scene();//primer call a la primera escena del juego

    function call_scene(){
      $("div #video").remove();
      $("div #cuento-container").remove();
      $(".accion").remove();
      f_accion = false;
      next = false;

      if(scene == 1){
        ini_video = data[0].fuente;
        scene = 1;//next_scene
        cierto = data[0].nombre;
      }else if(scene == 2){
        ini_video = data[1].fuente;
        scene = 2;//next_scene
        cierto = data[1].nombre;
      }else if(scene == 3){
        ini_video = data[2].fuente;
        scene = 3;//next_scene
        cierto = data[2].nombre;
      }else if(scene == 4){
        ini_video = data[3].fuente;
        scene = 4;//next_scene
        cierto = data[3].nombre;
      }

        //ini video
        $("#container").append("<div id='video'><video width='"+tam_width+"' height='"+tam_height+"' currentTime='3s' autoplay><source src='"+ini_video+"' type='video/webm'></video></div>");
        $("#container").append("<div id='cuento-container'></div>");
          
          $("video").on('ended', function(){
            f_accion = true;
            $("#cuento-container").append("<div id='Alegria' class='accion'>Alegria</div>");
            $("#cuento-container").append("<div id='Calma' class='accion'>Calma</div>");
            $("#cuento-container").append("<div id='Rabia' class='accion'>Rabia</div>");
            $("#cuento-container").append("<div id='Por' class='accion'>Por</div>");
            $("#cuento-container").append("<div id='Simpatia' class='accion'>Simpatia</div>");
            
                $(".accion").on('click',function(){
                  if($(this).attr('id') == cierto){//error
                    $("div #video").remove();
                    $("div #cuento-container").remove();
                    $(".accion").remove();
                    alert("Ganaste!! :) Pasemos a la siguiente escena");
                    scene++;
                    if(scene == 4){
                      var win = true;
                      scene = 1;  
                    }
                          if(scene == 1 && win == true){
                            alert("Ganaste!! :) No hay mas escenas pero a continuación puedes volver a jugar");
                            win = false;
                            $.ajax({
                            url:'/M-master/game/rangoup',
                            type:'POST',
                            datatype:'json',
                            data:{game: juego, level: idnivel},
                            success:function(respuesta){
                              
                            }
                          });
                          }
                          //next scene ini if win
                          call_scene();
                  }else{
                    $("div #video").remove();
                    scene = scene;
                    alert("Perdiste volveremos a empezar :(");
                    //next scene ini if win
                    call_scene();
                  }
                });
          });

    }
    }
    });
  };


  //Carga del Paint
  function cargpaint(){

    var clic=false;
   var xCoord,yCoord="";
   var canvas=document.getElementById("can");
   //creo 2 eventos para cuando pulse la tecla + y menos el pincel o la goma se haga mas pequeña o grande
   window.addEventListener("keydown", pincelmas, false);
   window.addEventListener("keydown", pincelmenos, false);
   var cntx=canvas.getContext("2d");
    //una variable para poder controlar en que color estabamos anteriormente por si cambiamos a la goma asi al cambiar al pincel volver al mismo color
   var colorant="red";
   //el modo en el que estamos para poder controlar si estamos pintando, borrando, cuadrado , circulo etc..
   mode='pincel';
   //color del pincel y tamaño de la linea
   cntx.strokeStyle="red";
   cntx.lineWidth=10;
   cntx.lineCap="round";
   cntx.fillStyle="#fff";
 cntx.fillRect(0,0,canvas.width,canvas.height);
 //controlamos si clicka el el raton y comprobamos en que modo esta  y la posicion
$("#can").mousedown(function(canvas){
   clic=true;
   cntx.save();
   xCoord=canvas.pageX-this.offsetLeft;
   yCoord=canvas.pageY-this.offsetTop;
   if(mode=='circulo'){
      cntx.beginPath();
      cntx.arc(xCoord, yCoord, 120, 0, 2*Math.PI);
    cntx.fillStyle=colorant;
    cntx.fill();
    cntx.closePath();
       }
       if(mode=='cuadrado'){
              cntx.beginPath();
       cntx.rect(xCoord, yCoord, 100, 100);
       cntx.fillStyle=colorant;
       cntx.fill();
       cntx.closePath();
       }
       if(mode=='rectangulo'){
       cntx.beginPath();
       cntx.rect(xCoord, yCoord, 200, 100);
       cntx.fillStyle=colorant;
       cntx.fill();
       cntx.closePath();
       }
       if(mode=='triangulo'){
        cntx.beginPath();
    cntx.moveTo(100,110);
    cntx.lineTo(200,10);
    cntx.lineTo(300,110);
    cntx.closePath();
    cntx.fillStyle=colorant;
    cntx.fill();
       }
});

$(document).mouseup(function(){
   clic=false
});

$(document).click(function(){
   clic=false
});
//cuando se mueve el raton que siga el trazado así da el efecto que esta pintando
$("#can").mousemove(function(canvas){
   if(clic==true){
       if(mode=="pincel" || mode=="borrador"){
        cntx.beginPath();
       cntx.moveTo(canvas.pageX-this.offsetLeft,canvas.pageY-this.offsetTop);
       cntx.lineTo(xCoord,yCoord);
       cntx.stroke();
       cntx.closePath();
       xCoord=canvas.pageX-this.offsetLeft;
       yCoord=canvas.pageY-this.offsetTop;
      cntx.lineCap="round";
      cntx.fillStyle="#fff";
    cntx.fillRect(0,0,canvas.width,canvas.height);
       }
       
   }
});
//para cambiar de color cuando clique en cada uno de los colores
$("#clr > div").click(function(){
  cntx.lineWidth=10;
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
   cntx.strokeStyle=$(this).css("background-color");
   colorant=cntx.strokeStyle;
});
//cambio a el modo y reseteo el tamaño del pincel a parte de cambiar el mouse a una goma de borrar     
$("#borrador").click(function(){
  mode="borrador";
  cntx.lineWidth=10;
  colorant=cntx.strokeStyle;
$("canvas").css("cursor","url('../M-master/pub/images/paint/Goma-Borrar-Kawaii-86342.png'), auto");
   cntx.strokeStyle="#fff";
});
//relleno el canvas de blanco y da el efecto de que se ha limpiado
$("#limpiar").click(function(){
   cntx.fillStyle="#fff";
   cntx.fillRect(0,0,canvas.width, canvas.height);
});
//al clicar en el menu en cada mod se cambia el modo y el mouse
$("#circulo").click(function(){
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
mode='circulo';
});

$("#cuadrado").click(function(){
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
mode='cuadrado';
});

$("#rectangulo").click(function(){
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
mode='rectangulo';
});

$("#pincel").click(function(){
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
  cntx.lineWidth=10;
  mode='pincel';
  $("canvas").css("cursor","url('../M-master/pub/images/paint/apple-icon-60x60 (1).ico'), auto");
   cntx.strokeStyle=colorant;
});
//la funcion guardar envia lo que hay en el canvas codificado en base64 con la funcion todataurl
$("#guardar").click(function(){
  imagen=canvas.toDataURL("image/jpeg");
   $.ajax({
      url:'../M-master/paint/guardar',
      type:'POST',
      datatype:'json',
      data:{paint: imagen},
      error:function(){
        show_mesg('No se pudo subir el dibujo');
      },
      success:function(respuesta){  
        $(".control-paint").css('opacity','1');
        show_mesg('Dibujo añadido :)');
      }
    })
});
//con esta funcion aumento de tamaño el pincel o la goma con los codigos de las teclas + y -
function pincelmas(e) {
    if (e.keyCode == "107") {
        cntx.lineWidth=cntx.lineWidth+15;
    }
}

function pincelmenos(e) {
    if (e.keyCode == "109") {
        cntx.lineWidth=cntx.lineWidth-5;
    }
}
  }

  //carga el diccionario y con append meto las section con sus respectivos divs y con la funcion cargdiccionario meto la fuente, nombre de la emocion y su descripcion
        function cargardic(){
    $.ajax({
      url:'../M-master/emociones/cargdiccionario',
      type:'POST',
      datatype:'json',
      success:function(respuesta){
           var data = JSON.parse(respuesta);
           for(i=0;i<data.length;i++){
            $("#container").append("<section><img class='parallax-window' src='"+data[i].fuente+"' /><div class='emocion'><span>Que es "+data[i].nombre+"?</span><div class='descr'>"+data[i].descripcion+"</div></div></section>");
           }
      }
    })
  }

  $(".sin_licencia").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

  $("#sin_licencia").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

  $("#sin_licencia2").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

  $("#sin_licencia3").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

  $("#sin_licencia4").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

  $("#sin_licencia5").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

  $("#sin_licencia6").click(function(){

    alert("Antes de utilizar nuestras opciones debe obtener la licencia o logearte si ya tienes cuenta!");

  });

});

//$("#container").append("<section><div class='parallax-window' data-parallax='scroll' data-image-src='"+data[0].fuente+"'></div><div class='emocion'><span>Que es la "+data[0].descripcion+"?</span><div>"+data[0].nombre+"</div></div></section>");
