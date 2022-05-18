//const boton = document.querySelectorAll("button");

//console.log(boton)


//boton.forEach(elemento=> elemento.addEventListener("click",mostrar))


//const insertBookings = document.getElementById("insertBookings")


//Function for call Fragments of 

//function mostrar(){
	
//	const id = event.target.value
	
//	fetch(`/booking/user/${id} `)
//	.then(response => response.text())
//	.then(data=> insertBookings.innerHTML = data)

	
//}






function modalform(){
	
	let modal= "";
	
	fetch(`/subscriptions/insert`)
	.then(response => response.text())
	.then(data=> divdialog.innerHTML = data)
	.then(()=>createModal())
	
}


const modalSubscriptionInsert = document.getElementById("insertSubscription");
const modal = document.getElementById("modalinsert");

const divdialog = document.getElementById("modalformdialog");


function createModal(){
	const modal = document.getElementById("modalinsert");
	console.log(modal)
	const closeModal = document.getElementById("btnCerrar");
	closeModal.addEventListener("click",()=> modal.close())
	console.log(closeModal)
	modal.showModal();
	
}


modalSubscriptionInsert.addEventListener("click",modalform);

function createButton(){
	
	
closemodal.addEventListener("click",()=> modal.close())

}


const updateButton = document.querySelectorAll(".updateButton")

console.log(updateButton)

updateButton.forEach(button => button.addEventListener("click",updateForm))

function updateForm ( event){

	 const id =(event.target.value);
	console.log(`/la mano que / ${id}`)
	const url  = `/subscriptions/update/${id}`;
	console.log(url)

	fetch(url)
 .then(response => response.text())
. then(data=> divdialog.innerHTML = data)
 .then(()=>createModal())




}









 