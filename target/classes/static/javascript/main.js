const boton = document.querySelectorAll("button");

console.log(boton)


boton.forEach(elemento=> elemento.addEventListener("click",mostrar))


const insertBookings = document.getElementById("insertBookings")


//Function for call Fragments of 

function mostrar(){
	
	const id = event.target.value
	
	fetch(`/booking/user/${id} `)
	.then(response => response.text())
	.then(data=> insertBookings.innerHTML = data)

	
}



 