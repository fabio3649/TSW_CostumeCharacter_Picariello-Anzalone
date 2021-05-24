<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="index.css" type="text/css"  >
  <title>Home</title>
</head>
<body>

  <section id="spedizione">
       <img src="\CostumeCharacter\\images\spedizione.png" alt="spedizione">
       <span> Spedizione gratuita per ordini superiori a 89.90 euro </span> <br>
       <span> Spedizione 10.00 euro in tutta Italia </span>
  </section>
    <header>
      <div class="logo">
        <a href="index.html" > <img src="\CostumeCharacter\\images\logo.png" alt="logo"  >  </a>

      </div>
          <div class="menu">
              <ul>
                  <li> <a href="costumi.html"> Costumi </a> </li>
                  <li> <a href="maschere.html"> Maschere </a> </li>
                  <li> <a href="accessori.html"> Accessori & Gadget </a> </li>
                  <li> <a href="bambini.html"> Per bambini </a> </li>
              </ul>
          </div>
          <div class="user">
            <ul>
              <li> <a href="Login.jsp"> <img src="\CostumeCharacter\\images\user.png" alt="user"  > </a> </li>
              <li> <a href="CartView.jsp"> <img src="\CostumeCharacter\\images\cart.png" alt="cart"  > </a> </li>
            </ul>
            <div class="badged">
            <span> 0 </span>
            
            </div>
          </div>

      </header>



      <div class="slider" >
         <img class="mySlides" src="\CostumeCharacter\\images\batman.jpg" style="width:100%">
         <img class="mySlides" src="\CostumeCharacter\\images\wonderwoman.jpg" style="width:100%">
         <img class="mySlides" src="\CostumeCharacter\\images\veneziane.jpg" style="width:100%">
         <img class="mySlides" src="\CostumeCharacter\\images\spiderman.png" style="width:100%">

      </div>


      <script>
      var myIndex = 0;
      carousel();

      function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
          x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 10000); // Change image every 2 seconds
      }
      </script>

      <h1 class="categorie"> Scegli tra una vasta gamma di costumi dei tuoi Supereroi preferiti </h1>
        <div class="container">


            <div class="item">
                <a href="image.html" > <img src="batmanCostumeDeluxe.jpg" alt="batman" > <h2> Costume Batman </h2>  </a>


            </div>

             <div class="item">
                <a href="image.html" > <img src="joker1.jpg" alt="batman" > <h2> Costume Joker </h2> </a>
            </div>


                 <div class="item">
                    <a href="image.html" > <img src="ironman1.jpg" alt="batman" > <h2> Costume Iron-Man </h2> </a>
            </div>

        </div>


      <div class="info">
        <ul>
            <li> <a href="costumi.html"> Assitenza clienti </a> </li>
            <li> <a href="maschere.html"> Metodi di pagamento </a> </li>
            <li> <a href="accessori.html"> Su di noi </a> </li>
            <li> <a href="bambini.html"> Contatti </a> </li>
        </ul>
        <ul>
            <li> <a href="costumi.html"> Politica sulla privacy </a> </li>
            <li> <a href="maschere.html"> Cookies </a> </li>
            <li> <a href="accessori.html"> Sezione aziendale </a> </li>
            <li> <a href="bambini.html"> Condizioni di vendita </a> </li>
        </ul>
        <div class="payment">
        <ul>
          <li> <a href="login.jsp"> <img src="\CostumeCharacter\\images\paypal.png" alt="user" height="100px" weight="100px" > </a> </li>
          <li> <a href="login.jsp"> <img src="\CostumeCharacter\\images\visa.png" alt="cart" height="100px" weight="100px" > </a> </li>
        </ul>
        </div>

      </div>


      <footer>
            &copy; 2021, Costume Character <br>
            All trademarks and registered trademarks appearing on this site are the property of therir
            respective owners.
      </footer>




</body>
</html>
