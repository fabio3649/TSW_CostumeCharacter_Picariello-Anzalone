<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

 <%@ include file="header.html" %>
		 


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
        setTimeout(carousel, 10000); // Change image every 10 seconds
      }
      </script>

     
		

      <%@ include file="footer.html" %>




</body>
</html>
