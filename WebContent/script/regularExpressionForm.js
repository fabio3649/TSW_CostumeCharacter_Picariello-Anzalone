function controlUser(user){
	var url = "CheckUsername?username="+user;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status == 200){
			document.getElementById("availability").innerHTML = xhttp.responseText;
			var x = document.getElementById("availability");
			x.style.fontSize="18px";
			x.style.color="red";
		}
	};
	xhttp.open("get", url ,true);
	xhttp.send();
}

function focusRegister(x) {
	x.style.background = "yellow";
	
}







	
	





	










