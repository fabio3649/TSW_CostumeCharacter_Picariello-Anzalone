<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*, java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;700;900&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="indexStyle.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.min.css" integrity="sha512-BiFZ6oflftBIwm6lYCQtQ5DIRQ6tm02svznor2GYQOfAlT3pnVJ10xCrU3XuXnUrWQ4EG8GKxntXnYEdKY0Ugg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
		<script src="https://unpkg.com/scrollreveal@4.0.0/dist/scrollreveal.min.js"></script>
		<title>CostumeCharacter</title>
	</head>
	<body>
	
		<div class="header">
			<div class="logo">
				<img alt="Logo" src="\CostumeCharacter\\images\logo.png">
			</div>
			<ul class="menu">
				<li><a href="Costumi.jsp">Costumi</a></li>
				<li><a href="">Maschere</a></li>
				<li><a href="">Accessori</a></li>
			</ul>
			<div class="cta">
				<a href="" class="button"> Contatti</a>
			</div>	
			<div class="hamburger">
				<span></span>
				<span></span>
				<span></span>
			</div>
		</div>
		
		<div class="hero">
			<div class="hero__content reveal">
				<h1 class="big-text reveal">Costume Character</h1>
				<p class="intro-text reveal">Costumi, Maschere e molto altro </p>
				<a href="" class="button reveal">Acquista subito!</a>
			</div>
			<video autoplay muted loop id="video-back">
				<source src="\CostumeCharacter\\images\video-bg.mp4" type="video/mp4">
			</video>
		</div>
		

		<div class="bg-cover mt-3 reveal">
			<div class="bg-cover__title reveal">
				<h3 class="big-text tw">Diventa tu l'eroe </h3>
			</div>
			<div class="bg-cover__text reveal">
				<h4 class="normal-text tw reveal">Supereroi</h4>
				<p class="tw reveal"> Per superare la discussione del progetto devono essere seguite nel dettaglio le seguenti linee guida. Il progetto è di gruppo (max tre persone). E' possibile suddividersi i compiti durante lo sviluppo, ma nel momento della discussione tutti devono essere a conoscenza dei contenuti e delle funzionalità dell'intero progetto. La Base di Dati ha un ruolo molto importante. </p>
				
				<h4 class="normal-text tw reveal">Titolo del parargrafo</h4>
				<p class="tw reveal"> Per superare la discussione del progetto devono essere seguite nel dettaglio le seguenti linee guida. Il progetto è di gruppo (max tre persone). E' possibile suddividersi i compiti durante lo sviluppo, ma nel momento della discussione tutti devono essere a conoscenza dei contenuti e delle funzionalità dell'intero progetto. La Base di Dati ha un ruolo molto importante. </p>
			
				<h4 class="normal-text tw reveal">Titolo del parargrafo</h4>
				<p class="tw reveal"> Per superare la discussione del progetto devono essere seguite nel dettaglio le seguenti linee guida. Il progetto è di gruppo (max tre persone). E' possibile suddividersi i compiti durante lo sviluppo, ma nel momento della discussione tutti devono essere a conoscenza dei contenuti e delle funzionalità dell'intero progetto. La Base di Dati ha un ruolo molto importante. </p>
			</div>
		</div>
		
		<div class="grid mt-3 reveal">
			<div class="col">
				<h3 class="big-text reveal">Una vasta gamma di<br>Gadget</h3>
			</div>
			<div class="col">
				<p class="mt-2 reveal">Per superare la discussione del progetto devono essere seguite nel dettaglio le seguenti linee guida. Il progetto è di gruppo (max tre persone). E' possibile suddividersi i compiti durante lo sviluppo, ma nel momento della discussione tutti devono essere a conoscenza dei contenuti e delle funzionalità dell'intero progetto. La Base di Dati ha un ruolo molto importante.</p>
			</div>
		</div>
		
		
		<div class="main-carousel mt-3" data-flickity='{ "cellAlign": "center", "contain": true }'>
		
		<%
		
			ProductModelDS dao = new ProductModelDS();
			ArrayList<ProductBean> list = dao.doRetrieveAll("idProduct");
			ArrayList<ProductBean> costumi = new ArrayList<ProductBean>();
			boolean temp=false;
			
			for(int i=0;i<list.size();i++){
				if(!(list.get(i).getType().equals("Costume"))){
					list.remove(i);
				}
			}
			
			for(int i=0;i<list.size();i++){
				temp=false;
				for(int j=0;j<costumi.size();j++){
					if((list.get(i).getName().equals(costumi.get(j).getName()))){
						temp=true;
					}
				}
				if(!temp)
					costumi.add(list.get(i));
			}
			
			
			ImageModelDS ds = new ImageModelDS();
			
			
			for(int i=0;i<costumi.size();i++){
				
				String url = ds.doRetrieveMain(costumi.get(i).getId()).getUrl();
				int id = costumi.get(i).getId();
		%>
		
		
		
					
			  			<div class="carousel-cell">
			  				<div class="carousel-cell__content">
			  					<a href="ProductPage.jsp?idProduct=<%=id%>"><img alt="asd" src="<%=url%>"></a>
			  					<p><%=costumi.get(i).getName() %></p>
			  				</div>
			  				
			  			</div>
					
		
		
		<%
				}
		%>
		
		
		</div>
		
		
		<div class="main-carousel mt-3" data-flickity='{ "cellAlign": "center", "contain": true }'>
		
		<%
		
			ArrayList<ProductBean> list2 = dao.doRetrieveAllByType("Maschera");
			ArrayList<ProductBean> maschere = new ArrayList<ProductBean>();
			
	
			
			for(int i=0;i<list2.size();i++){
				temp=false;
				for(int j=0;j<maschere.size();j++){
					if((list2.get(i).getName().equals(maschere.get(j).getName()))){
						temp=true;
					}
				}
				if(!temp)
					maschere.add(list2.get(i));
			}
			
			
			for(int i=0;i<maschere.size();i++){
				
				String url = ds.doRetrieveMain(maschere.get(i).getId()).getUrl();
				int id = maschere.get(i).getId();
		%>
		
		
		
					
			  			<div class="carousel-cell">
			  				<div class="carousel-cell__content">
			  					<a href="ProductPage.jsp?idProduct=<%=id%>"><img alt="asd" src="<%=url%>"></a>
			  					<p><%=maschere.get(i).getName() %></p>
			  				</div>
			  				
			  			</div>
					
		
		
		<%
				}
		%>
		
		
		</div>
		
		
		
		
		
	<footer class="footer">
		<div class="grid mt-3 reveal">
			<div class="col reveal">
				<h4 class="med-text tw">Customer Care</h4>
				<p>iopwiqn qiwjimda qiwjni</p>
			</div>
			<div class="col reveal">
				<h4 class="med-text tw">Metodi di pagamento</h4>
				<p>iopwiqn qiwjimda qiwjni</p>
			</div>
			<div class="col reveal">
				<h4 class="med-text tw">Azienda</h4>
				<p>iopwiqn qiwjimda qiwjni</p>
			</div>
			<div class="col reveal">
				<h4 class="med-text tw">Privacy policy</h4>
				<p>iopwiqn qiwjimda qiwjni</p>
			</div>
		</div>
	</footer>	
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.2/flickity.pkgd.min.js" integrity="sha512-cA8gcgtYJ+JYqUe+j2JXl6J3jbamcMQfPe0JOmQGDescd+zqXwwgneDzniOd3k8PcO7EtTW6jA7L4Bhx03SXoA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
		
		<script>
			$( document ).ready(function() {
				
				$( ".hamburger").on('click', function(){
					$(".menu").toggleClass("menu--open");
				});
				
			});
			
			ScrollReveal().reveal('.reveal', { distance: '60px', duration: 1500,  easing: 'cubic-bezier(.215, .61, .355, 1)' , interval: 150 });
			
			
		</script>
		
	</body>
</html>